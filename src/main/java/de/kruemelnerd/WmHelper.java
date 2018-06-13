package de.kruemelnerd;

import builder.TrainerBuilder;
import de.kruemelnerd.teilnehmer.Trainer;
import teilnehmer.Spieler;
import teilnehmer.Torwart;
import teilnehmer.Trainer;

import java.util.concurrent.ThreadLocalRandom;

public class WmHelper {

    public static int getRandomNumber(int min, int max) {
        return ThreadLocalRandom.current().nextInt(min, max);
    }


    public static Mannschaft loadMannschaft(String name) {

        Trainer trainer = new TrainerBuilder()
                .withAlter(getRandomNumber(30, 60))
                .withErfahrung(getRandomNumber(5, 10))
                .build();


        Spieler[] spieler = new Spieler[10];
        for (int i = 0; i <= 9; i++) {
            spieler[i] = new Spieler(getRandomNumber(18, 43), "vor" + i, "nach" + i, getRandomNumber(0, 10), getRandomNumber(0, 10), getRandomNumber(0, 10));
        }
        Torwart torwart = new Torwart(getRandomNumber(18, 43), "Peter", "Müller", getRandomNumber(0, 10), getRandomNumber(0, 10), getRandomNumber(0, 10), getRandomNumber(0, 10));


        Mannschaft mannschaft = new Mannschaft();
        mannschaft.setTrainer(trainer);
        mannschaft.setTorwart(torwart);
        mannschaft.setAlleSpieler(spieler);
        mannschaft.setName(name);
        return mannschaft;
    }
}
