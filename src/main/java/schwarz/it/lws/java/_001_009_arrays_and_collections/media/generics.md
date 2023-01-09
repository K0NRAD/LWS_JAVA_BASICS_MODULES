# Generics

Generics in Java ermöglichen es dir, Typparameter für Klassen, Interfaces und Methoden zu definieren. Dies bedeutet,
dass du eine Klasse oder Methode schreiben kannst, die mit verschiedenen Typen verwendet werden kann, ohne dass du jedes
Mal eine neue Version der Klasse oder Methode schreiben musst.

Hier ist ein einfaches Beispiel, wie du Generics in Java verwenden könntest, um eine Klasse "Pair" zu erstellen, die ein
Paar von Werten speichert:

```Java
public class Pair<T, U> {
    private T first;
    private U second;

    public Pair(T first, U second) {
        this.first = first;
        this.second = second;
    }

    public T getFirst() {
        return first;
    }

    public U getSecond() {
        return second;
    }
}
```

In diesem Beispiel wurde der Typparameter "T" für den ersten Wert und der Typparameter "U" für den zweiten Wert
verwendet. Du kannst die Klasse "Pair" nun mit verschiedenen Typen verwenden, z.B. "Pair<String, Integer>" oder "Pair<
Boolean, Double>".

Um die Klasse "Pair" zu verwenden, könntest du zum Beispiel so etwas schreiben:

```
Pair<String, Integer> pair = new Pair<>("Hello", 42);

String first = pair.getFirst();  // "Hello"
Integer second = pair.getSecond();  // 42
```

Ein weiteres Beispiel für Generics in Java

Angenommen, du möchtest eine Methode schreiben, die ein Array von Elementen in umgekehrter Reihenfolge sortiert. Du
könntest das mit Generics wie folgt implementieren:

```
import java.util.Arrays;

public class ReverseArray {
    public static <T> void reverse(T[] array) {
        // Kehre das Array um, indem du die Elemente vertauschst
        for (int i = 0; i < array.length / 2; i++) {
            T temp = array[i];
            array[i] = array[array.length - i - 1];
            array[array.length - i - 1] = temp;
        }
    }
    
    public static void main(String[] args) {
        Integer[] numbers = {1, 2, 3, 4, 5};
        ReverseArray.reverse(numbers);
        System.out.println(Arrays.toString(numbers));  // [5, 4, 3, 2, 1]
        
        String[] words = {"apple", "banana", "cherry"};
        ReverseArray.reverse(words);
        System.out.println(Arrays.toString(words));  // [cherry, banana, apple]
    }
}
```

In diesem Beispiel wurde der Typparameter "T" für den Typ der Elemente im Array verwendet. Die Methode "reverse" nimmt
ein Array vom Typ "T[]" entgegen und kehrt seine Elemente in umgekehrter Reihenfolge um.

Du kannst die Methode "reverse" nun mit Arrays von verschiedenen Typen verwenden, z.B. "Integer[]" oder "String[]". In
der Hauptmethode werden zwei Arrays, eines mit Zahlen und eines mit Wörtern, umgewandelt und die Ergebnisse werden
ausgegeben.