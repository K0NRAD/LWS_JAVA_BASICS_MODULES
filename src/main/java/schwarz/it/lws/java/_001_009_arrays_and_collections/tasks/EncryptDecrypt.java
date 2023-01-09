package schwarz.it.lws.java._001_009_arrays_and_collections.tasks;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.stream.Collector;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

/*
Task: Verschlüsseln und Entschlüsseln eines Textes.


    Es war ein dunkler und stürmischer Abend, als Maria ihren Laptop einschaltete, um ihre
    wichtigsten Dokumente zu sichern. Sie hatte immer ein ungutes Gefühl, wenn es draußen
    regnete und sie wollte sichergehen, dass ihre wichtigen Dateien sicher aufbewahrt waren.

    Sie öffnete die Klasse EncryptDecrypt und betrachtete den Code. Sie wusste, dass diese
    Klasse dafür verantwortlich war, Text zu verschlüsseln und wieder zu entschlüsseln, aber
    sie hatte sich noch nie die Mühe gemacht, genauer hinzuschauen.

    Maria entschied, dass es an der Zeit war, den Code genauer zu untersuchen und fing an,
    die Methoden encrypt und decrypt zu lesen. Sie stellte fest, dass encrypt einen Stream
    von geraden und ungeraden Zeichen im Text erstellte und diese dann zu einem neuen String
    zusammensetzte. Die Methode decrypt tat das Gleiche, aber in umgekehrter Reihenfolge.

    Maria war beeindruckt von der Leistungsfähigkeit des Codes und beschloss, ihn auszuprobieren.

    Sie gab einen Text ein und wählte eine Zahl für die Verschlüsselung. Der verschlüsselte Text
    wurde zurückgegeben und Maria war erstaunt, wie unleserlich er war. Sie gab den verschlüsselten
    Text und die Zahl in die decrypt-Methode ein und siehe da, der ursprüngliche Text wurde
    wiederhergestellt.

    Leider hat Maria den Code aus Versehen gelöscht, hilf Maria den verlorenen Code wieder
    herszustellen.

Todo:

    Erstellen eine Klasse EncryptDecrypt, die folgende Methoden enthält:

    public String encrypt(String text, int n):

        Diese Methode nimmt einen String text und eine ganze Zahl n als Eingabe und verschlüsselt
        den Text, indem sie die Zeichen des Textes anhand ihrer Position im String teilt und sie
        dann in umgekehrter Reihenfolge zusammensetzt. Die Methode sollte n Iterationen durchführen,
        wobei in jeder Iteration der Text verschlüsselt wird. Die Methode sollte den verschlüsselten
        Text zurückgeben.

    public String decrypt(String text, int n):

        Diese Methode nimmt einen verschlüsselten String text und eine ganze Zahl n als Eingabe und
        entschlüsselt den Text, indem sie ihn in n Iterationen wieder in seine ursprüngliche Form
        bringt. Die Methode sollte den entschlüsselten Text zurückgeben.

Algorithmus:

    - Nimm jeden zweiten Buchstaben der Zeichenkette.
    - Nimm anschließend die übrigen Buchstaben.
    - Verbinde beide Teile miteinander.
    - Wiederhole diesen Prozess n mal, um die Verschlüsselung zu verstärken.
    - Um die Zeichenkette wieder zu entschlüsseln, musst du den Prozess in umgekehrter Reihenfolge durchführen."

Stolperfallen:

    Achte darauf, dass nicht alle Texte eine Länge haben die ohne Rest durch zwei Teilbar ist.

Bearbeitungszeit:
    90 Minuten

 */
public class EncryptDecrypt {

    public String encrypt(String text, int n) {
        // Führe die folgenden Schritte so lange aus, wie n größer als 0 ist
        while (n > 0) {
            // Erstelle Streams für die geraden und ungeraden Zeichen im Text
            Stream<Character> evenChars = IntStream.range(0, text.length())
                    .filter(i -> i % 2 == 0)
                    .mapToObj(text::charAt);
            Stream<Character> oddChars = IntStream.range(0, text.length())
                    .filter(i -> i % 2 != 0)
                    .mapToObj(text::charAt);

            // Erstelle pro Iteration ein neues String Objekt aus den beiden Teil Character Streams
            text = Stream.concat(oddChars, evenChars)
                    .collect(Collector.of(
                            StringBuilder::new,
                            StringBuilder::append,
                            StringBuilder::append,
                            StringBuilder::toString));
            n--;
        }
        return text;
    }

    public String decrypt(String text, int n) {

        int oddSize = IntStream.range(0, text.length()).reduce(0, (accu, it) -> accu + (it % 2 != 0 ? 1 : 0));

        while (n > 0) {
            char[] evenCharacter = text.substring(oddSize).toCharArray();
            char[] oddCharacter = text.substring(0, oddSize).toCharArray();
            StringBuilder sb = new StringBuilder();
            int i = 0;
            while (sb.length() < text.length()) {
                if (i < evenCharacter.length) {
                    sb.append(evenCharacter[i]);
                }
                if (i < oddCharacter.length) {
                    sb.append(oddCharacter[i]);
                }
                i++;
            }
            text = sb.toString();
            n--;
        }
        return text;
    }
}

class EncryptDecryptTest {
    EncryptDecrypt encryptDecrypt;

    @BeforeEach
    void startUp() {
        encryptDecrypt = new EncryptDecrypt();
    }

    @Test
    void encryptTextWithFourIterations() {
        // given
        String text = "Wir sind in der SIT Lehrwerkstatt";
        int iterations = 1;

        // when
        String encryptedText = encryptDecrypt.encrypt(text, iterations);

        // then
        assertThat(encryptedText).isEqualTo("i idi e I erekttWrsn ndrSTLhwrsat");
    }

    @Test
    void decryptTextWithFourIterations() {
        // given
        String text = "i idi e I erekttWrsn ndrSTLhwrsat";
        int iterations = 1;

        // when
        String decryptedText = encryptDecrypt.decrypt(text, iterations);

        // then
        assertThat(decryptedText).isEqualTo("Wir sind in der SIT Lehrwerkstatt");
    }

    @Test
    void encryptAndDecryptTextWithTenIterations() {
        // given
        String text = "In der Lehrwerkstatt lernen die Aazubis nicht nur die Grundlagen der " +
                "Programmierung, sondern auch, wie man komplexe Anwendungen entwickelt " +
                "und lösungsorientiert denkt - Skills, die ihnen in ihrem zukünftigen " +
                "Beruf als Softwareentwickler von großem Nutzen sein werden.";
        int iterations = 10;

        // when
        String encryptedText = encryptDecrypt.encrypt(text, iterations);
        String decryptedText = encryptDecrypt.decrypt(encryptedText, iterations);

        // then
        assertThat(decryptedText)
                .hasSize(encryptedText.length())
                .isEqualTo(text);
    }
}