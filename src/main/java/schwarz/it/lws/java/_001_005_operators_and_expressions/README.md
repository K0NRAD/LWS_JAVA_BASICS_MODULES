# Operatoren und Ausdrücke in Java

- Ein Operator ist ein Symbol, das den Compiler dazu veranlasst, eine bestimmte Operation mit Operanden durchzuführen.
- Beispiel: a + b = c
- Im obigen Beispiel sind 'a' und 'b' Operanden, auf die der '+'-Operator angewendet wird.

## Arten von Operatoren:

### 1. Arithmetische Operatoren

- Arithmetische Operatoren werden verwendet, um mathematische Operationen wie Addition, Division, etc. auf Ausdrücke
  anzuwenden.
- Arithmetische Operatoren können nicht mit Booleschen Werten arbeiten.
- Der %-Operator (Modulo) kann mit Gleitkomma- und Doppelwerten arbeiten.
- Von den Increment und Decrement Operatoren gibt es zwei Ausprägungen, der Unterschied liegt bei dem Zeitpunkt wann das
  Inkrementieren/Dekrementieren erfolgt.
    - Pre Increment ++value, Pre Decrement --value
    - Post Increment value++, Post Decrement value--

Beispiele: (gegeben x = 7 und y = 2)

| Operator         | Beschreibung                         | Beispiel   |
|------------------|--------------------------------------|------------|
| + Addition       | addieren von zwei Werten             | x + y = 9  |
| - Subtraktion    | subtrahieren von zwei Werten         | x - y = 5  |
| * Multiplication | multiplizieren von zwei Werten       | x * y = 14 |
| / Division       | dividieren von zwei Werten           | x / y = 3  |
| % Modulo         | Restwert nach Division               | x % y = 1  |
| ++ Increment     | Wert um eins erhöhen ( x = x + 1 )   | ++x = 8    |
| -- Decrement     | Wert um eins verringern ( y = y -1 ) | --y = 1    |

### 2. Vergleichsoperatoren

Wie der Name schon sagt, werden diese Operatoren verwendet, um zwei Operanden zu vergleichen.

Beispiele: (gegeben x = 8 und y = 2)

| Operator              | Beschreibung                                                                                  | Beispiel       |
|-----------------------|-----------------------------------------------------------------------------------------------|----------------|
| == gleich             | Prüft auf Gleichheit, Rückgabe true bei Gleichheit, ansonsten false                           | x == y = false |
| != ungleich           | Prüft auf Ungleichheit, Rückgabe true bei Ungleichheit, ansonsten false                       | x != y = true  |
| > größer als          | Prüft ob Wert 1 größer Wert 2 ist, Rückgabe true wenn größer, ansonsten false                 | x > y = true   |
| < kleiner als         | Prüft ob Wert 1 kleiner Wert 2 ist, Rückgabe true wenn kleiner, ansonsten false               | x < y = false  |
| >= größer gleich als  | Prüft ob Wert 1 größer gleich Wert 2 ist, Rückgabe true wenn größer gleich, ansonsten false   | x > y = true   |
| <= kleiner gleich als | Prüft ob Wert 1 kleiner gleich Wert 2 ist, Rückgabe true wenn kleiner gleich, ansonsten false | x < y = false  |

### 3. Logische Operatoren

Diese Operatoren bestimmen die Logik in einem Ausdruck, der zwei oder mehr Werte oder Variablen enthält.

Beispiele: (gegeben x = 8 und y = 2)

