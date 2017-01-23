package net.lemonsoft.lemonhello;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;

import net.lemonsoft.lemonhello.enums.LemonHelloIconLocation;
import net.lemonsoft.lemonhello.interfaces.LemonPaintContext;

/**
 * LemonHello 对话框实际应用类
 * Created by LiuRi on 2017/1/11.
 */

public class LemonHello {

    public static LemonHelloInfo getWarningInfo(String title, String content) {
        LemonHelloInfo info = new LemonHelloInfo();
        info.setIconLocation(LemonHelloIconLocation.TOP)
                .setIconPaintContext(new LemonPaintContext() {
                    @Override
                    public void paint(Canvas canvas, float playProgress) {
                        int color = Color.argb(140, 255, 111, 2);
                        Paint paint = new Paint();
                        paint.setStyle(Paint.Style.FILL);
                        // 设置外侧的浅色圆形为图标颜色的0.1倍透明度
                        paint.setColor(color);
                        paint.setStrokeCap(Paint.Cap.ROUND);
                        paint.setStrokeWidth(8);
                        paint.setAntiAlias(true);
                        // 绘制外侧的完整浅色圆形
                        canvas.drawCircle(canvas.getWidth() / 2, canvas.getHeight() / 2, (canvas.getWidth() / 2 - 4) * playProgress, paint);


//                                paint.setStyle(Paint.Style.STROKE);
                        paint.setColor(Color.WHITE);
                        Path path = new Path();
                        path.moveTo(canvas.getWidth() * 0.45f, canvas.getHeight() * 0.2f);
                        path.lineTo(canvas.getWidth() * 0.55f, canvas.getHeight() * 0.2f);
                        path.lineTo(canvas.getWidth() * (0.55f - 0.025f * playProgress), canvas.getHeight() * (0.2f + 0.45f * playProgress));
                        path.lineTo(canvas.getWidth() * (0.45f + 0.025f * playProgress), canvas.getHeight() * (0.2f + 0.45f * playProgress));
                        path.close();

                        path.addRect(canvas.getWidth() * (0.5f - 0.033f * playProgress),
                                canvas.getWidth() * (0.75f - 0.033f * playProgress),
                                canvas.getWidth() * (0.5f + 0.033f * playProgress),
                                canvas.getWidth() * (0.75f + 0.033f * playProgress), Path.Direction.CW);
                        canvas.drawPath(path, paint);
                    }
                })
                .setIconWidth(60)
                .setTitle(title)
                .setContent(content);
        return info;
    }

}
