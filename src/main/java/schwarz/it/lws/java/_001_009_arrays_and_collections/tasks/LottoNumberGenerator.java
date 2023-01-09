package schwarz.it.lws.java._001_009_arrays_and_collections.tasks;

/*

Task: Lotto Zahlen Generator

    Es war ein Samstagabend und Maria hatte sich entschieden, am Lotto teilzunehmen.
    Sie wählte ihre Zahlen immer zufällig aus, ohne groß darüber nachzudenken. Sie öffnete
    ihren Laptop und suchte nach einem Lotto-Zahlengenerator online.
    Sie fand jedoch keine passende Klasse und beschloss, ihre Zahlen manuell auszuwählen.

    Sie dachte sich sechs Zahlen aus und ging zum Lottoladen in ihrer Nähe und kaufte
    einen Tippschein und trug ihre Zahlen ein. Am nächsten Tag schaltete sie den Fernseher
    ein, um die Lottoziehung zu verfolgen.
    Als sie ihre Zahlen verglich, wurde sie enttäuscht - keine ihrer Zahlen war gezogen worden.
    Sie beschloss, beim nächsten Mal einen Generator zu verwenden, um ihre Chancen zu verbessern.

    Helfe Maria einen Lotto-Zahlengenerator zu erstellen, der 6 zufällige Lottozahlen
    generiert und ausgibt.

Todo:

    - Das Programm sollte eine Methode haben, die 6 zufällige Lottozahlen generiert und als Array
      von ints zurückgibt.
    - Das Programm sollte eine Methode haben, die ein Array von Lottozahlen als Eingabe nimmt und sie
      auf dem Bildschirm ausgibt.
    - Das Programm sollte eine Hauptmethode haben, die die obigen Methoden aufruft und das
      Ergebnis ausgibt.

Hinweise:

    Verwende die Klasse java.util.Random, um zufällige Zahlen zu generieren.

Stolperfallen:

    Stelle sicher, dass bei jeder Ziehung eine Zahl zwischen 1 und 49 nur einmal gezogen
    wird,
 */

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Random;
import java.util.Set;
import java.util.TreeSet;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoNumberGenerator {

    /**
     * Diese Methode nimmt ein Array von Lottozahlen als Eingabe und
     * gibt sie auf dem Bildschirm aus.
     */
    public static void printLottoNumbers(int[] lottoNumbers) {
        for (int lottoNumber : lottoNumbers) {
            System.out.print(lottoNumber + " ");
        }
        System.out.println();
    }

    /**
     * Diese Methode generiert 6 zufällige Lottozahlen im Bereich von 1 bis 49
     * und gibt sie als Array von ints zurück.
     */
    public int[] generateLottoNumbers() {
        Set<Integer> lottoNumbersSet = new TreeSet<>();
        Random random = new Random();

        while (lottoNumbersSet.size() < 6) {
            lottoNumbersSet.add(random.nextInt(49) + 1);
        }

        int[] lottoNumbers = new int[6];
        int i = 0;
        for (int lottoNumber : lottoNumbersSet) {
            lottoNumbers[i++] = lottoNumber;
        }

        return lottoNumbers;
    }
}

class LottoNumberGeneratorTest {

    private LottoNumberGenerator lottoNumberGenerator;

    @BeforeEach
    public void setup() {
        lottoNumberGenerator = new LottoNumberGenerator();
    }

    @Test
    public void testLottoDrawSixOutOfFortyNineThatNoDoubleNumbersAreDrawn() {
        // given

        // when
        int[] lottoNumbers = lottoNumberGenerator.generateLottoNumbers();

        // then
        assertThat(lottoNumbers)
                .hasSize(6)
                .doesNotHaveDuplicates()
                .as("there are double values in the array");
    }
}