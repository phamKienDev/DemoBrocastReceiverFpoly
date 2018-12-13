package com.hlub.dev.test;

import android.content.Intent;
import android.content.IntentFilter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private MyBroadcardReceiver myBroadcardReceiver;
    private EditText edtText;
    private EditText edtText1;
    public static final String ACTION_KIMABOOK = "kimabook";
    public static final String ACTION_BAI3 = "bai03";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtText = (EditText) findViewById(R.id.edtText);
        edtText1 = (EditText) findViewById(R.id.edtText1);

        //co 2 cach tao broadcard receiver
        //cach 1: tao trong android manifest
        //cach 2: tao bang code tay


    }

    @Override
    protected void onStart() {
        super.onStart();
        initBroadcast();
        initBroadcast2();
    }

    @Override
    protected void onStop() {
        super.onStop();
        unregisterReceiver(myBroadcardReceiver);
    }

    //SEND Broadcast reveiver
    public void customBroadcast(View view) {
        Intent intent = new Intent();
        intent.setAction(ACTION_KIMABOOK);
        intent.putExtra(ACTION_KIMABOOK, edtText.getText().toString());
        sendBroadcast(intent);
    }

    //dang ky Broadcast receiver
    private void initBroadcast() {
        myBroadcardReceiver = new MyBroadcardReceiver();
        //final IntentFilter filter = new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE");
        final IntentFilter filter = new IntentFilter(ACTION_KIMABOOK); //custom Broadcast Receiver
        registerReceiver(myBroadcardReceiver, filter);
    }

    //dang ky Broadcast receiver 2
    private void initBroadcast2() {
        myBroadcardReceiver = new MyBroadcardReceiver();
        final IntentFilter filter = new IntentFilter(ACTION_BAI3); //custom Broadcast Receiver
        registerReceiver(myBroadcardReceiver, filter);
    }

    public void customBroadcast2(View view) {
        Intent intent = new Intent();
        intent.setAction(ACTION_BAI3);
        intent.putExtra(ACTION_BAI3,edtText1.getText().toString());
        sendBroadcast(intent);
    }
}
