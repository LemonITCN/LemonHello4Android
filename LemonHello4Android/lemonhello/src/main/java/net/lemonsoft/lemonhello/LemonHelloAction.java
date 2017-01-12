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

    public LemonHelloAction() {
    }

    public LemonHelloAction(String title, LemonHelloActionDelegate delegate) {
        this.title = title;
        this.delegate = delegate;
    }

    public LemonHelloAction(String title, int titleColor, LemonHelloActionDelegate delegate) {
        this.title = title;
        this.titleColor = titleColor;
        this.delegate = delegate;
    }

    public LemonHelloAction(String title, int titleColor, int backgroundColor, LemonHelloActionDelegate delegate) {
        this.title = title;
        this.titleColor = titleColor;
        this.backgroundColor = backgroundColor;
        this.delegate = delegate;
    }

    public LemonHelloAction(String title, int titleColor, Drawable backgroundDrawable, LemonHelloActionDelegate delegate) {
        this.title = title;
        this.titleColor = titleColor;
        this.backgroundDrawable = backgroundDrawable;
        this.delegate = delegate;
    }

    public String getTitle() {
        return title;
    }

    public LemonHelloAction setTitle(String title) {
        this.title = title;
        return this;
    }

    public int getBackgroundColor() {
        return backgroundColor;
    }

    public LemonHelloAction setBackgroundColor(int backgroundColor) {
        this.backgroundColor = backgroundColor;
        return this;
    }

    public Drawable getBackgroundDrawable() {
        return backgroundDrawable;
    }

    public LemonHelloAction setBackgroundDrawable(Drawable backgroundDrawable) {
        this.backgroundDrawable = backgroundDrawable;
        return this;
    }

    public int getTitleColor() {
        return titleColor;
    }

    public LemonHelloAction setTitleColor(int titleColor) {
        this.titleColor = titleColor;
        return this;
    }

    public int getBackgroundHoverColor() {
        return backgroundHoverColor;
    }

    public LemonHelloAction setBackgroundHoverColor(int backgroundHoverColor) {
        this.backgroundHoverColor = backgroundHoverColor;
        return this;
    }

    public Drawable getBackgroundHoverDrawable() {
        return backgroundHoverDrawable;
    }

    public LemonHelloAction setBackgroundHoverDrawable(Drawable backgroundHoverDrawable) {
        this.backgroundHoverDrawable = backgroundHoverDrawable;
        return this;
    }

    public int getTitleHoverColor() {
        return titleHoverColor;
    }

    public LemonHelloAction setTitleHoverColor(int titleHoverColor) {
        this.titleHoverColor = titleHoverColor;
        return this;
    }

    public LemonHelloActionDelegate getDelegate() {
        return delegate;
    }

    public LemonHelloAction setDelegate(LemonHelloActionDelegate delegate) {
        this.delegate = delegate;
        return this;
    }
}
