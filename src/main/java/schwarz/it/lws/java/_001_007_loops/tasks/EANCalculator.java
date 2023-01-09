package schwarz.it.lws.java._001_007_loops.tasks;
/*
Task: EAN Prüfsummen Rechner

EAN:
    EAN steht für "European Article Number" und ist ein internationaler Barcode-Standard,
    der verwendet wird, um Produkte eindeutig zu identifizieren.

    Die Prüfziffer der EAN-Nummern (13. Ziffer) berechnet sich, indem man die ersten
    zwölf Ziffern abwechselnd mit 1 und 3 multipliziert (links mit 1 anfangen) und
    diese Produkte summiert. Die Prüfziffer ist die Differenz der Summe zum nächsten
    Vielfachen von 10.
    Falls die Summe durch 10 teilbar ist, ist die Prüfziffer die 0.

Algorithmus:
    1. Lese den EAN von der Konsole ein
    2. Überprüfen, dass der EAN 13 Zeichen lang ist und nur Zahlen von 0 bis 9 enthält
    3. Durchlaufe in einer Schleife 12 Stellen von links nach rechts
    4. Bei jeder Iteration addiere die Zahl zu einer Summen-Variable, wenn sie gerade ist,
       oder multipliziere sie mit 3 und addiere sie zu der Summen-Variable, wenn sie ungerade ist
    5. Errechne die Differenz der Summe zum nächsten Vielfachen von 10
    6. Ist das Ergebnis 10, dann ist die Prüfziffer 0
    7. Gebe eine Meldung auf der Konsole aus ob der EAN gültig oder ungültig ist


Beispiel:

    978381582086[?]

    9x1 + 7x3 + 8x1 + 3x3 + 8x1 + 1x3 + 5x1 + 8x3 + 2x1 + 0x3 + 8x1 + 6x3
    9 + 21 + 8 + 9 + 8 + 3 + 5 + 24 + 2 + 0 + 8 + 18 = 115

    115 + 5 = 120 -> Prüfziffer: 5

Bearbeitungszeit:

    45 Minuten
 */

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Scanner;

import static org.assertj.core.api.Assertions.assertThat;

public class EANCalculator {

    public static void main(String[] args) {

    }

    public static int calculateChecksum(String ean) {

        return -1;
    }
}

// = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = =
// Don't change the JUnit test code.

class EANCalculatorTest {

    @Test
    public void testEanWithChecksum0() {
        // given
        String ean = "4005776013500";

        // when
        int checksum = EANCalculator.calculateChecksum(ean);

        // then
        assertThat(checksum).isEqualTo(0);
    }

    @ParameterizedTest
    @CsvSource({
            "4006381333931, 1",
            "4015605622061, 1",
            "4005776013500, 0",
            "4047443292379, 9",
            "4005808881179, 9",
            "4024074259272, 2",
            "4022679793592, 2",
            "4006381333917, 7",
            "4016937065227, 7",
            "4006381333924, 4"})
    public void testChecksumFromMultibleEan13Codes(String ean, int checkSum) {
        assertThat(EANCalculator.calculateChecksum(ean)).isEqualTo(checkSum);
    }

}