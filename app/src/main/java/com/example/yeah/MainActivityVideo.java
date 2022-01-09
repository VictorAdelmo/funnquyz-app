package com.example.yeah;

import android.os.Bundle;

import com.example.yeah.methods.Methods;
import com.example.yeah.methods.Videos;
import com.google.android.gms.ads.AdLoader;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.formats.UnifiedNativeAd;
import com.google.android.gms.ads.formats.UnifiedNativeAdView;
import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;

import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.Toast;

import androidx.constraintlayout.widget.ConstraintLayout;

import java.util.Collections;
import java.util.List;
import java.util.Random;

public class MainActivityVideo extends YouTubeBaseActivity {

    private YouTubePlayerView nYoutubePlayerView;
    private YouTubePlayer.OnInitializedListener mOnInitializedListener;
    private Button Iniciar, Voltar;
    private ConstraintLayout constraintLayout;
    private List<String> lista;

    private UnifiedNativeAd nativeAd;
    private FrameLayout frameLayout;

    private final Videos videos;
    private final Methods methods;


    public MainActivityVideo() {
        videos = new Videos();
        methods = new Methods();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_video);

        Iniciar = (Button) findViewById(R.id.iniciarButton);
        Voltar = (Button) findViewById(R.id.button2);
        nYoutubePlayerView = (YouTubePlayerView) findViewById(R.id.youtubePlay);
        constraintLayout = findViewById(R.id.VideoLay);
        frameLayout = (FrameLayout) findViewById(R.id.frameNative);

        //Anuncio
        try {
            AdLoader adLoader = new AdLoader.Builder(this
                    , getString(R.string.NATIVE_ADS_UNIT_ID))
                    .forUnifiedNativeAd(new UnifiedNativeAd.OnUnifiedNativeAdLoadedListener() {
                @Override
                public void onUnifiedNativeAdLoaded(UnifiedNativeAd unifiedNativeAd) {
                    nativeAd = unifiedNativeAd;
                    UnifiedNativeAdView adView = (UnifiedNativeAdView) getLayoutInflater()
                            .inflate(R.layout.ad_unified, null);
                    videos.populateUnifiedNativeAdView(unifiedNativeAd, adView);
                    frameLayout.removeAllViews();
                    frameLayout.addView(adView);
                }
            }).build();
            adLoader.loadAd(new AdRequest.Builder().build());
        }catch (Exception e){
            e.printStackTrace();
            Toast.makeText(getApplicationContext(),"Erro ao Exibir Anúncio "+ e.toString(),Toast.LENGTH_SHORT).show();
        }

        //Animação
        methods.AnimacaoCor(constraintLayout);

        //Youtube
        mOnInitializedListener = new YouTubePlayer.OnInitializedListener() {
            @Override
            public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean b) {
                youTubePlayer.setPlayerStyle(YouTubePlayer.PlayerStyle.CHROMELESS);

                String tipo = getIntent().getStringExtra("TYPE_VIDEO");

                if (tipo.equals("Acertou")) {
                    lista = videos.mostrarVideosEngraçados();
                }else if (tipo.equals("Errou")){
                    lista = videos.mostrarVideosSusto();
                }

                Random rnd = new Random();
                Collections.shuffle(lista);

                for (int i = 0; i < 1; i++) {
                    int index = rnd.nextInt(i + 1);
                    //youTubePlayer.loadVideos(lista.remove(index));
                    String a = lista.remove(index);
                    youTubePlayer.loadVideo(a);
                }
            }

            @Override
            public void onInitializationFailure(YouTubePlayer.Provider provider,
                                                YouTubeInitializationResult youTubeInitializationResult) {
            }
        };

        Iniciar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                nYoutubePlayerView.initialize("AIzaSyBxs53aXBetsN-U9IxqVwUHx6uzDdr1OK0", mOnInitializedListener);
            }
        });
        Voltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

    }

    @Override
    protected void onPause() {
        super.onPause();
        if (nativeAd != null) {
            nativeAd.destroy();
        }
    }

    public void onBackPressed() {
        finish();
    }


}


