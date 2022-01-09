package com.example.yeah;

import com.example.yeah.methods.Videos;

import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Teste {

    public static void main(String[] args) {
        Videos videos = new Videos();
        List<String> lista;

        lista = videos.mostrarVideosEngraçados();

        Random rnd = new Random();
        Collections.shuffle(lista);

        for (int i = 0; i < 1; i++) {
            int index = rnd.nextInt(i + 1);
            System.out.println(lista.remove(index));
        }
    }
}
