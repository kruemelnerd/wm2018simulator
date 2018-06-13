package de.kruemelnerd.builder;

import de.kruemelnerd.teilnehmer.Trainer;

public class TrainerBuilder {

    Trainer trainer;

    public TrainerBuilder() {
        this.trainer = new Trainer();
    }

    public Trainer build(){
        return this.trainer;
    }

    public TrainerBuilder withAlter(int alter) {
        trainer.setAlter(alter);
        return this;
    }

    public TrainerBuilder withVorname(String vorname) {
        trainer.setVorname(vorname);
        return this;
    }

    public TrainerBuilder withName(String nachname) {
        trainer.setName(nachname);
        return this;
    }

    public TrainerBuilder withErfahrung(int erfahrung) {
        trainer.setErfahrung(erfahrung);
        return this;
    }


}
