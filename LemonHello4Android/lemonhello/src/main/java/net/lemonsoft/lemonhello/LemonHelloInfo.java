package net.lemonsoft.lemonhello;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.SumPathEffect;
import android.graphics.drawable.Drawable;
import android.text.Layout;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

import net.lemonsoft.lemonhello.enums.LemonHelloIconLocation;
import net.lemonsoft.lemonhello.interfaces.LemonHelloEventDelegate;
import net.lemonsoft.lemonhello.interfaces.LemonPaintContext;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.BrokenBarrierException;

/**
 * LemonHello - 样式描述信息模型类
 * Created by LiuRi on 2017/1/11.
 */

public class LemonHelloInfo {

    private LemonHelloPrivateAnimationTool _PAT = LemonHelloPrivateAnimationTool.defaultPrivateAnimationTool();
    private LemonHelloPrivateSizeTool _PST = LemonHelloPrivateSizeTool.getPrivateSizeTool();

    /**
     * 对话框控件的宽度
     */
    private int width = LemonHelloGlobal.width;
    /**
     * 对话框控件的圆角半径
     */
    private int cornerRadius = LemonHelloGlobal.cornerRadius;
    /**
     * 对话框面板的背景颜色
     */
    private int panelBackgroundColor = LemonHelloGlobal.panelBackgroundColor;
    /**
     * 对话框面板的背景Drawable
     */
    private Drawable panelBackgroundDrawable = LemonHelloGlobal.panelBackgroundDrawable;
    /**
     * 对话框的背景蒙版颜色
     */
    private int maskColor = LemonHelloGlobal.maskColor;
    /**
     * 对话框的图标绘制上下文
     * 如果icon属性为空，那么会调用该属性iconPaintContext绘制
     * 如果iconPaintContext为空，那么会认为无图标
     */
    private LemonPaintContext iconPaintContext = LemonHelloGlobal.iconPaintContext;
    /**
     * 图标动画是否需要重复
     */
    private boolean isIconAnimationRepeat = LemonHelloGlobal.isIconAnimationRepeat;
    /**
     * 动画的执行的所需时长
     */
    private int animationTime = LemonHelloGlobal.animationTime;
    /**
     * 对话框的图标对象
     * 如果该对象为空，那么会调用iconPaintContext绘制
     * 如果iconPaintContext为空，那么会认为无图标
     */
    private Bitmap icon = LemonHelloGlobal.icon;
    /**
     * 图标的宽度
     * 图标为正方形，因此宽度也就是高度
     */
    private int iconWidth = LemonHelloGlobal.iconWidth;
    /**
     * 图标的位置描述属性
     */
    private LemonHelloIconLocation iconLocation = LemonHelloGlobal.iconLocation;
    /**
     * 对话框的标题，如果该属性为null或空字符串，那么认为其没有标题
     */
    private String title = LemonHelloGlobal.title;
    /**
     * 对话框的正文内容文字
     */
    private String content = LemonHelloGlobal.content;
    /**
     * 标题文字的颜色
     */
    private int titleColor = LemonHelloGlobal.titleColor;
    /**
     * 对话框正文内容文字颜色
     */
    private int contentColor = LemonHelloGlobal.contentColor;
    /**
     * 标题文字的字体大小
     */
    private int titleFontSize = LemonHelloGlobal.titleFontSize;
    /**
     * 对话对征文内容文字字体大小
     */
    private int contentFontSize = LemonHelloGlobal.contentFontSize;
    /**
     * 标题的按钮文字大小
     */
    private int buttonFontSize = LemonHelloGlobal.buttonFontSize;
    /**
     * 控件的内边距
     */
    private int padding = LemonHelloGlobal.padding;
    /**
     * 控件的间隙
     */
    private int space = LemonHelloGlobal.space;
    /**
     * action按钮的高度
     */
    private int actionLineHeight = LemonHelloGlobal.actionLineHeight;
    /**
     * 对话框的动画list（按钮说明信息list）
     */
    private List<LemonHelloAction> actions = new ArrayList<>();
    /**
     * 第一行的按钮数量
     * 如果超过这个数量，那么每一个Action都会被放到单独的行中
     * 如果该数值设置为<1的数字，那么认为该值为1
     */
    private int firstLineButtonCount = LemonHelloGlobal.firstLineButtonCount;
    /**
     * 是否显示状态栏
     */
    private boolean showStatusBar = LemonHelloGlobal.showStatusBar;
    /**
     * 状态栏的颜色
     */
    private int statusBarColor = LemonHelloGlobal.statusBarColor;
    /**
     * LemonHello的事件代理
     */
    private LemonHelloEventDelegate eventDelegate = LemonHelloGlobal.eventDelegate;
    /**
     * 是否使用消息队列，若您使用了消息队列，那么后通知显示的消息框会在前一个消息框关闭后再显示
     */
    private boolean useMessageQueue = LemonHelloGlobal.useMessageQueue;

