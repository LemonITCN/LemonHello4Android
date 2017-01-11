package net.lemonsoft.lemonhello;

import android.content.Context;
import android.util.DisplayMetrics;
import android.view.WindowManager;

/**
 * LemonBubble内私有使用的尺寸工具类
 * 开发者，请你不要在你的项目中尝试调用此类中的方法，你可以在LemonKit中找到更适合你的替代品
 * https://github.com/1em0nsOft/LemonKit4Android
 * Created by LiuRi on 2016/12/23.
 */

class LemonHelloPrivateSizeTool {

    private float _density;
    private DisplayMetrics _metrics;

    private static LemonHelloPrivateSizeTool _privateSizeTool;

    static synchronized LemonHelloPrivateSizeTool getPrivateSizeTool() {
        if (_privateSizeTool == null)
            _privateSizeTool = new LemonHelloPrivateSizeTool();
        return _privateSizeTool;
    }

    void setContext(Context context) {
        _density = context.getResources().getDisplayMetrics().density;
        _metrics = new DisplayMetrics();
        ((WindowManager) (context.getSystemService(Context.WINDOW_SERVICE))).getDefaultDisplay().getMetrics(_metrics);
    }

    /**
     * 换算dp到px
     *
     * @param dpValue dp的数值
     * @return 对应的px数值
     */
    int dpToPx(int dpValue) {
        return (int) (_density * dpValue + 0.5f);
    }

    /**
     * 换算px到dp
     *
     * @param pxValue px的数值
     * @return 对应的dp数值
     */
    int pxToDp(int pxValue) {
        return (int) (pxValue / _density + 0.5f);
    }

    /**
     * 获取屏幕的宽，单位dp
     *
     * @return 屏幕宽度dp值
     */
    int screenWidthDp() {
        return pxToDp(_metrics.widthPixels);
    }

    /**
     * 获取屏幕的高，单位dp
     *
     * @return 屏幕高度的dp值
     */
    int screenHeightDp() {
        return pxToDp(_metrics.heightPixels);
    }

}
