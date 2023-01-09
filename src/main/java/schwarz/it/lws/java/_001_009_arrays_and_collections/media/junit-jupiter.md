# Testen mit JUnit 5

JUnit ist ein Framework zum Testen von Java-Code. Es ermöglicht es Entwicklern, automatisierte Tests für ihren Code zu
schreiben und auszuführen, um sicherzustellen, dass der Code wie erwartet funktioniert. Die Tests werden in der Regel in
der Form von "Unit-Tests" geschrieben, die einzelne Methoden oder kleinere Teile des Codes testen. Die Tests werden dann
von JUnit ausgeführt und das Ergebnis wird angezeigt, um zu zeigen, ob der Test erfolgreich war oder nicht.
wird.

## Warum testen?

Sicherstellen, dass dein Code funktioniert: Unit-Tests helfen dir dabei, sicherzustellen, dass dein Code wie erwartet
funktioniert, indem sie spezifische Funktionen oder Methoden deines Codes testen.

- Verbessern die Qualität deines Codes: Durch das Schreiben von Unit-Tests zwingst du dich, deinen Code gründlich zu
  überdenken und ihn auf mögliche Fehler oder Schwachstellen zu überprüfen. Dies kann dazu beitragen, die Qualität
  deines
  Codes zu verbessern.

- Erleichtern die Fehlersuche: Wenn du Unit-Tests schreibst, kannst du Fehler in deinem Code schneller finden und
  beheben,
  da du genau weißt, welche Funktionen oder Methoden fehlerhaft sind.

- Erleichtern Änderungen am Code: Wenn du Unit-Tests hast, die deinen Code testen, kannst du Änderungen am Code
  vornehmen,
  ohne Angst haben zu müssen, dass du andere Teile des Codes zerstörst. Du kannst sicher sein, dass dein Code immer noch
  wie erwartet funktioniert, solange die Unit-Tests bestanden werden.

- Erhöhen die Zuverlässigkeit deines Codes: Wenn du regelmäßig Unit-Tests schreibst und ausführst, kannst du sicher
  sein,
  dass dein Code zuverlässig ist und wie erwartet funktioniert.

### Testmethoden Namen

Es ist wichtig, dass du gut benannte Testmethoden verwendest, um sicherzustellen, dass deine Tests leicht zu verstehen
und zu verfolgen sind. Hier sind einige Tipps, wie du gute Namen für deine JUnit-Tests erstellen kannst:

- Verwende klare und aussagekräftige Namen Verwende Namen, die die Funktionalität des Tests beschreiben und die
  erwarteten Ergebnisse anzeigen. Zum Beispiel: "testCalculateTotalCost()" statt "testMethod1()".

- Vermeide Abkürzungen und Akronyme: Verwende klare und verständliche Worte, um Verwirrung zu vermeiden.

- Verwende CamelCase-Schreibweise: Verwende CamelCase-Schreibweise, um Worte in deinem Testnamen zu trennen. Zum
  Beispiel: "testCalculateTotalCost()" statt "testcalculatetotalcost()".

- Sei spezifisch: Verwende spezifische Namen, um genau zu beschreiben, was der Test tut und welche Ergebnisse erwartet
  werden. Zum Beispiel: "testCalculateTotalCostForMultipleItems()" statt "testCalculateTotalCost()".

- Verwende Präfixe: Verwende Präfixe wie "test" oder "verify", um anzuzeigen, dass es sich um eine Testmethode handelt.

- Vermeide lange Namen: Vermeide es, zu lange Namen zu verwenden, da diese schwer zu lesen und zu verfolgen sind.
  Versuche, den Namen auf das Wesentliche zu beschränken.

## JUnit 5 Annotationen

| Annotation         | Beschreibung                                                                                           | 
|--------------------|--------------------------------------------------------------------------------------------------------|
| @Test              | Markiert eine Methode als Testmethode                                                                  | 
| @ParameterizedTest | Markiert eine Methode als parametrisierten Test, der mehrere Werte mit verschiedenen Argumenten testet |
| @RepeatedTest      | Markiert eine Methode als wiederholten Test, der mehrere Male mit denselben Argumenten ausgeführt wird |
| @BeforeEach        | Markiert eine Methode, die vor jedem Test in der Klasse ausgeführt wird                                |
| @AfterEach         | Markiert eine Methode, die nach jedem Test in der Klasse ausgeführt wird                               |
| @BeforeAll         | Markiert eine statische Methode, die vor allen Tests in der Klasse ausgeführt wird                     |
| @AfterAll          | Markiert eine statische Methode, die nach allen Tests in der Klasse ausgeführt wird                    |
| @Disabled          | Deaktiviert einen Test oder eine Testklasse                                                            |

