package com.example.yeah;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Build;

import androidx.core.app.NotificationCompat;

public class Alarme extends BroadcastReceiver {

    private NotificationCompat.Builder builder;
    public static final String CHANNEL_1_ID = "channel1";
    private int notifyID = 1;
    private NotificationManager notificationManager;
    private PendingIntent pendingIntent;

    @Override
    public void onReceive(Context context, Intent intent) {

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            notificacao(context, NotificationManager.IMPORTANCE_NONE);
        } else {
            notificacao(context, NotificationCompat.PRIORITY_MIN);
        }

        if (Intent.ACTION_BOOT_COMPLETED.equals(intent.getAction())) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                notificacao(context, NotificationManager.IMPORTANCE_NONE);
            } else {
                notificacao(context, NotificationCompat.PRIORITY_MIN);
            }
        }

        if (Intent.ACTION_TIME_CHANGED.equals(intent.getAction())) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                notificacao(context, NotificationManager.IMPORTANCE_LOW);
            } else {
                notificacao(context, NotificationCompat.PRIORITY_LOW);
            }
        }
    }

    public void notificacao(Context context, int object) {
        Intent intent = new Intent(context, MainInternet.class);
        pendingIntent = PendingIntent.getActivity(context, 1, intent, PendingIntent.FLAG_UPDATE_CURRENT);
        builder = new NotificationCompat.Builder(context, CHANNEL_1_ID)
                .setSmallIcon(R.mipmap.ic_funlogo1)
                .setContentTitle("Venha Jogar e se Divertir")
                .setAutoCancel(true)
                .setVisibility(NotificationCompat.VISIBILITY_PUBLIC)
                .setContentText("Venha se Divertir com Vídeos e uma Partida Competitiva!")
                .setContentIntent(pendingIntent)
                .setCategory(NotificationCompat.CATEGORY_MESSAGE)
                .setPriority(object);

        notificationManager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
        notificationManager.notify(notifyID, builder.build());
    }
}
