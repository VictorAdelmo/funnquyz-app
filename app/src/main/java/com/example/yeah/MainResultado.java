package com.example.yeah;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.yeah.recyclerView.ModelHistorico;
import com.example.yeah.methods.Methods;
import com.example.yeah.methods.ModelNivel;
import com.example.yeah.methods.Resultado;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.InterstitialAd;

import java.util.Random;

public class MainResultado extends AppCompatActivity {

    private TextView PontuacaoOponente,NomeOponente,ResultOponente,ResultUser,PontuacaoUser,NomeUser;
    private ImageView meuNivel,oponenteNivel;

    private static final int Ganhar = 200 ;
    private static final int  Perder = 80;
    private static final int Empate = 100;
    //private static final String perderVideo = "android.resource://com.example.yeah/"+ R.raw.lil_brabo;
   // private static final String ganharVideo = "android.resource://com.example.yeah/"+R.raw.rir;
    private  MediaPlayer clickSom;
    private  MediaPlayer palmasSom;
    private  MediaPlayer perderSom;
    private final Methods methods;
    private final Resultado resultado;
    private ModelNivel modelNivel;
    private  InterstitialAd mInterstitialAd;
    private final ModelHistorico modelHistorico;

    public MainResultado(){
        methods = new Methods();
        resultado = new Resultado();
        clickSom = new MediaPlayer();
        perderSom =  new MediaPlayer();
        palmasSom =  new MediaPlayer();
        modelHistorico = new ModelHistorico();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_resultado);

        meuNivel= (ImageView) findViewById(R.id.ImagemPatente);
        oponenteNivel = (ImageView) findViewById(R.id.PatenteOponente);
        PontuacaoUser = (TextView) findViewById(R.id.PontuacaoUser);
        ResultUser = (TextView) findViewById(R.id.ResultadoUser);
        ResultOponente = (TextView) findViewById(R.id.ResutlOponente);
        NomeOponente = (TextView) findViewById(R.id.NomeOponente);
        PontuacaoOponente = (TextView) findViewById(R.id.PontuacaoOponente);
        NomeUser = (TextView)findViewById(R.id.MeuNome);

        mInterstitialAd = new InterstitialAd(this);
        mInterstitialAd.setAdUnitId(getString(R.string.INTERTITIAL_ADS_ID));
        mInterstitialAd.loadAd(new AdRequest.Builder().build());

        clickSom = MediaPlayer.create(getApplicationContext(),R.raw.click);
        perderSom =  MediaPlayer.create(getApplicationContext(),R.raw.lose);
        palmasSom =  MediaPlayer.create(getApplicationContext(),R.raw.palmas);

        //Meu Nome
        NomeUser.setText(methods.mostrarNomeUser(getApplicationContext()));

        //Nome do Oponente
        String nomeOponente =  resultado.nomeOponente();
        NomeOponente.setText(nomeOponente);

        //Imagens Niveis
        modelNivel = methods.methodNivel(getApplicationContext(),methods.mostrarNivel(getApplicationContext()));
        meuNivel.setImageResource(modelNivel.getImg());
        oponenteNivel.setImageResource(modelNivel.getImg());

        Ganhador();

        mInterstitialAd.setAdListener(new AdListener(){
            @Override
            public void onAdClosed() {
                super.onAdClosed();
                telaInicial();
            }
        });

    }

    private void Ganhador(){
        int Myscore = getIntent().getIntExtra("QUESTAO_CERTA_COUNT", 0);//Numeros Acertos
        PontuacaoUser.setText(Myscore + " / 6");

        Random random = new Random();
        int value = random.nextInt(5 - 0) + 0;
        PontuacaoOponente.setText(value + " / 6");

        if (Myscore>value){
            ResultUser.setText("Vencedor");
            ResultOponente.setText("Perdedor");
            methods.addPontoNivel(getApplicationContext(),Ganhar);
            palmasSom.start();
        }else {
            ResultOponente.setText("Vencedor");
            ResultUser.setText("Perdedor");
            methods.tirarPontoNivel(getApplicationContext(),Perder);
            perderSom.start();
        }

        if (Myscore==value){
            ResultUser.setText("Empate");
            ResultOponente.setText("Empate");
            methods.addPontoNivel(getApplicationContext(),Empate);
            palmasSom.start();
        }

        modelHistorico.setImgNivel(modelNivel.getImg()); //Imagem
        modelHistorico.setPontuancaoUser(PontuacaoUser.getText().toString()); //6/8
        modelHistorico.setPontuancaoOponente(PontuacaoOponente.getText().toString()); //5/8
        modelHistorico.setResultadoOponente(ResultOponente.getText().toString()); //Empate,Perder,Vencer  Usuario
        modelHistorico.setResultadoUser(ResultUser.getText().toString());//Empate,Perder,Vencer  Usuario
        modelHistorico.setNomeOponente(NomeOponente.getText().toString());
        methods.salvarResultado(getApplicationContext(),modelHistorico);
    }

    public void Anuncio(View view) {
        clickSom.start();
        if (mInterstitialAd.isLoaded()) {
            mInterstitialAd.show();
        }else {
            telaInicial();
        }
    }

    public void onBackPressed() {
        if (mInterstitialAd.isLoaded()) {
            mInterstitialAd.show();
        }else {
            telaInicial();
        }
    }

    public void telaInicial(){
        Intent intent = new Intent(getApplicationContext(),BottomNavigation.class);
        startActivity(intent);
        finish();
    }

        /*private void Video(String eu, String oponente){
        MediaController mediaUser = new MediaController(this);
        videoUser.setMediaController(mediaUser);
        Uri uri = Uri.parse(eu);
        videoUser.setVideoURI(uri);
        videoUser.start();

        MediaController mediaOponente = new MediaController(this);
        videoOponente.setMediaController(mediaOponente);
        Uri uri2 = Uri.parse(oponente);
        videoOponente.setVideoURI(uri2);
        videoOponente.start();
    }*/

}