## @Test

Die @Test-Annotation in JUnit 5 markiert eine Methode als Testmethode, die ausgeführt werden soll, wenn der Testlauf
ausgeführt wird. Hier ist ein Beispiel für die Verwendung von @Test in JUnit 5:

```java
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ExampleTest {

    @Test
    void testExample() {
        int a = 1;
        int b = 2;
        int expectedSum = 3;

        int actualSum = a + b;
        Assertions.assertEquals(expectedSum, actualSum);
    }

}
```

n diesem Beispiel gibt es eine Testmethode namens testExample, die zwei Zahlen addiert und dann die erwartete Summe mit
der tatsächlichen Summe vergleicht, indem sie die assertEquals-Methode von JUnit verwendet. Wenn die erwartete Summe der
tatsächlichen Summe entspricht, wird der Test erfolgreich abgeschlossen. Wenn sie nicht übereinstimmt, wird eine
AssertionError ausgelöst und der Test wird als fehlgeschlagen markiert.

Du kannst auch mehrere Assertions in einer Testmethode verwenden, um sicherzustellen, dass mehrere Bedingungen erfüllt
sind:

```java
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ExampleTest {

    @Test
    void test1() {
        // test logic here
        Assertions.assertTrue(true);
    }

    @Test
    void test2() {
        // test logic here
        Assertions.assertFalse(false);
    }

}
```

In diesem Beispiel gibt es zwei Testmethoden: test1 und test2. Beide Methoden werden von JUnit ausgeführt und ihre
Ergebnisse werden überprüft

## @ParameterizedTest

Die @ParameterizedTest-Annotation in JUnit 5 kannst du verwenden, um eine Testmethode mehrfach mit verschiedenen
Argumenten auszuführen. Dies ist nützlich, wenn du denselben Testfall mit mehreren Datensätzen testen möchtest, um
sicherzustellen, dass dein Code für alle Fälle korrekt funktioniert.

Um eine parametrisierte Testmethode zu erstellen, musst du zunächst die @ParameterizedTest-Annotation verwenden, um die
Methode zu markieren. Dann musst du einen @MethodSource angeben, der die Quelle der Argumente für den Test anzeigt. Die
Quelle der Argumente kann entweder eine statische Methode oder eine externe Datei sein.

| Source           | Beschreibung                                                                                                                                                                                                                            |
|------------------|-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| @MethodSource    | Diese Annotation wird verwendet, um auf eine statische Methode zu verweisen, die einen Stream von Arguments-Objekten zurückgibt. Die Methode kann entweder in derselben Klasse oder in einer anderen Klasse definiert sein.             |
| @CsvSource       | Diese Annotation wird verwendet, um eine Liste von Werten im CSV-Format (Comma Separated Values) bereitzustellen. Die Werte werden an die Testmethode als Argumente übergeben.                                                          |
| @CsvFileSource   | Diese Annotation wird verwendet, um Werte aus einer CSV-Datei als Testdaten bereitzustellen. Die Werte werden an die Testmethode als Argumente übergeben.                                                                               |
| @ValueSource     | Diese Annotation wird verwendet, um eine Liste von einzelnen Werten bereitzustellen. Jeder Wert wird als einzelnes Argument an die Testmethode übergeben.                                                                               |
| @EnumSource      | Diese Annotation wird verwendet, um Werte aus einer Enumeration als Testdaten bereitzustellen. Jeder Wert wird als einzelnes Argument an die Testmethode übergeben.                                                                     |
| @ArgumentsSource | Diese Annotation wird verwendet, um auf eine Klasse zu verweisen, die das ArgumentsProvider-Interface implementiert. Die Klasse stellt einen Stream von Arguments-Objekten bereit, indem sie die provideArguments-Methode überschreibt. |

Hier ist ein Beispiel für eine parametrisierte Testmethode, die die statische Methode stringIntAndListProvider als
Quelle für die Argumente verwendet:

```
@ParameterizedTest
@MethodSource("stringIntAndListProvider")
void testWithMultiArgMethodSource(String str, int num, List<String> list) {
   ...
}

static Stream<Arguments> stringIntAndListProvider() {
   return Stream.of(
       Arguments.of("apple", 1, Arrays.asList("a", "b")),
       Arguments.of("lemon", 2, Arrays.asList("x", "y"))
   );
}
```

