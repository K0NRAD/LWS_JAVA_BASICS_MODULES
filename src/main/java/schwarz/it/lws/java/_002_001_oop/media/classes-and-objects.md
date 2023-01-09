# Klassen und Objekte

In Java sind Klassen und Objekte wichtige Konzepte der objektorientierten Programmierung (OOP). Sie ermöglichen es, den
Code in kleinere, wiederverwendbare Einheiten zu unterteilen und die Struktur des Programms zu vereinfachen.

## Klassen

Eine Klasse ist eine Vorlage oder ein "Blaupause" für Objekte. Sie definiert die Eigenschaften und Methoden, die die
Objekte haben werden. Eine Klasse kann auch als "Datenmodell" für ein bestimmtes Konzept oder eine bestimmte Entität in
einem Programm angesehen werden.

Eine Klasse besteht aus zwei Teilen: Eigenschaften (auch als "Attribute" oder "Felder" bezeichnet) und Methoden. Die
Eigenschaften beschreiben die Daten, die ein Objekt speichern kann, während die Methoden die Aktionen beschreiben, die
ein Objekt ausführen kann.

Hier ist ein Beispiel für eine Klasse in Java:

```java
class Person {
    // Eigenschaften (Felder)
    private String name;
    private int age;

    // Konstruktor
    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    // Getter Methoden
    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    // Setter Methoden
    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
```

## Objekte

Ein Objekt ist eine konkrete Instanz einer Klasse. Es hat die Eigenschaften und Methoden, die von der Klasse definiert
wurden, und kann diese verwenden. Ein Objekt wird erstellt, indem man die Klasse instanziiert und einen neuen
Objekt-Verweis erstellt.

Um auf die Eigenschaften und Methoden eines Objekts zuzugreifen, verwendet man den Punkt-Operator (.). Zum Beispiel, um
auf die name-Eigenschaft eines Person-Objekts zuzugreifen, verwendet man person.name. Um die getName-Methode eines
Person-Objekts aufzurufen, verwendet man person.getName().

Hier ist ein Beispiel für die Erstellung und Verwendung von Objekten in Java:

```java
class App {
    public static void main(String[] args) {
        Person person01 = new Person("Alice", 30);
        Person person02 = new Person("Bob", 35);

        System.out.printf("Name of person01 %s\n",person01.getName());
        System.out.printf("Age of person01 %d\n",person01.getAge());
        
        System.out.printf("Name of person02 %s\n",person02.getName());
        System.out.printf("Age of person02 %d\n",person02.getAge());
    }
}
```

### [INHALT](../README.md)