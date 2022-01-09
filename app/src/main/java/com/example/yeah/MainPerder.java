package com.example.yeah;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;

import com.example.yeah.methods.Methods;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.reward.RewardItem;
import com.google.android.gms.ads.reward.RewardedVideoAd;
import com.google.android.gms.ads.reward.RewardedVideoAdListener;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainPerder extends AppCompatActivity implements RewardedVideoAdListener {

    private InterstitialAd MmInterstitialAd;
    private RewardedVideoAd ReAdS;
    private Button Continuar,Voltar;
    private MediaPlayer mp;
    private final Methods methods;

    public MainPerder(){
        methods = new Methods();
        mp = new MediaPlayer();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_lose);

        Voltar = (Button) findViewById(R.id.VoltarLose);
        Continuar = (Button) findViewById(R.id.Continuar);

        MmInterstitialAd = new InterstitialAd(this);
        MmInterstitialAd.setAdUnitId(getString(R.string.INTERTITIAL_ADS_ID));
        MmInterstitialAd.loadAd(new AdRequest.Builder().build());

        ReAdS = MobileAds.getRewardedVideoAdInstance(this);
        ReAdS.setRewardedVideoAdListener(this);
        ReAdS.loadAd(getString(R.string.REWARD_ADS_ID),new AdRequest.Builder().build());

        mp = MediaPlayer.create(getApplicationContext(), R.raw.no_no_no);
        mp.start();

        Continuar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ReAdS.isLoaded()){
                    ReAdS.show();
                    mp.stop();
                }
            }
        });

        Voltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (MmInterstitialAd.isLoaded()) {
                    MmInterstitialAd.show();
                }else{
                    finish();
                    Intent intent = new Intent(MainPerder.this, BottomNavigation.class);
                    startActivity(intent);
                    methods.tirarPontoNivel(getApplicationContext(),80);
                }
            }
        });

        MmInterstitialAd.setAdListener(new AdListener() {
            @Override
            public void onAdClosed() {
                super.onAdClosed();
                finish();
                Intent intent = new Intent(MainPerder.this, BottomNavigation.class);
                startActivity(intent);
                methods.tirarPontoNivel(getApplicationContext(),80);
            }
        });

    }

    public void onBackPressed() {

    }

    @Override
    public void onRewardedVideoAdLoaded() {

    }

    @Override
    public void onRewardedVideoAdOpened() {

    }

    @Override
    public void onRewardedVideoStarted() {

    }

    @Override
    public void onRewardedVideoAdClosed() {

    }

    @Override
    public void onRewarded(RewardItem rewardItem) {
        Toast.makeText(this,"Sua Partida Voltou",Toast.LENGTH_SHORT).show();
        finish();
    }

    @Override
    public void onRewardedVideoAdLeftApplication() {

    }

    @Override
    public void onRewardedVideoAdFailedToLoad(int i) {

    }

    @Override
    public void onRewardedVideoCompleted() {

    }
}
