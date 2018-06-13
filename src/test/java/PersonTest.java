import org.junit.Test;
import teilnehmer.Spieler;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class PersonTest {

    @Test
    public void spielerInitalisierungTest(){

        // Vorgegebene Werte
        String vorname = "Paul";
        String nachname = "Müller";
        int alterWert= 22;
        int abwehrWert = 1;
        int staerkeWert = 6;
        int geschwindigkeitWert = 8;


        Spieler spieler = new Spieler(alterWert, vorname, nachname, staerkeWert, abwehrWert, geschwindigkeitWert);

        // Werte direkt in teilnehmer.Spieler
        assertThat(spieler.getAbwehr(), is(abwehrWert));
        assertThat(spieler.getGeschwindigkeit(), is(geschwindigkeitWert));
        assertThat(spieler.getStaerke(), is(staerkeWert));

        // Werte aus teilnehmer.Person in teilnehmer.Spieler vererbt
        assertThat(spieler.getAlter(), is(alterWert));
        assertThat(spieler.getName(), is(nachname));
        assertThat(spieler.getVorname(), is(vorname));
    }

    @Test
    public void prüfeSpieler(){

    }
}
