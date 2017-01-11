package net.lemonsoft.lemonhello;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;

import net.lemonsoft.lemonhello.interfaces.LemonPaintContext;

import java.util.List;

/**
 * LemonHello - 样式描述信息模型类
 * Created by LiuRi on 2017/1/11.
 */

public class LemonHelloInfo {

    /**
     * 对话框控件的宽度
     */
    private int width;
    /**
     * 对话框控件的圆角半径
     */
    private int cornerRadius;
    /**
     * 对话框面板的背景颜色
     */
    private int panelBackgroundColor;
    /**
     * 对话框面板的背景Drawable
     */
    private Drawable panelBackgroundDrawable;
    /**
     * 对话框的背景蒙版颜色
     */
    private int maskColor;
    /**
     * 对话框的图标绘制上下文
     * 如果icon属性为空，那么会调用该属性iconPaintContext绘制
     * 如果iconPaintContext为空，那么会认为无图标
     */
    private LemonPaintContext iconPaintContext;
    /**
     * 对话框的图标对象
     * 如果该对象为空，那么会调用iconPaintContext绘制
     * 如果iconPaintContext为空，那么会认为无图标
     */
    private Bitmap icon;
    /**
     * 对话框的标题，如果该属性为null或空字符串，那么认为其没有标题
     */
    private String title;
    /**
     * 对话框的正文内容文字
     */
    private String content;
    /**
     * 标题文字的颜色
     */
    private int titleColor;
    /**
     * 对话框正文内容文字颜色
     */
    private int contentColor;
    /**
     * 标题文字的字体大小
     */
    private int titleFontSize;
    /**
     * 对话对征文内容文字字体大小
     */
    private int contentFontSize;
    /**
     * 对话框的动画list（按钮说明信息list）
     */
    private List<LemonHelloAction> actions;
    /**
     * 第一行的按钮数量
     * 如果超过这个数量，那么每一个Action都会被放到单独的行中
     * 如果该数值设置为<1的数字，那么认为该值为1
     */
    private int firstLineButtonCount = 2;

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getCornerRadius() {
        return cornerRadius;
    }

    public void setCornerRadius(int cornerRadius) {
        this.cornerRadius = cornerRadius;
    }

    public int getPanelBackgroundColor() {
        return panelBackgroundColor;
    }

    public void setPanelBackgroundColor(int panelBackgroundColor) {
        this.panelBackgroundColor = panelBackgroundColor;
    }

    public Drawable getPanelBackgroundDrawable() {
        return panelBackgroundDrawable;
    }

    public void setPanelBackgroundDrawable(Drawable panelBackgroundDrawable) {
        this.panelBackgroundDrawable = panelBackgroundDrawable;
    }

    public int getMaskColor() {
        return maskColor;
    }

    public void setMaskColor(int maskColor) {
        this.maskColor = maskColor;
    }

    public LemonPaintContext getIconPaintContext() {
        return iconPaintContext;
    }

    public void setIconPaintContext(LemonPaintContext iconPaintContext) {
        this.iconPaintContext = iconPaintContext;
    }

    public Bitmap getIcon() {
        return icon;
    }

    public void setIcon(Bitmap icon) {
        this.icon = icon;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getTitleColor() {
        return titleColor;
    }

    public void setTitleColor(int titleColor) {
        this.titleColor = titleColor;
    }

    public int getContentColor() {
        return contentColor;
    }

    public void setContentColor(int contentColor) {
        this.contentColor = contentColor;
    }

    public int getTitleFontSize() {
        return titleFontSize;
    }

    public void setTitleFontSize(int titleFontSize) {
        this.titleFontSize = titleFontSize;
    }

    public int getContentFontSize() {
        return contentFontSize;
    }

    public void setContentFontSize(int contentFontSize) {
        this.contentFontSize = contentFontSize;
    }

    public List<LemonHelloAction> getActions() {
        return actions;
    }

    public void setActions(List<LemonHelloAction> actions) {
        this.actions = actions;
    }

    public int getFirstLineButtonCount() {
        return Math.max(firstLineButtonCount, 1);
    }

    public void setFirstLineButtonCount(int firstLineButtonCount) {
        this.firstLineButtonCount = Math.max(firstLineButtonCount, 1);
    }
}
