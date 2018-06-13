package de.kruemelnerd;

import org.apache.log4j.Logger;

import java.util.NoSuchElementException;

public class Spiel {

    //private static Logger LOG = Logger.getLogger(Spiel.class);

    private static final int SPIELDAUER = 90;

    private int torHeim;
    private int torAuswaerts;

    private Mannschaft heimMannschaft;
    private Mannschaft auswaertsMannschaft;

    public Spiel(){
        vorbereitungWmSpiel();
    }


    public void vorbereitungWmSpiel(){
        heimMannschaft = WmHelper.loadMannschaft("Deutschland");
        auswaertsMannschaft =  WmHelper.loadMannschaft("Mexiko");
    }

    public void starteWmSpiel(){
        Mannschaft teamInBallBesitz = werfeMuenzeFürStart(heimMannschaft, auswaertsMannschaft);
        Mannschaft teamNichtInBallBesitz = auswaertsMannschaft;
        if(teamInBallBesitz.equals(auswaertsMannschaft)){
            teamNichtInBallBesitz = heimMannschaft;
        }

        // schiedsrichter.anpfiff;
        teamInBallBesitz.anstoss();

        int ballInZone = 0;
        for (int i = 0; i < SPIELDAUER/2; i++) {
            int angriff = teamInBallBesitz.angriff();
            int verteidigung = teamNichtInBallBesitz.defensive();

            if(angriff > verteidigung){
//                LOG.info("Ein super Angriff! " + teamInBallBesitz.getName() + " kommt dem Tor ein Stück näher.");
                ballInZone++;

                if(ballInZone > 3){
                    int schussStaerke = teamInBallBesitz.schussAufTor();
                    int halteStaerke = teamNichtInBallBesitz.halteSchussAufTor();

                    if(schussStaerke > halteStaerke){
//                        LOG.info("TOOOOOOOOOOOOOOOOOOOOOOOOR für " + teamInBallBesitz.getName());
                        ballInZone = 0;
                        ballAbnahme(teamInBallBesitz, teamNichtInBallBesitz);
                    }
                }
            }
        }
    }

    public void ballAbnahme(Mannschaft ball, Mannschaft nichtBall){
        Mannschaft tmp = ball;
        ball = nichtBall;
        nichtBall = tmp;
    }

    public Mannschaft werfeMuenzeFürStart(Mannschaft team1, Mannschaft team2) throws NoSuchElementException{
        int muenze = WmHelper.getRandomNumber( 1, 2);
        if(muenze == 1){
            return team1;
        }else if(muenze == 2){
            return team2;
        }else {
            throw new NoSuchElementException("Die geworfene Münze war falsch!");
        }
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
}
