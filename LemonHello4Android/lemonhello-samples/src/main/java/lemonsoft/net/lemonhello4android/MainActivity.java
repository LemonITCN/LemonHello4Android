package lemonsoft.net.lemonhello4android;

import android.app.Activity;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.RectF;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import net.lemonsoft.lemonhello.LemonHello;
import net.lemonsoft.lemonhello.LemonHelloAction;
import net.lemonsoft.lemonhello.LemonHelloInfo;
import net.lemonsoft.lemonhello.LemonHelloView;
import net.lemonsoft.lemonhello.adapter.LemonHelloEventDelegateAdapter;
import net.lemonsoft.lemonhello.enums.LemonHelloIconLocation;
import net.lemonsoft.lemonhello.interfaces.LemonHelloActionDelegate;
import net.lemonsoft.lemonhello.interfaces.LemonPaintContext;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends Activity {

    private LinearLayout btn_success;
    private LinearLayout btn_error;
    private LinearLayout btn_warning;
    private LinearLayout btn_information;
    private LinearLayout btn_bookmark;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_success = (LinearLayout) findViewById(R.id.btn_success);
        btn_error = (LinearLayout) findViewById(R.id.btn_error);
        btn_warning = (LinearLayout) findViewById(R.id.btn_warning);
        btn_information = (LinearLayout) findViewById(R.id.btn_information);
        btn_bookmark = (LinearLayout) findViewById(R.id.btn_bookmark);

        initFunctions();

//        sButton = (Button) findViewById(R.id.sButton);
//        sButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                LemonHello.getSuccessHello("要删除\"LemonKit\"吗?", "您选择删除后会同时删除应用内的所有数据，确认删除吗？")
//                        .setIconWidth(80)
//                        .addAction(new LemonHelloAction("取消", Color.argb(255, 0, 120, 215), new LemonHelloActionDelegate() {
//                            @Override
//                            public void onClick(LemonHelloView helloView, LemonHelloInfo helloInfo, LemonHelloAction helloAction) {
//                                helloView.hide();
//                            }
//                        }))
//                        .addAction(new LemonHelloAction("删除", Color.RED, new LemonHelloActionDelegate() {
//                            @Override
//                            public void onClick(LemonHelloView helloView, LemonHelloInfo helloInfo, LemonHelloAction helloAction) {
//                                helloView.hide();
//                            }
//                        }))
//                        .show(MainActivity.this);
//            }
//        });
    }

    private void initFunctions() {

        // 成功按钮被点击
        btn_success.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LemonHello.getSuccessHello("提交成功", "恭喜您，您所填写的数据已经全部提交成功，我们的客服人员将在24小时内进行审核，请耐心等待.")
                        .addAction(new LemonHelloAction("我知道啦", new LemonHelloActionDelegate() {
                            @Override
                            public void onClick(LemonHelloView helloView, LemonHelloInfo helloInfo, LemonHelloAction helloAction) {
                                helloView.hide();
                            }
                        }))
                        .show(MainActivity.this);
            }
        });

        btn_error.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LemonHello.getErrorHello("发生错误", "对不起，您没有权限删除此数据，请联系系统管理员进行操作，谢谢。")
                        .addAction(new LemonHelloAction("关闭", new LemonHelloActionDelegate() {
                            @Override
                            public void onClick(LemonHelloView helloView, LemonHelloInfo helloInfo, LemonHelloAction helloAction) {
                                helloView.hide();
                            }
                        }))
                        .show(MainActivity.this);
            }
        });


    }
}
