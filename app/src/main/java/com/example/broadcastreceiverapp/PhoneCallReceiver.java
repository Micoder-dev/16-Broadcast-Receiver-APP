package com.example.broadcastreceiverapp;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.TelephonyManager;
import android.util.Log;
import android.widget.Toast;

public class PhoneCallReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {

        Bundle bundle = intent.getExtras();

        if (bundle != null) {

            String phoneState = bundle.getString(TelephonyManager.EXTRA_STATE);

            Log.i("RECEIVER", phoneState);
            Toast.makeText(context, phoneState, Toast.LENGTH_SHORT).show();

            if (phoneState.equals(TelephonyManager.EXTRA_STATE_RINGING)) {

                String phoneNumber = bundle.getString(TelephonyManager.EXTRA_INCOMING_NUMBER);

                Log.i("RECEIVER", phoneNumber + "");
                Toast.makeText(context, phoneNumber + "", Toast.LENGTH_SHORT).show();

            }

        }

    }
}