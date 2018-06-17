import de.kruemelnerd.Mannschaft;
import de.kruemelnerd.Spiel;
import de.kruemelnerd.builder.TrainerBuilder;
import de.kruemelnerd.teilnehmer.Spieler;
import de.kruemelnerd.teilnehmer.Torwart;
import de.kruemelnerd.teilnehmer.Trainer;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class SpielTest {

    Mannschaft mannschaft1;
    Mannschaft mannschaft2;

    @Before
    public void init() {

    }

    @Test
    public void ballAbnahmeTest(){
        mannschaft1 = new Mannschaft();
        mannschaft1.setName("Deutschland");
        mannschaft1 = new Mannschaft();
        mannschaft1.setName("Mexiko");

        assertThat(mannschaft1.getName(), is("Deutschland"));
        assertThat(mannschaft2.getName(), is("Mexiko"));

        Spiel spiel = new Spiel();
        spiel.ballAbnahme();

        assertThat(mannschaft1.getName(), is("Mexiko"));
        assertThat(mannschaft2.getName(), is("Deutschland"));


    }
}
