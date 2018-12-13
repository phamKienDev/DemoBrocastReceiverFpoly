package com.hlub.dev.test;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.telecom.TelecomManager;
import android.telephony.TelephonyManager;
import android.widget.Toast;

public class MyBroadcardReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        //Toast.makeText(context, "Network is turned ON/OF ", Toast.LENGTH_SHORT).show();
        if (intent.getAction().equals(MainActivity.ACTION_KIMABOOK)) {
            Toast.makeText(context, intent.getStringExtra(MainActivity.ACTION_KIMABOOK), Toast.LENGTH_SHORT).show();
        } else if (intent.getAction().equals(MainActivity.ACTION_BAI3)) {
            String text = intent.getStringExtra(MainActivity.ACTION_BAI3);

            if (text.length() == 9) {
                String sub = text.substring(0, 3);
                if (sub.equals("MEM") || sub.equals("VIP")) {
                    if (text.equals("MEM537128")) {
                        Toast.makeText(context, "Khuyen mai 10%", Toast.LENGTH_SHORT).show();
                    } else if (text.equals("MEM537129")) {
                        Toast.makeText(context, "Khuyen mai 20%", Toast.LENGTH_SHORT).show();
                    } else if (text.equals("VIP537128")) {
                        Toast.makeText(context, "Khuyen mai 30%", Toast.LENGTH_SHORT).show();
                    } else if (text.equals("VIP537129")) {
                        Toast.makeText(context, "Khuyen mai 50%", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(context, "Không bao giờ được khuyến mãi", Toast.LENGTH_SHORT).show();

                    }
                } else {
                    Toast.makeText(context, "Chuỗi nhập bắt đầu bằng MEM or VIP", Toast.LENGTH_SHORT).show();
                }
            } else {
                Toast.makeText(context, "Chuỗi nhập không đúng 9 kí tự ", Toast.LENGTH_SHORT).show();
            }

        } else if(intent.getAction().equals("android.intent.action.PHONE_STATE")){
            Bundle extras = intent.getExtras();
            if (extras != null) {
                String state = extras.getString(TelephonyManager.EXTRA_STATE);

                if (state.equals(TelephonyManager.EXTRA_STATE_RINGING)) {
                    String phone = extras.getString(TelephonyManager.EXTRA_INCOMING_NUMBER);
                    Toast.makeText(context, phone, Toast.LENGTH_SHORT).show();
                }
            }
        }
    }
}