    public int getWidth() {
        return width;
    }

    public LemonHelloInfo setWidth(int width) {
        this.width = width;
        return this;
    }

    public int getCornerRadius() {
        return cornerRadius;
    }

    public LemonHelloInfo setCornerRadius(int cornerRadius) {
        this.cornerRadius = cornerRadius;
        return this;
    }

    public int getPanelBackgroundColor() {
        return panelBackgroundColor;
    }

    public LemonHelloInfo setPanelBackgroundColor(int panelBackgroundColor) {
        this.panelBackgroundColor = panelBackgroundColor;
        return this;
    }

    public Drawable getPanelBackgroundDrawable() {
        return panelBackgroundDrawable;
    }

    public LemonHelloInfo setPanelBackgroundDrawable(Drawable panelBackgroundDrawable) {
        this.panelBackgroundDrawable = panelBackgroundDrawable;
        return this;
    }

    public int getMaskColor() {
        return maskColor;
    }

    public LemonHelloInfo setMaskColor(int maskColor) {
        this.maskColor = maskColor;
        return this;
    }

    public LemonPaintContext getIconPaintContext() {
        return iconPaintContext;
    }

    public LemonHelloInfo setIconPaintContext(LemonPaintContext iconPaintContext) {
        this.iconPaintContext = iconPaintContext;
        return this;
    }

    public boolean isIconAnimationRepeat() {
        return isIconAnimationRepeat;
    }

    public LemonHelloInfo setIconAnimationRepeat(boolean iconAnimationRepeat) {
        isIconAnimationRepeat = iconAnimationRepeat;
        return this;
    }

    public int getAnimationTime() {
        return animationTime;
    }

    public LemonHelloInfo setAnimationTime(int animationTime) {
        this.animationTime = animationTime;
        return this;
    }

    public Bitmap getIcon() {
        return icon;
    }

    public LemonHelloInfo setIcon(Bitmap icon) {
        this.icon = icon;
        return this;
    }

    public int getIconWidth() {
        if (icon == null && iconPaintContext == null)
            return 0;
        return iconWidth;
    }

    public LemonHelloInfo setIconWidth(int iconWidth) {
        this.iconWidth = iconWidth;
        return this;
    }

    public LemonHelloIconLocation getIconLocation() {
        return iconLocation;
    }

    public LemonHelloInfo setIconLocation(LemonHelloIconLocation iconLocation) {
        this.iconLocation = iconLocation;
        return this;
    }

    public String getTitle() {
        return title;
    }

    public LemonHelloInfo setTitle(String title) {
        this.title = title;
        return this;
    }

    public String getContent() {
        return content;
    }

    public LemonHelloInfo setContent(String content) {
        this.content = content;
        return this;
    }

    public int getTitleColor() {
        return titleColor;
    }

    public LemonHelloInfo setTitleColor(int titleColor) {
        this.titleColor = titleColor;
        return this;
    }

    public int getContentColor() {
        return contentColor;
    }

    public LemonHelloInfo setContentColor(int contentColor) {
        this.contentColor = contentColor;
        return this;
    }

    public int getTitleFontSize() {
        return titleFontSize;
    }

    public LemonHelloInfo setTitleFontSize(int titleFontSize) {
        this.titleFontSize = titleFontSize;
        return this;
    }

    public int getContentFontSize() {
        return contentFontSize;
    }

    public LemonHelloInfo setContentFontSize(int contentFontSize) {
        this.contentFontSize = contentFontSize;
        return this;
    }

    public int getButtonFontSize() {
        return buttonFontSize;
    }

    public LemonHelloInfo setButtonFontSize(int buttonFontSize) {
        this.buttonFontSize = buttonFontSize;
        return this;
    }

    public int getPadding() {
        return padding;
    }

    public void setPadding(int padding) {
        this.padding = padding;
    }

    public int getSpace() {
        return space;
    }

    public LemonHelloInfo setSpace(int space) {
        this.space = space;
        return this;
    }

    public int getActionLineHeight() {
        return actionLineHeight;
    }

    public LemonHelloInfo setActionLineHeight(int actionLineHeight) {
        this.actionLineHeight = actionLineHeight;
        return this;
    }

    public List<LemonHelloAction> getActions() {
        return actions;
    }

    public LemonHelloInfo setActions(List<LemonHelloAction> actions) {
        this.actions = actions;
        return this;
    }

    public LemonHelloInfo addAction(LemonHelloAction... actions) {
        for (LemonHelloAction action : actions)
            this.actions.add(action);
        return this;
    }

