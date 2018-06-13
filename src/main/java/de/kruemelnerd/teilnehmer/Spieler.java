package de.kruemelnerd.teilnehmer;

import de.kruemelnerd.*;

public class Spieler extends Person {

    int staerke;
    int abwehr;
    int geschwindigkeit;

    public Spieler(){
        super(0, null, null);
    }

    public Spieler(int alter, String vorname, String name, int staerke, int abwehr, int geschwindigkeit) {
        super(alter, vorname, name);
        this.staerke = staerke;
        this.abwehr = abwehr;
        this.geschwindigkeit = geschwindigkeit;
    }


    public int schussAufTor(){
        int muenze = WmHelper.getRandomNumber( 1, 2);
        int halteStaerke = (this.getStaerke() * 2) + this.getGeschwindigkeit() ;
        return halteStaerke ;
    }


    public int getStaerke() {
        return staerke;
    }

    public void setStaerke(int staerke) {
        this.staerke = staerke;
    }

    public int getAbwehr() {
        return abwehr;
    }

    public void setAbwehr(int abwehr) {
        this.abwehr = abwehr;
    }

    public int getGeschwindigkeit() {
        return geschwindigkeit;
    }

    public void setGeschwindigkeit(int geschwindigkeit) {
        this.geschwindigkeit = geschwindigkeit;
    }
}
