public class Torwart extends Spieler {

    int reaktion;

    public Torwart() {
        this.reaktion = 0;
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
