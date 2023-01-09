# Klassen und Methoden

In Java gibt es verschiedene Arten von Methoden, die sich in ihrer Zugänglichkeit, ihren Modifikatoren und ihrem
Speicherort unterscheiden. Die häufigsten Arten von Methoden in Java sind:

## Statische Methoden

Statische Methoden sind Methoden, die direkt einer Klasse und nicht einem Objekt zugeordnet sind.
Sie können ohne die Erstellung eines Objekts aufgerufen werden, indem man den Klassennamen und den Methodennamen
verwendet. Statische Methoden werden mit dem Schlüsselwort static vor der Rückgabetyp-Deklaration definiert.

Statische Methoden werden häufig verwendet, um allgemeine Funktionalitäten bereitzustellen, die nicht von einem
spezifischen Objekt abhängen. Sie können auch verwendet werden, um Eigenschaften oder Methoden zu definieren, die für
alle Objekte einer Klasse gleich sind.

Statische Methoden werden mit dem Schlüsselwort __static__ vor der Rückgabetyp-Deklaration definiert. Sie können nicht
auf nicht-statische Eigenschaften oder Methoden einer Klasse zugreifen, da sie kein spezifisches Objekt haben, auf das
sie sich beziehen könnten.

Hier ist ein Beispiel für die Verwendung von statischen Methoden in Java:

```java
class MathUtils {
    // Statische Methode
    public static int add(int a, int b) {
        return a + b;
    }
}

class App {
    public static void main(String[] args) {
        int result = MathUtils.add(1, 2); // Ruft die statische add-Methode auf
        System.out.printf("The result of addition 1 and 2 is %d\n", result);
    }
}
```

## Nicht-statische Methoden

Nicht-statische Methoden, auch als __Instanz-Methoden__ bezeichnet, sind Methoden, die Objekten zugeordnet sind und über
eine Objektreferenz aufgerufen werden müssen. Sie haben Zugriff auf sowohl statische als auch nicht-statische
Eigenschaften und Methoden einer Klasse.

Nicht-statische Methoden werden ohne das Schlüsselwort static vor der Rückgabetyp-Deklaration definiert. Sie müssen über
eine Objektreferenz aufgerufen werden, da sie sich auf die Eigenschaften und Methoden eines bestimmten Objekts beziehen.

Hier ist ein Beispiel für die Verwendung von nicht-statischen Methoden in Java:

```java
class Person {
    // Eigenschaften
    private String name;
    private int age;

    // Konstruktor
    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    // Nicht-statische Methode
    public void setName(String name) {
        this.name = name;
    }
}

class App {
    public static void main(String[] args) {
        Person person = new Person("Alice", 30);
        person.setName("Bob"); // Ruft die nicht-statische setName-Methode auf
    }
}
```

<img src="./important.png" width="44" height="44" /> 
Es ist wichtig zu beachten, dass nicht-statische Methoden nicht direkt aufgerufen

## Konstruktoren

In Java sind Konstruktoren spezielle nicht-statische Methoden, die bei der Erstellung eines Objekts aufgerufen werden.
Sie haben denselben Namen wie die Klasse und werden verwendet, um das Objekt zu initialisieren.

Konstruktoren haben keine Rückgabetyp-Deklaration und werden verwendet, um den Initialisierungscode für ein Objekt zu
gruppieren. Wenn kein Konstruktor explizit definiert wurde, wird automatisch ein parameterloser Konstruktor
bereitgestellt, der keine Initialisierung durchführt.

Hier ist ein Beispiel für die Verwendung von Konstruktoren in Java:

```java
class Person {
    // Eigenschaften
    private String name;
    private int age;

    // Konstruktor
    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }
}

class App {
    public static void main(String[] args) {
        // Ruft den Konstruktor auf, um ein Person-Objekt zu erstellen
        Person person = new Person("Alice", 30);
    }
}
```

Es ist möglich, mehrere Konstruktoren für eine Klasse zu definieren, um unterschiedliche Initialisierungsszenarien
abzubilden. Dies wird als "Überladung von Konstruktoren" bezeichnet.

Konstruktoren können auch von Unterklassen überschrieben werden, um spezifischen Initialisierungscode bereitzustellen.
Dies wird als "Chaining von Konstruktoren" bezeichnet

## Überladene Methoden

Überladene Methoden in Java sind Methoden, die denselben Namen haben, aber unterschiedliche Parameterlisten. Sie werden
verwendet, um statischen Polymorphismus zu erreichen. Die tatsächliche Methode, die aufgerufen wird, wird zur
Compile-Zeit aufgrund der übergebenen Parameter ausgewählt.

Hier ist ein Beispiel für die Verwendung von überladenen Methoden in Java:

```java
class Calculator {
    // Überladene Methode
    public int add(int a, int b) {
        return a + b;
    }

    // Überladene Methode
    public double add(double a, double b) {
        return a + b;
    }
}

class App {
    Calculator calculator = new Calculator();
    int result1 = calculator.add(1, 2); // Ruft die erste überladene Methode auf
    double result2 = calculator.add(1.5, 2.5); // Ruft die zweite überladene Methode auf
}
```

