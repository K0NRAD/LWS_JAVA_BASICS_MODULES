# Java Arrays und Collections 

## Inhalt

- __[Array](#array)__
- __[List](#list)__
- __[Set](#set)__
- __[Generics](./media/generics.md)__
- __[Streams API](./media/streams-api.md)__
- __[Testen mit JUnit](./media/junit-jupiter.md)__
- __[Prüfen mit AssertJ](./media/assertj.md)__
- __[JSON Daten Parsen](./media/json-data.md)__

## Array

In Java ist ein Array eine spezielle Datenstruktur, die es ermöglicht, mehrere Werte des gleichen Typs unter einem
einzigen Namen zu speichern. Arrays sind nützlich, wenn Sie eine große Anzahl von Werten des gleichen Typs speichern
möchten, z.B. eine Liste von Namen oder Zahlen.

Ein Array in Java wird mit der Klasse java.util.Arrays erstellt und kann jedes beliebige Datentyp enthalten, wie z.B.
Integers, Strings oder Objekte.

Hier ist ein Beispiel, wie Sie ein Array erstellen und verwenden:

```java
public class App {
    public static void main(String[] args) {
        // Erstellen Sie ein Array mit Integern
        int[] arr = new int[5];

        // Setzen Sie die Werte im Array
        arr[0] = 1;
        arr[1] = 2;
        arr[2] = 3;
        arr[3] = 4;
        arr[4] = 5;

        // Alternativ kannst du das Array auch wie folgt initialisieren:
        int[] arr2 = {1, 2, 3, 4, 5};

        // Zugriff auf die Werte im Array
        int val = arr[2];  // val ist 3

        // Iteriere durch das Array und gebe jeden Wert aus
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }
}
```

Das obige Beispiel erstellt zwei Arrays von Integern. Das erste Array wird mit der Größe 5 erstellt und dann werden die
Werte manuell gesetzt. Das zweite Array wird direkt mit den ursprünglichen Werten initialisiert. Das Beispiel zeigt
auch, wie man auf die Werte im Array zugreifen und das Array iterieren kann.

Es gibt noch viele andere Methoden und Funktionen, die in Arrays verfügbar sind, wie z.B. das Suchen von Werten, das
Sortieren von Arrays und das Kopieren von Arrays. Weitere Informationen finden Sie in der Dokumentation der
java.util.Arrays-Klasse.
       
### [INHALT](#inhalt)

## List

In Java ist eine Liste eine spezielle Datenstruktur, die es ermöglicht, mehrere Werte in einer sequenziellen Reihenfolge
zu speichern. Eine Liste ist ähnlich wie ein Array, aber sie ist flexibler, da sie in der Größe dynamisch wachsen und
schrumpfen kann.

Eine Liste in Java wird mit der Klasse java.util.List definiert. Es gibt verschiedene Implementierungen von Listen, wie
z.B. java.util.ArrayList und java.util.LinkedList, die jeweils ihre eigenen Vor- und Nachteile haben.

Hier ist ein Beispiel, wie Sie eine Liste erstellen und verwenden:

```java
import java.util.ArrayList;
import java.util.List;

public class App {
    public static void main(String[] args) {
        // Erstelle eine Liste mit Integers
        List<Integer> list = new ArrayList<>();

        // Fügen Sie einige Elemente hinzu
        list.add(1);
        list.add(2);
        list.add(3);

        // Füge ein Element an einer bestimmten Stelle hinzu
        list.add(1, 4);  // Die Liste ist jetzt [1, 4, 2, 3]

        // Entferne ein Element
        list.remove(2);  // Die Liste ist jetzt [1, 4, 3]

        // Ersetze ein Element
        list.set(0, 5);  // Die Liste ist jetzt [5, 4, 3]

        // Hole das Element an einer bestimmten Stelle
        int val = list.get(1);  // val ist 4

        // Prüfe ob ein Element enthalten ist
        if (list.contains(3)) {
            System.out.println("3 ist enthalten");
        }

        // Iteriere durch die Liste und gebe jedes Element aus
        for (Integer i : list) {
            System.out.println(i);
        }
    }
}
```

Das obige Beispiel erstellt eine Liste von Integern mit der Klasse java.util.ArrayList und fügt dann einige Elemente
hinzu. Es zeigt auch, wie man Elemente hinzufügt, entfernt und ersetzt, wie man auf die Werte in der Liste zugreifen und
wie man die Liste iterieren kann.

Es gibt noch viele andere Methoden und Funktionen, die in Listen verfügbar sind, wie z.B. das Sortieren von Listen, das
Verbinden von Listen und das Filtern von Elementen. Weitere Informationen findest du in der Dokumentation der
List-Klasse.

### [INHALT](#inhalt)

## Set

In Java gibt es verschiedene Implementierungen von Sets, die alle eine Menge von eindeutigen Elementen darstellen. Das
heißt, dass in einem Set keine zwei Elemente gleich sein dürfen und dass jedes Element nur einmal enthalten sein darf.

Ein Set wird in Java mit der Klasse java.util.Set definiert. Um ein Set zu erstellen, müssen Sie eine von mehreren
Implementierungen dieser Klasse verwenden, wie z.B. java.util.HashSet oder java.util.TreeSet.

Hier ist ein Beispiel, wie Sie ein Set erstellen und verwenden:

```java
import java.util.Set;
import java.util.HashSet;

public class App {
    public static void main(String[] args) {
        // Erstellen Sie ein Set mit Integers
        Set<Integer> set = new HashSet<>();

        // Füge einige Elemente hinzu
        set.add(1);
        set.add(2);
        set.add(3);

        // Versuche ein Element hinzuzufügen, das bereits enthalten ist
        set.add(2);  // Wird nicht hinzugefügt, da 2 bereits enthalten ist

        // Prüfe ob ein Element enthalten ist
        if (set.contains(3)) {
            System.out.println("3 ist enthalten");
        }

        // Iteriere durch das Set und gebe jedes Element aus
        for (Integer i : set) {
            System.out.println(i);
        }
    }
}
```

Das obige Beispiel erstellt ein Set von Integern mit der Klasse java.util.HashSet und fügt dann einige Elemente hinzu.
Es versucht auch, ein Element hinzuzufügen, das bereits enthalten ist, was aber nicht passiert, da Sets keine Duplikate
erlauben. Schließlich iteriert das Beispiel durch das Set und gibt jedes Element aus.

Es gibt noch viele andere Methoden und Funktionen, die in Sets verfügbar sind, wie z.B. das Entfernen von Elementen, das
Verbinden von Sets und das Vergleichen von Sets. Weitere Informationen finden Sie in der Dokumentation der Set-Klasse.

### [INHALT](#inhalt)

--- 

### [Verständnisfragen](./media/questions-of-understanding.md)