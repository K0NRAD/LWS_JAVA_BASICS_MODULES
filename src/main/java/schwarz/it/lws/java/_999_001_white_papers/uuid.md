# UUID in Java

Um in Java eine UUID (Universally Unique Identifier) zu erstellen, kannst du die Klasse __UUID__ aus dem Package _
_java.util__ verwenden. Du kannst entweder eine zufällige UUID erzeugen oder eine UUID von einem bestimmten String
erzeugen.

Hier sind zwei Beispiele, wie du in Java eine UUID erzeugen kannst:

### Zufällige UUID erzeugen

```java
import java.util.UUID;

class App {
    public static void main(String[] args) {
        UUID uuid = UUID.randomUUID();
        System.out.println(uuid);
    }
}
```

### UUID von einem String erzeugen

```java
import java.util.UUID;

class App {
    public static void main(String[] args) {
        String input = "abcdefghijklmnopqrstuvwxyz";
        UUID uuid = UUID.nameUUIDFromBytes(input.getBytes());
        System.out.println(uuid);
    }
}
```

Die Methode __randomUUID()__ gibt eine zufällig erzeugte UUID zurück, während die Methode __nameUUIDFromBytes(byte[]
name)__ eine UUID von einem Byte-Array erzeugt. Du kannst auch einen String in ein Byte-Array umwandeln, indem du die
Methode __getBytes()__ aufrufst.