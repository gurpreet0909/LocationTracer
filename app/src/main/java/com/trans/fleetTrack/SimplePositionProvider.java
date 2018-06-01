
package com.trans.fleetTrack;

import android.content.Context;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.util.Log;

@SuppressWarnings("MissingPermission")
public class SimplePositionProvider extends PositionProvider implements LocationListener {

    public SimplePositionProvider(Context context, PositionListener listener) {
        super(context, listener);
        if (!type.equals(LocationManager.NETWORK_PROVIDER)) {
            type = LocationManager.GPS_PROVIDER;
        }
    }

    public void startUpdates() {
        try {
            locationManager.requestLocationUpdates(type, requestInterval, 0, this);
        } catch (IllegalArgumentException e) {
            Log.w(TAG, e);
        }
    }

    public void stopUpdates() {
        locationManager.removeUpdates(this);
    }

    @Override
    public void onLocationChanged(Location location) {
        updateLocation(location);
    }

    @Override
    public void onStatusChanged(String provider, int status, Bundle extras) {
    }

    @Override
    public void onProviderEnabled(String provider) {
    }

    @Override
    public void onProviderDisabled(String provider) {
    }

}
