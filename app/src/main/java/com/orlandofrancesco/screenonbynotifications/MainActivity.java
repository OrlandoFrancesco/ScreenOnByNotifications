package com.orlandofrancesco.screenonbynotifications;

import static android.provider.Settings.ACTION_NOTIFICATION_LISTENER_SETTINGS;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        startActivity(new Intent(ACTION_NOTIFICATION_LISTENER_SETTINGS));

        Intent intent = new Intent(this, NotificationListener.class);
        startService(intent);
    }
}