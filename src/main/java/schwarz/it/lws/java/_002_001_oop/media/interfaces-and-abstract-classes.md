# Interfaces und abstrakte Klassen

In Java sind Interfaces abstrakte Datentypen, die eine Liste von Methodenkopfzeilen ohne Implementierungen
bereitstellen. Sie werden verwendet, um dynamischen Polymorphismus zu erreichen und dienen als eine Art "Vertrag", der
von Klassen implementiert werden kann, um bestimmte Funktionalitäten bereitzustellen.

Interfaces werden mit dem Schlüsselwort interface definiert und enthalten nur abstrakte Methoden und Konstanten. Sie
können von Klassen implementiert werden, die dann konkrete Implementierungen für die abstrakten Methoden bereitstellen
müssen.

Hier ist ein Beispiel für die Verwendung von Interfaces in Java:

```java
interface Shape {
    // Abstrakte Methode
    double getArea();

    String getName();
}

class Circle implements Shape {
    // Eigenschaften
    private double radius;

    // Konstruktor
    public Circle(double radius) {
        this.radius = radius;
    }

    // Implementierung der abstrakten Methode
    @Override
    public double getArea() {
        return Math.PI * radius * radius;
    }

    // Implementierung der abstrakten Methode
    @Override
    public String getName() {
        return "Circle";
    }
}

class App {
    public static void main(String[] args) {
        Shape shape = new Circle(5);

        String name = shape.getName(); // Ruft die konkrete Implementierung der getName-Methode auf
        double area = shape.getArea(); // Ruft die konkrete Implementierung der getArea-Methode auf

        System.out.printf("%s area: %f\n", name, area);
    }
}
```

Interfaces werden häufig verwendet, um gemeinsame Schnittstellen für eine Gruppe von Klassen bereitzustellen und
dynamischen Polymorphismus zu erreichen. Sie erzwingen, dass Klassen, die sie implementieren, bestimmte Funktionalitäten
bereitstellen, wodurch sichergestellt wird, dass bestimmte Methoden in allen Klassen vorhanden sind.

## Abstrakte Klassen

Abstrakte Klassen in Java sind Klassen, die nicht instanziiert werden können und die mindestens eine abstrakte Methode
enthalten. Sie werden verwendet, um dynamischen Polymorphismus zu erreichen und dienen als Vorlage für andere Klassen,
die von ihnen erben.

Abstrakte Klassen werden mit dem Schlüsselwort abstract vor der Klassendeklaration definiert und können sowohl abstrakte
als auch nicht-abstrakte Methoden enthalten. Abstrakte Klassen können nicht direkt instanziiert werden und müssen von
Unterklassen erweitert werden, um konkrete Implementierungen bereitzustellen.

Hier ist ein Beispiel für die Verwendung von abstrakten Klassen in Java:

```java
public abstract class Animal {
  // Abstrakte Methode
  public abstract void makeSound();

  // Nicht-abstrakte Methode
  public void eat() {
    System.out.println("Eating...");
  }
}

public class Dog extends Animal {
  // Implementierung der abstrakten Methode
  @Override
  public void makeSound() {
    System.out.println("woof");
  }
}

class App{
    public static void main(String[] args) {
        Animal animal = new Dog();
        animal.makeSound(); // Gibt "woof" aus
        animal.eat(); // Gibt "Eating..." aus
    }
}
```

### [INHALT](../README.md)