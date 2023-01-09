# Unit Testing mit Spring Boot

Das Schreiben guter Unit-Tests kann als eine Kunst angesehen werden, die schwer zu meistern ist. Die gute Nachricht ist jedoch, dass die Mechanismen, die dies unterstützen, leicht zu erlernen sind.

Dieses Tutorial vermittelt Ihnen diese Mechanismen und geht auf die technischen Details ein, die für das Schreiben guter Unit-Tests erforderlich sind, wobei der Schwerpunkt auf Spring Boot-Anwendungen liegt.

Wir schauen uns an, wie man Spring Beans auf eine testbare Art und Weise erstellt und diskutieren dann die Verwendung von Mockito und AssertJ, beides Bibliotheken, die Spring Boot standardmäßig zum Testen enthält.

Beachten Sie, dass in diesem Artikel nur Unit-Tests behandelt werden. Integrationstests, Tests der Web-Schicht und Tests der Persistenz-Schicht werden in den nächsten Artikeln dieser Serie behandelt.

## Abhängigkeiten

Für den Unit-Test in diesem Tutorial werden wir JUnit Jupiter (JUnit 5), Mockito und AssertJ verwenden. Wir werden auch Lombok einbeziehen, um ein wenig Boilerplate-Code zu reduzieren:

```groovy
dependencies{
  compileOnly('org.projectlombok:lombok')
  testCompile('org.springframework.boot:spring-boot-starter-test')
  testCompile 'org.junit.jupiter:junit-jupiter-engine:5.2.0'
  testCompile('org.mockito:mockito-junit-jupiter:2.23.0')
}
```

Mockito und AssertJ werden automatisch mit der spring-boot-starter-test-Abhängigkeit importiert, aber wir müssen Lombok selbst einbinden.

## Verwende Spring nicht in Unit-Tests

Wenn Du in der Vergangenheit Tests mit Spring oder Spring Boot geschrieben hast, wirst Du wahrscheinlich sagen, dass wir Spring nicht brauchen, um Unit-Tests zu schreiben. Warum ist das so?

Betrachte den folgenden "Unit"-Test, der eine einzelne Methode der Klasse RegisterUseCase testet:

```java
@ExtendWith(SpringExtension.class)
@SpringBootTest
class RegisterUseCaseTest {

    @Autowired
    private RegisterUseCase registerUseCase;

    @Test
    void savedUserHasRegistrationDate() {
        User user = new User("zaphod", "zaphod@mail.com");
        User savedUser = registerUseCase.registerUser(user);
        assertThat(savedUser.getRegistrationDate()).isNotNull();
    }
}
````

Die Ausführung dieses Tests in einem leeren Spring-Projekt auf meinem Computer dauert etwa 4,5 Sekunden.

Aber ein guter Unit-Test braucht nur Millisekunden. Andernfalls behindert er den Fluss "Test/Code/Test", der durch die Idee der testgetriebenen Entwicklung (TDD) gefördert wird. Aber auch wenn wir kein TDD praktizieren, ruiniert das Warten auf einen Test, der zu lange dauert, unsere Konzentration.

Die Ausführung der obigen Testmethode dauert tatsächlich nur Millisekunden. Der Rest der 4,5 Sekunden ist darauf zurückzuführen, dass der @SpringBootRunSpring Boot anweist, einen ganzen Spring Boot-Anwendungskontext einzurichten.

Wir haben also die gesamte Anwendung gestartet, nur um eine RegisterUseCase-Instanzmit unserem Test zu verbinden. Es wird noch länger dauern, wenn die Anwendung größer wird und Spring mehr und mehr Beans in den Anwendungskontext laden muss.

Warum also dieser Artikel, wenn wir Spring Boot nicht in einem Unit-Test verwenden sollten? Um ehrlich zu sein, dreht sich der größte Teil dieses Tutorials um das Schreiben von Unit-Tests ohne Spring Boot.

### Erstellen einer testbaren Spring Bean

Es gibt jedoch einige Dinge, die wir tun können, um unsere Spring Beans besser testbar zu machen.

## Feldinjektion ist böse

Lass uns mit einem schlechten Beispiel beginnen. Betrachten wir die folgende Klasse:

```java
@Service
public class RegisterUseCase {

    @Autowired
    private UserRepository userRepository;

    public User registerUser(User user) {
        return userRepository.save(user);
    }
}
````

Diese Klasse kann nicht ohne Spring getestet werden, da sie keine Möglichkeit bietet, eine UserRepository-Instanzzu übergeben. Stattdessen müssen wir den Test so schreiben, wie im vorherigen Abschnitt beschrieben, damit Spring eine UserRepository-Instanz erstellt und in das mit @Autowired annotierte Feld injiziert.

