import de.kruemelnerd.Mannschaft;
import de.kruemelnerd.builder.TrainerBuilder;
import de.kruemelnerd.teilnehmer.Spieler;
import de.kruemelnerd.teilnehmer.Torwart;
import de.kruemelnerd.teilnehmer.Trainer;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class MannschaftTest {

    Trainer trainer;
    Spieler[] spieler;
    Torwart torwart;

    @Before
    public void init() {
        trainer = new TrainerBuilder()
                .withAlter(55)
                .withErfahrung(7)
                .build();


        spieler = new Spieler[10];
        for (int i = 0; i <= 9; i++) {
            spieler[i] = new Spieler(20, "vor", "nach", 5, 5, 5);
        }
        torwart = new Torwart(21, "Peter", "Müller", 5, 5, 5, 5);

    }

    @Test
    public void angriffTest() {
        Mannschaft mannschaft = new Mannschaft();
        mannschaft.setAlleSpieler(spieler);
        mannschaft.setTorwart(torwart);
        mannschaft.setTrainer(trainer);

        int angriff = mannschaft.angriff();
        assertThat(angriff, is(1050));
    }


    @Test
    public void defensiveTest() {
        Mannschaft mannschaft = new Mannschaft();
        mannschaft.setAlleSpieler(spieler);
        mannschaft.setTorwart(torwart);
        mannschaft.setTrainer(trainer);

        int defensive = mannschaft.defensive();
        assertThat(defensive, is(1050));
    }
}
