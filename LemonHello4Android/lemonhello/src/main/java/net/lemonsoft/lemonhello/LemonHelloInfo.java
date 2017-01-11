package net.lemonsoft.lemonhello;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;

import net.lemonsoft.lemonhello.interfaces.LemonPaintContext;

/**
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


}
