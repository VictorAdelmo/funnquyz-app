package com.example.yeah.methods;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.drawable.AnimationDrawable;
import android.media.MediaPlayer;
import android.widget.Toast;

import androidx.constraintlayout.widget.ConstraintLayout;

import com.example.yeah.Alarme;
import com.example.yeah.recyclerView.ModelHistorico;
import com.example.yeah.R;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Random;

import static android.content.Context.MODE_PRIVATE;

public class Methods implements MethodsInterface {
    private AnimationDrawable animationDrawable;
    private Gson gson;

    public Methods() {
        gson = new Gson();
    }

    @Override
    public ModelNivel methodNivel(Context context, int ponto) {
        ModelNivel modelNivel = new ModelNivel();

        if (ponto < 100) {
            ponto = 100;
        }

        if (ponto >= 100) {
            modelNivel.setImg(R.mipmap.ic_bronze);
            modelNivel.setMedalha("Bronze I");
            modelNivel.setMensagem("(Péssimo)");
        }

        if (ponto >= 500) {
            modelNivel.setImg(R.mipmap.ic_bronze);
            modelNivel.setMedalha("Bronze II");
            modelNivel.setMensagem("(Péssimo)");
        }

        if (ponto >= 1000) {
            modelNivel.setImg(R.mipmap.ic_bronze);
            modelNivel.setMedalha("Bronze III");
            modelNivel.setMensagem("(Péssimo)");
        }

        if (ponto >= 1500) {
            modelNivel.setImg(R.mipmap.ic_iniciante);
            modelNivel.setMedalha("Iniciante I");
            modelNivel.setMensagem("(Não Desista)");
        }

        if (ponto >= 2000) {
            modelNivel.setImg(R.mipmap.ic_iniciante);
            modelNivel.setMedalha("Iniciante II");
            modelNivel.setMensagem("(Não Desista)");
        }

        if (ponto >= 2500) {
            modelNivel.setImg(R.mipmap.ic_iniciante);
            modelNivel.setMedalha("Iniciante III");
            modelNivel.setMensagem("(Não Desista)");
        }

        if (ponto >= 3000) {
            modelNivel.setMedalha("Ouro I");
            modelNivel.setMensagem("(Você é Bom)");
            modelNivel.setImg(R.mipmap.ic_ouro);
        }

        if (ponto >= 3500) {
            modelNivel.setMedalha("Ouro II");
            modelNivel.setMensagem("(Você é Bom)");
            modelNivel.setImg(R.mipmap.ic_ouro);
        }

        if (ponto >= 4000) {
            modelNivel.setMedalha("Ouro III");
            modelNivel.setMensagem("(Você é Bom)");
            modelNivel.setImg(R.mipmap.ic_ouro);
        }

        if (ponto >= 4500) {
            modelNivel.setMedalha("Diamente I");
            modelNivel.setMensagem("(Você é o Cara)");
            modelNivel.setImg(R.mipmap.ic_diamante);
        }

        if (ponto >= 5000) {
            modelNivel.setMedalha("Diamente II");
            modelNivel.setMensagem("(Você é o Cara)");
            modelNivel.setImg(R.mipmap.ic_diamante);
        }

        if (ponto >= 5500) {
            modelNivel.setMedalha("Diamente III");
            modelNivel.setMensagem("(Você é o Cara)");
            modelNivel.setImg(R.mipmap.ic_diamante);
        }

        return modelNivel;
    }

    @Override
    public void AnimacaoCor(ConstraintLayout constraintLayout) {
        animationDrawable = (AnimationDrawable) constraintLayout.getBackground();
        animationDrawable.setEnterFadeDuration(2000);
        animationDrawable.setExitFadeDuration(4000);
        animationDrawable.start();
    }

