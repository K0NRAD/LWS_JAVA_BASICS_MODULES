# Testgetriebene Entwicklung mit Spring Boot

Testgetriebene Entwicklung ist eine Methode, bei der Tests vor der Implementierung von Funktionalität geschrieben
werden. Diese Tests dienen dazu, die Spezifikation der Funktionalität zu beschreiben und sicherzustellen, dass sie
korrekt implementiert wird.

Spring Boot ist ein Framework, das es Entwicklern ermöglicht, schnell und einfach Anwendungen in Java zu erstellen.

In diesem Tutorial entwickeln wir in fünf Schritten eine einfache CRUD-Anwendung.

## Inahlt

- [Create Model](#create-model)
- [Object Mapping](#object-mapping)
- [Customer Repository](#customer-repository)
- [Customer Service](#customer-service)
- [Customer Controller](#customer-controller)
- [Fazit](#fazit)

## Entwicklungsumgebung

- IDE:         IntelliJ IDE
- Java:        17
- Spring Boot: 3.0.1

____

## Create Model

Erstelle eine neue Testklasse namens CustomerTest im Paket schwarz.it.lws.spring_boot_tdd.model.CustomerTest

```java
package schwarz.it.lws.spring_boot_tdd.model;

import org.junit.Test;

public class CustomerTest {

    @Test
    public void createCustomer() {
        Long id = 1000L;
        String firstName = "John";
        String lastName = "Doe";

        Customer customer = new Customer(id, firstName, lastName);
    }
}
```

### [Inhalt](#inhalt)

Im Testcode ist ein Fehler aufgetreten, da kein Kundenobjekt vorhanden ist. Bewege den Mauszeiger über „neuer
Kunde (...)“ und verwende die Schnellkorrektur, um die Klasse „Kunde“ zu generieren.

```java
package schwarz.it.lws.spring_boot_tdd.model;

public class Customer {

    public Customer(Long id, String firstName, String lastName) {
    }
}
```

Lombok wird verwendet, um den Boilerplate-Code zu reduzieren. Lombok generiert den Getter und Setter sowie die
Konstruktoren.<br>

Änder die Customer-Klasse wie folgt:

```java
package schwarz.it.lws.spring_boot_tdd.model;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Customer {
    private Long id;
    private String firstName;
    private String lastName;
}

```

Öffne und erweitere die CustomerTest-Klasse wie folgt:

```java
package schwarz.it.lws.spring_boot_tdd.model;

import org.assertj.core.api.Assertions;
import org.junit.Test;

public class CustomerTest {

    @Test
    public void createCustomer() {
        Long id = 1000L;
        String firstName = "John";
        String lastName = "Doe";

        Customer customer = new Customer(id, firstName, lastName);

        Assertions.assertThat(customer).isNotNull();
    }
}
```

Führe den Test aus und du wirst sehen, dass der Test erfolgreich bestanden wurde.

### [Inhalt](#inhalt)

____

## Object Mapping

Erstelle eine neue Testklasse namens CustomerMappingTest im Paket
schwarz.it.lws.spring_boot_tdd.model.CustomerMappingTest

```java
package schwarz.it.lws.spring_boot_tdd.model;

@RunWith(SpringRunner.class)
@DataJpaTest
public class CustomerMappingTest {

    @Autowired
    private TestEntityManager entityManager;

    @Test
    public void createAndPersistCustomer() {
        Long id = null;
        String firstName = "John";
        String lastName = "Doe";

        Customer customer = new Customer(id, firstName, lastName);

        Customer persistedCustomer = entityManager.persistAndFlush(customer);

        assertThat(persistedCustomer.getId()).isGreaterThan(0L);
    }
}
```

Führe den Test aus und du wirst sehen, dass der Test fehlgeschlagen ist. Warum ist es kaputt?

```bash
java.lang.IllegalArgumentException: Unknown entity: schwarz.it.lws.spring_boot_tdd.model.Customer
```

Dieser Fehler bedeutet, dass das Kundenobjekt keine Entität ist, die beibehalten werden kann.
Wie dies in der Customer-Klasse behoben wird, siehst du hier:

```java
package schwarz.it.lws.spring_boot_tdd.model;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity // <-- mark class as entity object
public class Customer {
    @Id                                             // <- every jpa object need an id field
    @GeneratedValue(strategy = GenerationType.AUTO) // <- the id will generated automatical
    private Long id;
    private String firstName;
    private String lastName;
}
``` 

Führe den Test CustomerMappingTest erneut aus und der Test wird erfolgreich bestanden.

### [Inhalt](#inhalt)

____

## Customer Repository

Erstelle eine neue Testklasse schwarz.it.lws.spring_boot_tdd.repository.CustomerRepositoryTest:

```java
package schwarz.it.lws.spring_boot_tdd.repository;

@RunWith(SpringRunner.class)
@DataJpaTest
public class CustomerRepositoryTest {

    @Autowired
    private CustomerRepository customerRepository;


}
``` 

Es liegt ein Fehler vor, weil kein Interface CustomerRepository vorhanden ist. Erstelle im Paket
schwarz.it.lws.spring_boot_tdd.repository ein Interface namens CustomerRepository:

```java
package schwarz.it.lws.spring_boot_tdd.repository;

import schwarz.it.lws.spring_boot_tdd.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
```

Fügen Sie die Testmethode createAndPersistCustomer() hinzu.

```java
package schwarz.it.lws.spring_boot_tdd.repository;

@RunWith(SpringRunner.class)
@DataJpaTest
public class CustomerRepositoryTest {

    @Autowired
    private CustomerRepository customerRepository;


    @Test
    public void createAndPersistCustomer() {
        Customer customer = new Customer(null, "John", "Doe");

        Customer persistedCustomer = customerRepository.save(customer);

        assertThat(persistedCustomer.getId()).isGreaterThan(0L);
    }
}
```

Führe den Test aus. Die Prüfung wird erfolgreich bestanden.

Jetzt werden wir testen, ob alle persistenten Kunden angezeigt werden. Füge dazu eine neue Testmethode namens
findAllCustomer() hinzu.

Wenn vier Kunden erstellt und gespeichert werden, wird die generische Methode findAll() des
Kundenverzeichnisses aufgerufen, das Ergebnis ist eine Liste von vier Kunden mit einer ID größer als 0.

```java
package schwarz.it.lws.spring_boot_tdd.repository;

@RunWith(SpringRunner.class)
@DataJpaTest
public class CustomerRepositoryTest {

    @Autowired
    private CustomerRepository customerRepository;


    @Before
    public void setUp() throws Exception {
        customerRepository.deleteAll();
    }

    // @Test public void createAndPersistCustomer() {...}

    @Test
    public void findAllCustomers() {
        customerRepository.saveAll(
                Arrays.asList(
                        new Customer(null, "John", "Doe"),
                        new Customer(null, "Jane", "Doe"),
                        new Customer(null, "Peter", "Pan"),
                        new Customer(null, "Paul", "Nobody")
                )
        );

        List<Customer> customers = customerRepository.findAll();

        assertThat(customers.size()).isEqualTo(4);
        assertThat(customers.get(0).getId()).isGreaterThan(0L);
        assertThat(customers.get(1).getId()).isGreaterThan(0L);
        assertThat(customers.get(2).getId()).isGreaterThan(0L);
        assertThat(customers.get(3).getId()).isGreaterThan(0L);
    }
}
```

Wir fügen eine neue Testmethode findCustomerByFirstNameAndLastName() hinzu.

```java
package schwarz.it.lws.spring_boot_tdd.repository;

@RunWith(SpringRunner.class)
@DataJpaTest
public class CustomerRepositoryTest {

    @Autowired
    private CustomerRepository customerRepository;

    @Before
    public void setUp() throws Exception {
        customerRepository.deleteAll();
    }

    // @Test public void createAndPersistCustomer() {}

    // @Test public void findAllCustomers() {...}

    @Test
    public void findCustomerByFirstNameAndLastName() {
        customerRepository.saveAll(
                Arrays.asList(
                        new Customer(null, "John", "Doe"),
                        new Customer(null, "Jane", "Doe"),
                        new Customer(null, "Peter", "Pan"),
                        new Customer(null, "Paul", "Nobody")
                )
        );

        String firstName = "Jane";
        String lastName = "Doe";

        List<Customer> customers = customerRepository.findByFirstNameAndLastName(firstName, lastName);

        assertThat(customers.size()).isEqualTo(1);
        assertThat(customers.get(0).getId()).isGreaterThan(0L);
        assertThat(customers.get(0).getFirstName()).isEqualTo(firstName);
        assertThat(customers.get(0).getLastName()).isEqualTo(lastName);
    }
}
```

Es liegt ein Fehler vor, die Methode findByFirstNameAndLastName(...) existiert nicht. Füge die Methode im Interface
schwarz.it.lws.spring_boot_tdd.repository.CustomerRepository hinzu.

```java
package schwarz.it.lws.spring_boot_tdd.repository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

    List<Customer> findByFirstNameAndLastName(String firstName, String lastName);

}
```

Führen Sie den Test erneut aus, der Test wird erfolgreich bestanden.

### [Inhalt](#inhalt)

____

## Customer Service

Erstelle eine neue Testklasse schwarz.it.lws.spring_boot_tdd.service.CustomerServiceTest.

```java
package schwarz.it.lws.spring_boot_tdd.service;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CustomerServiceTest {

    @Autowired
    private CustomerService customerService;

    @MockBean
    private CustomerRepository customerRepository;

    @Test
    public void findAllCustomers() {

        given(customerRepository.findAll()).willReturn(
                Arrays.asList(
                        new Customer(1L, "John", "Doe"),
                        new Customer(2L, "Jane", "Doe"),
                        new Customer(3L, "Peter", "Pan"),
                        new Customer(4L, "Paul", "Nobody")
                )
        );

        List<Customer> customers = customerService.findAll();

        assertThat(customers.size()).isEqualTo(4);
    }
}
```

Es liegt ein Fehler vor, weil die Klasse schwarz.it.lws.spring_boot_tdd.service.CustomerService nicht existiert.

Erstelle die Klasse CustomerService.

```java
package schwarz.it.lws.spring_boot_tdd.service;

@Service
public class CustomerService {

    private CustomerRepository customerRepository; // <- will injected in the constructor below, no @Autowired are required. 

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public List<Customer> findAll() {
        return customerRepository.findAll();
    }
}
```  

Füge die Testmethode findAllCustomers() wie unten gezeigt hinzu.

```java
package schwarz.it.lws.spring_boot_tdd.service;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CustomerServiceTest {

    @Autowired
    private CustomerService customerService;

    @MockBean // <- this will inject the mock repository into the service class
    private CustomerRepository customerRepository;

    @Test
    public void findAllCustomers() {

        given(customerRepository.findAll()).willReturn( // <- the method findAll() of the CustomerRepository will be mocked
                Arrays.asList(
                        new Customer(1L, "John", "Doe"),
                        new Customer(2L, "Jane", "Doe"),
                        new Customer(3L, "Peter", "Pan"),
                        new Customer(4L, "Paul", "Nobody")
                )
        );

        List<Customer> customers = customerService.findAll();

        assertThat(customers.size()).isEqualTo(4);
    }
}
```

Führe den Test aus und wirst sehen, dass er erfolgreich ist.

Jetzt erstelle eine Testmethode mit dem Namen findCustomerByFirstNameAndLastName().

```java
package schwarz.it.lws.spring_boot_tdd.service;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CustomerServiceTest {

    @Autowired
    private CustomerService customerService;

    @MockBean
    private CustomerRepository customerRepository;

    // @Test public void findAllCustomers() {}

    @Test
    public void findCustomerByFirstNameAndLastName() {
        String firstName = "Jane";
        String lastName = "Doe";

        given(customerRepository.findByFirstNameAndLastName(firstName, lastName)).willReturn(
                Arrays.asList(
                        new Customer(2L, "Jane", "Doe")
                )
        );

        List<Customer> customers = customerService.findByFirstNameAndLastName(firstName, lastName);

        assertThat(customers.size()).isEqualTo(1);
        assertThat(customers.get(0).getFirstName()).isEqualTo(firstName);
        assertThat(customers.get(0).getLastName()).isEqualTo(lastName);
    }
}
```

Es kommt wieder zu einem Fehler, weil die Methode findByFirstNameAndLastName(...) fehlt. Erstelle die Methode in der
Klasse schwarz.it.lws.spring_boot_tdd.service.CustomerService.

```java
package schwarz.it.lws.spring_boot_tdd.service;

@Service
public class CustomerService {

    private CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public List<Customer> findAll() {
        return customerRepository.findAll();
    }

    public List<Customer> findByFirstNameAndLastName(String firstName, String lastName) {
        return customerRepository.findByFirstNameAndLastName(firstName, lastName);
    }
}
```  

Führe den Test aus und du wirst sehen, dass alles grün ist.

Jetzt werden wir testen, ob ein neuer Kunde erstellt werden kann.

Füge der Testklasse die Testmethode createNewCustomer() hinzu.

```java
package schwarz.it.lws.spring_boot_tdd.service;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CustomerServiceTest {

    @Autowired
    private CustomerService customerService;

    @MockBean
    private CustomerRepository customerRepository;

    // @Test public void findAllCustomers() {}

    // @Test public void findCustomerByFirstNameAndLastName() {}

    @Test
    public void createNewCustomer() {
        Long id = 1L;
        String firstName = "Jane";
        String lastName = "Doe";
        Customer customer = new Customer(null, firstName, lastName);

        given(customerRepository.save(customer)).willReturn(
                new Customer(id, firstName, lastName)
        );

        Customer newCustomer = customerService.createCustomer(customer);

        assertThat(newCustomer.getId()).isEqualTo(id);
        assertThat(newCustomer.getFirstName()).isEqualTo(firstName);
        assertThat(newCustomer.getLastName()).isEqualTo(lastName);
    }
}
```

Wir beheben den Fehler und fügen die fehlende Methode in der CustomerService-Klasse hinzu.

```java
package schwarz.it.lws.spring_boot_tdd.service;

@Service
public class CustomerService {

    private CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    // public List<Customer> findAll() {}

    // public List<Customer> findByFirstNameAndLastName(String firstName, String lastName) {}

    public Customer createCustomer(Customer customer) {
        return customerRepository.save(customer);
    }
}
``` 

Nach dem Ausführen des Tests siehst du, dass der Test grün ist. Wir können einen neuen Kunden anlegen, nach Vor- und
Nachnamen suchen und alle Kunden auflisten.

Uns fehlt eine Methode, um einen Kunden zu löschen.

Wir erstellen eine neue Testmethode deleteCustomer().

```java
package schwarz.it.lws.spring_boot_tdd.service;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CustomerServiceTest {

    @Autowired
    private CustomerService customerService;

    @MockBean
    private CustomerRepository customerRepository;

    //@Test public void findAllCustomers() {}

    //@Test public void findCustomerByFirstNameAndLastName() {}

    //@Test public void createNewCustomer() {}

    @Test
    public void deleteCustomer() {
        Customer customer = new Customer(2L, "Jane", "Doe");

        doNothing().when(customerRepository).delete(customer);

        customerService.deleteCustomer(customer);

        verify(customerRepository, times(1)).delete(customer);
    }
}
```

Der Fehler wegen der fehlenden Methode wird in der CustomerService-Klasse behoben.

```java
package schwarz.it.lws.spring_boot_tdd.service;

@Service
public class CustomerService {

    private CustomerRepository customerRepository;

    //public CustomerService(CustomerRepository customerRepository) {}

    //public List<Customer> findAll() {}

    //public List<Customer> findByFirstNameAndLastName(String firstName, String lastName) {}

    //public Customer createCustomer(Customer customer) {}

    public void deleteCustomer(Customer customer) {
        customerRepository.delete(customer);
    }
}
```

Wir führen den Test durch und alles ist grün.

### [Inhalt](#inhalt)

____

## Customer Controller

Schließlich fügen wir den Rest-Controller in tdd-Manier hinzu. Wir erstellen eine neue Testklasse mit dem Namen
CustomerControllerTest.

```java
package schwarz.it.lws.spring_boot_tdd.controller;

@RunWith(SpringRunner.class)
@WebMvcTest(controllers = {CustomerController.class})
public class CustomerControllerTest {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    CustomerService customerService;

    @Test
    public void getFindAllCustomers() throws Exception {

        mockMvc.perform(MockMvcRequestBuilders.get("/customers"))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }
}
```

Der erste Fehler ist die fehlende Klasse CustomerController, wir werden sie sofort hinzufügen. Wie wir unten sehen,
injizieren wir den Kundenservice in den Konstruktor.

Wir fügen eine Get-Methode namens getFindAll() hinzu.

```java
package schwarz.it.lws.spring_boot_tdd.controller;


import schwarz.it.lws.spring_boot_tdd.model.Customer;
import schwarz.it.lws.spring_boot_tdd.service.CustomerService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/customers")
public class CustomerController {

    private CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping
    List<Customer> getFindAll() {
        return customerService.findAll();
    }
}
```

Wir führen den Test erfolgreich durch. Jetzt werden wir überprüfen, ob der Service das gültige Ergebnis erhält, dazu
werden wir die Methode findAll() des Kundendienstes mocken (nachahmen).

```java
package schwarz.it.lws.spring_boot_tdd.controller;

@RunWith(SpringRunner.class)
@WebMvcTest(controllers = {CustomerController.class})
public class CustomerControllerTest {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    CustomerService customerService;

    @Test
    public void getFindAllCustomers() throws Exception {

        when(customerService.findAll()).thenReturn(
                Arrays.asList(
                        new Customer(1L, "John", "Doe"),
                        new Customer(2L, "Jane", "Doe"),
                        new Customer(3L, "Peter", "Pan"),
                        new Customer(4L, "Paul", "Nobody")
                )
        );

        mockMvc.perform(MockMvcRequestBuilders.get("/customers"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.size()").value(4))
                .andExpect(jsonPath("$.[0].firstName").value("John"))
                .andExpect(jsonPath("$.[0].lastName").value("Doe"))
                .andExpect(jsonPath("$.[3].firstName").value("Paul"))
                .andExpect(jsonPath("$.[3].lastName").value("Nobody"));
    }
}
```

Wie du siehst, überprüfen wir das Ergebnis mit MockMvcResultMatchers.jsonPath, das ist eine kontinuierliche Möglichkeit,
JSON-Objekte zu validieren.

Jetzt erstellen wir eine Testmethode, um den Kunden anhand des Vor- und Nachnamens zu ermitteln.

```java
package schwarz.it.lws.spring_boot_tdd.controller;

@RunWith(SpringRunner.class)
@WebMvcTest(controllers = {CustomerController.class})
public class CustomerControllerTest {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    CustomerService customerService;

    //@Test public void getFindAllCustomers() throws Exception {}

    @Test
    public void getUserByFirsnameAndLastname() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/customers/John/Doe"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.size()").value(1))
                .andExpect(jsonPath("$.[0].firstName").value("John"))
                .andExpect(jsonPath("$.[0].lastName").value("Doe"));
    }
}
```

Wir führen den Test aus und der Test wird mit HTTP-Fehler 404 fehlschlagen. Das bedeutet, dass im Rest-Controller kein
Endpunkt für diese Resource vorhanden ist.

Wir werden die fehlende Methode im CustomerController hinzufügen.

```java
package schwarz.it.lws.spring_boot_tdd.controller;


import schwarz.it.lws.spring_boot_tdd.model.Customer;
import schwarz.it.lws.spring_boot_tdd.service.CustomerService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customers")
public class CustomerController {

    private CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    //@GetMapping List<Customer> getFindAll() {}

    @GetMapping(path = {"/{firstName}/{lastName}"})
    List<Customer> getFindByFirstNameAndLastName(
            @PathVariable("firstName") String firstName,
            @PathVariable("lastName") String lastName
    ) {
        return customerService.findByFirstNameAndLastName(firstName, lastName);
    }
}
```   

Wir führen den Test erneut aus und er schlägt fehl, da der CustomerService-Mock nicht implementiert ist. Wir werden eine
Mock-Methode hinzufügen.

```java
package schwarz.it.lws.spring_boot_tdd.controller;

@RunWith(SpringRunner.class)
@WebMvcTest(controllers = {CustomerController.class})
public class CustomerControllerTest {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    CustomerService customerService;

    //@Test public void getFindAllCustomers() throws Exception {}

    @Test
    public void getUserByFirsnameAndLastname() throws Exception {
        String firstName = "John";
        String lastName = "Doe";

        when(customerService.findByFirstNameAndLastName(firstName, lastName)).thenReturn(
                Arrays.asList(
                        new Customer(1L, firstName, lastName)
                )
        );

        mockMvc.perform(MockMvcRequestBuilders.get("/customers/John/Doe"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.size()").value(1))
                .andExpect(jsonPath("$.[0].firstName").value(firstName))
                .andExpect(jsonPath("$.[0].lastName").value(lastName));
    }
}
```

Wir führen die Tests erfolgreich durch.

Jetzt fügen wir einen Test für den restlichen Endpunkt createCustomer hinzu.

```java
package schwarz.it.lws.spring_boot_tdd.controller;

@RunWith(SpringRunner.class)
@WebMvcTest(controllers = {CustomerController.class})
public class CustomerControllerTest {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    CustomerService customerService;

    //@Test public void getFindAllCustomers() throws Exception {}

    //@Test public void getUserByFirsnameAndLastname() throws Exception {}

    @Test
    public void createUser() throws Exception {
        Long id = null;
        String firstName = "John";
        String lastName = "Doe";
        Customer customer = new Customer(id, firstName, lastName);

        when(customerService.createCustomer(customer)).thenReturn(
                new Customer(1L, firstName, lastName)
        );

        mockMvc.perform(post("/customers")
                        .contentType(MediaType.APPLICATION_JSON_UTF8)
                        .accept(MediaType.APPLICATION_JSON_UTF8)
                        .content(objectToJson(customer)))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(1L))
                .andExpect(jsonPath("$.firstName").value(firstName))
                .andExpect(jsonPath("$.lastName").value(lastName));
    }

    private byte[] objectToJson(Object obj) {
        ObjectMapper mapper = new ObjectMapper();
        try {
            return mapper.writeValueAsBytes(obj);
        } catch (JsonProcessingException e) {
            throw new RuntimeException("Failed to map json object");
        }
    }
}
```

Da der Test fehlgeschlagen ist, müssen wir den Restcontroller Endpunkt implementieren.

```Java
package schwarz.it.lws.spring_boot_tdd.controller;

@RestController
@RequestMapping("/customers")
public class CustomerController {

    private CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    //@GetMapping List<Customer> getFindAll() {}

    //@GetMapping(path = {"/{firstName}/{lastName}"}) List<Customer> getFindByFirstNameAndLastName(...)}

    @PostMapping
    public Customer postCustomer(@RequestBody Customer customer) {
        return customerService.createCustomer(customer);
    }
}
```

Test ausführen und alles ist grün.

Der letzte Rest-Endpunkt wird verwendet, um einen Kunden zu löschen.

Wir schreiben den Test für dieses Szenario.

```java
package schwarz.it.lws.spring_boot_tdd.controller;

@RunWith(SpringRunner.class)
@WebMvcTest(controllers = {CustomerController.class})
public class CustomerControllerTest {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    CustomerService customerService;

    //@Test public void getFindAllCustomers() throws Exception {}

    //@Test public void getUserByFirsnameAndLastname() throws Exception {}

    //@Test public void createUser() throws Exception {}

    @Test
    public void deleteCustomer() throws Exception {

        Long id = 1L;
        String firstName = "John";
        String lastName = "Doe";
        Customer customer = new Customer(id, firstName, lastName);

        doNothing().when(customerService).deleteCustomer(customer);

        mockMvc.perform(delete("/customers")
                        .contentType(MediaType.APPLICATION_JSON_UTF8)
                        .accept(MediaType.APPLICATION_JSON_UTF8)
                        .content(objectToJson(customer)))
                .andDo(print())
                .andExpect(status().isOk());

        verify(customerService, times(1)).deleteCustomer(customer);
    }

    private byte[] objectToJson(Object obj) {
        ObjectMapper mapper = new ObjectMapper();
        try {
            return mapper.writeValueAsBytes(obj);
        } catch (JsonProcessingException e) {
            throw new RuntimeException("Failed to map json object");
        }
    }
}
```

Dieser Test schlägt ebenfalls fehl, da es keinen Rest-Endpunkt zum Löschen eines Kunden gibt.

Wir werden diesen fehlenden Teil hinzufügen.

```java
package schwarz.it.lws.spring_boot_tdd.controller;

@RestController
@RequestMapping("/customers")
public class CustomerController {

    private CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    //@GetMappingList<Customer> getFindAll() {}

    //@GetMapping(path = {"/{firstName}/{lastName}"}) List<Customer> getFindByFirstNameAndLastName(...) {}

    //@PostMapping public Customer postCustomer(@RequestBody Customer customer){}

    @DeleteMapping
    public void deleteCustomer(@RequestBody Customer customer) {
        customerService.deleteCustomer(customer);
    }
}
```

Wir führen den Test erfolgreich durch.

### [Inhalt](#inhalt)

Jetzt haben wir eine einfache CRUD-Anwendung, mit Spring Boot testgetrieben entwickelt.

## Fazit

Testgetriebene Entwicklung kann in Verbindung mit Spring Boot dazu beitragen, die Qualität von Anwendungen zu erhöhen,
indem sichergestellt wird, dass Funktionalität ordnungsgemäß implementiert wird. Das Schreiben von Tests vor der
Implementierung von Funktionalität hilft auch, die Entwicklung zu beschleunigen, da Entwickler wissen, ob ihr Code den
Anforderungen entspricht, bevor sie fortfahren. Spring Boot erleichtert die Erstellung von Anwendungen, indem es viele
der manuellen Konfigurationsschritte automatisiert, die sonst erforderlich wären, um eine Anwendung zu erstellen und zu
testen.

### [Inhalt](#inhalt)
