package de.kruemelnerd;

import de.kruemelnerd.teilnehmer.Spieler;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Spiel {

    private static final Logger LOGGER = LogManager.getLogger(Spiel.class.getName());

    private static final int SPIELDAUER = 90;


    private static boolean DEBUGMODE = true;

    private int torHeim;
    private int torAuswaerts;

    private Mannschaft heimMannschaft;
    private Mannschaft auswaertsMannschaft;

    private Mannschaft teamInBallBesitz;
    private Mannschaft teamNichtInBallBesitz;


    public Spiel() {
        vorbereitungWmSpiel();
    }

    public Spiel(boolean debugMode) {
        DEBUGMODE = debugMode;
        vorbereitungWmSpiel();
    }




    public void vorbereitungWmSpiel() {
        heimMannschaft = WmHelper.loadMannschaft("Deutschland");
        auswaertsMannschaft = WmHelper.loadMannschaft("Mexiko");

        teamInBallBesitz = null;
        teamNichtInBallBesitz = null;
    }

    public Mannschaft starteWmSpiel() {
        Muenze muenze = werfeMuenzeFürStart();

        if (muenze == Muenze.KOPF) {
            teamInBallBesitz = heimMannschaft;
            teamNichtInBallBesitz = auswaertsMannschaft;
        }
        if (muenze == Muenze.ZAHL) {
            teamInBallBesitz = auswaertsMannschaft;
            teamNichtInBallBesitz = heimMannschaft;
        }

        // schiedsrichter.anpfiff;
        anstoss();

        spieleHalbzeit(1);

        halbzeitPause();

        spieleHalbzeit(2);
        return spielEnde();
    }

    private void halbzeitPause() {
        if(DEBUGMODE){
            LOGGER.info("Es ist HALBZEIT und dies ist der aktuelle Stand: " + heimMannschaft.getName() + ": "+heimMannschaft.getTore() + " - " + auswaertsMannschaft.getName() + ": " + auswaertsMannschaft.getTore());
        }

    }

    private Mannschaft spielEnde(){
        if(DEBUGMODE) {
            LOGGER.info("Das Spiel ist zuende!!!");
            LOGGER.info("Dies ist der finale Stand: " + heimMannschaft.getName() + ": " + heimMannschaft.getTore() + " - " + auswaertsMannschaft.getName() + ": " + auswaertsMannschaft.getTore());
        }
        if(heimMannschaft.getTore() == auswaertsMannschaft.getTore()){
            if(DEBUGMODE) {
                LOGGER.info("Es gab ein Unendschieden!");
            }
            return null;
        }

        Mannschaft gewinner = heimMannschaft;
        Mannschaft verlierer = auswaertsMannschaft;
        if(heimMannschaft.getTore() < auswaertsMannschaft.getTore()){
            gewinner = auswaertsMannschaft;
            verlierer = heimMannschaft;
        }
        if(DEBUGMODE) {
            LOGGER.info("Damit hat " + gewinner.getName() + " das Spiel gewonnen!!!");
        }
        return gewinner;

    }

    private void spieleHalbzeit(int haelfte) {

        int ballInZone = 0;
        for (int dauerSpielhaelfte = 0; dauerSpielhaelfte < (SPIELDAUER+1) / 2; dauerSpielhaelfte++) {
            int dauerGesamtesSpiel = dauerSpielhaelfte+1;
            if(haelfte == 2){
                dauerGesamtesSpiel += SPIELDAUER/2;
            }
            int angriff = teamInBallBesitz.angriff();
            int verteidigung = teamNichtInBallBesitz.defensive();

            if (angriff > verteidigung) {
                if(DEBUGMODE) {
                    LOGGER.info("Minute: " + dauerGesamtesSpiel + " - Ballposition: " + ballInZone + " - Ein super Angriff! " + teamInBallBesitz.getName() + " kommt dem Tor ein Stück näher.");
                }
                ballInZone++;

                if (ballInZone > 3) {
                    schussAufsTor();
                }
            } else {
                if(DEBUGMODE) {
                    LOGGER.info("Minute: " + dauerGesamtesSpiel + " - Ballposition: " + ballInZone + " - Abgewehrt! " + teamNichtInBallBesitz.getName() + " konnte die gegnerische Mannschaft erfolgreich zurückdrängen");
                }

                ballInZone--;


                if (ballInZone <= -3) {
                    // Ball im Aus
                    ballAbnahme();
                    ballInZone = -2;
                }
            }
        }
    }

    private void schussAufsTor() {
        int schussStaerke = teamInBallBesitz.schussAufTor();
        int halteStaerke = teamNichtInBallBesitz.halteSchussAufTor();

        if (schussStaerke > halteStaerke) {
            feierTor();
            ballAbnahme();
            anstoss();

        }else{
            if(DEBUGMODE) {
                LOGGER.info("Dieses Tor konnte gehalten werden. Großes Lob an Torwart " + teamNichtInBallBesitz.getTorwart().getName());
            }
            ballAbnahme();
        }
    }

    private void feierTor() {
        if(DEBUGMODE) {
            LOGGER.info("TOOOOOOOOOOOOOOOOOOOOOOOOR für " + teamInBallBesitz.getName());
        }
        teamInBallBesitz.torGeschossen();
    }

    public void anstoss(){
        Spieler spieler = teamInBallBesitz.anstoss();
        LOGGER.info("Der Anstoss für " + teamInBallBesitz.getName() + " wird von " + spieler.getName() + " ausgeführt. Wir sind alle gespannt!");
    }
    public void ballAbnahme() {
        Mannschaft tmp = teamInBallBesitz;
        teamInBallBesitz = teamNichtInBallBesitz;
        teamNichtInBallBesitz = tmp;
    }

    public Muenze werfeMuenzeFürStart() {
        return Muenze.findByValue(WmHelper.getRandomNumber(0, 2));
    }


    public int getTorHeim() {
        return torHeim;
    }

    public void setTorHeim(int torHeim) {
        this.torHeim = torHeim;
    }

    public int getTorAuswaerts() {
        return torAuswaerts;
    }

    public void setTorAuswaerts(int torAuswaerts) {
        this.torAuswaerts = torAuswaerts;
    }

    public Mannschaft getHeimMannschaft() {
        return heimMannschaft;
    }

    public void setHeimMannschaft(Mannschaft heimMannschaft) {
        this.heimMannschaft = heimMannschaft;
    }

    public Mannschaft getAuswaertsMannschaft() {
        return auswaertsMannschaft;
    }

    public void setAuswaertsMannschaft(Mannschaft auswaertsMannschaft) {
        this.auswaertsMannschaft = auswaertsMannschaft;
    }


    public static boolean isDEBUGMODE() {
        return DEBUGMODE;
    }
    public enum Muenze {
        KOPF(0), ZAHL(1);

        private int zahl;

        private Muenze(int zahl) {
            this.zahl = zahl;
        }

        public static Muenze findByValue(int value) {
            for (Muenze m : values()) {
                if (m.zahl == value) {
                    return m;
                }
            }
            return null;
        }
    }
}
