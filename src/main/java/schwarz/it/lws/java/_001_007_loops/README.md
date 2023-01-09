# Schleifen in Java

## 1. for-Schleife:

Die for-Schleife wird verwendet, um eine festgelegte Anzahl von Durchläufen zu wiederholen.

Sie hat folgenden Aufbau

```
for (Initalsierung; Bedingung; Weiterschaltung) {
   // Code, der wiederholt ausgeführt wird
}
```

Die __Initalsierung__ wird einmal am Anfang der Schleife ausgeführt und initialisiert z.B. eine
Zählvariable.
Die __Bedingung__ wird vor jedem Durchlauf der Schleife geprüft und bestimmt, ob die Schleife fortgesetzt oder
beendet wird.
Die __Weiterschaltung__ wird am Ende jedes Durchlaufs ausgeführt und kann z.B. eine Zählvariable inkrementieren oder
dekrementieren.

## 2. while-Schleife

Die while-Schleife wird verwendet, um eine bestimmte Bedingung zu wiederholen, solange sie true ist. Sie hat folgenden

Sie hat folgenden Aufbau:

```
while (Bedingung) {
   // Code, der wiederholt ausgeführt wird
}
```

Die Bedingung wird vor jedem Durchlauf der Schleife geprüft und bestimmt, ob die Schleife fortgesetzt oder beendet wird.

## 3. do-while-Schleife

Die do-while-Schleife ist ähnlich wie die while-Schleife, aber die Bedingung wird am Ende jedes Durchlaufs geprüft.

Sie hat folgenden Aufbau:

```
do {
   // Code, der wiederholt ausgeführt wird
} while (Bedingung);
```

Die Bedingung wird am Ende jedes Durchlaufs geprüft und bestimmt, ob die Schleife fortgesetzt oder beendet wird. Die
do-while-Schleife wird mindestens einmal ausgeführt, da die Bedingung erst am Ende des ersten Durchlaufs geprüft wird.

## 4. foreach-Schleife (auch als enhanced for-Schleife bekannt)

Die foreach-Schleife wird verwendet, um jedes Element in einer Sammlung (z.B. einem Array oder einer Liste) zu
durchlaufen.

Sie hat folgenden Aufbau:

```
for (Elementtyp element : sammlung) {
   // Code, der für jedes Element in der Sammlung ausgeführt wird
}
```

Die foreach-Schleife besteht aus drei Teilen: dem for-Schlüsselwort, einer Kopfzeile und dem Codeblock, der ausgeführt
wird.

In der Kopfzeile wird zunächst der Typ des Elements angegeben, das in der Sammlung durchlaufen wird (Elementtyp). Danach
wird ein neuer Variablenname für das Element angegeben (element), der im Codeblock verwendet werden kann. Zuletzt wird
das :-Zeichen und der Name der Sammlung angegeben (sammlung), die durchlaufen werden soll.

Der Codeblock wird für jedes Element in der Sammlung ausgeführt. Der Variablenname (element), der in der Kopfzeile
definiert wurde, kann im Codeblock verwendet werden, um auf das aktuelle Element in der Sammlung zuzugreifen.

Hier ist ein Beispiel für die Verwendung einer foreach-Schleife, um die Elemente in einem Array von Integers zu
auszugeben:

```
int[] numbers = {1, 2, 3, 4, 5};

for (int number : numbers) {
   System.out.println(number);
}
```

## 5. Wann eine for-Schleife und wann eine while-Schleife

Eine for-Schleife wird verwendet, wenn Sie eine bestimmte Anzahl von Iterationen durchführen möchten,
während eine while-Schleife verwendet wird, wenn Sie eine Iteration so lange durchführen möchten,
bis eine bestimmte Bedingung erfüllt ist.

Hier ist ein Beispiel für eine for-Schleife, die verwendet wird, um die Zahlen von 1 bis 10 auszugeben:

```
for (int i = 1; i <= 10; i++) {
  System.out.println(i);
}
```

In diesem Beispiel wird die Schleife 10 Mal durchlaufen, da der Zähler i von 1 bis 10 inkrementiert wird.

Hier ist ein Beispiel für eine while-Schleife, die verwendet wird, um die Eingabe des Benutzers zu lesen,
bis eine gültige Eingabe eingegeben wurde:

```
Scanner scanner = new Scanner(System.in);

int input = 0;
while (input <= 0) {
  System.out.print("Bitte geben Sie eine positive Zahl ein:");
  input = scanner.next();  
}
```

In diesem Beispiel wird die Schleife solange durchlaufen, bis eine positive Zahl eingegeben wurde. Wenn eine positive
Zahl eingegeben wurde, wird die Schleife beendet und das Programm fortgesetzt.