| Operator                 | Beschreibung                                    | Beispiel                                |
|--------------------------|-------------------------------------------------|-----------------------------------------|
| && logisch und           | Gibt true zurück wenn beide Operanten true sind | x > y && x != y  -> true                |
| &#124;&#124; logisch und | Gibt true zurück wenn beide Operanten true sind | x < y &#124;&#124; x != y  -> true      |
| ! logisch not            | Negiert das Ergebnis einer Prüfung              | !(x < y &#124;&#124; x != y)  -> false) |

Die Operatoren && und || sind sogenannte Kurzschluss-Operatoren, bei einer Verkettung, bricht die Überprüfung sofort ab,
sobald eine Bedingung nicht mehr zutrifft. Stelle dir vor, du willst einen externen Service aufrufen, das gibt nur Sinn,
wenn die Adresse für den Service überhaupt existiert.

```
String DEVELOPER_API = "https://development/developers";

if(existResource(DEVELOPER_API) && loginDeveloperApi(DEVELOPER_API)) {
    List<Developer> developers = getDevelopers(DEVELOPER_API);
   ...
}
```

### 4. Bitweise Operatoren

Das binäre System ist ein Zahlensystem, bei dem nur die Zahlen 0 und 1 verwendet werden. Im binären System werden die
Zahlen in Gruppen von jeweils acht Bits (einem Byte) dargestellt, die wiederum in Gruppen von vier Bits (einem Nibble)
unterteilt werden können. Jedes Bit kann entweder 0 oder 1 sein, und jedes Byte kann daher 256 verschiedene Werte
darstellen.

| Wertigkeit | 128 | 64  | 32  | 16  | 8   | 4   | 2   | 1   |     |
|------------|-----|-----|-----|-----|-----|-----|-----|-----|-----|
| binär      | 1   | 0   | 1   | 0   | 1   | 0   | 1   | 0   |     |
| Addition   | 128 | 0   | 32  | 0   | 8   | 0   | 2   | 0   | 170 |
|            |     |     |     |     |     |     |     |     |     |
| binär      | 0   | 0   | 0   | 1   | 1   | 0   | 0   | 1   |     |
| Addition   | 0   | 0   | 0   | 16  | 8   | 0   | 0   | 1   | 25  |
|            |     |     |     |     |     |     |     |     |     |
| binär      | 0   | 1   | 1   | 0   | 0   | 1   | 0   | 0   |     |
| Addition   | 0   | 64  | 32  | 0   | 0   | 4   | 0   | 0   | 100 |

Diese Operatoren führen die Operationen für jedes Bit einer Zahl aus.

#### Wahrheitstabellen

__Binär AND (und)__

| IN A | IN B | OUT |
|------|------|-----|
| 0    | 0    | 0   |
| 0    | 1    | 0   |
| 1    | 0    | 0   |
| 1    | 1    | 1   |

__Binär OR (oder)__

| IN A | IN B | OUT |
|------|------|-----|
| 0    | 0    | 0   |
| 0    | 1    | 1   |
| 1    | 0    | 1   |
| 1    | 1    | 1   |

__Binär XOR (exklusiv oder)__

| IN A | IN B | OUT |
|------|------|-----|
| 0    | 0    | 0   |
| 0    | 1    | 1   |
| 1    | 0    | 1   |
| 1    | 1    | 0   |

Beispiel: (gegeben x =2 und y=3. 2 im Binärsystem 100 und 3 ist 011.

| Operator                  | Beschreibung                                                                            | Beispiel                              |
|---------------------------|-----------------------------------------------------------------------------------------|---------------------------------------|
| & bitweise und            | Alle Bits der zwei Werte werden, wie in der Wahrheitstabelle, verknüpft                 | (x & y) = (100 & 011) = 000           |
| &#124; bitweise oder      | Alle Bits der zwei Werte werden, wie in der Wahrheitstabelle, verknüpft                 | (x &#124; y) = (100 &#124; 011) = 111 |
| ^ bitweise exklusive oder | Alle Bits der zwei Werte werden, wie in der Wahrheitstabelle, verknüpft                 | (x ^ y) = (100 ^ 011) = 111           |
| << shift nach links       | Verschiebt die Bits um n Stellen nach links, die Stellen rechts werden mit 0 aufgefüllt | x << 2 = 8                            |
| >> shift nach rechts      | Verschiebt die Bits um n Stellen nach rechts, die Stellen links werden mit 0 aufgefüllt | y >> 2 = 1                            |

## Vorrang der Operatoren

- Die Operatoren werden nach ihrem Vorrang angewendet und ausgewertet. Zum Beispiel hat (+, -) einen geringeren Vorrang
  als (*, /). Daher werden '*' und / zuerst ausgewertet.
- Falls wir diese Reihenfolge ändern möchten, verwenden wir Klammern ()
