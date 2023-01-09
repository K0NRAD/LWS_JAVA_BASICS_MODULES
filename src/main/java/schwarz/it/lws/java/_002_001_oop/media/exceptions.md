# Exceptions (Ausnahmen)

Ausnahmen sind spezielle Ereignisse, die während der Ausführung eines Programms auftreten und das normale Flussverhalten
unterbrechen. Sie werden verwendet, um Fehler oder unerwartete Ereignisse zu melden und zu verarbeiten.

In Java werden Ausnahmen mithilfe von try- und catch-Blöcken behandelt. Ein try-Block enthält den Code, der
möglicherweise eine Ausnahme auslöst. Ein oder mehrere catch-Blöcke folgen dem try-Block und fangen Ausnahmen auf, die
vom try-Block ausgelöst werden.

Hier ist ein Beispiel für die Verwendung von try- und catch-Blöcken in Java:

```java
class App {
    public static void main(String[] args) {
        try {
            // Code, der möglicherweise eine Ausnahme auslöst
            int result = 1 / 0;
        } catch (Exception e) {
            // Code, der ausgeführt wird, wenn eine Ausnahme auftritt
            System.out.println("Fehler: " + e.getMessage());
        }
    }
}
```

Es ist auch möglich, Ausnahmen manuell zu erstellen und zu werfen, indem man das Schlüsselwort throw verwendet.

Hier ist ein Beispiel für das Werfen einer Ausnahme in Java:

```java
class App {
    public static void main(String[] args) {
        String input = null;

        if (input == null) {
            throw new NullPointerException("Input must not be zero.");
        }
    }
}
```

## Checked und unchecked Exceptions.

In Java gibt es zwei Arten von Exceptions: checked und unchecked.

Checked Exceptions sind Exceptions, die durch die Java-Compiler überprüft werden und die in der Methode deklariert oder
geworfen werden müssen, die sie verwendet. Beispiele für checked Exceptions sind __IOExceptions__ und __SQLExceptions__.

Unchecked Exceptions sind Exceptions, die nicht von der Java-Compiler überprüft werden und die nicht in der Methode
deklariert oder geworfen werden müssen, die sie verwendet. Unchecked Exceptions sind in der Regel durch
Programmierfehler verursacht und umfassen RuntimeExceptions und Errors.

Es gibt auch einige andere Arten von Exceptions, die in Java verwendet werden können, wie zum Beispiel:

### Erweiterte Exceptions

Erweiterte Exceptions sind Exceptions, die von einer anderen Exception erweitert werden, um spezifischere
Fehlermeldungen bereitzustellen. Sie werden verwendet, um die Art des Fehlers, der in einem Programm auftritt, genauer
zu beschreiben.

Zum Beispiel könnte eine Anwendung eine "InvalidInputException" erstellen, die von der Exception-Klasse erweitert wird
und verwendet wird, um anzuzeigen, dass eine ungültige Eingabe vom Benutzer empfangen wurde. Dies gibt dem Entwickler
spezifischere Informationen darüber, was schief gelaufen ist, als wenn nur eine allgemeine Exception geworfen wurde.

Um eine erweiterte Exception in Java zu erstellen, müssen Sie eine neue Klasse erstellen, die von der Exception-Klasse
erweitert wird, und dann die entsprechenden Fehlermeldungen und Konstruktoren hinzufügen.

Hier ist ein Beispiel für eine erweiterte Exception in Java:

```Java
class InvalidInputException extends RuntimeException {
    public InvalidInputException(String message) {
        super(message);
    }
}

class App {
    public static void main(String[] args) {
        App app = new App();
        app.processInput(3);
    }

    public void processInput(String input) throws InvalidInputException {
        if (input.length() < 5) {
            throw new InvalidInputException("Input is too short!");
        }
        // Process the input
    }
}
```

<img src="./important.png" width="44" height="44" />
Unchecked Exceptions" sind solche, die die Klassen RuntimeException und Error erweitern und die nicht in der Methode
deklariert oder geworfen werden müssen, in der sie verwendet werden. Es ist wichtig zu beachten, dass diese erweiterten
Exceptions als solche behandelt werden.

### Selbstdefinierte Exceptions

Selbstdefinierte Exceptions sind Exceptions, die von Entwicklern erstellt werden, um spezifische Fehler in einem
Java-Programm anzuzeigen. Sie werden verwendet, um die Art des Fehlers, der in einem Programm auftritt, genauer zu
beschreiben und dem Entwickler spezifischere Informationen darüber zu liefern, was schief gelaufen ist, als wenn nur
eine allgemeine Exception geworfen wurde.

Um eine selbstdefinierte Exception in Java zu erstellen, müssen Sie eine neue Klasse erstellen, die von der
Exception-Klasse erweitert wird, und dann die entsprechenden Fehlermeldungen und Konstruktoren hinzufügen. Hier ist ein

Beispiel für eine selbstdefinierte Exception in Java:

```java
class InvalidInputException extends Exception {
    public InvalidInputException(String message) {
        super(message);
    }
}

class App {
    public static void main(String[] args) {
        App app = new App();
        app.processInput(3);
    }

    public void processInput(String input) throws InvalidInputException {
        if (input.length() < 5) {
            throw new InvalidInputException("Input is too short!");
        }
        // Process the input
    }
}
```

<img src="./important.png" width="44" height="44" />
Es ist wichtig zu beachten, dass selbstdefinierte Exceptions als checked Exceptions behandelt werden, d.h. sie müssen in
der Methode deklariert oder geworfen werden, die sie verwendet. Unchecked Exceptions, wie RuntimeExceptions und Errors,
müssen nicht deklariert oder geworfen werden.

### AssertionError