In diesem Beispiel wird die Testmethode testWithMultiArgMethodSource zweimal ausgeführt, einmal mit dem ersten
Datensatz ("apple", 1, ["a", "b"]) und einmal mit dem zweiten Datensatz ("lemon", 2, ["x", "y"]).

Du kannst auch eine externe CSV-Datei als Quelle für die Argumente verwenden. Hier ist ein Beispiel dafür:

```
@ParameterizedTest
@CsvSource({ "apple, 1, a, b", "lemon, 2, x, y" })
void testWithCsvSource(String str, int num, String arg1, String arg2) {
   ...
}
```

In diesem Beispiel wird die Testmethode testWithCsvSource ebenfalls zweimal ausgeführt, einmal mit dem ersten
Datensatz ("apple", 1, "a", "b") und einmal mit dem zweiten Datensatz ("lemon", 2, "x", "y").

Hier der komplette Beispielcode:

```java
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.params.provider.Arguments.arguments;

public class ParameterizedExampleTest {

    @ParameterizedTest
    @CsvSource({"apple, 1, a, b", "lemon, 2, x, y"})
    void testWithCsvSource(String str, int num, String arg1, String arg2) {
        Assertions.assertNotNull(str);
        Assertions.assertNotEquals(0, num);
        Assertions.assertNotNull(arg1);
        Assertions.assertNotNull(arg2);
    }

    @ParameterizedTest
    @MethodSource("stringIntAndListProvider")
    void testWithMultiArgMethodSource(String str, int num, List<String> list) {
        Assertions.assertNotNull(str);
        Assertions.assertNotEquals(0, num);
        Assertions.assertNotNull(list);
    }

    static Stream<Arguments> stringIntAndListProvider() {
        return Stream.of(
                arguments("apple", 1, Arrays.asList("a", "b")),
                arguments("lemon", 2, Arrays.asList("x", "y"))
        );
    }

    @Test
    void testWithoutParameters() {
        // regular test with no parameters
    }

}
```

```java
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.RepeatedTest;

public class RepeatedExampleTest {

    @RepeatedTest(5)
    void repeatedTest() {
        // test logic here
        Assertions.assertTrue(true);
    }

    @RepeatedTest(value = 5, name = "{displayName} {currentRepetition}/{totalRepetitions}")
    void repeatedTestWithName(TestInfo testInfo) {
        Assertions.assertTrue(true);
    }
}
```

In diesem Beispiel gibt es zwei wiederholte Testmethoden: repeatedTest und repeatedTestWithName. Die Testmethode
repeatedTest wird fünfmal ausgeführt, während die Testmethode repeatedTestWithName ebenfalls fünfmal ausgeführt wird,
aber mit einem angepassten Namen, der die aktuelle Wiederholung und die Gesamtzahl der Wiederholungen anzeigt.

Du kannst auch die @RepeatedTest-Annotation mit dem @BeforeEach- und @AfterEach-Lifecycle-Hooks verwenden, um Aktionen
vor und nach jeder Wiederholung eines Tests auszuführen:

```java
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;

public class RepeatedExampleTest {

    @BeforeEach
    void beforeEach() {
        // logic to run before each repetition of the test
    }

    @RepeatedTest(5)
    void repeatedTest() {
        Assertions.assertTrue(true);
    }

    @AfterEach
    void afterEach() {
        // logic to run after each repetition of the test
    }

}
```

In diesem Beispiel wird die Methode beforeEach vor jeder Wiederholung der Testmethode repeatedTest ausgeführt.

## @BeforeEach

Die @BeforeEach-Annotation in JUnit 5 markiert eine Methode als Lifecycle-Hook, die vor jedem Test in der Klasse
ausgeführt wird. Sie kann verwendet werden, um Vorbereitungen für die Tests in der Klasse durchzuführen, z.B. das
Initialisieren von Variablen oder das Öffnen von Verbindungen.

Hier ist ein Beispiel für die Verwendung von @BeforeEach in JUnit 5:

```java
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class BeforeEachTest {

    private String str;

    @BeforeEach
    void setup() {
        str = "Hello, World!";
    }

    @Test
    void test1() {
        // test logic using str here
    }

    @Test
    void test2() {
        // test logic using str here
    }

}
```

In diesem Beispiel wird die Methode setup vor jedem Test in der Klasse ausgeführt und initialisiert die Variable str mit
dem Wert "Hello, World!". Die Testmethoden test1 und test2 können dann die Variable str verwenden, um ihre Tests
durchzuführen.

