package lemonsoft.net.lemonhello4android;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;

import net.lemonsoft.lemonhello.LemonHello;
import net.lemonsoft.lemonhello.LemonHelloInfo;
import net.lemonsoft.lemonhello.LemonHelloView;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                LemonHelloInfo info = new LemonHelloInfo();
                LemonHelloView.defaultHelloView().showHelloWithInfo(MainActivity.this, info);
            }
        }, 2000);

    }
}
