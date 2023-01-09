package schwarz.it.lws.java._001_007_loops.tasks;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.nio.charset.StandardCharsets;
import java.util.Scanner;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

/*

Task: Base64 Encoder und Decoder

    Schreibe eine Java-Klasse mit zwei Methoden zum Base64-Kodieren und Dekodieren von Daten.

Todo:

    Die Methoden sollen die folgenden Funktionen haben:

        // Diese Methode soll die übergebenen Binärdaten kodieren und den
        // kodierten Text als Zeichenfolge zurückgeben.
        public static String encode(byte[] data)

        // Diese Methode soll den übergebenen kodierten Text dekodieren
        // und das entsprechende Binär-Array zurückgeben.
        public static byte[] decode(String encoded)

        // Diese Methode soll die Länge des encodierten Textes berechnen
        // und zurückgeben
        public static int getEncodedLength(byte[] data)

        // Diese Methode soll die Länge des decodierten Textes berechnen
        // und zurückgeben
        public static int getDecodedLength(String encoded)

!! Verwende bei der Umsetzung keine externen Bibliotheken oder eingebaute Funktionen.


Base64:
    Base64 ist ein Verfahren zum Kodieren von Daten, insbesondere von Binärdaten wie Bildern
    oder Musikdateien, in eine Zeichenfolge, die nur aus Buchstaben und Zahlen besteht.
    Dies ermöglicht es, die Daten über Textprotokolle zu übertragen, die normalerweise
    keine Binärdaten unterstützen.

    Im Einzelnen werden die Binärdaten in Gruppen von sechs Bits unterteilt und jeder Gruppe
    wird dann ein Zeichen aus einem vordefinierten Satz von 64 Zeichen zugeordnet.
    Die resultierende Zeichenfolge kann dann als Text übertragen werden und am Empfangsort
    wieder in die ursprünglichen Binärdaten umgewandelt werden.

    Die Zeichentabelle, die von Base64 verwendet wird, besteht aus 64 Zeichen, die wie folgt
    angeordnet sind:

    A - 0       N - 13      a - 26     n - 39      0 - 52
    B - 1       O - 14      b - 27     o - 40      1 - 53
    C - 2       P - 15      c - 28     p - 41      2 - 54
    D - 3       Q - 16      d - 29     q - 42      3 - 55
    E - 4       R - 17      e - 30     r - 43      4 - 56
    F - 5       S - 18      f - 31     s - 44      5 - 57
    G - 6       T - 19      g - 32     t - 45      6 - 58
    H - 7       U - 20      h - 33     u - 46      7 - 59
    I - 8       V - 21      i - 34     v - 47      8 - 60
    J - 9       W - 22      j - 35     w - 48      9 - 61
    K - 10      X - 23      k - 36     x - 49      + - 62
    L - 11      Y - 24      l - 37     y - 50      / - 63
    M - 12      Z - 25      m - 38     z - 51

    Jedes dieser Zeichen wird einer Gruppe von sechs Bits aus den Binärdaten zugeordnet, wodurch
    eine Zeichenfolge erstellt wird, die nur aus Buchstaben und Zahlen besteht.
    Die Zeichen + und / werden verwendet, um die Codierung zu unterscheiden von reinen Textdaten.
    Das '='Zeichen Wwrd zum Auffüllen der dreier Byte Gruppen benötigt.

Algorithmus:

    1. Fordere vom Anwender die Eingabe eines Textes über die Konsole
    2. Enkodiere den Text nach Base64
    3. Geben den Base64 String auf der Konsole aus
    4. Dekodiere den Base64 String, sodass der originale Text wieder hergestellt wird
    5. Gebe den dekodierten Base64 String auf der Konsole aus.

Beispiel:

    Der String "Schwarz IT" würde anhand der Zeichentabelle wie folgt kodiert werden:

    01010011 01100011 01101000 01110111 01100001 01110010 01111010 00100000 01001001 01010100 00000000 00000000
    S        c        h        w        a        r        z                 I        T

    010100 110110 001101 101000 011101 110110 000101 110010 011110 100010 000001 001001 010101 000000 000000 000000
    U      2      N      o      d      2      F      y      e      i      B      J      V      A      =      =


Bearbeitungszeit:

    120 Minuten

 */

public class Base64 {

    public static void main(String[] args) {

    }

    public static String encode(byte[] data) {
        byte[] encoded = new byte[getEncodedLength(data)];

        return new String(encoded);
    }

    public static byte[] decode(String encoded) {
        byte[] decoded = new byte[getDecodedLength(encoded)];

        return decoded;
    }

    public static int getEncodedLength(byte[] data) {
        return -1;
    }

    public static int getDecodedLength(String encoded) {
        return -1;
    }
}

// = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = =
// Don't change the JUnit test code.

class Base64Test {

    // Erstelle einen Stream von Testdaten für den Enkodierungstest
    private static Stream<Object[]> encodeTestDataProvider() {
        return Stream.of(
                new Object[]{"Schwarz IT", "U2Nod2FyeiBJVA=="},
                new Object[]{"Carton", "Q2FydG9u"},
                new Object[]{"Testing the Base64 encoding", "VGVzdGluZyB0aGUgQmFzZTY0IGVuY29kaW5n"}
        );
    }

    // Erstelle einen Stream von Testdaten für den Dekodierungstest
    private static Stream<Object[]> decodeTestDataProvider() {
        return Stream.of(
                new Object[]{"U2Nod2FyeiBJVA==", "Schwarz IT"},
                new Object[]{"Q2FydG9u", "Carton"},
                new Object[]{"VGVzdGluZyB0aGUgQmFzZTY0IGVuY29kaW5n", "Testing the Base64 encoding"}
        );
    }

    // Führe den Enkodierungstest mit Testdaten aus dem encodeTestDataProvider-Stream durch
    @ParameterizedTest
    @MethodSource("encodeTestDataProvider")
    public void testEncode(String input, String expectedOutput) {
        assertThat(Base64.encode(input.getBytes(StandardCharsets.UTF_8))).isEqualTo(expectedOutput);
    }

    // Führe den Dekodierungstest mit Testdaten aus dem decodeTestDataProvider-Stream durch
    @ParameterizedTest
    @MethodSource("decodeTestDataProvider")
    public void testDecode(String input, String expectedOutput) {
        assertThat(Base64.decode(input)).isEqualTo(expectedOutput.getBytes(StandardCharsets.UTF_8));
    }

    // Teste die Berechnung der Enkodierungslänge mit Testdaten aus der @CsvSource-Annotation
    @ParameterizedTest
    @CsvSource({
            "Schwarz IT, 16",
            "Carton, 8",
            "Testing the Base64 encoding, 36"})
    public void testGetEncodedLength(String input, int length) {
        assertThat(Base64.getEncodedLength(input.getBytes(StandardCharsets.UTF_8))).isEqualTo(length);
    }

    // Teste die Berechnung der Dekodierungslänge mit Testdaten aus der @CsvSource-Annotation
    @ParameterizedTest
    @CsvSource({
            "U2Nod2FyeiBJVA==, 10",
            "Q2FydG9u, 6",
            "VGVzdGluZyB0aGUgQmFzZTY0IGVuY29kaW5n, 27"})
    public void testGetDecodedLength(String input, int length) {
        assertThat(Base64.getDecodedLength(input)).isEqualTo(length);
    }
}