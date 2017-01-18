package lemonsoft.net.lemonhello4android;

import android.app.Activity;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;

import net.lemonsoft.lemonhello.LemonHello;
import net.lemonsoft.lemonhello.LemonHelloAction;
import net.lemonsoft.lemonhello.LemonHelloInfo;
import net.lemonsoft.lemonhello.LemonHelloView;
import net.lemonsoft.lemonhello.adapter.LemonHelloEventDelegateAdapter;
import net.lemonsoft.lemonhello.enums.LemonHelloIconLocation;
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
                info.setIconLocation(LemonHelloIconLocation.TOP)
                        .setIcon(BitmapFactory.decodeResource(getResources(), R.mipmap.ic_launcher))
                        .setTitle("要删除\"LemonKit\"吗?")
                        .setContent("删除此应用将同时删除其应用内的所有数据，您确定要删除吗?")
                        .addAction(new LemonHelloAction("取消", new LemonHelloActionDelegate() {
                            @Override
                            public void onClick(LemonHelloView helloView, LemonHelloInfo helloInfo, LemonHelloAction helloAction) {
                                System.out.println("cancel");
                                helloView.hide();
                            }
                        }))
                        .addAction(new LemonHelloAction("删除", Color.RED, new LemonHelloActionDelegate() {
                            @Override
                            public void onClick(LemonHelloView helloView, LemonHelloInfo helloInfo, LemonHelloAction helloAction) {
                                System.out.println("delete");
                            }
                        }))
                        .setEventDelegate(new LemonHelloEventDelegateAdapter() {
                            @Override
                            public void onMaskTouch(LemonHelloView helloView, LemonHelloInfo helloInfo) {
                                System.out.println("mask touch");
                            }
                        });
                LemonHelloView.defaultHelloView().showHelloWithInfo(MainActivity.this, info);
            }
        }, 2000);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                LemonHelloInfo info = new LemonHelloInfo();
                info.setIconLocation(LemonHelloIconLocation.TOP)
                        .setIcon(BitmapFactory.decodeResource(getResources(), R.mipmap.ic_launcher))
                        .setTitle("要删除\"LemonKit\"吗?")
                        .setContent("删除此应用将同时删除其应用内的所有数据，您确定要删除吗?")
                        .addAction(new LemonHelloAction("取消", new LemonHelloActionDelegate() {
                            @Override
                            public void onClick(LemonHelloView helloView, LemonHelloInfo helloInfo, LemonHelloAction helloAction) {
                                System.out.println("cancel");
                                helloView.hide();
                            }
                        }))
                        .addAction(new LemonHelloAction("删除", Color.RED, new LemonHelloActionDelegate() {
                            @Override
                            public void onClick(LemonHelloView helloView, LemonHelloInfo helloInfo, LemonHelloAction helloAction) {
                                System.out.println("delete");
                            }
                        }))
                        .setEventDelegate(new LemonHelloEventDelegateAdapter() {
                            @Override
                            public void onMaskTouch(LemonHelloView helloView, LemonHelloInfo helloInfo) {
                                System.out.println("mask touch");
                            }
                        });
                LemonHelloView.defaultHelloView().showHelloWithInfo(MainActivity.this, info);
            }
        }, 4000);
    }
}
