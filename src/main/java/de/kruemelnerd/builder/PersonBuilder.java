package de.kruemelnerd.builder.;


import de.kruemelnerd.teilnehmer.Person;

public class PersonBuilder {

    Person person;

    public PersonBuilder() {
        this.person = new Person();
    }

    public Person build(){
        return this.person;
    }

    public PersonBuilder withAlter(int alter) {
        this.person.setAlter(alter);
        return this;
    }

    public PersonBuilder withVorname(String vorname) {
        this.person.setVorname(vorname);
        return this;
    }

    public PersonBuilder withName(String nachname) {
        this.person.setName(nachname);
        return this;
    }
}
