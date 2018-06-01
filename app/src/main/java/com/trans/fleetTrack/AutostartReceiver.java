
package com.trans.fleetTrack;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

public class AutostartReceiver extends WakefulBroadcastReceiver {
    
    @Override
    public void onReceive(Context context, Intent intent) {
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
        if (sharedPreferences.getBoolean(MainFragment.KEY_STATUS, false)) {
            startWakefulService(context, new Intent(context, TrackingService.class));
        }
    }

}
