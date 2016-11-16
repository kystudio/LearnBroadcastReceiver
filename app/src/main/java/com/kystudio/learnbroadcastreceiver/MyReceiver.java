package com.kystudio.learnbroadcastreceiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public class MyReceiver extends BroadcastReceiver {
    public static final String MY_ACTION = "com.kystudio.learnbroadcastreceiver.intent.action.MyReceiver";

    public MyReceiver() {
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        System.out.println("MyReceiver 接收到了消息，内容是：" + intent.getStringExtra("data"));
        //下面这个方法用途是终止广播，不过使用这个方法的话，相对应的发送广播的方法也要改，不能用sendBroadcast(intent)，要使用sendOrderBroadcast(intent,null)[第二个参数是权限];
        //终止广播后，优先级低于当前广播接收器的广播接收器不再执行。
        abortBroadcast();
    }
}
