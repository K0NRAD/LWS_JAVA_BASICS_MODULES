# Benutzer-Ein und Ausgabe in Java

### Ein-/Ausgabe-Streams 
Es existieren standardmässig folgende Ein-/Ausgabe-Streams
- System.in - wird verwendet zum Einlesen von Daten aus der Konsole ( String text = scanner.nextLine(); )
- System.out - wird verwender zur Ausgabe von Daten auf der Konsole ( System.out.println("Java is awesome"); )
- System.err - wird verwender zur Ausgabe von Daten auf der Konsole im Fehlerfall ( System.err.println("An error has occurred."); )


### Lesen von Daten von der Konsole

- Die Klasse Scanner des Pakets java.util wird verwendet, um Eingaben von der Tastatur des Benutzers entgegenzunehmen.
- Die Scanner-Klasse hat viele Methoden, um Eingaben vom Benutzer zu erhalten, abhängig von der Art der Eingabe.
- Um eine der Methoden der Scanner-Klasse zu verwenden, müssen wir zunächst ein Objekt der Scanner-Klasse erstellen, wie
  im folgenden Beispiel gezeigt:

```
// Importieren der Scanner-Klasse
import java.util.Scanner;

//Erzeugen eines Objekts namens "scanner" der Klasse Scanner.
Scanner scanner = new Scanner(System.in); 
```

Einlesen einer Eingabezeile in einen String-Wert über die Tastatur:

```
// Eingabe Prompt
System.out.print("Enter a sentence:"); 

// Lesen der Eingabezeile
String line = scanner.nextLine();
```

Einlesen eines Integer-Wertes über die Tastatur:

```
// Eingabe Prompt
System.out.print("Enter number of days:"); 

// Lesen des nächsten Ganzzahl Wertes
int numberOfDays = scanner.nextInt();
```

Einlesen eines float Wertes

```
// Eingabe Prompt
System.out.print("Enter article price:"); 

// Lesen der Eingabezeile
float articlePrice = scanner.nextFloat();
```

## Fehler bei der Dateneingabe

Gibst du einen nicht nummerischen Wert ein, wenn ein nummerischer Wert angefordert wird, führt das zu einer Exception. 
Danach kann aus dem Eingabe-Stream nicht mehr gelesen werden.

```
// Eingabe Prompt
System.out.print("Enter article price:"); 

// Lesen der Eingabezeile 
float articlePrice = scanner.nextFloat();

// Bei der Eingabe von z.B. xyz anstatt eines nummerischen Wertes
// wird eine Exception ausgelöst
// Exception in thread "main" java.util.InputMismatchException
// 	at java.base/java.util.Scanner.throwFor(Scanner.java:943)
// 	at java.base/java.util.Scanner.next(Scanner.java:1598)
// 	at java.base/java.util.Scanner.nextFloat(Scanner.java:2501)
// 	at schwarz.it.lws.java._001_004_system_io.App.main(App.java:29)
```

Diesen Fehler wird am besten programmatisch behandelt.
Der Wert wird als Text (String) eingelesen, intern geprüft, ob es ein Zahlenwert ist. 
Wenn ja, wird, der String, durch eine geeignete Konverter-Methode in nummerischen Datentype umgewandelt.

Das Beispiel zeigt eine Möglichkeit mit dem Fehler umzugehen.

```
NumberFormat format = NumberFormat.getInstance(Locale.GERMANY);
try {
    System.out.print("Enter the net article price:");
    String articleNetPriceTxt = scanner.next();
    float articlePriceEuros = format.parse(articleNetPriceTxt).floatValue();

    System.out.print("Enter the value added tax in percent:");
    String valueAddedTaxPercentTxt = scanner.next();
    float valueAddedTaxPercentEuros = format.parse(valueAddedTaxPercentTxt).floatValue();

    float valueAddedTaxEuros = articlePriceEuros * valueAddedTaxPercentEuros * 0.01F;
    System.out.printf("The VAT %.2f euros\n", valueAddedTax);
    
    float grossItemPriceEuros = articleNetPrice + valueAddedTax;
    System.out.printf("The gross item price is %.2f\n", grossItemPrice);
} catch (ParseException ex) {
    System.out.println("Only decimal numbers may be entered");
}
```
### Ausgeben von Daten auf der Konsole
- für die Ausgabe von Daten auf der Konsole können für die beiden Ausgabe-Streams (System.out, System.err) die __print__ Methoden verwendet werden.
- System.out.print("Java is awesome") - Ausgabe von "Java is awesome" ohne Zeilenvorschub ('\n')
- System.out.println("Java is awesome") - Ausgabe von "Java is awesome" mit Zeilenvorschub ('\n')
- System.out.printf("Java is %d%% awesome\n", 100) - Ausgabe von "Java is 100% awesome" mit Zeilenvorschub ('\n')
