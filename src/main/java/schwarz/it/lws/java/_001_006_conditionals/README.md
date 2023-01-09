# Java Conditions

# Java-Tutorial: Relationale und logische Operatoren in Java

## if-Anweisung

Die if-Anweisung in Java ist eine Steuerungsanweisung, die es ermöglicht, einen Codeblock auszuführen, wenn eine
bestimmte Bedingung erfüllt ist. Sie hat folgende Syntax:

```
if (Bedingung) {
   // Code, der ausgeführt wird, wenn die Bedingung wahr ist
}
```

Die Bedingung ist ein boolscher Ausdruck, der ausgewertet wird, um festzustellen, ob er wahr oder falsch ist. Wenn die
Bedingung wahr ist, wird der Code innerhalb der geschweiften Klammern ausgeführt. Wenn die Bedingung falsch ist, wird
der Code übersprungen und das Programm setzt mit der nächsten Anweisung fort.

Ein Beispiel für eine if-Anweisung:

```
int x = 10;
if (x > 5) {
   System.out.println("x ist größer als 5");
}
```

In diesem Beispiel ist die Bedingung x > 5, die wahr ist, da x den Wert 10 hat. Daher wird der Code innerhalb der
if-Anweisung ausgeführt und die Meldung "x ist größer als 5" wird auf der Konsole ausgegeben.

### else-Anweisung

Du kannst auch eine optionale else-Klausel in Ihre if-Anweisung aufnehmen, um Code anzugeben, der ausgeführt werden
soll, wenn die Bedingung falsch ist:

```
if (Bedingung) {
   // Code, der ausgeführt wird, wenn die Bedingung wahr ist
} else {
   // Code, der ausgeführt wird, wenn die Bedingung falsch ist
}
```

Ein Beispiel für eine else-Anweisung:

```
int x = 10;
if (x > 15) {
   System.out.println("x ist größer als 15");
} else {
   System.out.println("x ist nicht größer als 15");
}
```

In diesem Fall ist die Bedingung x > 15 falsch, da x den Wert 10 hat, daher wird der Code in der else-Klausel ausgeführt
und die Meldung "x ist nicht größer als 15" wird auf der Konsole ausgegeben.

---

### [Verständnisfragen](./media/questions-of-understanding.md)