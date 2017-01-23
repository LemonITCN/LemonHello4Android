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

    /**
     * 获取一个带有橘黄色主题的感叹号!提示框
     *
     * @param title   提示的标题内容
     * @param content 提示的正文内容
     * @return 提示框信息描述对象
     */
    public static LemonHelloInfo getWarningHello(String title, String content) {
        LemonHelloInfo info = new LemonHelloInfo();
        info.setIconLocation(LemonHelloIconLocation.TOP)
                .setIconPaintContext(new LemonPaintContext() {
                    @Override
                    public void paint(Canvas canvas, float playProgress) {
                        int color = Color.argb(140, 255, 111, 2);
                        Paint paint = new Paint();
                        paint.setStyle(Paint.Style.FILL);
                        // 绘制背景圆形
                        paint.setColor(color);
                        paint.setStrokeCap(Paint.Cap.ROUND);
                        paint.setStrokeWidth(8);
                        paint.setAntiAlias(true);
                        canvas.drawCircle(canvas.getWidth() / 2, canvas.getHeight() / 2, (canvas.getWidth() / 2 - 4) * playProgress, paint);
                        // 设置画笔颜色为白色，并绘制感叹号
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

    /**
     * 获取一个带有蓝色主题的信息i提示框
     *
     * @param title   提示的标题内容
     * @param content 提示的正文内容
     * @return 提示框信息描述对象
     */
    public static LemonHelloInfo getInformationHello(String title, String content) {
        LemonHelloInfo info = new LemonHelloInfo();
        info.setIconLocation(LemonHelloIconLocation.TOP)
                .setIconPaintContext(new LemonPaintContext() {
                    @Override
                    public void paint(Canvas canvas, float playProgress) {
                        int color = Color.argb(180, 51, 153, 255);
                        Paint paint = new Paint();
                        paint.setStyle(Paint.Style.FILL);
                        // 绘制背景圆形
                        paint.setColor(color);
                        paint.setStrokeCap(Paint.Cap.ROUND);
                        paint.setStrokeWidth(8);
                        paint.setAntiAlias(true);
                        canvas.drawCircle(canvas.getWidth() / 2, canvas.getHeight() / 2, (canvas.getWidth() / 2 - 4) * playProgress, paint);
                        // 设置画笔为白色并开始绘制中间的i
                        paint.setColor(Color.WHITE);

                        Path path = new Path();
                        path.addCircle(canvas.getWidth() / 2, canvas.getHeight() * 0.3f, canvas.getWidth() * 0.05f * playProgress, Path.Direction.CW);
                        path.moveTo(canvas.getWidth() * 0.45f, canvas.getHeight() * 0.425f);
                        path.lineTo(canvas.getWidth() * 0.55f, canvas.getHeight() * 0.425f);
                        path.lineTo(canvas.getWidth() * (0.55f - 0.025f * playProgress), canvas.getHeight() * (0.2f + 0.55f * playProgress));
                        path.lineTo(canvas.getWidth() * (0.45f + 0.025f * playProgress), canvas.getHeight() * (0.2f + 0.55f * playProgress));
                        canvas.drawPath(path, paint);
                    }
                })
                .setIconWidth(60)
                .setTitle(title)
                .setContent(content);
        return info;
    }

    /**
     * 获取一个带有红色主题的错X号提示框
     *
     * @param title   提示的标题内容
     * @param content 提示的正文内容
     * @return 提示框信息描述对象
     */
    public static LemonHelloInfo getErrorHello(String title, String content) {
        LemonHelloInfo info = new LemonHelloInfo();
        info.setIconLocation(LemonHelloIconLocation.TOP)
                .setIconPaintContext(new LemonPaintContext() {
                    @Override
                    public void paint(Canvas canvas, float playProgress) {
                        int color = Color.argb(160, 255, 51, 0);
                        Paint paint = new Paint();
                        paint.setStyle(Paint.Style.FILL);
                        // 绘制背景圆形
                        paint.setColor(color);
                        paint.setStrokeCap(Paint.Cap.ROUND);
                        paint.setStrokeWidth(canvas.getWidth() * 0.05f);
                        paint.setAntiAlias(true);
                        canvas.drawCircle(canvas.getWidth() / 2, canvas.getHeight() / 2, (canvas.getWidth() / 2 - 4) * playProgress, paint);
                        // 设置画笔为白色并开始绘制中间的i
                        paint.setColor(Color.WHITE);
                        // 动画旋转画布
                        canvas.rotate(-270 * playProgress, canvas.getWidth() / 2, canvas.getHeight() / 2);
                        // 画X
                        canvas.drawLine(canvas.getWidth() * 0.35f, canvas.getHeight() * 0.35f, canvas.getWidth() * 0.65f, canvas.getHeight() * 0.65f, paint);
                        canvas.drawLine(canvas.getWidth() * 0.65f, canvas.getHeight() * 0.35f, canvas.getWidth() * 0.35f, canvas.getHeight() * 0.65f, paint);
                    }
                })
                .setIconWidth(60)
                .setTitle(title)
                .setContent(content);
        return info;
    }

    /**
     * 获取一个带有绿色主题的对号提示框
     *
     * @param title   提示的标题内容
     * @param content 提示的正文内容
     * @return 提示框信息描述对象
     */
    public static LemonHelloInfo getSuccessHello(String title, String content) {
        LemonHelloInfo info = new LemonHelloInfo();
        info.setIconLocation(LemonHelloIconLocation.TOP)
                .setIconPaintContext(new LemonPaintContext() {
                    @Override
                    public void paint(Canvas canvas, float playProgress) {
                        int color = Color.argb(120, 0, 153, 0);
                        Paint paint = new Paint();
                        paint.setStyle(Paint.Style.FILL);
                        // 绘制背景圆形
                        paint.setColor(color);
                        paint.setStrokeCap(Paint.Cap.ROUND);
                        paint.setStrokeWidth(canvas.getWidth() * 0.05f);
                        paint.setAntiAlias(true);
                        canvas.drawCircle(canvas.getWidth() / 2, canvas.getHeight() / 2, (canvas.getWidth() / 2 - 4) * playProgress, paint);
                        // 设置画笔为白色并开始绘制中间的i
                        paint.setColor(Color.WHITE);
                        // 动画旋转画布
                        canvas.rotate(-90 + 90 * playProgress, canvas.getWidth() / 2, canvas.getHeight() / 2);
                        // 画X
                        canvas.drawLine(canvas.getWidth() * 0.3f, canvas.getHeight() * 0.5f, canvas.getWidth() * 0.45f, canvas.getHeight() * 0.65f, paint);
                        canvas.drawLine(canvas.getWidth() * 0.45f, canvas.getHeight() * 0.65f, canvas.getWidth() * 0.7f, canvas.getHeight() * 0.35f, paint);
                    }
                })
                .setIconWidth(60)
                .setTitle(title)
                .setContent(content);
        return info;
    }

}
