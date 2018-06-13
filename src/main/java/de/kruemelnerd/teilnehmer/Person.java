package de.kruemelnerd.teilnehmer;

public class Person {

    int alter;
    String vorname;
    String name;

    public Person() {
    }

    public Person(int alter, String vorname, String name) {
        this.alter = alter;
        this.vorname = vorname;
        this.name = name;
    }

    public int getAlter() {
        return alter;
    }

    public void setAlter(int alter) {
        this.alter = alter;
    }

    public String getVorname() {
        return vorname;
    }

    public void setVorname(String vorname) {
        this.vorname = vorname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
