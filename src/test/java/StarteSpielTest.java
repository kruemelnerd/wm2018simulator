import de.kruemelnerd.Spiel;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.junit.Test;


public class StarteSpielTest {

    @Test
    public void wm2018SimulatorTest(){
        Logger.getRootLogger().setLevel(Level.DEBUG);

        Spiel spiel = new Spiel();

        spiel.starteWmSpiel();

    }

}
