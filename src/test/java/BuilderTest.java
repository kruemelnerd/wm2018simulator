import de.kruemelnerd.builder.PersonBuilder;
import de.kruemelnerd.builder.TrainerBuilder;
import de.kruemelnerd.teilnehmer.Person;
import de.kruemelnerd.teilnehmer.Trainer;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class BuilderTest {

    @Test
    public void personBuilderTest() {
        Person person = new PersonBuilder()
                .withAlter(120)
                .withName("Müller")
                .withVorname("Peter")
                .build();

        assertThat(person.getAlter(), is(120));
        assertThat(person.getName(), is("Müller"));
        assertThat(person.getVorname(), is("Peter"));
    }


    @Test
    public void trainerBuilderTest() {
        Trainer trainer = new TrainerBuilder()
                .withAlter(120)
                .withName("Müller")
                .withVorname("Peter")
                .withErfahrung(5)
                .build();

        assertThat(trainer.getAlter(), is(120));
        assertThat(trainer.getName(), is("Müller"));
        assertThat(trainer.getVorname(), is("Peter"));
        assertThat(trainer.getErfahrung(), is(5));
    }
}
