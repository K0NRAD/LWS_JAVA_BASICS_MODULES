# Spring Boot Annotations

| Annotation             | Beschreibung                                                                                                                                                                                      |
|------------------------|---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| @SpringBootApplication | Diese Annotation kennzeichnet die Hauptklasse einer Spring Boot-Anwendung. Sie ist eine Kombination aus drei Annotations: @SpringBootConfiguration, @EnableAutoConfiguration, und @ComponentScan. |
| @Configuration         | Diese Annotation kennzeichnet eine Klasse als Spring-Konfigurationsklasse. Die Klasse enthält Anweisungen zum Konfigurieren von Beans für die Anwendung.                                          |
| @Bean                  | Diese Annotation wird verwendet, um eine Methode als Bean-Definition zu kennzeichnen. Die Methode gibt eine neue Bean-Instanz zurück, die von Spring verwaltet wird.                              |
| @ComponentScan         | Diese Annotation wird verwendet, um anzugeben, dass Spring nach anderen Komponenten, Konfigurationsklassen und Services in einem bestimmten Paket oder seinen Unterpaketen suchen soll.           |
| @Autowired             | Diese Annotation wird verwendet, um anzugeben, dass eine Bean-Eigenschaft automatisch von Spring injiziert werden soll.                                                                           |
| @Service               | Diese Annotation wird verwendet, um eine Klasse als Business-Service-Klasse zu kennzeichnen. Die Klasse enthält die Geschäftslogik der Anwendung.                                                 |
| @Controller            | Diese Annotation wird verwendet, um eine Klasse als Spring MVC-Controller-Klasse zu kennzeichnen. Die Klasse verarbeitet HTTP-Anforderungen und gibt die entsprechende Antwort zurück.            |
| @RequestMapping        | Diese Annotation wird verwendet, um eine Methode oder eine Klasse als Behandlung von HTTP-Anforderungen für eine bestimmte URI zu kennzeichnen.                                                   |
| @ResponseBody          | Diese Annotation wird verwendet, um anzugeben, dass der Rückgabewert einer Methode als HTTP-Antwortkörper verwendet werden soll.                                                                  |
| @RestController        | Diese Annotation ist eine Kombination aus @Controller und @ResponseBody. Sie wird verwendet, um eine Klasse als RESTful-Controller-Klasse zu kennzeichnen, die direkt HTTP-Antworten zurückgibt.  |
| @Repository            | Diese Annotation wird verwendet, um eine Klasse als Datenbank-Zugriffsklasse zu kennzeichnen. Die Klasse enthält Methoden zum Zugriff auf Daten aus einer Datenbank.                              |
| @Entity                | Diese Annotation wird verwendet, um eine Klasse als JPA-Entitätsklasse zu kennzeichnen. Die Klasse stellt eine Tabelle in der Datenbank dar.                                                      |
| @Id                    | Diese Annotation wird verwendet, um die primäre Schlüsselspalte einer JPA-Entitätsklasse zu kennzeichnen.                                                                                         |
| @OneToMany             | Diese Annotation wird verwendet, um eine Eins-zu-Viele-Beziehung zwischen zwei JPA-Entitäten zu kennzeichnen.                                                                                     |
| @ManyToOne             | Diese Annotation wird verwendet, um eine Viele-zu-Eins-Beziehung zwischen zwei JPA-Entitäten zu kennzeichnen.                                                                                     |
| @Lazy                  | Diese Annotation wird verwendet, um anzugeben, dass die Initialisierung einer Bean verzögert werden soll, bis sie tatsächlich verwendet wird.                                                     |
| @Primary               | Diese Annotation wird verwendet, um anzugeben, dass eine Bean als primäre Bean für einen bestimmten Typ betrachtet werden soll.                                                                   |
| @Qualifier             | Diese Annotation wird verwendet, um eine Bean für Autowiring mit einem bestimmten Namen zu kennzeichnen.                                                                                          |
| @Scheduled             | Diese Annotation wird verwendet, um anzugeben, dass eine Methode zu einem festgelegten Zeitpunkt aufgerufen werden soll.                                                                          |
| @Async                 | Diese Annotation wird verwendet, um anzugeben, dass eine Methode asynchron ausgeführt werden soll.                                                                                                |

--- 

### [Inhalt](../README.md)
