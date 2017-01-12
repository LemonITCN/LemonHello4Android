package net.lemonsoft.lemonhello;

import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.SumPathEffect;
import android.graphics.drawable.Drawable;
import android.widget.RelativeLayout;
import android.widget.TextView;

import net.lemonsoft.lemonhello.enums.LemonHelloIconLocation;
import net.lemonsoft.lemonhello.interfaces.LemonHelloEventDelegate;
import net.lemonsoft.lemonhello.interfaces.LemonPaintContext;

import java.util.List;

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
     * 对话框的动画list（按钮说明信息list）
     */
    private List<LemonHelloAction> actions = LemonHelloGlobal.actions;
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

    public void setShowStatusBar(boolean showStatusBar) {
        this.showStatusBar = showStatusBar;
    }

    public int getStatusBarColor() {
        return statusBarColor;
    }

    public void setStatusBarColor(int statusBarColor) {
        this.statusBarColor = statusBarColor;
    }

    public LemonHelloEventDelegate getEventDelegate() {
        return eventDelegate;
    }

    public void setEventDelegate(LemonHelloEventDelegate eventDelegate) {
        this.eventDelegate = eventDelegate;
    }

    public boolean isUseMessageQueue() {
        return useMessageQueue;
    }

    public void setUseMessageQueue(boolean useMessageQueue) {
        this.useMessageQueue = useMessageQueue;
    }

    private int getTextViewHeight(TextView textView) {
        Paint.FontMetrics fontMetrics = textView.getPaint().getFontMetrics();
        return _PST.pxToDp((int) (fontMetrics.descent - fontMetrics.top)) + 2;
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

    public void calViewsFrame(RelativeLayout contentPanel,
                              LemonPaintView paintView,
                              TextView titleView,
                              TextView contentView,
                              RelativeLayout actionContainer) {
        titleView.setText(title);
        contentView.setText(content);
        titleView.setTextSize(titleFontSize);
        contentView.setTextSize(contentFontSize);

        int panelHeight, titleWidth, titleHeight, contentWidth, contentHeight,
                titleX, titleY, contentX, contentY, iconX, iconY, actionsY;
        panelHeight = titleX = titleY = contentX = iconX = iconY = padding;

        titleWidth = width - padding * 2;
        titleHeight = getTextViewHeight(titleView);
        contentHeight = getTextViewHeight(contentView);
        contentWidth = width - padding * 2 - space - iconWidth;

        _PAT.setLocation(titleView, titleX, titleY);
        _PAT.setSize(titleView, titleWidth, titleHeight);

        switch (iconLocation) {
            case TOP:
                iconX = (width - iconWidth) / 2;
                contentWidth = width - padding * 2;
                break;
            case LEFT:
                iconY = titleY + titleHeight + space;
                contentX = iconX + iconWidth + space;
                break;
            case RIGHT:
                iconY = titleY + titleHeight + space;
                break;
        }

        contentY = titleY + titleHeight + space;

        _PAT.setLocation(paintView, iconX, iconY);
        _PAT.setSize(paintView, iconWidth, iconWidth);
        paintView.setBackgroundColor(Color.RED);
        contentView.setBackgroundColor(Color.BLUE);
        titleView.setBackgroundColor(Color.GRAY);


        _PAT.setSize(contentView, contentWidth, contentHeight);
        _PAT.setLocation(contentView, contentX, contentY);

        _PAT.setLocation(contentPanel, (_PST.screenWidthDp() - width) / 2, 400);
        _PAT.setSize(contentPanel, width, 100);


    }

}