    @Override
    public void tirarVidas(Context context, int valor) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("DATA", MODE_PRIVATE);
        int vidas = sharedPreferences.getInt("VIDAS", 0);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt("VIDAS", vidas - valor);
        editor.apply();
    }

    @Override
    public void addVidas(Context context, int valor) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("DATA", MODE_PRIVATE);
        int vidas = sharedPreferences.getInt("VIDAS", 0);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt("VIDAS", vidas + valor);
        editor.apply();
    }

    @Override
    public void addPontoNivel(Context context, int valor) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("DATA", MODE_PRIVATE);
        int nivel = sharedPreferences.getInt("MY_PATENTE", 0);
        sharedPreferences.edit().putInt("MY_PATENTE", nivel + valor).apply();
    }

    @Override
    public void tirarPontoNivel(Context context, int valor) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("DATA", MODE_PRIVATE);
        int nivel = sharedPreferences.getInt("MY_PATENTE", 0);
        if (nivel >= 80) {
            sharedPreferences.edit().putInt("MY_PATENTE", nivel - valor).apply();
        }
    }

    @Override
    public int mostrarNivel(Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("DATA", MODE_PRIVATE);
        int pontos = sharedPreferences.getInt("MY_PATENTE", 0);
        return pontos;
    }

    @Override
    public int mostrarVidas(Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("DATA", MODE_PRIVATE);
        int vidas = sharedPreferences.getInt("VIDAS", 0);
        return vidas;
    }

    @Override
    public void salvarNomeUser(Context context, String nome) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("DATA", MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("NOME", nome);
        editor.apply();
    }

    @Override
    public String mostrarNomeUser(Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("DATA", MODE_PRIVATE);
        String nome = sharedPreferences.getString("NOME", "");
        return nome;
    }

    @Override
    public MediaPlayer execAudio(Context context) {
        Random random = new Random();

        final MediaPlayer mp = MediaPlayer.create(context, R.raw.derp);
        final MediaPlayer mp2 = MediaPlayer.create(context, R.raw.buzz);
        final MediaPlayer mp3 = MediaPlayer.create(context, R.raw.wow);

        int r = random.nextInt(3);

        if (r == 0) {
            mp.start();
            return mp;
        }

        if (r == 1) {
            mp2.start();
            return mp2;
        }

        if (r == 2) {
            mp3.start();
            return mp3;
        }
        return null;
    }

    @Override
    public void salvarResultado(Context context, ModelHistorico modelHistorico) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("DATA", MODE_PRIVATE);
        String historicoSalvo = sharedPreferences.getString("Historico", "");

        if (historicoSalvo == null || historicoSalvo.isEmpty()) {
            List<ModelHistorico> listaSalva = new ArrayList<>();
            listaSalva.add(modelHistorico);
            String novoJson = gson.toJson(listaSalva);

            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putString("Historico", novoJson);
            editor.apply();
        }else {
            List<ModelHistorico> listaSalva = gson.fromJson(historicoSalvo, new TypeToken<List<ModelHistorico>>() {}.getType());
            listaSalva.add(modelHistorico);
            String novoJson = gson.toJson(listaSalva);

            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putString("Historico", novoJson);
            editor.apply();
        }
    }

    @Override
    public List<ModelHistorico> mostrarHistorico(Context context) {
        List<ModelHistorico> historico;
        SharedPreferences sharedPreferences = context.getSharedPreferences("DATA", MODE_PRIVATE);
        String json = sharedPreferences.getString("Historico", "");

        if (json.isEmpty()) {
            historico = new ArrayList<>();
            Toast.makeText(context, "Você Não tem Histórico de Partidas", Toast.LENGTH_SHORT).show();
        } else {
            Type type = new TypeToken<List<ModelHistorico>>() {
            }.getType();
            historico = gson.fromJson(json, type);
        }
        return historico;
    }

    @Override
    public void SetarAlarme(Context context) {
        AlarmManager alarmMgr = (AlarmManager) context.getSystemService(Context.ALARM_SERVICE);
        Intent intent1 = new Intent(context, Alarme.class);
        PendingIntent pendingIntent = PendingIntent.getBroadcast(context, 1, intent1, 0);

        boolean alarmeAtivo = (PendingIntent.getBroadcast(context, 1, intent1, PendingIntent.FLAG_NO_CREATE) == null);

        if (alarmeAtivo) {
            Calendar calendar = Calendar.getInstance();
            calendar.add(Calendar.MINUTE,20);
            calendar.setTimeInMillis(System.currentTimeMillis());
            long inicio = calendar.getTimeInMillis();
            alarmMgr.setRepeating(AlarmManager.RTC_WAKEUP,inicio, AlarmManager.INTERVAL_DAY * 3,pendingIntent);
        }
    }
}
