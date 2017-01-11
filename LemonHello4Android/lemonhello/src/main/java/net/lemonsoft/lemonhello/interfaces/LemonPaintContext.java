package net.lemonsoft.lemonhello.interfaces;

import android.graphics.Canvas;

/**
 * 正式绘制动画的接口
 */
public interface LemonPaintContext {
    /**
     * 绘制方法
     *
     * @param canvas       要绘制图形的画布
     * @param playProgress 当前动画播放的进度
     */
    void paint(Canvas canvas, float playProgress);
}
