package net.lemonsoft.lemonhello;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Build;
import android.os.Handler;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.RelativeLayout;
import android.widget.TableRow;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * LemonHello - 容器控件类
 * Created by LiuRi on 2017/1/11.
 */

public class LemonHelloView {

    /**
     * 私有Animation工具类
     */
    private LemonHelloPrivateAnimationTool _PAT = LemonHelloPrivateAnimationTool.defaultPrivateAnimationTool();
    /**
     * 私有Size工具类
     */
    private LemonHelloPrivateSizeTool _PST = LemonHelloPrivateSizeTool.getPrivateSizeTool();

    // 对话框控件的实体控件容器
    private Dialog _container;
    // 整个dialog全屏的布局容器
    private RelativeLayout _rootLayout;
    // 对context对象进行存储的变量
    private Context _context;
    // 当前正在显示的对话框控件的信息对象
    private LemonHelloInfo _currentInfo;
    // 背景灰色半透明蒙版
    private View _backMaskView;
    // 包含弹出框真正内容的小布局面板
    private LemonHelloPanel _contentPanel;
    // 包含弹出框真正内容的小布局面板的内容layout，之所以再套一层是为了动画效果处理起来方便
    private RelativeLayout _contentLayout;
    // 动画和帧图片显示的控件
    private LemonPaintView _paintView;
    // 标题显示标签控件
    private TextView _titleView;
    // 正文内容显示控件
    private TextView _contentView;
    // action按钮容器布局
    private RelativeLayout _actionContainer;
    // 当前是否被显示状态
    private boolean _isShow;

    // 是否已经初始化过了，避免重新创建控件
    private boolean haveInit = false;

    // 用于存储单例对象的变量
    private static LemonHelloView _defaultHelloViewObject;

    public boolean isShow() {
        return _isShow;
    }

    public synchronized void setIsShow(boolean isShow) {
        this._isShow = isShow;
    }

    /**
     * 消息队列，加入消息队列的HelloInfo会陆续的显示，而不是一次性的全部显示在屏幕上
     * 当前一个Hello信息框被关闭的时候，下一个信息框才会被弹出
     */
    private List<LemonHelloInfoPack> queue = new ArrayList<>();

    /**
     * 获取单例Hello控件对象
     *
     * @return 单例Hello提示框控件实例对象
     */
    public static synchronized LemonHelloView defaultHelloView(Context context) {
        if (_defaultHelloViewObject == null)
            _defaultHelloViewObject = new LemonHelloView();
        return _defaultHelloViewObject;
    }

    /**
     * 获取单例Hello提示框控件对象 - 调用此方法前提是通过setDefaultContext方法设置了默认的context对象
     *
     * @return 单例Hello提示框控件实例对象
     */
    public static synchronized LemonHelloView defaultHelloView() {
        if (_defaultHelloViewObject == null) {
            _defaultHelloViewObject = new LemonHelloView();
        }
        return _defaultHelloViewObject;
    }

    public void showHelloWithInfo(Context context, LemonHelloInfo helloInfo) {
        if (isShow() && _currentInfo.isUseMessageQueue()) {// 当前有对话框正在显示中，并且当前HelloInfo支持队列
            queue.add(new LemonHelloInfoPack(context, helloInfo));
            return;
        } else if (context == null && helloInfo == null && queue.size() > 0) {
            // 从队列中读取一个HelloInfo并显示
            LemonHelloInfoPack pack = queue.get(0);
            queue.remove(0);
            if (pack.getContext() != null && !pack.getContext().equals(context))
                haveInit = false;
            _context = pack.getContext();
            _currentInfo = pack.getHelloInfo();
            autoInit(_context);
            _container.show();
            initContentPanel(_currentInfo);// 根据泡泡信息对象对正文内容面板进行初始化
        } else {
            // 需要立即将该helloInfo显示出来
            if (_context != null && !_context.equals(context))
                haveInit = false;
            _context = context;
            _currentInfo = helloInfo;
            autoInit(_context);
            _container.show();
            initContentPanel(_currentInfo);// 根据泡泡信息对象对正文内容面板进行初始化
        }
    }