<img src="./important.png" width="44" height="44" />
Es ist wichtig zu beachten, dass die Überladung von Methoden in Java auf der Basis der Anzahl und/oder der Art der
Parameter erfolgt. Die Rückgabetypen der Methoden spielen keine Rolle bei der Überladung.

Überladene Methoden werden häufig verwendet, um Funktionalität bereitzustellen, die für unterschiedliche Datentypen
geeignet ist. Sie können auch verwendet werden, um unterschiedliche Implementierungen für die gleiche Funktion
bereitzustellen, je nachdem, welche Parameter übergeben werden.

## Abstrakte Methoden

In Java sind abstrakte Methoden Methoden, die nur eine Methodenkopfzeile und keine Implementierung haben. Sie werden in
abstrakten Klassen und Interfaces verwendet und müssen von Unterklassen implementiert werden. Sie dienen dazu,
dynamischen Polymorphismus zu erreichen.

Abstrakte Methoden werden mit dem Schlüsselwort abstract vor der Rückgabetyp-Deklaration definiert und müssen in einer
abstrakten Klasse oder einem Interface enthalten sein. Sie können nicht direkt aufgerufen werden und müssen von einer
Unterklasse implementiert werden, um eine konkrete Implementierung zu haben.

Hier ist ein Beispiel für die Verwendung von abstrakten Methoden in Java:

```java
abstract class Animal {
    // Abstrakte Methode
    public abstract void makeSound();
}

class Dog extends Animal {
    // Implementierung der abstrakten Methode
    @Override
    public void makeSound() {
        System.out.println("woof");
    }
}

class Cat extends Animal {
    // Implementierung der abstrakten Methode
    @Override
    public void makeSound() {
        System.out.println("meow");
    }
}

class App {
    public static void main(String[] args) {
        Animal animal01 = new Dog();
        animal01.makeSound(); // Gibt "woof" aus

        Animal animal02 = new Cat();
        animal.makeSound(); // Gibt "meow" aus
    }
}
```

## Einschließende Methoden

Einschließende Methoden in Java sind Methoden, die in einer Klasse definiert sind, aber in einer Unterklasse
überschrieben werden können. Sie werden mit dem Schlüsselwort final vor der Rückgabetyp-Deklaration definiert und können
nicht in Unterklassen überschrieben werden.

Einschließende Methoden werden verwendet, um sicherzustellen, dass bestimmte Methoden in Unterklassen nicht
überschrieben werden und somit ihre Funktionalität beibehalten. Sie werden häufig verwendet, um sicherzustellen, dass
bestimmte Methoden, die für die Integrität oder Sicherheit einer Klasse wichtig sind, nicht unbeabsichtigt geändert
werden.

Hier ist ein Beispiel für die Verwendung von einschließenden Methoden in Java:

```java
class MyClass {
    // Einschließende Methode
    public final void doSomething() {
        // Code hier
    }
}

class MySubClass extends MyClass {
    // Kann die einschließende Methode nicht überschreiben
    // @Override
    // public void doSomething() {
    //   // Code hier
    // }
}
```

<img src="./important.png" width="44" height="44" />
Es ist wichtig zu beachten, dass einschließende Methoden nicht von Unterklassen überschrieben werden können. Wenn eine
Unterklasse versucht, eine einschließende Methode zu überschreiben, wird ein Compilerfehler generiert. Einschließende
Methoden können jedoch in Unterklassen aufgerufen werden.

## Private Methoden

Private Methoden sind Methoden, die nur innerhalb der Klasse, in der sie definiert sind, sichtbar sind. Sie können nicht
von anderen Klassen aufgerufen werden und dienen dazu, die Interaktion mit anderen Klassen zu beschränken und den Code
in kleinere, wiederverwendbare Einheiten zu unterteilen. Private Methoden werden mit dem Schlüsselwort __private__ vor
der Rückgabetyp-Deklaration definiert.

Hier ist ein Beispiel für die Verwendung von privaten Methoden in Java:

```java
class MyClass {
    public void action() {
        // private Methoden können nur innerhalb einer 
        // Instanz einer Klasse aufgerufen werden.
        doSomething();
    }

    // Private Methode
    private void doSomething() {
        // Code hier
    }
}
```

<img src="./important.png" width="44" height="44" />
Private Methoden können nur innerhalb der Klasse, in der sie definiert sind, aufgerufen werden. Sie können nicht von
anderen Klassen aufgerufen werden und sind somit eine Möglichkeit, den Zugriff auf bestimmte Teile des Codes
einzuschränken.

Private Methoden werden häufig verwendet, um Code in wiederverwendbare Einheiten zu unterteilen und die Interaktion mit
anderen Klassen zu beschränken. Sie können auch verwendet werden, um bestimmte Funktionalitäten innerhalb einer Klasse
zu verstecken, die für den Benutzer nicht relevant sind.

### [INHALT](../README.md)
