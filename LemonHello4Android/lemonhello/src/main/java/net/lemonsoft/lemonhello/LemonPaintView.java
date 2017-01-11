package net.lemonsoft.lemonhello;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.widget.ImageView;

/**
 * hello中的动画与帧图片展示控件
 * Created by LiuRi on 2016/12/24.
 */

public class LemonPaintView extends ImageView {

    // 保存hello信息对象
    private LemonHelloInfo _helloInfo;
    // 控制动画播放进度的数值动画器
    private ValueAnimator _playProgressValueAnimator;
    // 动画播放进度存储变量，0-1之间的浮点数
    private float _playProgressValue;

    public LemonPaintView(final Context context) {
        super(context);
        if (_playProgressValueAnimator != null) // 如果动画执行器变量不是null
            _playProgressValueAnimator.end(); // 那么有可能上一次动画执行器的还没执行完，先停止上一次的
        else // 如果执行到这里，说明动画执行器对象还为null，
            _playProgressValueAnimator = ValueAnimator.ofFloat(0, 1);// 那么创建动画执行器
        _playProgressValueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                _playProgressValue = (float) valueAnimator.getAnimatedValue();// 保存当前的动画进度值
                postInvalidate();// 刷新界面（重新调用onDraw方法重绘）
            }
        });
    }

    public void setHelloInfo(LemonHelloInfo bubbleInfo) {
        if (_playProgressValueAnimator != null)
            _playProgressValueAnimator.end();// 为了保险起见，先尝试停止上一次的动画执行器
        _helloInfo = bubbleInfo;// 保存hello信息对象
        if (bubbleInfo != null) {// 如果传进来的不是null，那么开始调用动画执行器，开始播放动画，因为防止在非自定义动画模式下显示自定义动画的最后一帧，所以在这里进行一次判断

            // 这里之所以没用Integer.MAX_VALUE,是因为在Android7.0中有时候有问题，如果谁能知道原因麻烦告诉我一下
            // ⤵️⤵️⤵️⤵️⤵️⤵️⤵️⤵️⤵️⤵️⤵️⤵️⤵️⤵️⤵️⤵️⤵️⤵️⤵️⤵️⤵️⤵️⤵️⤵️⤵️⤵️⤵️⤵️⤵️⤵️⤵️⤵️⤵️⤵️⤵️⤵️⤵️⤵️⤵️⤵️⤵️⤵️⤵️⤵️⤵️⤵️⤵️⤵️⤵️⤵️⤵️
            _playProgressValueAnimator.setRepeatCount(_helloInfo.isIconAnimationRepeat() ? 99999999 : 0);// 根据hello信息对象中设置的是否重复来设置重复次数
            _playProgressValueAnimator.start();// 开始播放动画
            _playProgressValueAnimator.setDuration(bubbleInfo.getAnimationTime());// 设置单次动画的总执行时间
        }
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (_helloInfo != null &&
                _helloInfo.getIconPaintContext() != null &&
                _helloInfo.getIcon() == null)// 判断非空指针才进行操作
            _helloInfo.getIconPaintContext().paint(canvas, _playProgressValue);// 调用hello信息对象中的预先设置的绘制函数开始绘制
    }

}