    /**
     * 自动初始化
     *
     * @param context 上下文对象
     */
    private void autoInit(Context context) {
        _context = context;
        _PST.setContext(context);// 初始化尺寸工具类
        if (!haveInit) {
            initContainerAndRootLayout();// 初始化容器和根视图
            initCommonView();// 初始化公共的控件
            haveInit = true;
        }
    }

    /**
     * 初始化容器与根视图布局
     */
    private void initContainerAndRootLayout() {
        _container = new Dialog(// 判断是否有状态栏
                _context,
                _currentInfo.isShowStatusBar() ?
                        android.R.style.Theme_NoTitleBar :
                        android.R.style.Theme_NoTitleBar_Fullscreen
        );// 创建对话框对象并设置无标题栏主题
        if (_currentInfo.isShowStatusBar()) {
            Window window = _container.getWindow();// 设置
            if (window != null && Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
                window.setStatusBarColor(_currentInfo.getStatusBarColor());
            }
        }
        _rootLayout = new RelativeLayout(_context);// 实例化根布局对象
        Window window = _container.getWindow();
        if (window == null) {// 检测是否成功获取window对象
            // 如果为null那么不再继续进行，防止空指针异常
            new Exception("Get lemon hello dialog's window error!").printStackTrace();
            return;
        }
        window.getDecorView().setPadding(0, 0, 0, 0);// 去掉系统默认的与屏幕边缘的内边距
        window.setBackgroundDrawableResource(android.R.color.transparent);// 设置背景透明
        window.addFlags(WindowManager.LayoutParams.FLAG_LAYOUT_IN_SCREEN);// 设置窗口全屏
        window.addFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);// 防止状态栏更新导致界面卡顿
        _container.setContentView(_rootLayout);// 把根视图与对话框相关联
        _container.setCanceledOnTouchOutside(false);// 设置背景点击关闭为true
        _container.setOnKeyListener(new DialogInterface.OnKeyListener() {// 禁止返回按钮返回
            public boolean onKey(DialogInterface dialog, int keyCode, KeyEvent event) {
                return keyCode == KeyEvent.KEYCODE_BACK && event.getRepeatCount() == 0;
            }
        });
    }

    /**
     * 初始化公共的控件
     */
    private void initCommonView() {
        // 实例化灰色半透明蒙版控件
        _backMaskView = new View(_context);
        _backMaskView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (_currentInfo.getEventDelegate() != null)
                    _currentInfo.getEventDelegate().onMaskTouch(LemonHelloView.this, _currentInfo);
            }
        });
        // 设置全屏宽
        _backMaskView.setLayoutParams(new RelativeLayout.LayoutParams(_PST.dpToPx(_PST.screenWidthDp()), _PST.dpToPx(_PST.screenHeightDp())));
        _rootLayout.setAlpha(0);// 设置全透明，也就是默认不可见，后期通过动画改变来显示

        // 实例化内容面板控件
        _contentPanel = new LemonHelloPanel(_context);
        _contentPanel.setX(_PST.dpToPx((int) (_PST.screenWidthDp() / 2.0)));
        _contentPanel.setY(_PST.dpToPx((int) (_PST.screenHeightDp() / 2.0)));

        // 实例化内容面板控件的布局
        _contentLayout = new RelativeLayout(_context);

        // 实例化绘图动画和帧图片显示的控件
        _paintView = new LemonPaintView(_context);

        // 实例化标题显示标签控件
        _titleView = new TextView(_context);
        _titleView.setX(0);
        _titleView.setY(0);
        _titleView.setGravity(Gravity.CENTER);

        _contentView = new TextView(_context);
        _contentView.setX(0);
        _contentView.setY(0);
        _contentView.setGravity(Gravity.CENTER);

        _actionContainer = new RelativeLayout(_context);
        _actionContainer.setX(0);
        _actionContainer.setY(0);

        _contentView.setAlpha(0);
        _titleView.setAlpha(0);
        _contentPanel.setAlpha(0);

        // 把所有控件添加到根视图上
        _rootLayout.addView(_backMaskView);// 半透明灰色背景
        _rootLayout.addView(_contentPanel);// 主内容面板
        _contentPanel.addView(_contentLayout);
        _contentLayout.addView(_paintView);// 动画和帧图标显示控件放置到内容面板上
        _contentLayout.addView(_titleView);// 标题显示标签控件放置到内容面板上
        _contentLayout.addView(_contentView);// 正文内容显示标签控件放到内容面板上
        _contentLayout.addView(_actionContainer);// action事件容器放到内容面板中
    }

    /**
     * 根据泡泡信息对象初始化内容面板
     *
     * @param info 泡泡信息对象
     */
    private void initContentPanel(final LemonHelloInfo info) {
        _paintView.setImageBitmap(null);
        _paintView.setHelloInfo(null);
        if (info.getIcon() == null) {
            // 显示自定义动画
            _paintView.setHelloInfo(info);
        } else {
            // 显示单张图片
            _paintView.setImageBitmap(info.getIcon());
        }
        // 设置根视图的透明度为1，不透明
        _PAT.setAlpha(_rootLayout, 1);
        // 动画改变到内容面板的背景颜色到预设值
        _PAT.setBackgroundColor(_contentPanel, info.getCornerRadius(), info.getPanelBackgroundColor());
        // 设置内容面板的透明度为1，不透明
        _PAT.setAlpha(_contentPanel, 1);
        _PAT.setAlpha(_contentView, 1);
        _PAT.setAlpha(_titleView, 1);
        _titleView.setTextColor(info.getTitleColor());
        // 设置蒙版色
        _PAT.setBackgroundColor(_backMaskView, 0, info.getMaskColor());
        // 调用泡泡控件信息对象中的方法来计算面板和图标标题等控件的位置和大小，并动画移动
        info.calViewsFrame(LemonHelloView.this, _contentPanel, _contentLayout, _paintView, _titleView, _contentView, _actionContainer);
        setIsShow(true);
    }

    /**
     * 隐藏当前正在显示的泡泡控件
     */
    public void hide() {
        _PAT.setAlpha(_rootLayout, 0);// 动画设置根视图不透明
        _PAT.setAlpha(_contentPanel, 0);// 动画设置内容面板不透明
        _PAT.setSize(_contentPanel, _PST.pxToDp((int) (_contentPanel.getMeasuredWidth() * 1.1f)), _PST.pxToDp((int) (_contentPanel.getMeasuredHeight() * 1.1)));// 动画设置面板的大小为0，0
//        _PAT.setSize(_paintView, 0, 0);// 动画设置图标动画控件的大小为0，0
//        _PAT.setSize(_titleView, 0, 0);// 动画设置标题控件的大小为0，0
//        _PAT.setSize(_contentView, 0, 0);
        _PAT.setAlpha(_contentView, -5);
        _PAT.setAlpha(_paintView, -5);
        _PAT.setAlpha(_titleView, -5);
//        _PAT.setLocation(_paintView, 0, 0);// 动画设置图标动画控件的坐标为0，0，可以让动画看起来更像是整体缩小
//        _PAT.setLocation(_titleView, 0, 0);// 动画设置标题控件的坐标为0，0，可以让动画看起来更像是整体缩小
//        _PAT.setLocation(_contentView, 0, 0);
        // 把内容面板缩小至屏幕中间
//        _PAT.setLocation(_contentPanel, _PST.screenWidthDp() / 2, _PST.screenHeightDp() / 2);
        _PAT.setLocation(_contentPanel, _PST.pxToDp((int) (_contentPanel.getX() - _contentPanel.getMeasuredWidth() * 0.05)), _PST.pxToDp((int) (_contentPanel.getY() - _contentPanel.getMeasuredHeight() * 0.05)));
        _PAT.setLocation(_contentLayout, _PST.pxToDp((int) (_contentPanel.getMeasuredWidth() * 0.05)), _PST.pxToDp((int) (_contentPanel.getMeasuredHeight() * 0.05)));
        setIsShow(false);// 设置当前的状态为不显示状态
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                _container.dismiss();
                setIsShow(false);
                if (queue.size() > 0)// 展示队列中的下一个提示框
                    showHelloWithInfo(null, null);
                haveInit = false;// 让其每次彻底关闭后在开启都重新创建对象，防止部分手机按返回键后再次弹出时候闪退
                // 如果哪位大神有更好的办法请联系我  liuri@lemonsoft.net
            }
        }, 300);// 待所有动画处理完毕后关闭根Dialog
    }

    /**
     * 强制关闭当前正在显示的泡泡控件
     */
    public void forceHide() {
        _container.dismiss();
        this.haveInit = false;
    }
}
