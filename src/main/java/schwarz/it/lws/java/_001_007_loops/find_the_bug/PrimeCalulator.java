package schwarz.it.lws.java._001_007_loops.find_the_bug;

/*
Task: Primzahlen Rechner

    Das Programm fragt den Benutzer nach einer positiven Ganzzahl und prüft dann, ob jede Zahl
    von 2 bis zur eingegebenen Zahl eine Primzahl ist.

    Wenn es eine Primzahl ist, wird sie ausgegeben.

Todo:

    Der Primzahlen Rechner funktioniert nicht wie erwartet, helfe dem Programmierer den Fehler
    zu finden und zu beheben.

Hinweis:
    Es kann auch sein, dass der Algorithmus nicht optimal gewählt wurde.

Bearbeitungszeit:

    20 Minuten
 */

import java.util.Scanner;


public class PrimeCalulator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = 0;
        do {
            System.out.print("Please enter a positive integer:");
            n = scanner.nextInt();
        } while (n <= 0);

        for (int i = 2; i <= n; i++) {
            boolean isPrime = true;
            for (int j = 2; j < i; j++) {
                if (i % j == 1) {
                    isPrime = false;
                    break;
                }
            }
            if (isPrime) {
                System.out.println(i + " is a prime number.");
            }
        }
    }
}
