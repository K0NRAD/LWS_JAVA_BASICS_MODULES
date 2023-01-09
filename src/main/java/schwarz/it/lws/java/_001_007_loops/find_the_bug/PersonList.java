package schwarz.it.lws.java._001_007_loops.find_the_bug;
/*
Task: Person List

    Das Programm erstellt eine Personenliste und fügt vier Personen hinzu.
    Anschliessend wird die Personenliste auf der Konsole ausgegeben.

Todo:

    Es haben sich ein paar Bugs eingeschlichen. Finde die Fehler und
    behebe sie, so dass das Programm wir erwartet funktioniert.


Bearbeitungszeit:

    30 Minuten
 */

import java.util.ArrayList;

public class PersonList {

    public static void main(String[] args) {
        ArrayList<Person> persons = new ArrayList<>();

        persons.add(new Person("Max", 25));
        persons.add(new Person("Moritz", 30));
        persons.add(new Person("John", 42));
        persons.add(new Person("Jane", 32));

        for (Person p : persons) {
            System.out.println(p.name + ": " + p.age);
        }
    }
}

class Person {
    String name;
    int age;

    public Person(String name, int age) {
        name = name;
        age = age;
    }
}
