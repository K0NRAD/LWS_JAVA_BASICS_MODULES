package schwarz.it.lws.java._001_007_loops.tasks;
/*
Task: Reverse Words

    Schreibe eine Java-Methode `reverseWords`, die einen Satz als String `sentence`
    akzeptiert und den Satz mit den Worten in umgekehrter Reihenfolge zurückgibt.

Todo:

    Vervollständige die Funktion `reverseWords`, die einen String-Parameter, mit einem Text,
    enthält und drehe jedes Wort um.

    Wichtig, alle Leerzeichen in der Zeichenkette müssen erhalten bleiben.

Beispiele:

    "This is an example!"   ==> "sihT si na !elpmaxe"
    "double  spaces"        ==> "elbuod  secaps"

Bearbeitungszeit:

    60 Minuten
*/

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class ReverseWords {
    public String reverseWords(final String sentence) {

        return "";
    }
}

// = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = =
// Don't change the JUnit test code.

class ReverseWordsTest {
    ReverseWords reverseWords;

    @BeforeEach
    public void setup() {
        reverseWords = new ReverseWords();
    }

    @Test
    public void testReverseWordsWithSingleWord() {
        // given
        String sentence = "hello";
        // when
        String result = reverseWords.reverseWords(sentence);
        // then
        assertThat(result).isEqualTo("olleh");
    }

    @Test
    public void testReverseWordsWithMultipleWords() {
        // given
        String sentence = "hello world";
        // when
        String result = reverseWords.reverseWords(sentence);
        // then
        assertThat(result).isEqualTo("olleh dlrow");
    }

    @Test
    public void testReverseWordsWithMultipleWordsAndMultipleSpaces() {
        // given
        String sentence = "hello   world";
        // when
        String result = reverseWords.reverseWords(sentence);
        // then
        assertThat(result).isEqualTo("olleh   dlrow");
    }

    @Test
    public void testReverseWordsWithLeadingAndTrailingSpaces() {
        // given
        String sentence = "   hello world   ";
        // when
        String result = reverseWords.reverseWords(sentence);
        // then
        assertThat(result).isEqualTo("   olleh dlrow   ");
    }

    @Test
    public void testReverseWords_emptyString() {
        // given
        String sentence = "";
        // when
        String result = reverseWords.reverseWords(sentence);
        //then
        assertThat(result).isEmpty();
    }
}