Die Lektion hier ist, keine Feldinjektion zu verwenden.

## Einen Konstruktor bereitstellen

Eigentlich sollten wir die @Autowired-Annotation gar nicht verwenden:

```java
@Service
public class RegisterUseCase {

  private final UserRepository userRepository;

  public RegisterUseCase(UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  public User registerUser(User user) {
    return userRepository.save(user);
  }
}
```

Diese Version ermöglicht Konstruktorinjektion, indem sie einen Konstruktor bereitstellt, der die Übergabe einer UserRepository-Instanz ermöglicht. Im Unit-Test können wir nun eine solche Instanz erstellen (vielleicht eine Mock-Instanz, wie wir später noch besprechen werden) und sie an den Konstruktor übergeben.

Spring wird diesen Konstruktor automatisch verwenden, um ein RegisterUseCase-Objekt zu instanziieren, wenn der Produktionsanwendungskontext erstellt wird. Beachten Sie, dass wir vor Spring 5 die @Autowired-Annotation zum Konstruktor hinzufügen müssen, damit Spring den Konstruktor findet.

Beachten Sie auch, dass das UserRepository-Feld jetzt endgültig ist. Dies ist sinnvoll, da sich der Inhalt des Feldes während der Lebensdauer einer Anwendung niemals ändern wird. Es hilft auch, Programmierfehler zu vermeiden, denn der Compiler wird sich beschweren, wenn wir vergessen haben, das Feld zu initialisieren.

## Reduktion von Boilerplate-Code

Mit der @RequiredArgsConstructor-Annotationvon Lombok können wir den Konstruktor automatisch generieren lassen:

```java
@Service
@RequiredArgsConstructor
public class RegisterUseCase {

  private final UserRepository userRepository;

  public User registerUser(User user) {
    user.setRegistrationDate(LocalDateTime.now());
    return userRepository.save(user);
  }
}
```

Nun haben wir eine sehr prägnante Klasse ohne Boilerplate-Code, die einfach in einem einfachen Java-Testfall instanziiert werden kann:

```java
class RegisterUseCaseTest {

  private UserRepository userRepository = ...;

  private RegisterUseCase registerUseCase;

  @BeforeEach
  void initUseCase() {
    registerUseCase = new RegisterUseCase(userRepository);
  }

  @Test
  void savedUserHasRegistrationDate() {
    User user = new User("zaphod", "zaphod@mail.com");
    User savedUser = registerUseCase.registerUser(user);
    assertThat(savedUser.getRegistrationDate()).isNotNull();
  }
}
```

Es fehlt noch ein Teil, und zwar wie man die UserRepository-Instanz, von der unsere zu testende Klasse abhängt, nachahmt, denn wir wollen uns nicht auf die echte Instanz verlassen, die wahrscheinlich eine Verbindung zu einer Datenbank benötigt.

## Verwendung von Mockito zum Nachahmen von Abhängigkeiten

Mockito ist heutzutage die de-facto-Standardbibliothek für das Mocking und bietet mindestens zwei Möglichkeiten, ein gespottetes UserRepository zu erstellen, um die Lücke im vorherigen Codebeispiel zu füllen.

### Mocking von Abhängigkeiten mit einfachem Mockito

Die erste Möglichkeit ist, Mockito einfach programmatisch zu verwenden:

```java
private UserRepository userRepository = Mockito.mock(UserRepository.class);
````

Damit wird ein Objekt erstellt, das von außen wie ein UserRepository aussieht. Standardmäßig tut es nichts, wenn eine Methode aufgerufen wird, und gibt null zurück, wenn die Methode einen Rückgabewert hat.

Unser Test würde nun mit einer NullPointerException bei assertThat(savedUser.getRegistrationDate()).isNotNull()fehlschlagen, weil userRepository.save(user) nun null zurückgibt.

Wir müssen also Mockito sagen, dass es etwas zurückgeben soll, wenn userRepository.save() aufgerufen wird. Wir tun dies mit der statischen when-Methode:

```java
@Test
void savedUserHasRegistrationDate() {
  User user = new User("zaphod", "zaphod@mail.com");
  when(userRepository.save(any(User.class))).then(returnsFirstArg());
  User savedUser = registerUseCase.registerUser(user);
  assertThat(savedUser.getRegistrationDate()).isNotNull();
}
```

Dadurch gibt userRepository.save() dasselbe Benutzerobjekt zurück, das an die Methode übergeben wird.

Mockito verfügt über eine ganze Reihe weiterer Funktionen, die das Mocking, den Abgleich von Argumenten und die Überprüfung von Methodenaufrufen ermöglichen. Weitere Informationen finden Sie in der Referenzdokumentation.

### Mocking-Abhängigkeiten mit der @Mock-Annotation von Mockito

Eine alternative Möglichkeit zur Erstellung von Mock-Objekten ist die @Mock-Annotation von Mockito in Kombination mit der MockitoExtension für JUnit Jupiter:

```java
@ExtendWith(MockitoExtension.class)
class RegisterUseCaseTest {