    public LemonHelloInfo removeAction(LemonHelloAction... actions) {
        for (LemonHelloAction action : actions)
            if (this.actions.contains(action))
                this.actions.remove(action);
        return this;
    }

    public LemonHelloInfo removeAllActions() {
        this.actions.clear();
        return this;
    }

    public int getFirstLineButtonCount() {
        return Math.max(firstLineButtonCount, 1);
    }

    public LemonHelloInfo setFirstLineButtonCount(int firstLineButtonCount) {
        this.firstLineButtonCount = Math.max(firstLineButtonCount, 1);
        return this;
    }

    public boolean isShowStatusBar() {
        return showStatusBar;
    }

    public LemonHelloInfo setShowStatusBar(boolean showStatusBar) {
        this.showStatusBar = showStatusBar;
        return this;
    }

    public int getStatusBarColor() {
        return statusBarColor;
    }

    public LemonHelloInfo setStatusBarColor(int statusBarColor) {
        this.statusBarColor = statusBarColor;
        return this;
    }

    public LemonHelloEventDelegate getEventDelegate() {
        return eventDelegate;
    }

    public LemonHelloInfo setEventDelegate(LemonHelloEventDelegate eventDelegate) {
        this.eventDelegate = eventDelegate;
        return this;
    }

    public boolean isUseMessageQueue() {
        return useMessageQueue;
    }

    public LemonHelloInfo setUseMessageQueue(boolean useMessageQueue) {
        this.useMessageQueue = useMessageQueue;
        return this;
    }

    private int getTextViewHeight(TextView textView) {
        Paint.FontMetrics fontMetrics = textView.getPaint().getFontMetrics();
        return _PST.pxToDp((int) (fontMetrics.descent - fontMetrics.top)) + 2;
    }

    private int measureTextViewHeight(TextView textView, int viewWidth) {
        int widthMeasureSpec = View.MeasureSpec.makeMeasureSpec(_PST.dpToPx(viewWidth), View.MeasureSpec.AT_MOST);
        int heightMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, View.MeasureSpec.UNSPECIFIED);
        textView.measure(widthMeasureSpec, heightMeasureSpec);
        return _PST.pxToDp(textView.getMeasuredHeight());
    }

    /**
     * 获取textView的文字宽
     *
     * @param textView 要查询文字宽的标签控件
     * @return 获取到的文字宽度数值
     */
    private int getTextViewWidth(TextView textView) {
        return _PST.pxToDp((int) (textView.getPaint().measureText(textView.getText().toString())));
    }

    /**
     * 计算视图的位置等矩形信息
     *
     * @param helloView       整个对话框HelloView
     * @param contentPanel    内容面板
     * @param contentLayout   内容面板的布局
     * @param paintView       图标显示控件
     * @param titleView       标题显示控件
     * @param contentView     内容显示控件
     * @param actionContainer 事件按钮容器面板
     */
    public void calViewsFrame(final LemonHelloView helloView,
                              LemonHelloPanel contentPanel,
                              RelativeLayout contentLayout,
                              LemonPaintView paintView,
                              TextView titleView,
                              TextView contentView,
                              RelativeLayout actionContainer) {
        contentPanel.setCornerRadius(cornerRadius);
        titleView.setText(title);
        contentView.setText(content);
        titleView.setTextSize(titleFontSize);
        contentView.setTextSize(contentFontSize);

        contentView.setTextSize(contentFontSize);

        int panelHeight, titleWidth, titleHeight, contentWidth, contentHeight, actionsHeight,
                titleX, titleY, contentX, contentY, iconX, iconY, actionsY;
        panelHeight = titleX = titleY = contentX = iconX = iconY = padding;

        titleWidth = width - padding * 2;
        titleHeight = (title == null || title.equals("")) ? 0 : getTextViewHeight(titleView);
        contentWidth = width - padding * 2 - (getIconWidth() == 0 ? 0 : space) - getIconWidth();

        switch (iconLocation) {
            case TOP:
                iconX = (width - iconWidth) / 2;
                contentWidth = width - padding * 2;
                titleY += iconWidth + space;
                break;
            case LEFT:
                iconY = titleY + titleHeight + space;
                contentX = iconX + iconWidth + space;
                break;
            case RIGHT:
                iconX = width - padding - getIconWidth();
                iconY = titleY + titleHeight + space;
                break;
        }

        if (getIconWidth() <= 0)
            contentX = padding;

        contentHeight = (content == null || content.equals("")) ? 0 : measureTextViewHeight(contentView, contentWidth);
        if (contentHeight < getIconWidth() && iconLocation != LemonHelloIconLocation.TOP)// 内容高小于图标的高
            contentHeight = getIconWidth();
        contentY = titleY + titleHeight + space;

        actionsY = contentY + contentHeight + space * 2;
        actionsHeight = actions.size() <= 0 ? 0 :
                actions.size() <= firstLineButtonCount ?
                        getActionLineHeight() :
                        getActionLineHeight() * actions.size();
        actionContainer.setBackgroundColor(Color.argb(30, 150, 150, 150));
        panelHeight = actionsY + actionsHeight;
        for (int i = 0; i < actions.size(); i++) {
            final LemonHelloAction action = actions.get(i);
            Button actionView = new Button(actionContainer.getContext());
            actionView.setText(action.getTitle());
            actionView.setTextColor(action.getTitleColor());
            actionView.setBackgroundColor(action.getBackgroundColor());
            actionView.setTextSize(buttonFontSize);
            actionView.setGravity(Gravity.CENTER);
            actionContainer.addView(actionView);
            actionView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    action.getDelegate().onClick(helloView, LemonHelloInfo.this, action);
                }
            });
            actionView.setOnTouchListener(new View.OnTouchListener() {
                // 设置触摸监听器，设置触摸的颜色变化
                @Override
                public boolean onTouch(View v, MotionEvent event) {
                    switch (event.getAction()) {
                        case MotionEvent.ACTION_DOWN:
                            v.setBackgroundColor(action.getBackgroundHoverColor());
                            break;
                        case MotionEvent.ACTION_UP:
                            v.setBackgroundColor(action.getBackgroundColor());
                            break;
                    }
                    return false;
                }
            });
            if (actions.size() <= firstLineButtonCount) {
                // 横向排列
                actionView.setLayoutParams(new RelativeLayout.LayoutParams(_PST.dpToPx(width / actions.size() - 1), _PST.dpToPx(_PST.dpToPx(actionLineHeight - 1))));
                actionView.setX(_PST.dpToPx(i * (width / actions.size())));
                actionView.setY(1);
            } else {
                // 纵向排列
                actionView.setLayoutParams(new RelativeLayout.LayoutParams(_PST.dpToPx(width), _PST.dpToPx(actionLineHeight - 1)));
                actionView.setY(_PST.dpToPx(i * actionLineHeight + 1));
            }
        }

        contentPanel.setLayoutParams(new RelativeLayout.LayoutParams(_PST.dpToPx((int) (width * 1.1)), _PST.dpToPx((int) (panelHeight * 1.1))));
        contentPanel.setX(_PST.dpToPx((int) (_PST.screenWidthDp() / 2 - width / 2)));
        contentPanel.setY(_PST.dpToPx((int) (_PST.screenHeightDp() / 2 - panelHeight / 2)));

        // 使用下面这种特效会让窗口有点颤抖，暂不明原因，待考究
