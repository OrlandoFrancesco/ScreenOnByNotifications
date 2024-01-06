package com.orlandofrancesco.screenonbynotifications;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.os.PowerManager;
import android.service.notification.NotificationListenerService;
import android.service.notification.StatusBarNotification;
import android.view.Display;
import android.view.Window;
import android.widget.Toast;

public class NotificationListener extends NotificationListenerService{

    Context context = this;

    @Override
    public IBinder onBind(Intent intent) {
        return super.onBind(intent);
    }

    @Override
    public void onNotificationPosted(StatusBarNotification sbn) {
        super.onNotificationPosted(sbn);
        PowerManager powerManager = (PowerManager) getSystemService(Context.POWER_SERVICE);
        @SuppressLint("InvalidWakeLockTag") PowerManager.WakeLock wakeLock = powerManager.newWakeLock(PowerManager.SCREEN_BRIGHT_WAKE_LOCK
                | PowerManager.ACQUIRE_CAUSES_WAKEUP, "CHESS");
        try {
            wakeLock.acquire();
            Thread.sleep(1000);
        } catch (Exception e) {
            Toast.makeText(context, e.getMessage(), Toast.LENGTH_SHORT).show();
        } finally {
            wakeLock.release();
        }
    }
}
