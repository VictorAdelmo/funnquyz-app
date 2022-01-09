package com.example.yeah;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.os.Bundle;

import android.view.LayoutInflater;
import android.view.View;
import android.content.Intent;

import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;

import android.widget.TextView;

import android.widget.Toast;


import com.example.yeah.methods.Methods;
import com.example.yeah.methods.ModelNivel;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.reward.RewardItem;
import com.google.android.gms.ads.reward.RewardedVideoAd;
import com.google.android.gms.ads.reward.RewardedVideoAdListener;


public class InicioFrag extends Fragment implements RewardedVideoAdListener {

    //Layout
    private TextView VidasSaldo, Nome;
    private Button BotaoJogar;
    private ImageView NivelImg;
    private TextView NivelMsg, NivelMedalha, Pontos;
    private ImageButton Reward;

    private final Methods methods;
    private RewardedVideoAd ReAdS;

    public InicioFrag() {
        methods = new Methods();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.activity_main, container, false);
        Pontos = (TextView) v.findViewById(R.id.textView12);
        NivelImg = (ImageView) v.findViewById(R.id.Patente);
        NivelMsg = (TextView) v.findViewById(R.id.PatenteMsg);
        NivelMedalha = (TextView) v.findViewById(R.id.TextoPatente);
        VidasSaldo = (TextView) v.findViewById(R.id.VidasNumero);
        Nome = (TextView) v.findViewById(R.id.textViewNome3);
        BotaoJogar = (Button) v.findViewById(R.id.BotaoJogar);
        Reward = (ImageButton) v.findViewById(R.id.Reward);
        return v;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        //Anuncio Recompensa
        ReAdS = MobileAds.getRewardedVideoAdInstance(getContext());
        ReAdS.setRewardedVideoAdListener(this);
        ReAdS.loadAd(getString(R.string.REWARD_ADS_ID), new AdRequest.Builder().build());

        MetodoNivel();
        methods.SetarAlarme(getContext());

        //Mostrar Vidas
        VidasSaldo.setText("" + methods.mostrarVidas(getContext()));

        //Mostrar Nome
        Nome.setText("" + methods.mostrarNomeUser(getContext()));

        BotaoJogar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (methods.mostrarVidas(getContext()) != 0) {
                    Intent intent = new Intent(getContext(), MainQuestoes.class);
                    startActivity(intent);
                    getActivity().finish();
                    methods.tirarVidas(getContext(), 1);
                } else {
                    Toast.makeText(getContext(), "Você Não Tem Vidas", Toast.LENGTH_SHORT).show();
                }
            }
        });

        Reward.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MetodoVidas(methods.mostrarVidas(getContext()));
            }
        });
    }

    private void MetodoVidas(int vidas) {
        if (vidas >= 4) {
            Reward.setEnabled(false);
            Toast.makeText(getContext(), "Você Atingiu o Máximo de Vidas", Toast.LENGTH_SHORT).show();
        } else if (ReAdS.isLoaded()){
            Reward.setEnabled(true);
            ReAdS.show();
        }
    }

    private void MetodoNivel() {
        int pontos = methods.mostrarNivel(getContext());
        ModelNivel modelNivel = methods.methodNivel(getContext(), pontos);
        NivelImg.setImageResource(modelNivel.getImg());
        NivelMedalha.setText(modelNivel.getMedalha());
        NivelMsg.setText(modelNivel.getMensagem());
    }

    public void onBackPressed() {

    }

    @Override
    public void onResume() {
        super.onResume();
        //Mostrar Vidas para Jogar
        VidasSaldo.setText("" + methods.mostrarVidas(getContext()));
        methods.mostrarVidas(getContext());

        //Mostrar Nome Usuario
        Nome.setText(""+methods.mostrarNomeUser(getContext()));
        methods.mostrarNomeUser(getContext());
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

    }

    @Override
    public void onRewardedVideoAdLeftApplication() {

    }

    @Override
    public void onRewardedVideoAdFailedToLoad(int i) {

    }

    @Override
    public void onRewardedVideoCompleted() {
        Toast.makeText(getContext(), "Você Ganhou 4 Vidas", Toast.LENGTH_SHORT).show();
        methods.addVidas(getContext(), 4);
    }
}


