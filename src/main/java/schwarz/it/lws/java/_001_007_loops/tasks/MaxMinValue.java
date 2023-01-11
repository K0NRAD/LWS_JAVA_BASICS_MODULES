package schwarz.it.lws.java._001_007_loops.tasks;
/*
Task: Max Min Value

    Die Aufgabe besteht darin, bei gegebenen drei ganzen Zahlen die maximale und
    minimale Zahl zu bestimmen, ohne dabei bedingte Anweisungen wie if, switch
    oder ternary operator (?:) zu verwenden.

    Es sollen also alternative Lösungsansätze gefunden werden, um die Aufgabe zu
    lösen.

    Es kann dabei möglicherweise auf Schleifen oder bitweise Operationen
    zurückgegriffen werden.

    Es dürfen keine Arrays, Liste, Standard-Funktionen oder Bibliotheken verwendet
    werden um die Maximal- und Minimalzahl zu ermitteln.

Hinweis:

    Für die Aufgabe muss keine Benutzerinteraktion implementiert werden, die
    Funktionen werden mit Unittest auf Korrektheit überprüft.

Bearbeitungsdauer:

     30 Minuten.
 */

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

public class MaxMinValue {

    // Lösung durch wiederholte Addition
    int findMinValue(int a, int b, int c) {
        int min = 0;
        return min;
    }

    // Lösung durch wiederholte Subtraktion
    int findMaxValue(int a, int b, int c) {
        int max = 0;
        return max;
    }
}

// = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = =
// Don't change the JUnit test code.

class MaxMinValueTest {
    MaxMinValue maxMinValue;

    @BeforeEach
    void setUp() {
        maxMinValue = new MaxMinValue();
    }

    @ParameterizedTest
    @CsvSource({"1, 2, 3, 3", "3, 2, 1, 3", "2, 3, 1, 3", "-1, -2, -3, 0", "-3, -2, -1, 0"})
    public void testFindMaxValue(int a, int b, int c, int expectedMax) {
        assertThat(maxMinValue.findMaxValue(a, b, c)).isEqualTo(expectedMax);
    }

    @ParameterizedTest
    @CsvSource({"1, 2, 3, 1", "3, 2, 1, 1", "2, 3, 1, 1", "-1, -2, -3, 0", "-3, -2, -1, 0"})
    public void testFindMinValue(int a, int b, int c, int expectedMin) {
        assertThat(maxMinValue.findMinValue(a, b, c)).isEqualTo(expectedMin);
    }
}
