package net.lemonsoft.lemonhello.interfaces;

import net.lemonsoft.lemonhello.LemonHelloAction;
import net.lemonsoft.lemonhello.LemonHelloInfo;
import net.lemonsoft.lemonhello.LemonHelloView;

/**
 * LemonHello - 事件回调代理
 * Created by LiuRi on 2017/1/11.
 */

public interface LemonHelloActionDelegate {

    void onClick(
            LemonHelloView helloView,
            LemonHelloInfo helloInfo,
            LemonHelloAction helloAction
    );

}
