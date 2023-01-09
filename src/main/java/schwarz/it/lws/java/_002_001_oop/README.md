# Objektorientierte Programmierung - OOP

## Inhalt

- __[OOP auf einen Blick](#oop-auf-einen-blick)__
- __[OOP ist eine Art, deine Projekte zu entwerfen](#oop-ist-eine-art-deine-projekte-zu-entwerfen)__
- __[Ziele](#ziele)__
- __[Robustheit](#robustheit)__
- __[Anpassungsfähigkeit](#anpassungsfaehigkeit)__
- __[Wiederverwendbarkeit](#wiederverwendbarkeit)__
- __[Grundsätze](#grundsaetze)__
- __[Modularität](#modularität)__
- __[Abstraktion](#abstraktion)__
- __[Verkapselung](#verkapselung)__
- __[Klassen und Objekte](./media/classes-and-objects.md)__
- __[Klassen Methoden](./media/classes-methods.md)__
- __[Vererbung Polimorphie](./media/polimorphy.md)__
- __[Interfaces und abstrakte Klassen](./media/interfaces-and-abstract-classes.md)__
- __[Annotations](./media/annotations.md)__
- __[Exceptions](./media/exceptions.md)__

## OOP auf einen Blick

In OOP sind alle Instanzen von Klassen Objekte. Das bedeutet, dass jedes Objekt eine bestimmte Klasse hat, von der es
abstammt und die es beschreibt. Diese Klasse kann Eigenschaften (z.B. Titel, Autor, Seitenzahl) und Verhaltensweisen (
z.B. lesen, ausleihen, zurückgeben) definieren.

Beispielsweise, wenn Du eine Bibliotheks-App erstellst, könntest Du eine Klasse "Buch" erstellen, die die Eigenschaften
und Verhaltensweisen eines Buches beschreibt. Du könntest dann mehrere Objekte von dieser Klasse erstellen, die jedes
einzelne Buch in Deiner Bibliothek darstellen. Jedes dieser Objekte würde die Eigenschaften und Verhaltensweisen der
Klasse "Buch" besitzen und könnte z.B. gelesen oder ausgeliehen werden.

OOP ermöglicht es dir, deinen Code einfach und strukturiert zu gestalten, indem Du die verschiedenen Aspekte deines
Projekts in Klassen und Objekte aufteilst. Du kannst dir deinen Code wie reale Objekte vorstellen, die in einer Art
Werkstatt (dein Code-Editor) zusammengefügt werden, um ein bestimmtes Projekt (z.B. eine Bibliotheks-App) zu erstellen.

[INHALT](#inhalt)
## OOP ist eine Art deine Projekte zu entwerfen

Du kannst es als eine Art betrachten, Systeme zu entwerfen. Sie ist für fast alle Programmiersprachen verfügbar!

Da es sich um einen Design-Mechanismus handelt (so nenne ich ihn), hat es eine Reihe von Zielen und Prinzipien!

[INHALT](#inhalt)
## Ziele

Das ist es, was Du bei der Entwicklung eines OOP-Systems anstreben solltest.

[INHALT](#inhalt)
## Robustheit

Einfach ausgedrückt: ein Programm, das für alle erwarteten Eingaben in der Anwendung des Programms die richtige Ausgabe
erzeugt, aber auch mit unerwarteten Eingaben umgehen kann.

Du könntest zum Beispiel wollen, dass Dein E-Mail-Formular am Ende immer @gmail.com enthält. Vielleicht fügen Deine
Benutzer nicht @gmail.com hinzu, aber Deine App sollte das handhaben können!

[INHALT](#inhalt)
## Anpassungsfaehigkeit

Dein Programm muss sich im Laufe der Zeit mit den neuen Trends und Bedürfnissen des Marktes weiterentwickeln!

Zum Beispiel sind jetzt (auf E-Commerce-Websites) Chatbots im Trend. Vielleicht wird es später ein Trend sein, anstelle
von Chatbots durch KI mit Deiner Stimme zu sprechen, anstatt mit ihnen zu texten!
Deine App sollte in der Lage sein, sich weiterzuentwickeln.

[INHALT](#inhalt)
## Wiederverwendbarkeit

Derselbe Code sollte in verschiedenen Teilen der Anwendung verwendet werden können. Schreibe keine sehr
spezifischen Funktionen! Schreibe stattdessen Funktionen für allgemeine Zwecke.

Anstelle einer Funktion, mit der Du ein bestimmtes Modell (aus der Datenbank) filtern kannst, habe Du zum Beispiel
eine Funktion, mit der Du jedes Modell filtern kannst, mit jedem beliebigen Feld, das Du auswählst, Du musst nur
Parameter übergeben!

[INHALT](#inhalt)
## Grundsaetze

Dies sind Ansätze (betrachte sie als Methoden), um die oben genannten Ziele zu erreichen.

[INHALT](#inhalt)
## Modularität

Modularität bedeutet, dass Sie verschiedene Komponenten (in Ihrer Anwendung) haben, die alle ihre eigenen Funktionen
haben.

Mit anderen Worten: Halte alles in Ordnung.

Packe nicht alles auf einen Haufen, sondern schaffe Platz für alles!

[INHALT](#inhalt)
## Abstraktion

Abstraktion bedeutet, ein System in seine grundlegendsten (einfachsten) Bestandteile zu zerlegen!

Etwas wie "Teile und herrsche"!

[INHALT](#inhalt)
## Verkapselung

Die verschiedenen Komponenten einer APP sollten die internen Details ihrer jeweiligen Implementierungen nicht
preisgeben.

Kapselung gibt Dir die Freiheit, komponentenspezifische Kodierung zu machen (dies widerspricht dem, was ich über
Wiederverwendbarkeit gesagt habe, aber manchmal müssen wir spezifische Funktionen in unseren Komponenten hinzufügen).

[INHALT](#inhalt)

--- 

### [Verständnisfragen](./media/questions-of-understanding.md)