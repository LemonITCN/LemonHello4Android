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

    private Button sButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sButton = (Button) findViewById(R.id.sButton);
        sButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LemonHello.getSuccessHello("要删除\"LemonKit\"吗?", "您选择删除后会同时删除应用内的所有数据，确认删除吗？")
                        .setIconWidth(80)
                        .addAction(new LemonHelloAction("取消", Color.argb(255, 0, 120, 215), new LemonHelloActionDelegate() {
                            @Override
                            public void onClick(LemonHelloView helloView, LemonHelloInfo helloInfo, LemonHelloAction helloAction) {
                                helloView.hide();
                            }
                        }))
                        .addAction(new LemonHelloAction("删除", Color.RED, new LemonHelloActionDelegate() {
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
