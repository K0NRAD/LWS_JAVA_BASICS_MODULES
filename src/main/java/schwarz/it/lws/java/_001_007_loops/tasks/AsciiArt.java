package schwarz.it.lws.java._001_007_loops.tasks;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/*
Task: ASCII Art

    ASCII-Kunst erlaubt es, Formen mithilfe von Zeichen darzustellen. Um genau
    zu sein, sind diese Formen in unserem Fall Wörter.

    Zum Beispiel könnte das Wort "SCHWARZIT" in ASCII-Art wie folgt dargestellt werden:

        " ##   ##  # #  # #   #   ##   ###  ###  ###  "
        "#    #    # #  # #  # #  # #    #   #    #   "
        " #   #    ###  ###  ###  ##    #    #    #   "
        "  #  #    # #  ###  # #  # #  #     #    #   "
        "##    ##  # #  # #  # #  # #  ###  ###   #   "

Todo:

    Deine Aufgabe ist es den eingegebenen Text in ASCII Art zu konvertieren.

    Ergänze in der Funktion `toAsciiArt(...)` den erforderlichen Code.

    Die Parameter der Funktion `toAsciiArt(String text, String[] abc, int chrWidth, int chrHeight)` haben
    folgenden bedeutung:
        - text      - Der zu konvertierende Text
        - abc       - Die Buchstaben A-Z und ? im ASCII Art Format
        - chrWidth  - Die Zeichenbreite eines einzelnen ASCII Art Zeichens
        - chrHeight - Die Zeichenhöhe eines einzelnen ASCII Art Zeichens

    Der Rückgabe Wert ist ein String Array mit den einzelnen Zeilen des konvertierten Textes.

Hinweis:

    Es können nur die Buchstaben a-z und A-Z konvertiert werden, für alle anderen Zeichen wird das
    ASCII Art Fragezeichen zurückgegeben.

    Die Ausgabe erfolg in mit den Großbuchstaben de ASCII Art ABC's

    Schaue dir die Testfälle mit den Unit-Tests an, un ein besseres Verständnis für die Umsetzung zu
    bekommen

Bearbeitungszeit:

    120 Minuten
 */

public class AsciiArt {
    /**
     *
     * @param text       - Der zu konvertierende Text
     * @param abc        - Buchstaben A-Z und ? im ASCII Art Format
     * @param chrWidth   - Zeichenbreite eines einzelnen ASCII Art Zeichens
     * @param chrHeight  - Zeichenhöhe eines einzelnen ASCII Art Zeichens
     *
     * @return           - String Array mit den ASCII-Art Zeilen des konvertierten Textes.
     */
    public String[] toAsciiArt(String text, String[] abc, int chrWidth, int chrHeight) {
        String asciiArtLines[] = {};

        return asciiArtLines;
    }
}

// = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = =
// Don't change the JUnit test code.

class AsciiArtTest {
    // ASCII Art Zeichensatz
    static final String[] ABC_01 = {
            " #   ##    ##  ##   ###  ###   ##  # #  ###   ##  # #  #    # #  ###   #   ##    #   ##    ##  ###  # #  # #  # #  # #  # #  ###  ###  ",
            "# #  # #  #    # #  #    #    #    # #   #     #  # #  #    ###  # #  # #  # #  # #  # #  #     #   # #  # #  # #  # #  # #    #    #  ",
            "###  ##   #    # #  ##   ##   # #  ###   #     #  ##   #    ###  # #  # #  ##   # #  ##    #    #   # #  # #  ###   #    #    #    ##  ",
            "# #  # #  #    # #  #    #    # #  # #   #   # #  # #  #    # #  # #  # #  #     ##  # #    #   #   # #  # #  ###  # #   #   #         ",
            "# #  ##    ##  ##   ###  #     ##  # #  ###   #   # #  ###  # #  # #   #   #      #  # #  ##    #   ###   #   # #  # #   #   ###   #   "};

    AsciiArt asciiArt = new AsciiArt();

    @Test
    void testToAsciiArtWithLetterA() {
        String[] asciiArtLines = asciiArt.toAsciiArt("A", ABC_01, 5, 5);

        String[] requiered = {
                " #   ",
                "# #  ",
                "###  ",
                "# #  ",
                "# #  "};
        assertThat(asciiArtLines).isEqualTo(requiered);
    }

    @Test
    void testToAsciiArtWithTextSCHWARZIT() {
        String[] asciiArtLines = asciiArt.toAsciiArt("SCHWARZIT", ABC_01, 5, 5);

        String[] requiered = {
                " ##   ##  # #  # #   #   ##   ###  ###  ###  ",
                "#    #    # #  # #  # #  # #    #   #    #   ",
                " #   #    ###  ###  ###  ##    #    #    #   ",
                "  #  #    # #  ###  # #  # #  #     #    #   ",
                "##    ##  # #  # #  # #  # #  ###  ###   #   "};

        assertThat(asciiArtLines).isEqualTo(requiered);
    }

    @Test
    void testToAsciiArtWithTextSchwarzIT() {
        String[] asciiArtLines = asciiArt.toAsciiArt("SchwarzIT", ABC_01, 5, 5);

        String[] requiered = {
                " ##   ##  # #  # #   #   ##   ###  ###  ###  ",
                "#    #    # #  # #  # #  # #    #   #    #   ",
                " #   #    ###  ###  ###  ##    #    #    #   ",
                "  #  #    # #  ###  # #  # #  #     #    #   ",
                "##    ##  # #  # #  # #  # #  ###  ###   #   "};

        assertThat(asciiArtLines).isEqualTo(requiered);
    }

    @Test
    void testToAsciiArtWithTextSCHWARZITAndIllegalCharacter() {
        String[] asciiArtLines = asciiArt.toAsciiArt("SCH@ARZ@T", ABC_01, 5, 5);

        String[] requiered = {
                " ##   ##  # #  ###   #   ##   ###  ###  ###  ",
                "#    #    # #    #  # #  # #    #    #   #   ",
                " #   #    ###   ##  ###  ##    #    ##   #   ",
                "  #  #    # #       # #  # #  #          #   ",
                "##    ##  # #   #   # #  # #  ###   #    #   "};

        assertThat(asciiArtLines).isEqualTo(requiered);

    }
}
