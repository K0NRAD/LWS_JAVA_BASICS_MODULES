# AssertJ

AssertJ ist eine Java-Bibliothek, die dazu dient, Tests von Java-Code zu vereinfachen. Sie bietet eine Reihe von
Methoden, die es ermöglichen, Prüfungen (assertions) in Tests durchzuführen. Diese Methoden sind in einer einfachen und
lesbaren Syntax geschrieben, die es ermöglicht, Tests auf eine klare und verständliche Art und Weise zu schreiben.
Beispielsweise kann man mit AssertJ überprüfen, ob eine bestimmte Bedingung wahr ist oder ob ein Objekt einen bestimmten
Wert hat. AssertJ kann in Verbindung mit anderen Testframeworks wie JUnit oder TestNG verwendet werden und ist eine gute
Wahl für die Erstellung von Unit-Tests und Integrationstests in Java-Projekten.

## AssertJ im Maven-Projekt

Um AssertJ in einem Maven-Projekt zu verwenden, müssen Sie zunächst die Abhängigkeit in der pom.xml-Datei Ihres Projekts
hinzufügen. Öffne dazu die pom.xml-Datei und füge den folgenden Code-Abschnitt innerhalb des <dependencies>-Tags ein:

```
<dependency>
  <groupId>org.assertj</groupId>
  <artifactId>assertj-core</artifactId>
  <version>3.21.0</version>
  <scope>test</scope>
</dependency>
```

## Import in Java-Test-Klassen

Sobald du die Abhängigkeit hinzugefügt hast, kannst du AssertJ in deinen Tests verwenden, indem du den folgenden
Import in deinen Testklassen hinzufügst:

```
import static org.assertj.core.api.Assertions.assertThat;
```

Nachdem du AssertJ eingebunden hast, können die AssertJ-Methoden wie assertThat() in deinen Tests verwendet werden, um
Prüfungen durchzuführen. Hier ist eine Aufstellung von Test-Metoden die du in deinem Testcode verwenden kannst:

| Test                                                       | Beschreibung                                                                    |
|------------------------------------------------------------|---------------------------------------------------------------------------------|
| assertThat(value).isGreaterThan(otherValue)                | prüfen, ob ein Wert größer als ein anderer ist                                  | 
| assertThat(value).isGreaterThanOrEqualTo(otherValue)       | prüfen, ob ein Wert größer oder gleich einem anderen ist                        | 
| assertThat(value).isLessThan(otherValue)                   | prüfen, ob ein Wert kleiner als ein anderer ist                                 | 
| assertThat(value).isLessThanOrEqualTo(otherValue)          | prüfen, ob ein Wert kleiner oder gleich einem anderen ist                       | 
| assertThat(value).isBetween(lowerValue, upperValue)        | prüfen, ob ein Wert zwischen zwei anderen liegt                                 | 
| assertThat(array).isEmpty()                                | prüfen, ob das Array leer ist.                                                  |
| assertThat(array).hasSize(size)                            | prüfen, ob das Array eine bestimmte Größe hat.                                  |
| assertThat(array).contains(element)                        | prüfen, ob das Array ein bestimmtes Element enthält.                            |
| assertThat(array).contains(element, atIndex(index))        | prüfen, ob das Array ein bestimmtes Element an einer bestimmten Stelle enthält. |
| assertThat(array).containsExactly(element1, element2, ...) | prüfen, ob das Array eine bestimmte Reihenfolge von Elementen enthält.          | 
| assertThat(array).containsOnlyOnce(1, 2, 3, 4)             | prüfen, ob das Array nur einmal jedes Element enthält                           |
| assertThat(array).doesNotHaveDuplicates()                  | prüfen, ob das Array keinen doppelten Werte enthält                             |
| assertThat(list).isEmpty()                                 | prüfen, ob die Liste leer ist:                                                  |
| assertThat(list).hasSize(expectedSize)                     | prüfen, ob eine Liste eine bestimmte Größe hat.                                 |
| assertThat(list).contains(element)                         | prüfen, ob eine Liste einen bestimmten Wert enthält.                            |
| assertThat(list).contains(element, atIndex(index))         | prüfen, ob die Liste ein bestimmtes Element an einer bestimmten Stelle enthält  | 
| assertThat(list).containsExactly(element1, element2, ...)  | prüfen, ob die Liste eine bestimmte Reihenfolge von Elementen enthält           | 
| assertThat(string).startsWith(expectedPrefix)              | prüfen, ob eine Zeichenfolge mit einem bestimmten Präfix beginnt.               |
| assertThat(map).containsKey(expectedKey)                   | prüfen, ob eine Map einen bestimmten Schlüssel enthält.                         |
| assertThat(map).isEmpty()                                  | prüfen, ob eine Map leer ist.                                                   |
| assertThat(map).isNotEmpty()                               | prüfen, ob eine Map nicht leer ist.                                             |
| assertThat(set).isEmpty()                                  | prüfen, ob ein Set leer ist.                                                    |
| assertThat(set).isNotEmpty()                               | prüfen, ob ein Set nicht leer ist.                                              |
| assertThat(queue).isEmpty()                                | prüfen, ob eine Warteschlange leer ist.                                         |
| assertThat(queue).isNotEmpty()                             | prüfen, ob eine Warteschlange nicht leer ist.                                   |
| assertThat(boolean).isTrue()                               | prüfen, ob eine boolesche Variable wahr ist.                                    |
| assertThat(boolean).isFalse()                              | prüfen, ob eine boolesche Variable falsch ist.                                  |
| assertThat(object).isInstanceOf(expectedClass)             | prüfen, ob ein Objekt eine bestimmte Klasse implementiert.                      |

## Verketten von AssertJ Aufrufen

Um AssertJ-Aufrufe zu verketten, können Sie einfach mehrere Methoden hintereinander aufrufen, indem Sie sie
aneinanderreihen. Jeder Aufruf gibt das Ergebnis des vorherigen Aufrufs zurück, so dass Sie mehrere Prüfungen in einer
einzigen Zeile schreiben können.

Hier ist ein Beispiel, in dem ein String-Objekt auf mehrere Eigenschaften gleichzeitig geprüft wird:

```
String myString = "Hello, World!";

// Verkette mehrere Aufrufe von AssertJ
assertThat(myString)
    .isNotNull()
    .isNotEmpty()
    .startsWith("Hello")
    .endsWith("World!")
    .contains("o, W");
```

In diesem Beispiel wird überprüft, ob der String myString nicht null ist, nicht leer ist, mit "Hello" beginnt, mit "
World!" endet und "o, W" enthält. Wenn alle diese Prüfungen erfolgreich sind, wird der Test als bestanden betrachtet.
Wenn eine der Prüfungen fehlschlägt, wird eine Fehlermeldung ausgegeben und der Test schlägt fehl.

### [INHALT](../README.md)