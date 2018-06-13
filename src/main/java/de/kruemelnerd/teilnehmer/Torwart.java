package de.kruemelnerd.teilnehmer;

import de.kruemelnerd.WmHelper;

public class Torwart extends Spieler {

    int reaktion;

    public Torwart() {
        this.reaktion = 0;
    }

    public int halteSchussAufTor(){
        int halteStaerke = ((this.getStaerke() * 2) + this.getGeschwindigkeit() + this.reaktion) * WmHelper.getRandomNumber( 1, 10);
        return halteStaerke ;
    }


    public Torwart(int reaktion) {
        this.reaktion = reaktion;
    }

    public Torwart(int alter, String vorname, String name, int staerke, int abwehr, int geschwindigkeit, int reaktion) {
        super(alter, vorname, name, staerke, abwehr, geschwindigkeit);
        this.reaktion = reaktion;
    }


    public int getReaktion() {
        return reaktion;
    }

    public void setReaktion(int reaktion) {
        this.reaktion = reaktion;
    }
}
