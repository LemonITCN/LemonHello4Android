package lemonsoft.net.lemonhello4android;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;

import net.lemonsoft.lemonhello.LemonHello;
import net.lemonsoft.lemonhello.LemonHelloAction;
import net.lemonsoft.lemonhello.LemonHelloInfo;
import net.lemonsoft.lemonhello.LemonHelloView;
import net.lemonsoft.lemonhello.interfaces.LemonHelloActionDelegate;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                LemonHelloInfo info = new LemonHelloInfo();
                info.setTitle("要删除\"LemonKit\"吗?")
                        .setContent("删除此应用讲同事删除其数据删除此应用讲同事删除其数据删除此应用讲同事删除其数据删除此应用讲同事删除其数据删除此应用讲同事删除其数据删除此应用讲同事删除其数据删除此应用讲同事删除其数据删除此应用讲同事删除其数据删除此应用讲同事删除其数据删除此应用讲同事删除其数据删除此应用讲同事删除其数据删除此应用讲同事删除其数据删除此应用讲同事删除其数据删除此应用讲同事删除其数据删除此应用讲同事删除其数据")
                        .addAction(new LemonHelloAction("取消", new LemonHelloActionDelegate() {
                            @Override
                            public void onClick(LemonHelloView helloView, LemonHelloInfo helloInfo, LemonHelloAction helloAction) {

                            }
                        }))
                        .addAction(new LemonHelloAction("删除", Color.RED, new LemonHelloActionDelegate() {
                            @Override
                            public void onClick(LemonHelloView helloView, LemonHelloInfo helloInfo, LemonHelloAction helloAction) {

                            }
                        }));
                LemonHelloView.defaultHelloView().showHelloWithInfo(MainActivity.this, info);
            }
        }, 2000);

    }
}
