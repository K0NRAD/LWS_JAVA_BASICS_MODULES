package schwarz.it.lws.java._001_005_operators_and_expressions.tasks;

import java.util.Scanner;

/*
Task: Bits schieben

    Erstelle ein Java-Programm, das drei Ganzzahlen x, y und z, im Bereich von 0 bis 255, entgegennimmt
    und deren Binärdarstellung ausgibt.
    Die Binärdarstellungen sollen jeweils acht Stellen haben, wobei eventuell fehlende Stellen mit Nullen
    aufgefüllt werden sollen.

    Anschließend soll das Programm eine neue Ganzzahl erstellen, indem es x an die höchstwertige Stelle der
    Binärdarstellung setzt, y an die nächstniedriger wertige Stelle und z an die niedrigst wertige Stelle.
    Die Binärdarstellung der neuen Ganzzahl soll ebenfalls ausgegeben werden.
    Die neue Ganzzahl soll 24 Stellen haben, wobei eventuell fehlende Stellen wiederum mit Nullen aufgefüllt
    werden sollen.

    Die neue Ganzzahl muss durch arithmetische Operationen gebildet werden und nich durch konkatenieren der
    Binärdarstellungen der Variablen x, y und z.

Algorithmus:

    1. Ein Scanner-Objekt erstellt, um Benutzereingaben entgegenzunehmen.
    2. Drei Ganzzahlen x, y und z von der Benutzerin oder dem Benutzer eingelesen.
    3. Die Eingaben werden als Binärdarstellungen ausgegeben, wobei eventuell fehlende
       Stellen mit Nullen aufgefüllt werden.

    4. Eine neue Ganzzahl erstellen, indem x an die höchstwertige Stelle der Binärdarstellung gesetzt wird,
       y an die nächstniedrigerwertige Stelle und z an die niedrigstwertige Stelle.
    5. Die Binärdarstellung der neuen Ganzzahl wird ebenfalls ausgegeben, wobei eventuell fehlende Stellen
       wiederum mit Nullen aufgefüllt werden.

Beispiel:

    Werden x = 5, y = 3 und z = 6 eingegeben, soll das Programm folgende Ausgabe produzieren:

    00000101
    00000011
    00000110
    000001010000001100000110

Hinweis:

    Verwende die Klasse Scanner, um die Benutzereingaben zu lesen, und die Klasse String mit der
    Methode format, um die Binärdarstellungen auf acht bzw. 24 Stellen aufzufüllen. Verwende außerdem
    die Klasse Integer mit der Methode toBinaryString, um die Binärdarstellungen zu erhalten.
    Die Bitverschiebungen kannst du mit den Operatoren << und | durchführen.

Bearbeitungszeit:

    20 Minuten
 */
public class BitShifter {
    public static void main(String[] args) {

    }
}
