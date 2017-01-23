package net.lemonsoft.lemonhello;

import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.Drawable;

import net.lemonsoft.lemonhello.enums.LemonHelloIconLocation;
import net.lemonsoft.lemonhello.interfaces.LemonHelloEventDelegate;
import net.lemonsoft.lemonhello.interfaces.LemonPaintContext;

import java.util.ArrayList;
import java.util.List;

/**
 * LemonHello 全局配置类
 * Created by LiuRi on 2017/1/12.
 */

public class LemonHelloGlobal {


    /**
     * 对话框控件的宽度
     */
    public static int width = 260;
    /**
     * 对话框控件的圆角半径
     */
    public static int cornerRadius = 8;
    /**
     * 对话框面板的背景颜色
     */
    public static int panelBackgroundColor = Color.argb(245, 255, 255, 255);
    /**
     * 对话框面板的背景Drawable
     */
    public static Drawable panelBackgroundDrawable = null;
    /**
     * 对话框的背景蒙版颜色
     */
    public static int maskColor = Color.argb(180, 0, 0, 0);
    /**
     * 对话框的图标绘制上下文
     * 如果icon属性为空，那么会调用该属性iconPaintContext绘制
     * 如果iconPaintContext为空，那么会认为无图标
     */
    public static LemonPaintContext iconPaintContext = null;
    /**
     * 图标动画是否需要重复
     */
    public static boolean isIconAnimationRepeat = false;
    /**
     * 动画的执行的所需时长
     */
    public static int animationTime = 400;
    /**
     * 对话框的图标对象
     * 如果该对象为空，那么会调用iconPaintContext绘制
     * 如果iconPaintContext为空，那么会认为无图标
     */
    public static Bitmap icon = null;
    /**
     * 图标的宽度
     * 图标为正方形，因此宽度也就是高度
     */
    public static int iconWidth = 40;
    /**
     * 图标的位置描述属性
     */
    public static LemonHelloIconLocation iconLocation = LemonHelloIconLocation.LEFT;
    /**
     * 对话框的标题，如果该属性为null或空字符串，那么认为其没有标题
     */
    public static String title = "LemonHello";
    /**
     * 对话框的正文内容文字
     */
    public static String content = "LemonHello Message";
    /**
     * 标题文字的颜色
     */
    public static int titleColor = Color.BLACK;
    /**
     * 对话框正文内容文字颜色
     */
    public static int contentColor = Color.BLACK;
    /**
     * 标题文字的字体大小
     */
    public static int titleFontSize = 15;
    /**
     * 对话对征文内容文字字体大小
     */
    public static int contentFontSize = 12;
    /**
     * 标题的按钮文字大小
     */
    public static int buttonFontSize = 14;
    /**
     * 第一行的按钮数量
     * 如果超过这个数量，那么每一个Action都会被放到单独的行中
     * 如果该数值设置为<1的数字，那么认为该值为1
     */
    public static int firstLineButtonCount = 2;
    /**
     * 是否显示状态栏
     */
    public static boolean showStatusBar = true;
    /**
     * 状态栏的颜色
     */
    public static int statusBarColor = Color.BLACK;
    /**
     * LemonHello的事件代理
     */
    public static LemonHelloEventDelegate eventDelegate = null;
    /**
     * 是否使用消息队列，若您使用了消息队列，那么后通知显示的消息框会在前一个消息框关闭后再显示
     */
    public static boolean useMessageQueue = true;
    /**
     * 控件的内边距
     */
    public static int padding = 16;
    /**
     * 控件的间隙
     */
    public static int space = 10;
    /**
     * action按钮的高度
     */
    public static int actionLineHeight = 40;
}
