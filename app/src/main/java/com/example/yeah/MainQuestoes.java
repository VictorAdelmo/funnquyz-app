package com.example.yeah;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.yeah.methods.Methods;
import com.example.yeah.methods.Perguntas;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Locale;
import java.util.Random;

public class MainQuestoes extends AppCompatActivity {
    private Button Alternativa1, Alternativa2, Alternativa3, Alternativa4;
    private TextView Perguntas, countLabel, Tempo;
    private String questaoCerta;
    private int questaoCertaCount = 0;
    private int quizCount = 1;

    private AdView mAdView;
    private CountDownTimer countDownTimer;

    private long tempoZerado;
    private static final int QUIZ_COUNT = 7;
    private static final long COUNT_DOWN_IN_MILLIS = 20000; // 20 Segundos

    private final ArrayList<ArrayList<String>> quizArray = new ArrayList<>();
    private final Perguntas perguntas;
    private final AdRequest adRequest;
    private final Methods methods;

    public MainQuestoes(){
        perguntas = new Perguntas();
        adRequest = new AdRequest.Builder().build();
        methods = new Methods();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_questoes);

        mAdView = (AdView) findViewById(R.id.adView);
        Tempo = (TextView) findViewById(R.id.Uauu);
        Alternativa1 = (Button) findViewById(R.id.Alternativa1);
        Alternativa2 = (Button) findViewById(R.id.Alternativa2);
        Alternativa3 = (Button) findViewById(R.id.Alternativa3);
        Alternativa4 = (Button) findViewById(R.id.Alternativa4);
        countLabel = (TextView) findViewById(R.id.countLabel);
        Perguntas = (TextView) findViewById(R.id.Perguntas);

        mAdView.loadAd(adRequest);

        String[][] perguntasData = perguntas.perguntasData();
        for (int i = 0; i < perguntasData.length; i++) {
            ArrayList<String> tmpArray = new ArrayList<>();
            tmpArray.add(perguntasData[i][0]); //Pergunta
            tmpArray.add(perguntasData[i][1]); //Questao Certa
            tmpArray.add(perguntasData[i][2]); //Questao2
            tmpArray.add(perguntasData[i][3]); //Questao3
            tmpArray.add(perguntasData[i][4]); //Questao4
            quizArray.add(tmpArray);
        }

        tempoZerado = COUNT_DOWN_IN_MILLIS;
        showNextQuiz();
    }

    public void showNextQuiz() {
        Random random = new Random();
        countLabel.setText("" + quizCount);
        int randomNum = random.nextInt(quizArray.size());
        ArrayList<String> quiz = quizArray.get(randomNum);

        Perguntas.setText(quiz.get(0));
        questaoCerta = quiz.get(1);
        quiz.remove(0);

        Collections.shuffle(quiz);
        Alternativa1.setText(quiz.get(0));
        Alternativa2.setText(quiz.get(1));
        Alternativa3.setText(quiz.get(2));
        Alternativa4.setText(quiz.get(3));
        quizArray.remove(randomNum);
    }

    public void checkAlternativa(View view) {
        Button BotaoAlternativa = (Button) findViewById(view.getId());
        String BtnText = BotaoAlternativa.getText().toString();

        if (quizCount < QUIZ_COUNT) {
            if (BtnText.equals(questaoCerta)) {
                questaoCertaCount++;
                methods.execAudio(getApplicationContext());
                MostrarVideo("Acertou");
            } else {
                methods.execAudio(getApplicationContext());
                MostrarVideo("Errou");
            }
        }else if (quizCount == QUIZ_COUNT) {
            Intent intent = new Intent(getApplicationContext(), MainResultado.class);
            intent.putExtra("QUESTAO_CERTA_COUNT", questaoCertaCount);
            overridePendingTransition(R.anim.right, R.anim.left_out);
            startActivity(intent);
            finish();
            countDownTimer.cancel();
        } /*else {
            quizCount++;
            //showNextQuiz();
        }*/
    }

    private void MostrarVideo(String video) {
        Intent Iintent = new Intent(getApplicationContext(), MainActivityVideo.class);
        Iintent.putExtra("TYPE_VIDEO",video);
        startActivity(Iintent);
        overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
    }

    //Tempo
    private void startCountTimer() {
        countDownTimer = new CountDownTimer(tempoZerado, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                tempoZerado = millisUntilFinished;
                updateCountDownText();
            }

            @Override
            public void onFinish() {
                tempoZerado = 0;
                PerdePartida();
            }
        }.start();
    }


    private void resetTime() {
        tempoZerado = COUNT_DOWN_IN_MILLIS;
        updateCountDownText();
        startCountTimer();
    }

    private void updateCountDownText() {
        int minutes = (int) (tempoZerado / 1000) / 60;
        int seconds = (int) (tempoZerado / 1000) % 60;
        String timeFormat = String.format(Locale.getDefault(), "%02d:%02d", minutes, seconds);
        Tempo.setText(timeFormat);

        if (tempoZerado < 5000) {
            Tempo.setTextColor(Color.RED);
        } else {
            Tempo.setTextColor(Color.BLACK);
        }
    }

    public void PerdePartida(){
        Intent intent = new Intent(MainQuestoes.this, MainPerder.class);
        startActivity(intent);
        overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
        finish();
    }

    protected void onPause(){
        super.onPause();
        tempoZerado = 0;
        countDownTimer.cancel();
    }

    protected void onResume() {
        super.onResume();
        resetTime();
        showNextQuiz();
        quizCount++;
    }

    public void onBackPressed() {

    }
}





