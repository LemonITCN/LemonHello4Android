package net.lemonsoft.lemonhello;

import android.app.Dialog;
import android.content.Context;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

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
    private RelativeLayout _contentPanel;
    // 动画和帧图片显示的控件
    private LemonPaintView _paintView;
    // 标题显示标签控件
    private TextView _titleView;
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
     * 获取单例泡泡控件对象
     *
     * @return 单例泡泡控件实例对象
     */
    public static synchronized LemonHelloView defaultHelloView(Context context) {
        if (_defaultHelloViewObject == null)
            _defaultHelloViewObject = new LemonHelloView();
        return _defaultHelloViewObject;
    }

    /**
     * 获取单例泡泡控件对象 - 调用此方法前提是通过setDefaultContext方法设置了默认的context对象
     *
     * @return 单例泡泡控件实例对象
     */
    public static synchronized LemonHelloView defaultHelloView() {
        if (_defaultHelloViewObject == null) {
            _defaultHelloViewObject = new LemonHelloView();
        }
        return _defaultHelloViewObject;
    }

}
