package schwarz.it.lws.java._002_001_oop.tasks.article_manager;
/*
Aufgabenstellung:

    Deine Aufgabe ist es, eine Anwendung zu entwickeln, die Artikel verwaltet. Die Anwendung
    soll dem Benutzer ermöglichen, Artikel hinzuzufügen, zu aktualisieren, zu löschen, zu
    suchen und aufzulisten.
    Der Benutzer soll auswählen können, ob er einen Artikel über seine ID oder seinen EAN-Code
    suchen möchte.
    Wenn der Benutzer einen Artikel aktualisiert, soll er die Möglichkeit haben, bestimmte
    Eigenschaften des Artikels zu ändern, indem er diese Eingaben leer lässt.
    Die Anwendung soll auch eine Eingabeprüfung implementieren, um sicherzustellen, dass der
    Benutzer gültige Eingaben macht, z.B. keine negativen Preise oder ungültige Steuerkennzeichen.
    Die Anwendung soll auch ein Exception-Handling-Mechanismus implementieren, um sicherzustellen,
    dass die Anwendung ordnungsgemäß funktioniert, wenn der Benutzer versucht, einen Artikel
    mit einer ID oder einem EAN-Code zu suchen, der nicht in der Datenbank vorhanden ist.

Anforderungen:

    Erstelle eine Klasse Article mit den Attributen id, name, description, price, taxId und eans.
    taxId sollte ein Enum mit den Werten A, B, C und NONE sein. eans sollte eine Liste von
    EAN-Codes enthalten.

    Erstelle eine Klasse ArticleService, die Methoden enthält, um Artikel hinzuzufügen,
    aufzulisten, zu aktualisieren, zu suchen und zu löschen. Du solltest auch eine Möglichkeit
    implementieren, um Artikel über ihre ID und EAN-Codes zu suchen.

    Erstelle eine Klasse ArticleController, die die Benutzerinteraktion verwaltet.
    Der ArticleController sollte eine Endlosschleife enthalten, die dem Benutzer mögliche
    Aktionen anzeigt und dann die entsprechenden Methoden des ArticleService aufruft, um die
    Aktionen auszuführen.

    Erstelle eine main-Methode in der Klasse ArtikelManager, die eine Instanz des ArticleService
    erstellt und diese an eine Instanz des ArticleController übergibt. Rufe anschließend die
    run-Methode des ArticleController auf,

Bearbeitungszeit:

    120 Minuten
 */

import schwarz.it.lws.java._002_001_oop.tasks.article_manager.controller.ArticleController;
import schwarz.it.lws.java._002_001_oop.tasks.article_manager.service.ArticleService;

public class ArtikelManager {
    public static void main(String[] args) {
    }
}