Es gibt keine festen Regeln dafür, wann man eine for-Schleife und wann man eine while-Schleife verwenden sollte. Es
hängt von der Art der Aufgabe und Deinen Vorlieben ab. In der Regel werden for-Schleifen verwendet, wenn die Anzahl der
Iterationen im Voraus bekannt ist, während while-Schleifen verwendet werden, wenn die Anzahl der Iterationen ungewiss
ist. Es ist jedoch möglich, dass eine for-Schleife auch verwendet wird, wenn die Anzahl der Iterationen ungewiss ist,
indem man eine unendliche Schleife erstellt, indem man die Bedingung immer auf true setzt.

## 6. Continue und Break

Continue und break sind beides Schlüsselwörter in Java, die innerhalb von Schleifen verwendet werden können, um das
Verhalten der Schleife zu beeinflussen.

Continue wird verwendet, um den Rest des Codeblocks der aktuellen Schleife zu überspringen und direkt mit dem nächsten
Durchlauf fortzufahren. Wenn continue innerhalb einer Schleife ausgeführt wird, wird der Code unterhalb von continue
übersprungen und die Schleife setzt fort, indem sie die Bedingung für den nächsten Durchlauf überprüft.

Hier ist ein Beispiel, in dem continue verwendet wird, um alle ungeraden Zahlen in einem Array von Integern zu
überspringen:

```
int[] numbers = {1, 2, 3, 4, 5};

for (int number : numbers) {
   if (number % 2 == 1) {
      continue;
   }
   System.out.println(number);
}
```

Break wird verwendet, um die Schleife vorzeitig zu beenden und zum Code nach der Schleife zu springen. Wenn break
innerhalb einer Schleife ausgeführt wird, wird die Schleife beendet und der Code unterhalb von break wird ausgeführt.

Hier ist ein Beispiel, in dem break verwendet wird, um die Schleife zu beenden, sobald eine Zahl größer als 3 gefunden
wird:

```
int[] numbers = {1, 2, 3, 4, 5};

for (int number : numbers) {
   if (number > 3) {
      break;
   }
   System.out.println(number);
}
```

!! Es ist wichtig zu beachten, dass continue und break nur innerhalb von Schleifen verwendet werden können und dass sie
nur das Verhalten der Schleife beeinflussen, in der sie sich befinden. Sie haben keine Auswirkungen auf Schleifen, die
innerhalb der aktuellen Schleife ausgeführt werden, oder auf Schleifen, die außerhalb der aktuellen Schleife ausgeführt
werden.

Wenn Du aus allen Schleifen ausbrechen möchtest, kannst Du ein Label verwenden, um die äußere Schleife zu kennzeichnen
und dann "break" mit dem Label verwenden, um aus allen Schleifen auszubrechen.

Hier ist ein Beispiel:

```
loop: 
for (int i = 0; i < 10; i++) {
  for (int j = 0; j < 10; j++) {
    if (j == 5) {
      // Breche beide Schleifen ab
      break loop;
    }
    System.out.println("i: " + i + ", j: " + j);
  }
}
```

In diesem Beispiel wird die Ausführung der Schleifen abgebrochen, sobald j den Wert 5 hat, und es wird keine weitere
Ausgabe mehr geben.

## Wissenwertes über ASCII-Zeichen

ASCII (American Standard Code for Information Interchange) ist ein Zeichenkodierungsstandard, der verwendet wird, um
Buchstaben, Zahlen und Sonderzeichen in digitalen Formaten darzustellen. Der ASCII-Standard definiert einen 7-Bit-Code
für 128 verschiedene Zeichen, darunter Buchstaben, Ziffern, Sonderzeichen und Steuerzeichen.

Einige Beispiele für ASCII-Zeichen sind:

- Buchstaben: A, B, C, D, ..., Z, a, b, c, d, ..., z
- Ziffern: 0, 1, 2, 3, 4, 5, 6, 7, 8, 9
- Sonderzeichen: !, ", #, $, %, &, ', (, ), *, +, ,, -, ., /, :, ;, <, =, >, ?, @, [, , ], ^, _, `, {, |, }, ~
- Steuerzeichen: Bell (BEL), Backspace (BS), Horizontal Tab (HT), Line Feed (LF), Carriage Return (CR), Form Feed (FF)

ASCII wurde ursprünglich entwickelt, um Daten zwischen Computern und anderen elektronischen Geräten auszutauschen. Heute
wird es jedoch hauptsächlich noch in der Softwareentwicklung verwendet, um Zeichen zu codieren und zu decodieren. Es
gibt auch andere Zeichenkodierungen wie Unicode, die eine größere Auswahl an Zeichen unterstützen und daher für die
Darstellung von Text in verschiedenen Sprachen besser geeignet sind.

Die Ziffern 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 haben folgende ASCII-Codes:

0 = 48 1 = 49 2 = 50 3 = 51 4 = 52 5 = 53 6 = 54 7 = 55 8 = 56 9 = 57

Um aus einem Zahl-Zeichen den Zahlenwert zu bekommen besteht die folgende Möglichkeit:

int number = '5' - '0'; // 53 - 48 = 5

---

### [Verständnisfragen](./media/questions-of-understanding.md)