package schwarz.it.lws.java._001_007_loops.tasks;

/*
Task: Bouncing Ball

    Ein Kind spielt mit einem Ball im n-ten Stockwerk eines hohen Gebäudes.
    Die Höhe dieses Stockwerks über dem Boden, h, ist bekannt.
    Es lässt den Ball aus dem Fenster fallen. Der Ball prallt (z. B.) auf zwei
    Drittel seiner Höhe ab (Sprungkraft 0,66).

    Seine Mutter schaut aus einem Fenster, das 1,5 Meter über dem Boden liegt.

Todo:

    Wie oft wird die Mutter den Ball vor ihrem Fenster vorbeifliegen sehen (auch wenn er fällt und springt)?

    Es müssen drei Bedingungen erfüllt sein:
        - Der Parameter "h" in Metern muss größer als 0 sein.
        - Der Parameter "bounce" muss größer als 0 und kleiner als 1 sein.
        - Der Parameter "Fenster" muss kleiner als h sein.

    Wenn alle drei Bedingungen erfüllt sind, wird eine positive ganze Zahl, andernfalls -1 zurückgegeben.

Anmerkung:
    Der Ball kann nur gesehen werden, wenn die Höhe des abprallenden Balls größer ist
    als der Parameter "window".

Beispiele:

    - h = 3, bounce = 0.66, window = 1.5, result is 3
    - h = 3, bounce = 1, window = 1.5, result is -1

Bearbeitungszeit:

    30 Minuten
 */

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class BouncingBall {

    public static int bouncingBall(double h, double bounce, double window) {
        int bounces = -1;

        return bounces;
    }
}


// = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = =
// Don't change the JUnit test code.

class BouncingBallTest {

    @Test
    public void testValidBouncingBallConditions() {
        // Teste den Fall, in dem die Bedingungen erfüllt sind und der Ball springt
        double height = 3;
        double bounce = .66;
        double window = 1.5;
        int expected = 3;
        int got = BouncingBall.bouncingBall(height, bounce, window);
        assertThat(got).isEqualTo(expected);
    }

    @Test
    void testHigherBouncingBall() {
        // Teste den Fall, in dem der Ball höher springt
        // given
        double height = 30;
        double bounce = .66;
        double window = 1.5;
        int expected = 15;
        // when
        int got = BouncingBall.bouncingBall(height, bounce, window);
        // then
        assertThat(got).isEqualTo(expected);
    }

    @Test
    void testNegativeWindowHeight() {
        // Teste den Fall, in dem die Fensterhöhe negativ ist
        // given
        double height = 3;
        double bounce = 1.5;
        double window = -1;
        int expected = -1;

        // when
        int got = BouncingBall.bouncingBall(height, bounce, window);

        // then
        assertThat(got).isEqualTo(expected);
    }


    @Test
    void testBounceFactorEqualToOne() {
        // Teste den Fall, in dem der Faktor für den Rückprall 1 ist
        // given
        double height = 3;
        double bounce = 1;
        double window = 1.5;
        int expected = -1;

        // when
        int got = BouncingBall.bouncingBall(height, bounce, window);

        // then
        assertThat(got).isEqualTo(expected);
    }
}
