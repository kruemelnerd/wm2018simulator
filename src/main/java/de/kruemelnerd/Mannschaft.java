package de.kruemelnerd;

import org.apache.log4j.spi.LoggerFactory;
import teilnehmer.Spieler;
import teilnehmer.Torwart;
import teilnehmer.Trainer;

import org.apache.log4j.Logger;

public class Mannschaft {

    private static Logger LOG = Logger.getLogger(Mannschaft.class);

    public String name;
    public Trainer trainer = new Trainer();
    public Spieler[] alleSpieler = new Spieler[9];
    public Torwart torwart = new Torwart();


    public int angriff(){
        int angriffStaerke = 0;
        for ( Spieler spieler : alleSpieler){
            angriffStaerke += spieler.getStaerke() * 2;
            angriffStaerke += spieler.getGeschwindigkeit() ;
        }
        angriffStaerke *= trainer.getErfahrung();
        return angriffStaerke;
    }

    public int defensive(){
        int defensivStaerke = 0;
        for ( Spieler spieler : alleSpieler){
            defensivStaerke += spieler.getAbwehr() * 2;
            defensivStaerke += spieler.getGeschwindigkeit();
        }
        defensivStaerke *= trainer.getErfahrung();
        return defensivStaerke;
    }


    public void anstoss(){
        Spieler spieler = alleSpieler[WmHelper.getRandomNumber(0, alleSpieler.length)];
        LOG.info("Der Anstoss wird von " + spieler.getName() + " ausgeführt. Wir sind alle gespannt!");
    }

    public int schussAufTor(){
        Spieler spieler = alleSpieler[WmHelper.getRandomNumber(0, alleSpieler.length)];
        int schussStaerke = ((spieler.getStaerke() * 2) + spieler.getGeschwindigkeit()) * trainer.getErfahrung();
        return schussStaerke;
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
}
