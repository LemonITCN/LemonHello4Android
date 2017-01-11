package net.lemonsoft.lemonhello;

import android.animation.ValueAnimator;
import android.graphics.Color;
import android.graphics.RectF;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.RoundRectShape;
import android.os.Build;
import android.view.View;
import android.widget.RelativeLayout;

/**
 * LemonBubble私有类，该类可以以动画的方式移动控件的位置、大小等外观属性
 * 开发者，请你不要在你的项目中尝试调用此类中的方法，你可以在LemonKit中找到更适合你的替代品
 * https://github.com/1em0nsOft/LemonKit4Android
 * Created by LiuRi on 2016/12/25.
 */

class LemonHelloPrivateAnimationTool {

    // 私有动画工具类实例变量，单例方法准备
    private static LemonHelloPrivateAnimationTool _privateAnimationTool;
    // 私有尺寸工具类，该变量仅为了精简代码，代码整洁
    private static LemonHelloPrivateSizeTool _PST = LemonHelloPrivateSizeTool.getPrivateSizeTool();

    // 私有动画工具类的单例方法
    static synchronized LemonHelloPrivateAnimationTool defaultPrivateAnimationTool() {
        if (_privateAnimationTool == null)
            _privateAnimationTool = new LemonHelloPrivateAnimationTool();
        return _privateAnimationTool;
    }

    // 根据DP值返回px值，为了简洁易懂代码而写
    private int _DP(int value) {
        return LemonHelloPrivateSizeTool.getPrivateSizeTool().dpToPx(value);
    }

