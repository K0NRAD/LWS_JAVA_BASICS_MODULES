package schwarz.it.lws.java._002_001_oop.tasks.csv_extractor;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

/*
Task: CSV Extractor

    Schreibe einen CSV Extraktor mit selbstdefinierten Generics.

Todo:

    - Es werden zwei Annotation-Interfaces benötigt, vervollständige die Annotations.
      für CsvTable und Csv
        @CsvTable   - Wird an der Klasse angebracht und hat ein Attribut:
                        `quote` - bestimmt ob die CSV Werte in Quotes gestellt wird ("John";"Doe")
        
        @CsvColumn  - Wird an den Attributen der Klasse angebracht und hat ein Attribut:
                        `name` - CSV Column Name, ist name != "" wird name als Column-Name
                                 verwendet, ansonsten der Name des des Klassen-Attributs.


    - Ergänze die Model-Klassen (Domain-Klassen) um die fehlenden Annotations. Zum Vereinfachen
      des Codes wurde das Lombok Framework verwendet, zu diesem gehören die Annotations 
      @Getter,@Setter und @Builder. Diese Annotations brauchst du nicht weiter beachten.
     
    - Erstelle eine Methode mit dem Namen `getAsCsv`, die eine Liste eines beliebigen 
      Types entgegennimmt und die Daten als CSV-String zurückgibt.
      Das Grundgerüst der Methode ist bereits mit der erforderlichen Signatur erstelle
      und muss von dir noch mit Leben gefüllt werden.

Beispiel 1:

  @CsvTable
  class User {
       @CsvColumn
       private Long id;
       @CsvColumn
       private String firstName;
       @CsvColumn
       private String lastName;
       @CsvColumn
       private String email;
  }

  Input:
      List<User> users = List.of(
          User.builder().id(1001L).firstName("John1").lastName("Doe1").email("john1.doe1@home.com").build(),
          User.builder().id(1002L).firstName("John2").lastName("Doe2").email("john2.doe2@home.com").build(),
          User.builder().id(1003L).firstName("John3").lastName("Doe3").email("john3.doe3@home.com").build(),
          User.builder().id(1004L).firstName("John4").lastName("Doe4").email("john4.doe4@home.com").build());

  Output:
       id;firstName;lastName;email
       1001;John1;Doe1;john1.doe1@home.com
       1002;John2;Doe2;john2.doe2@home.com
       1003;John3;Doe3;john3.doe3@home.com
       1004;John4;Doe4;john4.doe4@home.com

 Beispiel 2:

  @CsvTable(quote=true)
  class Car {
      @CsvColumn
      private Long id;
      @CsvColumn
      private String name;
      @CsvColumn
      private String brand;
      @CsvColumn
      private Double price;
  }

  Input:
      List<Car> cars = List.of();
          Car.builder().id(2001L).name("Audi A4").brand("Audi").price(40000.0).build(),);
          Car.builder().id(2002L).name("Astra").brand("Opel").price(30000.0).build(),);
          Car.builder().id(2003L).name("X5").brand("BMW").price(50000.0).build(),);
          Car.builder().id(2004L).name("EQE").brand("Mercedes-Benz").price(60000.0).build());

  Output:
       "id";"name";"brand";"price"
       "2001";"Audi A4";"Audi";"40000.0"
       "2002";"Astra";"Opel";"30000.0"
       "2003";"X5";"BMW";"50000.0"
       "2004";"EQE";"Mercedes-Benz";"60000.0"

Beispiel 3:

  @CsvTable(quote=true)
  class Store {
      @CsvColumn(name = "storenr")
      private Long id;
      @CsvColumn
      private String name;
      @CsvColumn
      private String city;
      @CsvColumn
      private String street;
      @CsvColumn(name = "qm")
      private Integer size;
  }

  Input:
      List<Store> stores = List.of(
          Store.builder().id(6001L).name("Store 6001").city("Hauptstadt").street("Hauptstr. 1").size(1200).build(),
          Store.builder().id(6002L).name("Store 6002").city("Hauptstadt").street("Hauptstr. 2").size(1300).build(),
          Store.builder().id(6003L).name("Store 6003").city("Hauptstadt").street("Hauptstr. 3").size(1400).build(),
          Store.builder().id(6004L).name("Store 6004").city("Hauptstadt").street("Hauptstr. 4").size(1500).build());

  Outout:
      "storenr";"name";"city";"street";"qm"
      "6001";"Store 6001";"Hauptstadt";"Hauptstr. 1";"1200"
      "6002";"Store 6002";"Hauptstadt";"Hauptstr. 2";"1300"
      "6003";"Store 6003";"Hauptstadt";"Hauptstr. 3";"1400"
      "6004";"Store 6004";"Hauptstadt";"Hauptstr. 4";"1500"

Bearbeitungszeit:

    120 Minuten
*/


// = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = =
// Annotaion Interfaces

@interface CsvTable {
}

@interface CsvColumn {
}

// = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = =
// Domain Klassen (Model)
@Getter
@Setter
@Builder
class User {
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
}

@Getter
@Setter
@Builder
class Car {
    private Long id;
    private String name;
    private String brand;
    private Double price;
}

@Getter
@Setter
@Builder
class Store {
    private Long id;
    private String name;
    private String city;
    private String street;
    private Integer size;
}


public class CsvExtractor {

    /**
     * 
     * @param objects   - Liste mit beliebigen Objekten
     * @return          - CSV-String der übergebenen Objektliste
     * @param <T>       - generischer Datentyp der Objektliste
     * @throws IllegalAccessException 
     */
    public <T> String getAsCsv(List<T> objects) throws IllegalAccessException {
        return "";
    }
}

// = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = =
// Don't change the JUnit test code.

class CsvExtractorTest {
    CsvExtractor csvExtractor;

    @BeforeEach
    public void setup() {
        csvExtractor = new CsvExtractor();
    }

    @Test
    public void extractCsvDataFromUserList() throws IllegalAccessException {
        // given
        List<User> users = List.of(
                User.builder().id(1001L).firstName("John1").lastName("Doe1").email("john1.doe1@home.com").build(),
                User.builder().id(1002L).firstName("John2").lastName("Doe2").email("john2.doe2@home.com").build(),
                User.builder().id(1003L).firstName("John3").lastName("Doe3").email("john3.doe3@home.com").build(),
                User.builder().id(1004L).firstName("John4").lastName("Doe4").email("john4.doe4@home.com").build()
        );

        // when
        String csv = csvExtractor.getAsCsv(users);

        // then
        String expected = """
                id;firstName;lastName;email
                1001;John1;Doe1;john1.doe1@home.com
                1002;John2;Doe2;john2.doe2@home.com
                1003;John3;Doe3;john3.doe3@home.com
                1004;John4;Doe4;john4.doe4@home.com""";

        assertThat(csv).isEqualTo(expected);
    }

    @Test
    void extractCsvDataFromListOfCars() throws IllegalAccessException {
        // given
        List<Car> cars = List.of(
                Car.builder().id(2001L).name("Audi A4").brand("Audi").price(40000.0).build(),
                Car.builder().id(2002L).name("Astra").brand("Opel").price(30000.0).build(),
                Car.builder().id(2003L).name("X5").brand("BMW").price(50000.0).build(),
                Car.builder().id(2004L).name("EQE").brand("Mercedes-Benz").price(60000.0).build()
        );

        // when
        String csv = csvExtractor.getAsCsv(cars);

        // then
        String expected = """
                "id";"name";"brand";"price"
                "2001";"Audi A4";"Audi";"40000.0"
                "2002";"Astra";"Opel";"30000.0"
                "2003";"X5";"BMW";"50000.0"
                "2004";"EQE";"Mercedes-Benz";"60000.0\"""";

        assertThat(csv).isEqualTo(expected);
    }

    @Test
    void extractCsvDataFromListOfStores() throws IllegalAccessException {
        // given
        List<Store> stores = List.of(
                Store.builder().id(6001L).name("Store 6001").city("Hauptstadt").street("Hauptstr. 1").size(1200).build(),
                Store.builder().id(6002L).name("Store 6002").city("Hauptstadt").street("Hauptstr. 2").size(1300).build(),
                Store.builder().id(6003L).name("Store 6003").city("Hauptstadt").street("Hauptstr. 3").size(1400).build(),
                Store.builder().id(6004L).name("Store 6004").city("Hauptstadt").street("Hauptstr. 4").size(1500).build()
        );

        // when
        String csv = csvExtractor.getAsCsv(stores);

        // then
        String expected = """
                "storenr";"name";"city";"street";"qm"
                "6001";"Store 6001";"Hauptstadt";"Hauptstr. 1";"1200"
                "6002";"Store 6002";"Hauptstadt";"Hauptstr. 2";"1300"
                "6003";"Store 6003";"Hauptstadt";"Hauptstr. 3";"1400"
                "6004";"Store 6004";"Hauptstadt";"Hauptstr. 4";"1500\"""";

        assertThat(csv).isEqualTo(expected);
    }
}