## Streams

Java bietet zwei Haupttypen von Streams: Byte-Streams und Character-Streams.

### Byte-Streams

Byte-Streams sind für die Verarbeitung von Bytes gedacht und bieten Methoden zum Lesen und Schreiben von Bytes.

Hier sind einige Beispiele für Byte-Streams in Java:

- `InputStream`: Basisklasse für alle Input-Byte-Streams
- `OutputStream`: Basisklasse für alle Output-Byte-Streams
- `FileInputStream`: Liest Bytes aus einer Datei
- `FileOutputStream`: Schreibt Bytes in eine Datei
- `ByteArrayInputStream`: Liest Bytes aus einem Byte-Array
- `ByteArrayOutputStream`: Schreibt Bytes in ein Byte-Array
- `PipedInputStream`: Liest Bytes aus einem Piped-Output-Stream
- `PipedOutputStream`: Schreibt Bytes in einen Piped-Input-Stream

### Character-Streams

Character-Streams sind für die Verarbeitung von Unicode-Zeichen gedacht und bieten Methoden zum Lesen und Schreiben von
Zeichen.

Hier sind einige Beispiele für Character-Streams in Java:

- `Reader`: Basisklasse für alle Input-Character-Streams
- `Writer`: Basisklasse für alle Output-Character-Streams
- `FileReader`: Liest Zeichen aus einer Datei
- `FileWriter`: Schreibt Zeichen in eine Datei
- `CharArrayReader`: Liest Zeichen aus einem Char-Array
- `CharArrayWriter`: Schreibt Zeichen in ein Char-Array
- `StringReader`: Liest Zeichen aus einer String
- `StringWriter`: Schreibt Zeichen in eine String
- `PipedReader`: Liest Zeichen aus einem Piped-Output-Stream
- `PipedWriter`: Schreibt Zeichen in einen Piped-Input-Stream

Hier ist ein Beispiel in Java, wie eine Textdatei geschrieben und gelesen werden kann:

```java
import java.io.*;

public class FileExample {
    public static void main(String[] args) {
        // Pfad der Datei
        String filePath = "textfile.txt";

        // Text, der in die Datei geschrieben werden soll
        String text = "Dies ist ein Beispieltext.";

        // Schreibe Text in die Datei
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            writer.write(text);
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Lese Text aus der Datei
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
```

Hier ist ein Beispiel in Java, wie eine JSON-Datei geschrieben und gelesen werden kann:

```java
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

public class JSONExample {
    public static void main(String[] args) {
        // Pfad der Datei
        String filePath = "article.json";

        // Article-Objekt, das in die JSON-Datei geschrieben werden soll
        Article article = new Article();
        article.setId(42);
        article.setName("Wert1");

        // Schreibe Article-Objekt in die JSON-Datei
        ObjectMapper mapper = new ObjectMapper();
        try {
            mapper.writeValue(new File(filePath), article);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Lese Article-Objekt aus der JSON-Datei
        try {
            Article readedArticle = mapper.readValue(new File(filePath), Article.class);
            System.out.println(readedArticle.getName());
            System.out.println(readedArticle.getId());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class Article {
    private int id;
    private String name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
```