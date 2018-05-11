package com.ringdroid;

import android.app.Notification;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;
import android.support.v7.app.NotificationCompat;

public class RecordService extends Service {
    public RecordService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Log.d("RecordService", "onCreate executed");
        Intent intent = new Intent(this, RingdroidEditActivity.class);
        PendingIntent pi = PendingIntent.getActivity(this, 0, intent, 0);
        Notification notification = new NotificationCompat.Builder(this)
                .setContentTitle("Recording...")
                .setContentText("Press me to stop")
                .setContentIntent(pi)
                .setAutoCancel(true)
                .build();
        startForeground(1, notification);

    }


}