  @Mock
  private UserRepository userRepository;

  private RegisterUseCase registerUseCase;

  @BeforeEach
  void initUseCase() {
    registerUseCase = new RegisterUseCase(userRepository);
  }

  @Test
  void savedUserHasRegistrationDate() {
    // ...
  }

}
```

Die Annotation @Mock gibt die Felder an, in die Mockito Mock-Objekte injizieren soll. Mit der @MockitoExtensionwird Mockito angewiesen, diese @Mock-Annotationen auszuwerten, da JUnit dies nicht automatisch tut.

Das Ergebnis ist dasselbe wie bei einem manuellen Aufruf von Mockito.mock(), es ist Geschmackssache, welchen Weg man wählt. Beachten Sie jedoch, dass durch die Verwendung von MockitoExtension unsere Tests an das Testframework gebunden sind.

Beachten Sie, dass wir anstelle der manuellen Erstellung eines RegisterUseCase-Objekts genauso gut die @InjectMocks-Annotationfür das Feld registerUseCase verwenden können. Mockito erstellt dann eine Instanz für uns, die einem bestimmten Algorithmus folgt:

```java
@ExtendWith(MockitoExtension.class)
class RegisterUseCaseTest {

  @Mock
  private UserRepository userRepository;

  @InjectMocks
  private RegisterUseCase registerUseCase;

  @Test
  void savedUserHasRegistrationDate() {
    // ...
  }
}
```

### Erstellen von lesbaren Assertions mit AssertJ

Eine weitere Bibliothek, die automatisch mit der Spring Boot Testunterstützung mitgeliefert wird, ist AssertJ. Wir haben sie bereits oben verwendet, um unsere Assertion zu implementieren:

```java
assertThat(savedUser.getRegistrationDate()).isNotNull();
```

Aber wäre es nicht schön, die Assertion noch lesbarer zu machen? Zum Beispiel so:

```java
assertThat(savedUser).hasRegistrationDate();
```

Es gibt viele Fälle, in denen kleine Änderungen wie diese den Test so viel verständlicher machen. Erstellen wir also unsere eigene benutzerdefinierte Behauptungim Ordner test sources:

```java
class UserAssert extends AbstractAssert<UserAssert, User> {

  UserAssert(User user) {
    super(user, UserAssert.class);
  }

  static UserAssert assertThat(User actual) {
    return new UserAssert(actual);
  }

  UserAssert hasRegistrationDate() {
    isNotNull();
    if (actual.getRegistrationDate() == null) {
      failWithMessage(
        "Expected user to have a registration date, but it was null"
      );
    }
    return this;
  }
}
```

Wenn wir nun die assertThat-Methode aus der neuen UserAssert-Klasse statt aus der AssertJ-Bibliothek importieren, können wir die neue, leichter zu lesende Assertion verwenden.

Die Erstellung einer benutzerdefinierten Assertion wie dieser mag nach einer Menge Arbeit aussehen, ist aber in Wirklichkeit in ein paar Minuten erledigt. Ich bin der festen Überzeugung, dass es sich lohnt, diese Minuten zu investieren, um lesbaren Testcode zu erstellen, auch wenn er danach nur geringfügig besser lesbar ist. Schließlich schreiben wir den Testcode nur einmal, und andere (einschließlich "mein zukünftiges Ich") müssen den Code viele, viele Male während der Lebensdauer der Software lesen, verstehen und dann manipulieren.

Wenn Ihnen das immer noch zu viel Arbeit ist, schauen dir den Assertions Generator von AssertJ an.

# Fazit

Es gibt Gründe, eine Spring-Anwendung in einem Test zu starten, aber für einfache Unit-Tests ist es nicht notwendig. Es ist sogar schädlich wegen der längeren Durchlaufzeiten. Stattdessen sollten wir unsere Spring Beans so bauen, dass sie das Schreiben einfacher Unit-Tests leicht unterstützen.

Der Spring Boot Test Starterwird mit Mockito und AssertJ als Testbibliotheken geliefert.

Lasst uns diese Testbibliotheken nutzen, um ausdrucksstarke Unit-Tests zu erstellen!
