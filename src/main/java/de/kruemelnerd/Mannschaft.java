package de.kruemelnerd;

import de.kruemelnerd.teilnehmer.Spieler;
import de.kruemelnerd.teilnehmer.Torwart;
import de.kruemelnerd.teilnehmer.Trainer;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Arrays;
import java.util.Objects;

public class Mannschaft {

    private static final Logger LOGGER = LogManager.getLogger(Spiel.class.getName());

    private String name;
    private Trainer trainer = new Trainer();
    private Spieler[] alleSpieler = new Spieler[9];
    private Torwart torwart = new Torwart();

    private int tore = 0;


    public int angriff() {
        int angriffStaerke = 0;
        for (Spieler spieler : alleSpieler) {
            angriffStaerke += spieler.getStaerke() * 2;
            angriffStaerke += spieler.getGeschwindigkeit();
        }
        angriffStaerke *= trainer.getErfahrung();
        angriffStaerke *= WmHelper.getRandomNumber(0, 5);
        return angriffStaerke;
    }

    public int defensive() {
        int defensivStaerke = 0;
        for (Spieler spieler : alleSpieler) {
            defensivStaerke += spieler.getAbwehr() * 2;
            defensivStaerke += spieler.getGeschwindigkeit();
        }
        defensivStaerke *= trainer.getErfahrung();
        defensivStaerke *= WmHelper.getRandomNumber(0, 5);
        return defensivStaerke;
    }


    public Spieler anstoss() {
        Spieler spieler = alleSpieler[WmHelper.getRandomNumber(0, alleSpieler.length)];
        return spieler;
    }

    public int schussAufTor() {
        Spieler spieler = alleSpieler[WmHelper.getRandomNumber(0, alleSpieler.length)];
        return spieler.schussAufTor();
    }


    public int halteSchussAufTor() {
        return torwart.halteSchussAufTor();
    }

    public void torGeschossen() {
        tore++;
    }

    // -------------------
    // Getter & Setter
    // -------------------

    public Trainer getTrainer() {
        return trainer;
    }

    public void setTrainer(Trainer trainer) {
        this.trainer = trainer;
    }

    public Spieler[] getAlleSpieler() {
        return alleSpieler;
    }

    public void setAlleSpieler(Spieler[] alleSpieler) {
        this.alleSpieler = alleSpieler;
    }

    public Torwart getTorwart() {
        return torwart;
    }

    public void setTorwart(Torwart torwart) {
        this.torwart = torwart;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public int getTore() {
        return tore;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Mannschaft)) return false;
        Mannschaft that = (Mannschaft) o;
        return Objects.equals(name, that.name) &&
                Objects.equals(trainer, that.trainer) &&
                Arrays.equals(alleSpieler, that.alleSpieler) &&
                Objects.equals(torwart, that.torwart);
    }

    @Override
    public int hashCode() {

        int result = Objects.hash(name, trainer, torwart);
        result = 31 * result + Arrays.hashCode(alleSpieler);
        return result;
    }
}
