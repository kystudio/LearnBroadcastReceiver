package com.kystudio.learnbroadcastreceiver;

import android.content.Intent;
import android.content.IntentFilter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Intent intent;
    private MyReceiver receiver = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //intent = new Intent(MainActivity.this, MyReceiver.class);

        findViewById(R.id.btnSendBroadcastReceiver).setOnClickListener(this);
        findViewById(R.id.btnRegBroadcastReceiver).setOnClickListener(this);
        findViewById(R.id.btnUnRegBroadcastReceiver).setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btnSendBroadcastReceiver:
                intent = new Intent(MyReceiver.MY_ACTION);
                intent.putExtra("data", "厉害了word哥");
                //sendBroadcast(intent);
                sendOrderedBroadcast(intent, null);//如果中途要终止广播，须使用这个方法，否则异常
                System.out.println("广播发送成功");
                break;
            case R.id.btnRegBroadcastReceiver:
                if (receiver == null) {
                    receiver = new MyReceiver();
                    registerReceiver(receiver, new IntentFilter(MyReceiver.MY_ACTION));
                    System.out.println("注册广播接收器成功");
                }
                break;
            case R.id.btnUnRegBroadcastReceiver:
                if (receiver != null) {
                    unregisterReceiver(receiver);
                    receiver = null;
                    System.out.println("注销广播接收器成功");
                }
                break;
        }
    }
}
