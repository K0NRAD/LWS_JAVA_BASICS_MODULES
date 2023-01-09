# JSON Daten

## JSON

JSON (JavaScript Object Notation) ist ein Standard-Format zur Übertragung von Daten, insbesondere von Anwendungen, die
in JavaScript geschrieben sind. Es ist eine einfache Textdarstellung von strukturierten Daten und basiert auf dem
Prinzip von Schlüssel-Wert-Paaren.

JSON wird häufig verwendet, um Daten zwischen Server und Web-Anwendung, zwischen Web-Anwendungen und mobilen Anwendungen
oder zwischen verschiedenen Systemen zu übertragen. Es ist eine Alternative zu anderen Datenformaten wie XML (eXtensible
Markup Language) und ist in der Regel kürzer und leichter zu lesen und zu schreiben.

Ein JSON-Objekt besteht aus einer Menge von Schlüssel-Wert-Paaren, die durch Kommas getrennt sind und von geschweiften
Klammern umschlossen sind. Der Wert eines Schlüssels kann ein String, eine Zahl, ein Boolean (true oder false), null
oder ein anderes JSON-Objekt oder eine JSON-Liste sein. Hier ist ein Beispiel für ein JSON-Objekt:

```json
{
  "name": "John",
  "age": 30,
  "isEmployed": true,
  "skills": [
    "Java",
    "JavaScript",
    "Python"
  ],
  "address": {
    "street": "Main Street",
    "city": "New York",
    "country": "USA"
  }
}
```

Eine JSON-Liste ist eine Sequenz von Werten, die durch Kommas getrennt sind und von eckigen Klammern umschlossen sind.

Hier ist ein Beispiel für eine JSON-Liste:

```json
[
  "Java",
  "JavaScript",
  "Python"
]
```

## JSON Daten parsen

Um JSON-Daten zu parsen, kannst du die Klasse JSONObject, der Bibliothek org.json verwenden.

Die Syntax der org.json-Bibliothek in Java ist relativ einfach.

Hier sind einige der wichtigsten Klassen und Methoden:

| Klass/Methoden     | Beschreibung                                                                                                                 |
|--------------------|------------------------------------------------------------------------------------------------------------------------------|
| JSONObject         | Diese Klasse repräsentiert ein JSON-Objekt und ermöglicht es, Schlüssel-Wert-Paare hinzuzufügen, abzurufen und zu entfernen. | 
| JSONArray          | Diese Klasse repräsentiert eine JSON-Liste und ermöglicht es, Elemente hinzuzufügen, abzurufen und zu entfernen.             |             
| get(key)           | Diese Methode wird verwendet, um den Wert eines Schlüssels im JSON-Objekt abzurufen.                                         |                                         
| put(key, value)    | Diese Methode wird verwendet, um ein Schlüssel-Wert-Paar zum JSON-Objekt hinzuzufügen.                                       |                                       
| remove(key)        | Diese Methode wird verwendet, um ein Schlüssel-Wert-Paar aus dem JSON-Objekt zu entfernen.                                   |                                   
| getInt(key)        | Diese Methoden werden verwendet, um den Wert eines Schlüssels als Integer abzurufen.                                         |                                         
| getDouble(key)     | Diese Methoden werden verwendet, um den Wert eines Schlüssels als Double abzurufen.                                          |                                          
| getBoolean(key)    | Diese Methoden werden verwendet, um den Wert eines Schlüssels als Boolean abzurufen.                                         |                                         
| getJSONObject(key) | Diese Methoden werden verwendet, um den Wert eines Schlüssels als JSONObject.                                                |                                                
| getJSONArray(key)  | Diese Methoden werden verwendet, um den Wert eines Schlüssels als JSONArray abzurufen.                                       |                                       

Hier ist ein Beispiel, wie du diese Klasse verwenden könntest, um einen String mit JSON-Daten
zu parsen und die Werte von bestimmten Schlüsseln abzurufen:

