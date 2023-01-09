package schwarz.it.lws.java._001_007_loops.tasks;

/*
Task: Printer Errors

    In einer Fabrik druckt ein Drucker Etiketten für Kartons. Für eine Art von Kartons
    muss der Drucker Farben verwenden, die, um die Dinge einfach zu halten, mit Buchstaben
    von a bis m benannt sind.

    Die von dem Drucker verwendeten Farben werden in einer Steuerzeichenfolge aufgezeichnet.
    Eine "gute" Steuerzeichenfolge wäre zum Beispiel aaabbbbhaijjjm, was bedeutet, dass der
    Drucker dreimal die Farbe a, viermal die Farbe b, einmal die Farbe h und dann einmal die
    Farbe a verwendet hat...

    Manchmal gibt es Probleme: Mangel an Farben, technischer Fehler und eine "schlechte"
    Steuerzeichenfolge wird erzeugt, z.B. aaaxbbbbyyhwawiwjjjwwm mit Buchstaben, die nicht
    von a bis m sind.

    Du musst eine Funktion schreiben, printer_error, die eine Zeichenfolge übergeben bekommt und
    den Fehlergrad des Druckers als Zeichenfolge zurückgibt, die einen Bruch darstellt, dessen
    Zähler die Anzahl der Fehler und dessen Nenner die Länge der Steuerzeichenfolge ist.
    Kürze diesen Bruch nicht auf einen einfacheren Ausdruck.
    Die Zeichenfolge hat eine Länge von mindestens einem und enthält nur Buchstaben von a bis z.

Algorithmus:

    - Iteriere über jedes Zeichen c in s.
    - Wenn c nicht in der Menge {'a', 'b', 'c', ..., 'm'} enthalten ist, erhöhe den
      Zähler für die Anzahl der Druckfehler um 1.
    - Gib die Anzahl der Druckfehler und die Gesamtlänge von s im Format "x/y" zurück,
      wobei x die Anzahl der Druckfehler und y die Gesamtlänge von s ist.

Beispiele:
    s="aaabbbbhaijjjm"
    printer_error(s) => "0/14"
    s="aaaxbbbbyyhwawiwjjjwwm"
    printer_error(s) => "8/22"


Bearbeitungszeit:

    30 Minuten
 */

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class PrinterErrors {

    public String printerError(String s) {
        return "0/0";
    }

}

// = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = =
// Don't change the JUnit test code.

class PrinterErrorTest {
    private PrinterErrors printerErrors;

    @BeforeEach
    void setUp() {
        printerErrors = new PrinterErrors();
    }

    @Test
    void testErrorCodesWithoutErrors() {
        // given
        String errorCode = "aaabbbbhaijjjm";

        // when
        String got = printerErrors.printerError(errorCode);

        // then
        assertThat(got).isEqualTo("0/14");
    }

    @Test
    void testErrorCodeWithEightErrors() {
        // given
        String errorCode = "aaaxbbbbyyhwawiwjjjwwm";

        // when
        String got = printerErrors.printerError(errorCode);

        // then
        assertThat(got).isEqualTo("8/22");
    }

    @Test
    void testErrorCodeWithElevenErrors() {
        // given
        String errorCode = "aaaxbbybffbyyhwawippwjjjwwm";

        // when
        String got = printerErrors.printerError(errorCode);

        // then
        assertThat(got).isEqualTo("11/27");
    }
}

