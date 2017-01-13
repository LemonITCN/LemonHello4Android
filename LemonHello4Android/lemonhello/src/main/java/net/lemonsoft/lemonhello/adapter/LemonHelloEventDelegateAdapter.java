package net.lemonsoft.lemonhello.adapter;

import net.lemonsoft.lemonhello.LemonHelloAction;
import net.lemonsoft.lemonhello.LemonHelloInfo;
import net.lemonsoft.lemonhello.LemonHelloView;
import net.lemonsoft.lemonhello.interfaces.LemonHelloEventDelegate;

/**
 * LemonHello 事件代理适配器
 * Created by LiuRi on 2017/1/11.
 */

public abstract class LemonHelloEventDelegateAdapter implements LemonHelloEventDelegate {

    @Override
    public void onActionDispatch(LemonHelloView helloView, LemonHelloInfo helloInfo, LemonHelloAction helloAction) {

    }

    @Override
    public void onMaskTouch(LemonHelloView helloView, LemonHelloInfo helloInfo) {

    }
    
}
