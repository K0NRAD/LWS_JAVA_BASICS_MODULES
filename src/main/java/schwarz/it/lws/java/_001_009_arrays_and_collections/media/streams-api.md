## Streams-API

Die Streams-API in Java 8 ist ein neues Feature, das es ermöglicht, Streams von Daten zu verarbeiten. Streams sind
sequentielle Abfolgen von Elementen, die mit verschiedenen Operationen verarbeitet werden können.

Die Streams-API bietet verschiedene Operationen zur Verarbeitung von Streams, wie z.B.:

- `map`: Anwenden einer Funktion auf jedes Element des Streams
- `filter`: Filtern des Streams anhand eines Prädikats
- `sorted`: Sortieren des Streams
- `forEach`: Ausführen einer Aktion für jedes Element des Streams
- `reduce`: Reduzieren des Streams auf einen Wert
- `collect`: Sammeln des Streams in einem Container (z.B. Liste oder Set)

Hier ist ein Beispiel für die Verwendung der Streams-API:

```java
class App {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        // Wandle die Zahlen in ihre Quadratzahlen um und filter die größer als 20
        List<Integer> squaredNumbers = numbers.stream()
                .map(n -> n * n)
                .filter(n -> n > 20)
                .collect(Collectors.toList());

        // Gib die gefilterten Quadratzahlen aus
        squaredNumbers.forEach(System.out::println);
    }
}
```

Das Beispiel wandelt zunächst die Zahlen in einen Stream um und verwendet dann die map-Operation, um eine Funktion auf
jedes Element des Streams anzuwenden. Danach wird der filter-Operator verwendet, um die Elemente, die nicht dem
angegebenen Prädikat entsprechen, aus dem Stream zu entfernen. Schließlich wird der collect-Operator verwendet, um den
Stream in einer Liste zu sammeln. Die gefilterten Quadratzahlen werden schließlich mit der forEach-Operation ausgegeben.

- `flatMap` - sammeln der element einer inneren Liste von Elementen

```java

class Article {
    private String name;
    private List<String> eanNumbers;
    // Konstruktor und Getter/Setter-Methoden werden hier weggelassen
}

class App {
    public static void main(String[] args) {
        List<Article> articles = Arrays.asList(
                new Article("Artikel 1", Arrays.asList("1234567890", "0987654321")),
                new Article("Artikel 2", Arrays.asList("1111111111", "2222222222", "3333333333")),
                new Article("Artikel 3", Arrays.asList("4444444444"))
        );

        // Komprimiert die Liste der EAN-Nummern in einen einzigen Stream
        List<String> eanNumbers = articles.stream()
                .flatMap(article -> article.getEanNumbers().stream())
                .collect(Collectors.toList());

        // Druckt die komprimierte Liste der EAN-Nummern
        eanNumbers.forEach(System.out::println);
    }
}
```

In diesem Beispiel wird eine Liste von Artikeln erstellt, jeder Artikel mit einer Liste von EAN-Nummern. Die
flatMap-Operation wird verwendet, um die Liste der EAN-Nummern jedes Artikels in einen einzigen Stream von EAN-Nummern
zu flatten. Der collect-Operator wird schließlich verwendet, um den Stream in einer Liste zu sammeln, die dann
ausgegeben wird.

## [INHALT](../README.md)
 