    /**
     * 对指定的控件设置尺寸大小
     *
     * @param view     要设置尺寸的控件
     * @param widthDp  宽度，单位dp
     * @param heightDp 高度，单位dp
     */
    void setSize(final View view, final int widthDp, final int heightDp) {
        // 获取整个动画的其实空间宽高
        final int startWidth = _PST.pxToDp(view.getLayoutParams() == null ? 0 : view.getLayoutParams().width);
        final int startHeight = _PST.pxToDp(view.getLayoutParams() == null ? 0 : view.getLayoutParams().height);
        // 计算起始宽高和目标宽高之间的差值
        final int subWidth = widthDp - startWidth;
        final int subHeight = heightDp - startHeight;
        // 创建动画进度处理器，从0-1之间设置动画的进度周期
        ValueAnimator valueAnimator = ValueAnimator.ofFloat(0, 1);
        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                // 根据动画执行进度来计算当前进度下宽和高
                int currentWidth = (int) ((float) animation.getAnimatedValue() * subWidth + startWidth);
                int currentHeight = (int) ((float) animation.getAnimatedValue() * subHeight + startHeight);
                // 设置宽和高
                view.setLayoutParams(
                        new RelativeLayout.LayoutParams(_DP(currentWidth), _DP(currentHeight)));
                // 刷新界面
                view.postInvalidate();
            }
        });
        // 启动动画执行器
        valueAnimator.start();
    }

    /**
     * 设置控件的位置
     *
     * @param view 要设置位置的控件对象
     * @param x    水平x坐标
     * @param y    垂直y坐标
     */
    void setLocation(final View view, int x, int y) {
        // 获取当前控件的初始XY坐标的DP值
        final int startX = _PST.pxToDp((int) (view.getX()));
        final int startY = _PST.pxToDp((int) (view.getY()));
        // 计算起始坐标和结束坐标之间的差值
        final int subX = x - startX;
        final int subY = y - startY;
        // 初始化动画过程处理器
        ValueAnimator valueAnimator = ValueAnimator.ofFloat(0, 1);
        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                // 根据动画0-1之间的播放进度计算此时的控件XY坐标位置
                view.setX(_DP((int) ((float) animation.getAnimatedValue() * subX + startX)));
                view.setY(_DP((int) ((float) animation.getAnimatedValue() * subY + startY)));
                view.postInvalidate();
            }
        });
        // 开始执行动画
        valueAnimator.start();
    }

    /**
     * 渐变设置透明度
     *
     * @param view  设置透明度的控件
     * @param alpha 透明度的目标值
     */
    void setAlpha(final View view, float alpha) {
        // 初始化动画执行器，让值得起始点为当前控件的透明度，目标值为目标透明度
        ValueAnimator valueAnimator = ValueAnimator.ofFloat(view.getAlpha(), alpha);
        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                // 动态取出当前动画执行器的动画过程值并设置给控件
                view.setAlpha((float) animation.getAnimatedValue());
            }
        });
        // 启动动画执行器
        valueAnimator.start();
    }

    /**
     * 动画改变背景颜色
     *
     * @param view  要改变背景颜色的控件
     * @param color 要改变成的目标背景颜色
     */
    void setBackgroundColor(final View view, final int cornerRadius, int color) {
        int startColor = Color.argb(0, 255, 255, 255);
        Drawable drawable = view.getBackground();
        if (drawable instanceof ColorDrawable)// 如果是ColorDrawable，那么通过这种方式取出原始颜色
            startColor = ((ColorDrawable) drawable).getColor();
        if (drawable instanceof ShapeDrawable)// 如果是ShapeDrawable，那么通过这种方式取出原始颜色
            startColor = ((ShapeDrawable) drawable).getPaint().getColor();
        // 先算出原颜色的ARGB值
        final int startA = (startColor & 0xff000000) >>> 24;
        final int startR = (startColor & 0x00ff0000) >> 16;
        final int startG = (startColor & 0x0000ff00) >> 8;
        final int startB = (startColor & 0x000000ff);
        // 算出目标颜色的ARGB值
        int aimA = (color & 0xff000000) >>> 24;
        int aimR = (color & 0x00ff0000) >> 16;
        int aimG = (color & 0x0000ff00) >> 8;
        int aimB = (color & 0x000000ff);
        // 算颜色ARGB的差值
        final int subA = aimA - startA;
        final int subR = aimR - startR;
        final int subG = aimG - startG;
        final int subB = aimB - startB;
        ValueAnimator valueAnimator = ValueAnimator.ofFloat(0, 1);
        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                // 根据进度来计算当前动画进度下ARGB的四种值并应用修改颜色
                int color = Color.argb(
                        (int) (startA + subA * (float) animation.getAnimatedValue()),
                        (int) (startR + subR * (float) animation.getAnimatedValue()),
                        (int) (startG + subG * (float) animation.getAnimatedValue()),
                        (int) (startB + subB * (float) animation.getAnimatedValue()));
                if (cornerRadius == 0)// 如果当前不需要圆角，那么直接设置背景颜色即可
                    view.setBackgroundColor(color);
                else// 如果当前空间设置了圆角，那么还得通过构造圆角背景的方法来创建drawable并设置
                    setCornerRadius(view, cornerRadius, color);
            }
        });
        // 开始动画执行器
        valueAnimator.start();
    }

    // 设置空间的圆角
    void setCornerRadius(View view, int radius, int color) {
        radius = _DP(radius);
        int borderWidth = 0;// 加边框后会出现空心圆角矩形的效果，所以设置为0
        float[] outerRadius = new float[8];
        float[] innerRadius = new float[8];
        for (int i = 0; i < 8; i++) {
            outerRadius[i] = radius + borderWidth;
            innerRadius[i] = radius;
        }
        ShapeDrawable shapeDrawable = // 创建图形drawable
                new ShapeDrawable(
                        // 创建圆角矩形
                        new RoundRectShape(outerRadius,
                                new RectF(borderWidth, borderWidth, borderWidth, borderWidth),
                                innerRadius));
        shapeDrawable.getPaint().setColor(color);// 使用指定的颜色绘制，即背景颜色
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
            // 高版本SDK使用新的API
            view.setBackground(shapeDrawable);
        } else {
            view.setBackgroundDrawable(shapeDrawable);
        }
    }

}
