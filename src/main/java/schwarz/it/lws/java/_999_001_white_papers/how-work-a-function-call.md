# Wie funktioniert ein Funktionsaufruf

Ein Funktionsaufruf ist ein Vorgang, bei dem eine Funktion aufgerufen wird, um ihren Code auszuführen. Dies geschieht,
indem der Aufrufer (normalerweise der aktuelle Codeblock oder die aktuelle Funktion) einen Funktionsnamen und ggf.
einige Argumente übergibt, die von der Funktion verwendet werden können.

Der Aufruf einer Funktion kann mithilfe eines Stacks und eines Heaps realisiert werden. Der Stack ist ein spezieller
Bereich im Hauptspeicher (RAM), in dem Daten temporär gespeichert werden, während der Code ausgeführt wird. Der Heap
hingegen ist ein Bereich im Hauptspeicher, in dem dynamisch allokierten Speicherplatz verwaltet wird.

Wenn eine Funktion aufgerufen wird, wird ein neuer Eintrag (auch als "Frame" bezeichnet) im Stack erstellt, der die
lokalen Variablen, den Rücksprungpunkt (der angibt, wo der Code fortgesetzt werden soll, wenn die Funktion beendet ist)
und ggf. andere Informationen enthält. Der Stack wird verwendet, um die Reihenfolge der Funktionsaufrufe zu verfolgen
und um sicherzustellen, dass die richtigen Variablen und Werte zur Verfügung stehen, wenn sie von der Funktion benötigt
werden.

Wenn die Funktion dynamischen Speicherplatz allokiert (z.B. mit der malloc-Funktion in C), wird dieser Speicherplatz im
Heap bereitgestellt. Der Heap wird verwendet, um Speicherplatz für langlebige Objekte bereitzustellen, die über den
Lebenszyklus der Funktion hinaus benötigt werden.

Wenn die Funktion beendet ist, wird der Frame aus dem Stack entfernt und der Code kehrt zum Aufrufer zurück. Der
Speicherplatz, der im Heap allokiert wurde, muss manuell freigegeben werden (normalerweise mit der free-Funktion in C),
wenn er nicht mehr benötigt wird.