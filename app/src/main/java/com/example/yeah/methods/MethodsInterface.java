package com.example.yeah.methods;

import android.content.Context;
import android.media.MediaPlayer;

import androidx.constraintlayout.widget.ConstraintLayout;

import com.example.yeah.recyclerView.ModelHistorico;

import java.util.List;

public interface MethodsInterface {

     ModelNivel methodNivel(Context context,int pontos);
     void AnimacaoCor(ConstraintLayout constraintLayout);
     void tirarVidas(Context context,int valor);
     void addVidas(Context context,int valor);
     void addPontoNivel(Context context,int valor);
     void tirarPontoNivel(Context context,int valor);
     int mostrarNivel(Context context);
     int mostrarVidas(Context context);
     void salvarNomeUser(Context context,String nome);
     String mostrarNomeUser(Context context);
     MediaPlayer execAudio(Context context);
     void salvarResultado(Context context,ModelHistorico model);
     List<ModelHistorico> mostrarHistorico(Context context);
     void SetarAlarme(Context context);
}
