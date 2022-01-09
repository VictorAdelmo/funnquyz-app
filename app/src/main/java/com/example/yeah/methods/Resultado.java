package com.example.yeah.methods;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Resultado {

    public String nomeOponente() {
        List<String> listaNomes = new ArrayList<>();
        listaNomes.add("Dark");
        listaNomes.add("Outdated");
        listaNomes.add("Gladiator");
        listaNomes.add("Entropy");
        listaNomes.add("Inbecil");
        listaNomes.add("Storm");
        listaNomes.add("Thunder");
        listaNomes.add("Boxeador");
        listaNomes.add("Destructor");
        listaNomes.add("Slayer Mog");
        listaNomes.add("Hunter");
        listaNomes.add("Mage");
        listaNomes.add("Divine");
        listaNomes.add("Arrow");
        listaNomes.add("Shiryu");
        listaNomes.add("Supreme");
        listaNomes.add("Phoenix");
        listaNomes.add("Legendary");
        listaNomes.add("Instict");
        listaNomes.add("Tears");
        listaNomes.add("Envyus");
        listaNomes.add("Rising");
        listaNomes.add("Immortal");
        listaNomes.add("Warlock");
        listaNomes.add("Reaper");
        listaNomes.add("Pantheon");
        listaNomes.add("Maxthon");
        listaNomes.add("Executor");
        listaNomes.add("BloodFlare");
        listaNomes.add("Summoners");
        listaNomes.add("Banedragon");
        listaNomes.add("Infinite");
        listaNomes.add("Fear");
        listaNomes.add("Sunset");
        listaNomes.add("Bruiser");
        listaNomes.add("Punisher");
        listaNomes.add("Heavy Hands");
        listaNomes.add("Studd");
        listaNomes.add("Punk");
        listaNomes.add("Wild Thing");
        listaNomes.add("Superhuman");
        listaNomes.add("El Diablo");
        listaNomes.add("Girl Power");
        listaNomes.add("La Diva");
        listaNomes.add("Assassina em série");
        listaNomes.add("Martha");
        listaNomes.add("Athenas");
        listaNomes.add("Boss");
        listaNomes.add("Bitterman");
        listaNomes.add("ZodiacKiller");
        listaNomes.add("OsamasGhost");
        listaNomes.add("Assustadinho");
        listaNomes.add("Cabelero");
        listaNomes.add("Mastro");
        listaNomes.add("Negolino");
        listaNomes.add("Ticoliro");
        listaNomes.add("Thanos fraco");
        listaNomes.add("Ostara");
        listaNomes.add("Cruizcredo");
        listaNomes.add("Pimpolhão");
        listaNomes.add("Narizdotorto");
        listaNomes.add("SemNome");
        listaNomes.add("Dilma Rousseff");
        listaNomes.add("2Pac");
        listaNomes.add("ManoBrown");
        listaNomes.add("Carneirinho");
        listaNomes.add("PerdedoresNuncaGanham"); //MaiorNome
        listaNomes.add("Mario");
        listaNomes.add("Criolin");
        listaNomes.add("Fernandin");
        listaNomes.add("Kiki");
        listaNomes.add("Lupi");
        listaNomes.add("LekLek");
        listaNomes.add("CeCe");
        listaNomes.add("Bilson");
        listaNomes.add("Popeye");
        listaNomes.add("Fini");
        listaNomes.add("Gordin");
        listaNomes.add("ThugThug");
        listaNomes.add("Nego Ney");
        listaNomes.add("Beijin");
        listaNomes.add("Jabinho");
        listaNomes.add("Garyzera");
        listaNomes.add("Synister");
        listaNomes.add("JP");
        listaNomes.add("Bulking");

        Random rnd = new Random();
        Collections.shuffle(listaNomes);

        for (int i = 0; i < 1; i++) {
            int index = rnd.nextInt(i + 1);
            return listaNomes.remove(index);
        }
        return null;
    }

}

