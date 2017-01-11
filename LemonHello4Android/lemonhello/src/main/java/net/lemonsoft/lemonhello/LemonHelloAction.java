package net.lemonsoft.lemonhello;

import android.graphics.drawable.Drawable;

import net.lemonsoft.lemonhello.interfaces.LemonHelloActionDelegate;

/**
 * LemonHello - 按钮事件描述类
 * 描述事件的功能、按钮文字颜色、
 * Created by LiuRi on 2017/1/11.
 */

public class LemonHelloAction {

    /**
     * 按钮的标题
     */
    private String title;
    /**
     * 按钮的背景颜色
     */
    private int backgroundColor;
    /**
     * 背景的Drawable
     */
    private Drawable backgroundDrawable;
    /**
     * 标题颜色
     */
    private int titleColor;
    /**
     * 手指触摸未离开时的按钮背景颜色
     */
    private int backgroundHoverColor;
    /**
     * 手指触摸未离开时的按钮背景Drawable
     */
    private Drawable backgroundHoverDrawable;
    /**
     * 手指触摸未离开时的按钮标题颜色
     */
    private int titleHoverColor;
    /**
     * 触摸的事件
     */
    private LemonHelloActionDelegate delegate;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getBackgroundColor() {
        return backgroundColor;
    }

    public void setBackgroundColor(int backgroundColor) {
        this.backgroundColor = backgroundColor;
    }

    public Drawable getBackgroundDrawable() {
        return backgroundDrawable;
    }

    public void setBackgroundDrawable(Drawable backgroundDrawable) {
        this.backgroundDrawable = backgroundDrawable;
    }

    public int getTitleColor() {
        return titleColor;
    }

    public void setTitleColor(int titleColor) {
        this.titleColor = titleColor;
    }

    public int getBackgroundHoverColor() {
        return backgroundHoverColor;
    }

    public void setBackgroundHoverColor(int backgroundHoverColor) {
        this.backgroundHoverColor = backgroundHoverColor;
    }

    public Drawable getBackgroundHoverDrawable() {
        return backgroundHoverDrawable;
    }

    public void setBackgroundHoverDrawable(Drawable backgroundHoverDrawable) {
        this.backgroundHoverDrawable = backgroundHoverDrawable;
    }

    public int getTitleHoverColor() {
        return titleHoverColor;
    }

    public void setTitleHoverColor(int titleHoverColor) {
        this.titleHoverColor = titleHoverColor;
    }

    public LemonHelloActionDelegate getDelegate() {
        return delegate;
    }

    public void setDelegate(LemonHelloActionDelegate delegate) {
        this.delegate = delegate;
    }
}
