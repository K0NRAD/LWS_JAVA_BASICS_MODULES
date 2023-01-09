package schwarz.it.lws.java._001_007_loops.find_the_bug;
/*
Task: Noodle Calculator

    In einem Supermarkt werden Nudeln in Packungen à 500g verkauft. Ein Kunde
    möchte wissen, wie viele Packungen Nudeln er für einen bestimmten Nudelbedarf
    kaufen muss.

Todo:

    Das Programm arbeitet nicht wie erwartet. Finde die Fehler und behebe sie,
    so dass die Nudel Berechnung korrekt funktioniert.

    Die Ein-/Ausgabe auf dem Terminal sollte wie folgt aussehen:

        Pasta requirement (in grams): 1000
        Pasta packs needed: 2

Algorithmus:

    - Fordere den Nudelbedarf in Gramm vom Benutzer ein.
    - Berechne, wie viele Packungen Nudeln der Kunde kaufen muss, indem der
      Nudelbedarf durch 500 teilt und den Quotienten aufrundet.
    - Gib die Anzahl der benötigten Nudelpackungen aus.

Berabeitungszeit:

    30 Minuten
 */

import java.util.Scanner;

public class PastaCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Pasta requirement (in grams):");
        int nudelbedarf = scanner.nextByte();

        int packungen = nudelbedarf / 500;

        System.out.println("Pasta packs needed:" + packungen);
    }
}