Hinweis: Beachte, dass die @BeforeEach-Methode vor jedem Test in der Klasse ausgeführt wird, einschließlich
parametrisierter Tests und wiederholter Tests.

## @AfterEach

Die @AfterEach-Annotation in JUnit 5 markiert eine Methode als Lifecycle-Hook, die nach jedem Test in der Klasse
ausgeführt wird. Sie kann verwendet werden, um Aufräumarbeiten nach den Tests in der Klasse durchzuführen, z.B. das
Schließen von Verbindungen oder das Löschen von temporären Dateien.

Hier ist ein Beispiel für die Verwendung von @AfterEach in JUnit 5:

```java
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.io.File;

public class AfterEachTest {

    private File tempFile;

    @Test
    void test1() {
        // test logic using tempFile here
    }

    @Test
    void test2() {
        // test logic using tempFile here
    }

    @AfterEach
    void tearDown() {
        tempFile.delete();
    }

}
```

In diesem Beispiel wird die Methode tearDown nach jedem Test in der Klasse ausgeführt und löscht die temporäre Datei

## @BeforeAll

Die @BeforeAll-Annotation in JUnit 5 markiert eine Methode als Lifecycle-Hook, die einmal vor allen Tests in der Klasse
ausgeführt wird. Sie kann verwendet werden, um Vorbereitungen für alle Tests in der Klasse durchzuführen, z.B. das
Initialisieren von Variablen oder das Öffnen von Verbindungen.

Hier ist ein Beispiel für die Verwendung von @BeforeAll in JUnit 5:

```java
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class BeforeAllExampleTest {

    private static String str;

    @BeforeAll
    static void setupAll() {
        str = "Hello, World!";
    }

    @Test
    void test1() {
        // test logic using str here
    }

    @Test
    void test2() {
        // test logic using str here
    }

}
```

In diesem Beispiel wird die Methode setupAll einmal vor allen Tests in der Klasse ausgeführt und initialisiert die
statische Variable str mit dem Wert

## @AfterAll

Die @AfterAll-Annotation in JUnit 5 markiert eine Methode als Lifecycle-Hook, die einmal nach allen Tests in der Klasse
ausgeführt wird. Sie kann verwendet werden, um Aufräumarbeiten nach allen Tests in der Klasse durchzuführen, z.B. das
Schließen von Verbindungen oder das Löschen von temporären Dateien.

Hier ist ein Beispiel für die Verwendung von @AfterAll in JUnit 5:

```java
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Test;

public class AfterAllExampleTest {

    private static String str;

    @AfterAll
    static void tearDownAll() {
        str = null;
    }

    @Test
    void test1() {
        str = "Hello, World!";
        // test logic using str here
    }

    @Test
    void test2() {
        str = "Hello, World!";
        // test logic using str here
    }

}
```

In diesem Beispiel wird die Methode tearDownAll einmal nach allen Tests in der Klasse ausgeführt und setzt die statische
Variable str auf null. Die Testmethoden test1 und test2 setzen die Variable str auf den Wert "Hello, World!", aber
dieser Wert wird nach allen Tests in der Klasse auf null gesetzt.

## @Disabled

Die @Disabled-Annotation in JUnit 5 kann verwendet werden, um Tests, Klassen oder Methoden zu deaktivieren, sodass sie
nicht von JUnit ausgeführt werden. Dies kann hilfreich sein, wenn du Tests deaktivieren möchtest, die noch nicht
implementiert sind oder wenn du Tests deaktivieren möchtest, die aufgrund von Änderungen in der Anwendung fehlschlagen.

Hier sind einige Beispiele für die Verwendung von @Disabled in JUnit 5:

```java
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

public class DisabledExampleTest {

    @Test
    @Disabled("Test is currently not implemented")
    void test1() {
        // test logic here
    }

    @Disabled
    @Test
    void test2() {
        // test logic here
    }

    @Test
    void test3() {
        // test logic here
    }

    @Disabled
    class DisabledClassExample {

        @Test
        void test() {
            // test logic here
        }

    }

}
```

In diesem Beispiel werden die Testmethoden test1 und test2 deaktiviert, während die Testmethode test3 aktiviert bleibt.
Die gesamte Klasse DisabledClassExample wird ebenfalls deaktiviert, sodass keine Tests in dieser Klasse ausgeführt
werden. Du kannst auch eine optionale Nachricht angeben, um den Grund für die Deaktivierung anzugeben, wie im Fall von
test1.

## [INHALT](../README.md)