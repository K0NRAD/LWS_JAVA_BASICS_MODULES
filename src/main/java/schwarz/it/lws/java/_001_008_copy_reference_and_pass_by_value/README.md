# Call by Reference und Call By Value

In Java gibt es zwei Arten, wie du Variablen an Methoden übergeben kannst: "Call by Value" und "Call by Reference".

Bei "Call by Value" übergibst du den Wert einer Variablen an eine Methode. Die Methode bekommt eine Kopie dieses Werts,
aber die ursprüngliche Variable bleibt unverändert.

Bei "Call by Reference" übergibst du die tatsächliche Speicheradresse einer Variablen an eine Methode. Dadurch kann die
Methode die ursprüngliche Variable direkt verändern.

In Java gibt es jedoch keine Möglichkeit, Variablen per Referenz zu übergeben. Stattdessen kannst du Objekte als
Referenzen behandeln und diese an Methoden übergeben. Auf diese Weise kannst du das Objekt in der Methode verändern,
aber nicht die Referenz selbst.

```java
/**
 * Diese Klasse demonstriert den Unterschied zwischen "Call by Value" und
 * "Call by Reference" in Java.
 */
public class CopyReferenceAndPassByValue {

    public static void main(String[] args) {
        // Erstelle ein Point-Objekt mit den Koordinaten (100, 200)
        java.awt.Point point = new Point(100, 200);

        // Gebe den Wert von point aus und rufe die printPoint-Methode auf
        System.out.println("point = " + point);
        printPoint(point);

        // Gebe den aktualisierten Wert von point aus
        System.out.println("point = " + point);

        // Definiere die Variable i mit dem Wert 100
        int i = 100;

        // Gebe den Wert von i aus und rufe die printI-Methode auf
        System.out.println("i = " + i);
        printI(i);

        // Gebe den unveränderten Wert von i aus
        System.out.println("i = " + i);
    }

    /**
     * Diese Methode nimmt eine Kopie des übergebenen int-Werts entgegen und
     * gibt ihn aus. Anschließend wird der Wert von i auf 200 geändert,
     * aber diese Änderung hat keine Auswirkungen auf den ursprünglichen
     * Wert von i außerhalb der Methode.
     */
    private static void printI(int i) {
        System.out.println("i = " + i);
        i = 200;
    }

    /**
     * Diese Methode nimmt eine Referenz auf ein Point-Objekt entgegen und
     * gibt die Koordinaten des Objekts aus. Anschließend werden die
     * Koordinaten des Objekts verändert, was sich auf den ursprünglichen
     * Wert von point außerhalb der Methode auswirkt.
     */
    private static void printPoint(Point point) {
        System.out.println("point = " + point);
        point.x = 200;
        point.y = 400;
    }
}
```

---

## [Verständnisfragen](./media/questions-of-understanding.md)
