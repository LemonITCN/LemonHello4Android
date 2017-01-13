package net.lemonsoft.lemonhello;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.Region;
import android.view.MotionEvent;
import android.widget.RelativeLayout;

/**
 * LemonHello 面板控件
 * Created by LiuRi on 2017/1/13.
 */

public class LemonHelloPanel extends RelativeLayout {

    private LemonHelloPrivateSizeTool _PST = LemonHelloPrivateSizeTool.getPrivateSizeTool();

    public LemonHelloPanel(Context context) {
        super(context);
    }

    private int cornerRadius = 0;

    public int getCornerRadius() {
        return cornerRadius;
    }

    public void setCornerRadius(int cornerRadius) {
        this.cornerRadius = cornerRadius;
        this.postInvalidate();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        // 需要剪切应显示视图的其余部分
        Path path = new Path();
        path.addRoundRect(
                new RectF(0, 0, canvas.getWidth(), canvas.getHeight()),
                _PST.dpToPx(cornerRadius),
                _PST.dpToPx(cornerRadius),
                Path.Direction.CW
        );
        canvas.clipPath(path, Region.Op.REPLACE);
    }

    @Override
    public boolean onInterceptHoverEvent(MotionEvent event) {
        return super.onInterceptHoverEvent(event);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        super.onTouchEvent(event);
        return true;
    }
}
