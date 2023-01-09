# Annotations

Eine Annotation in Java ist eine spezielle Art von Interface, die dazu verwendet wird, zusätzliche Informationen zu
Klassen, Methoden, Variablen und anderen Elementen zu speichern. Im Gegensatz zu normalen Interfaces enthält eine
Annotation keine Methoden, sondern nur Elemente, die als Annotationen-Member bezeichnet werden. Annotationen können bei
der Kompilierung oder zur Laufzeit ausgelesen werden und können z.B. für
die Generierung von Code, die Validierung von Eingaben oder die Konfiguration von Systemen verwendet werden.

Hier ist ein Beispiel, wie du eine Annotation für ein Einzelhandelsunternehmen erstellen könntest, um die Artikelnummer
von Produkten zu speichern:

```java
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface ItemNumber {
    String value();
}
```

In diesem Beispiel wurde die Annotation "ItemNumber" erstellt, die auf Feldern (z.B. Membervariablen) verwendet werden
kann. Die Annotation enthält einen einzelnen Wert "value", der die Artikelnummer speichert. Die Annotation wird bei der
Laufzeit aufbewahrt, sodass sie zur Laufzeit ausgelesen werden kann.

Du kannst die Annotation wie folgt verwenden:

```java
public class Product {
    @ItemNumber("123456")
    private String name;
    private double price;

    // ...
}
```

Um eine Annotation zur Laufzeit auszulesen, kannst du die Reflection-API in Java verwenden. Hier ist ein Beispiel, wie
du die Annotation "ItemNumber" aus dem vorherigen Beispiel auslesen könntest:

```java
import java.lang.reflect.Field;

public class Main {
    public static void main(String[] args) throws NoSuchFieldException {
        // Hole das Feld "name" der Klasse "Product"
        Field field = Product.class.getDeclaredField("name");

        // Prüfe, ob das Feld die Annotation "ItemNumber" hat
        if (field.isAnnotationPresent(ItemNumber.class)) {
            // Hole die Annotation "ItemNumber" vom Feld
            ItemNumber annotation = field.getAnnotation(ItemNumber.class);

            // Hole den Wert der Annotation
            String value = annotation.value();
            System.out.println("Item number: " + value);  // Item number: 123456
        }
    }
}
```

In diesem Beispiel wird das Feld "name" der Klasse "Product" mithilfe der Reflection-API geholt. Dann wird überprüft, ob
das Feld die Annotation "ItemNumber" hat, und falls ja, wird die Annotation ausgelesen und der Wert ausgegeben.

### [INHALT](../README.md)