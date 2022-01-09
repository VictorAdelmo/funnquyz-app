package com.example.yeah;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.example.yeah.methods.Methods;

import de.hdodenhof.circleimageview.CircleImageView;

public class MainInternet extends AppCompatActivity {

    private final Methods methods;
    private CircleImageView logo;

    public MainInternet(){
        methods = new Methods();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_internet);

        logo = (CircleImageView) findViewById(R.id.imageView3);
        logo.setImageResource(R.mipmap.ic_fun_logo);

        String nome = methods.mostrarNomeUser(getApplicationContext());
        CriarNotificacao();

        if (nome == null || nome.equals("")) {
            Intent intent = new Intent(getApplicationContext(), MainNomeUser.class);
            startActivity(intent);
            finish();
        } else {
            Intent intent = new Intent(getApplicationContext(), BottomNavigation.class);
            startActivity(intent);
            finish();
        }
    }

    public void CriarNotificacao() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            NotificationChannel channel1 = new NotificationChannel(
                    "channel1",
                    "Jogar",
                    NotificationManager.IMPORTANCE_HIGH
            );
            channel1.setDescription("Jogar Agora");
            NotificationManager notificationManager1 = getSystemService(NotificationManager.class);
            notificationManager1.createNotificationChannel(channel1);
        }
    }

}



