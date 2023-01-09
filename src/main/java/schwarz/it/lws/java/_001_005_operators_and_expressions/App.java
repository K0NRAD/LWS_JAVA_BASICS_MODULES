package schwarz.it.lws.java._001_005_operators_and_expressions;
/*
Lernziele: OPERATOREN AUSDRÜCKE
    - Zuweisungsoperator in Anweisung und Ausdruck
    - Math.random()
    - Arithmetik, Divisionsoperator, Restwert-Operator
    - Vergleiche ( ==, <, >, <=, >=, != )
    - Logische Operatoren ( &, | )
    - Kurzschluss ( e.g. & vs. && )
    - Präfix-/Postfix-Inkrement / Dekrement
    - Verbundoperator ( a += 1 )
    - Typumwandlung (casting)
    - String-Konkatenation ( + )
    - Bitmanipulation ( ~, &, |, ^ )
    - Verschiebung ( <<, >> )
 */

public class App {

    public static void main(String[] args) {

    }

    // = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = =
    // Helper functions

    private static boolean getB1() {
        System.out.println("Call getB1");
        sleep(1);
        return false;
    }

    private static boolean getB2() {
        System.out.println("Call getB2");
        sleep(10);
        return false;
    }

    private static boolean getB3() {
        System.out.println("Call getB3");
        sleep(2);
        return true;
    }

    private static void sleep(int seconds) {
        long timeout = System.currentTimeMillis() + seconds * 1000L;
        long nextDot = System.currentTimeMillis() + 1000L;

        while (System.currentTimeMillis() < timeout) {
            if (System.currentTimeMillis() >= nextDot) {
                System.out.print(".");
                nextDot = System.currentTimeMillis() + 1000L;
            }
        }
        System.out.println();
    }

}
