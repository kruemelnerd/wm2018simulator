import de.kruemelnerd.Mannschaft;
import de.kruemelnerd.Spiel;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;


public class StarteSpielTest {

    private static final Logger LOGGER = LogManager.getLogger(Spiel.class.getName());

    @Test
    public void wm2018SimulatorTest() {


        int mexikoGewonnen = 0;
        int deutschlandGewonnen = 0;
        int unentschieden = 0;
        for (int i = 0; i < 10000; i++) {

            Spiel spiel = new Spiel(false);

            Mannschaft gewinner = spiel.starteWmSpiel();
            if(gewinner == null){
                unentschieden++;
            }else if ("Mexiko".equals(gewinner.getName())) {
                mexikoGewonnen++;
            } else if ("Deutschland".equals(gewinner.getName())) {
                deutschlandGewonnen++;
            }
        }
        LOGGER.info("");
        LOGGER.info("");
        LOGGER.info("");
        LOGGER.info("");
        LOGGER.info("Deutschland: " + deutschlandGewonnen);
        LOGGER.info("Mexiko: " + mexikoGewonnen);
        LOGGER.info("unentschieden: " + unentschieden);


    }

}