```java
import org.json.JSONObject;

public class JsonParserExample {
    public static void main(String[] args) {
        String jsonString = "{\"name\": \"John\", \"age\": 30, \"city\": \"New York\"}";

        JSONObject jsonObject = new JSONObject(jsonString);
        String name = jsonObject.getString("name");
        int age = jsonObject.getInt("age");
        String city = jsonObject.getString("city");

        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("City: " + city);
    }
}
```

Dieser Code würde die Ausgabe "Name: John, Age: 30, City: New York" erzeugen.

Wenn du die JSON-Daten in aus einer Datei lesen möchtest, kannst du die Methode JSONObject.read() verwenden, um ein
JSONObject aus einem Reader zu erstellen.

Hier ist ein Beispiel:

```java
import java.io.FileReader;

import org.json.JSONObject;

public class JsonParserExample {
    public static void main(String[] args) throws Exception {
        FileReader reader = new FileReader("data.json");
        JSONObject jsonObject = new JSONObject(reader);
        // Verarbeite die JSON-Daten wie oben gezeigt
    }
}
```

Um auf verschachtelt JSON-Objekt zuzugreifen, kannst du wie folgt vorgehen:

```java
import org.json.JSONObject;

public class JsonParserExample {
    public static void main(String[] args) {
        String jsonString = """
                    {
                        "employees": [
                            {
                                "firstName": "John",
                                "lastName": "Doe",
                                "roles": [
                                    "Manager",
                                    "Developer"
                                ]
                            },
                            {
                                "firstName": "Anna",
                                "lastName": "Smith",
                                "roles": [
                                    "Designer"
                                ]
                            },
                            {
                                "firstName": "Peter",
                                "lastName": "Jones",
                                "roles": [
                                    "QA Tester"
                                ]
                            }
                        ]
                    }
                """;

        JSONObject jsonObject = new JSONObject(jsonString);
        JSONArray employees = jsonObject.getJSONArray("employees");
        for (int i = 0; i < employees.length(); i++) {
            JSONObject employee = employees.getJSONObject(i);
            String firstName = employee.getString("firstName");
            String lastName = employee.getString("lastName");
            System.out.println(firstName + " " + lastName + ":");

            JSONArray roles = employee.getJSONArray("roles");
            for (int j = 0; j < roles.length(); j++) {
                String role = roles.getString(j);
                System.out.println("- " + role);
            }
        }
    }
}
```

Dieser Code würde die Ausgabe:

```
"John Doe: - Manager - Developer, Anna Smith: - Designer, Peter Jones: - QA Tester" erzeugen.
```

Best practices zum Parsen von JSON-Daten mit der org.json-Bibliothek in Java:

- Verwende die get-Methoden mit dem entsprechenden Datentyp, um sicherzustellen, dass du die richtige Art von Wert
  abrufst. Zum Beispiel solltest du getInt verwenden, wenn du erwartest, dass der Wert ein Integer ist, und getDouble
  verwenden, wenn du erwartest, dass der Wert ein Double ist.

- Verwende die opt-Methoden, wenn du nicht sicher bist, ob der Wert im JSON-Objekt vorhanden ist oder nicht. Diese
  Methoden werden wie die get-Methoden verwendet, aber sie geben einen Defaultwert zurück, wenn der Wert nicht vorhanden
  ist, anstatt eine JSONException zu werfen.

- Verwende die getJSONObject- und getJSONArray-Methoden, um auf verschachtelte JSON-Objekte und -Listen zuzugreifen.
  Vergiss nicht, dass du auf diese Weise immer noch auf die get, opt und andere Methoden zugreifen kannst, um auf die
  Werte innerhalb dieser Objekte und Listen zuzugreifen.

- Verwende Try-Catch-Blöcke, um mögliche Ausnahmen zu behandeln, die beim Parsen der JSON-Daten auftreten können.


### [INHALT](../README.md)