//        contentPanel.setX(_PST.dpToPx((int) (_PST.screenWidthDp() / 2 - width * 0.55)));
//        contentPanel.setY(_PST.dpToPx((int) (_PST.screenHeightDp() / 2 - panelHeight * 0.55)));

        _PAT.setLocation(contentPanel, (_PST.screenWidthDp() - width) / 2, (_PST.screenHeightDp() - panelHeight) / 2);

        titleView.setX(_PST.dpToPx(titleX));
        titleView.setY(_PST.dpToPx(titleY));
        titleView.setLayoutParams(new RelativeLayout.LayoutParams(_PST.dpToPx(titleWidth), _PST.dpToPx(titleHeight)));

        paintView.setX(_PST.dpToPx(iconX));
        paintView.setY(_PST.dpToPx(iconY));
        paintView.setLayoutParams(new RelativeLayout.LayoutParams(_PST.dpToPx(getIconWidth()), _PST.dpToPx(getIconWidth())));

        actionContainer.setX(0);
        actionContainer.setY(_PST.dpToPx(actionsY));
        actionContainer.setLayoutParams(new RelativeLayout.LayoutParams(_PST.dpToPx(width), _PST.dpToPx(actionsHeight)));

        contentView.setX(_PST.dpToPx(contentX));
        contentView.setY(_PST.dpToPx(contentY));
        contentView.setLayoutParams(new RelativeLayout.LayoutParams(_PST.dpToPx(contentWidth), _PST.dpToPx(contentHeight)));

        contentLayout.setX(_PST.dpToPx((int) (width * 0.05)));
        contentLayout.setY(_PST.dpToPx((int) (panelHeight * 0.05)));
        contentLayout.setLayoutParams(new RelativeLayout.LayoutParams(_PST.dpToPx(width), _PST.dpToPx(panelHeight)));

        _PAT.setLocation(contentLayout, 0, 0);

        _PAT.setSize(contentPanel, width, panelHeight);

    }

    public void show(Context context) {
        LemonHelloView.defaultHelloView().showHelloWithInfo(context, this);
    }

}
