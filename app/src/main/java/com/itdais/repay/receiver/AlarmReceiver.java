package com.itdais.repay.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

/**
 * @描述
 * @作者 丁军伟
 * @时间 2017/11/3
 */
public class AlarmReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        Log.d("TTT","测试");
        Toast.makeText(context, "测试", Toast.LENGTH_SHORT).show();
    }
}
