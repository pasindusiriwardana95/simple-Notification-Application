package com.pasindusiriwardana.notificationapp;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button notButton;

    NotificationCompat.Builder notification;
    private static final int uniqueID=45612;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        notButton=(Button)findViewById(R.id.notiButton);

        notification= new NotificationCompat.Builder(this);
        notification.setAutoCancel(true);

        notButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //build the notification
                 notification.setSmallIcon(R.drawable.ic_notification_see);
                 notification.setTicker("nVoi");
                 notification.setWhen(System.currentTimeMillis());
                 notification.setContentTitle("Hi fellow Transporter!");
                 notification.setContentText("Your Package is waiting..");

                Intent intent=new Intent(MainActivity.this,MainActivity.class);
                PendingIntent pendingIntent=PendingIntent.getActivity(MainActivity.this,0,intent,PendingIntent.FLAG_UPDATE_CURRENT);
                notification.setContentIntent(pendingIntent);

                //builds notification and issues it
                NotificationManager notificationManager=(NotificationManager)getSystemService(NOTIFICATION_SERVICE);
                notificationManager.notify(uniqueID,notification.build());
            }
        });

    }
}