In Java, AssertionErrors sind Unchecked Exceptions, die von der Klasse AssertionError abgeleitet sind. Sie werden
normalerweise verwendet, um eine Bedingung darzustellen, die in einer Anwendung niemals auftreten sollte. Sie werden
häufig in Test- und Debugging-Szenarien verwendet, um zu signalisieren, dass eine Bedingung, die als wahr angenommen
wurde, tatsächlich falsch ist.

AssertionErrors können auf verschiedene Weisen auftreten. Eine Möglichkeit besteht darin, das Schlüsselwort "assert" in
Java zu verwenden, um eine Bedingung zu überprüfen. Wenn die Bedingung false ist, wird eine AssertionError-Exception
ausgelöst. Eine andere Möglichkeit besteht darin, dass eine Bedingung innerhalb einer Anwendung aufgrund von
Programmierfehlern oder inkonsistenten Zuständen false wird, was zu einer AssertionError führt.

<a src="important.png" width="25" height="25"></a>
Es ist wichtig zu beachten, dass AssertionErrors Unchecked Exceptions sind und daher nicht in der Methode deklariert
oder geworfen werden müssen, in der sie verwendet werden. Sie können jedoch von der Anwendung abgefangen und behandelt
werden, wenn dies erforderlich ist.

```java
public class Main {
    public static void main(String[] args) {
        int x = 10;
        int y = 20;

        // Verwendung des Schlüsselworts "assert" zur Überprüfung einer Bedingung
        assert x > y : "x ist nicht größer als y";
    }
}
```

In diesem Beispiel wird beim Ausführen der Anwendung ein AssertionError ausgelöst, da die Bedingung "x ist größer als y"
false ist. Wenn die Anwendung jedoch mit der Option "java -ea" ausgeführt wird, wird die Assertion aktiviert und der
AssertionError wird ausgelöst.

<img src="./important.png" width="44" height="44" />
Es ist wichtig zu beachten, dass AssertionErrors Unchecked Exceptions sind und daher nicht in der Methode deklariert
oder geworfen werden müssen, in der sie verwendet werden. Sie können jedoch von der Anwendung abgefangen und behandelt
werden, wenn dies erforderlich ist.

### NoClassDefFoundError

Ein NoClassDefFoundError in Java tritt auf, wenn eine Klasse nicht gefunden werden kann, die von einem anderen Klassen-
oder Codeblock verwendet wird. Dies kann auf verschiedene Weisen geschehen, z.B. wenn:

- Die Klasse, die verwendet wird, nicht im Klassenpfad der Anwendung enthalten ist, so dass sie beim Kompilieren oder
  Ausführen der Anwendung nicht gefunden werden kann.
- Eine benötigte Klasse zur Compile-Zeit vorhanden war, aber zur Ausführungszeit entfernt wurde oder ihr Pfad geändert
  wurde, sodass sie nicht gefunden werden kann.
- Eine abhängige Klasse fehlt oder nicht korrekt geladen wird, wodurch eine Klasse, die von ihr abhängt, nicht gefunden
  werden kann.

Hier ist ein Beispiel für einen NoClassDefFoundError in Java:

```java
public class Main {
    public static void main(String[] args) {
        // Versuch, die Klasse "Utils" zu verwenden, die nicht im Klassenpfad enthalten ist
        Utils.printMessage("Hello World!");
    }
}
```

In diesem Beispiel würde beim Versuch, die Anwendung auszuführen, ein NoClassDefFoundError ausgelöst werden, da die
Klasse "Utils" nicht gefunden werden kann. Um dieses Problem zu beheben, muss die Klasse "Utils" entweder im Klassenpfad
der Anwendung enthalten sein oder muss im Codeblock, in dem sie verwendet wird, importiert werden.

<img src="./important.png" width="44" height="44" />
Es ist wichtig zu beachten, dass NoClassDefFoundErrors Unchecked Exceptions sind und daher nicht in der Methode
deklariert oder geworfen werden müssen, in der sie verwendet werden. Sie können jedoch von der Anwendung abgefangen und
behandelt werden, wenn dies erforderlich ist.

### OutOfMemoryError

Ein OutOfMemoryError in Java tritt auf, wenn eine Anwendung versucht, mehr Arbeitsspeicher zu verwenden, als vom JVM (
Java Virtual Machine) zugewiesen wurde oder als von der Hardware zur Verfügung steht. Dies kann passieren, wenn eine
Anwendung zu viele Objekte erstellt oder zu große Datenmengen verarbeitet, ohne den Speicher freizugeben, den sie nicht
mehr benötigt.

Hier ist ein Beispiel für einen OutOfMemoryError in Java:

```java
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        while (true) {
            // Fügt der Liste unendlich viele Integer-Objekte hinzu, was zu einem OutOfMemoryError führt
            list.add(new Integer.valueOf(10));
        }
    }
}
```

In diesem Beispiel würde beim Ausführen der Anwendung ein OutOfMemoryError ausgelöst werden, da die Anwendung versucht,
unendlich viele Integer-Objekte zu erstellen und im Arbeitsspeicher zu speichern, was den vom JVM zugewiesenen Speicher
überschreitet.

<img src="./important.png" width="44" height="44" />
Es ist wichtig zu beachten, dass OutOfMemoryErrors Unchecked Exceptions sind und daher nicht in der Methode deklariert
oder geworfen werden müssen, in der sie verwendet werden. Sie können jedoch von der Anwendung abgefangen und behandelt
werden, wenn dies erforderlich ist. Um OutOfMemoryErrors zu vermeiden, ist es wichtig, den Arbeitsspeicher sorgfältig zu
verwalten und nicht mehr Speicher zu verwenden, als vom JVM zugewiesen wurde oder als von der Hardware zur Verfügung
steht.

### [INHALT](../README.md)