package schwarz.it.lws.java._002_001_oop.tasks.wearher_forecast;

/*
Task: Weather App

    Die Aufgabe besteht darin, eine Konsolen-Anwendung zu erstellen, die die Wettervorhersage
    für einen beliebigen Ort anzeigt. Die Wetterdaten werden von der Website https://openweathermap.org
    abgerufen und müssen mithilfe einer API-Methode abgerufen werden.
    Ein API-Key, der nach einer kostenlosen Registrierung auf der Homepage von OpenWeatherMap generiert
    werden kann, ist erforderlich.

    Für diese Lerneinheit kann der folgenden Key verwendet werden:

        API_KEY = "b64102f327b1ea647b1c8e508bafac87"

    Das Programm soll die Wetter-Vorhersagen-App aus der vorherigen Lerneinheit entsprechend
    dem MVC Pattern und den SOLID Prinzipien umgestalten.

Todo:

    Das Ziel des Programms ist es, eine Konsolen-Anwendung in Java zu entwickeln, die über die Konsole
    die Eingabe des Ortes für die Wettervorhersage anfordert.
    Mit der Ortsangabe und den weiteren erforderlichen Parametern wird ein URL erzeugt, um die
    API-Methode von OpenWeatherMap abzurufen.
    Der HttpClient aus dem Java Package java.net.http wird als HTTP-Client verwendet.
    Der Payload mit den Wetterdaten wird aus dem Response des API-Aufrufs extrahiert und mithilfe
    der JSON Bibliothek org.json:json:20210307 geparst.
    Die Wetterdaten werden dann in der Konsole angezeigt und die Eingabeaufforderung für den Ort
    wird erneut angezeigt.
    Mit Eingabe von Q oder X anstatt eines Ortsnamens wird die Anwendung beendet.
    Im Falle von Eingabe eines falschen Ortes oder Nicht-Erreichbarkeit des OpenWeatherMap Services
    werden entsprechende Fehlermeldungen angezeigt.

    Das Programm sollte den Regeln des MVC Patterns folgen und die S.O.L.I.D Prinzipien berücksichtigen.

    Die Wettervorhersage für die nächsten drei Tage für den angegebenen Ort, angezeigt in der Konsole.
    Im Falle von Eingabe eines falschen Ortes oder Nicht-Erreichbarkeit des OpenWeatherMap Services,
    entsprechende Fehlermeldungen in der Konsole.

Beispiele

    Input (in der Konsole):
        "Bad Friedrichshall"

    Output (in der Konsole):
        Das Wetter für den 14.04.2022 ist mäßig bewölkt bei 17,3°C
        Das Wetter für den 15.04.2022 ist leichter Regen bei 19,8°C
        Das Wetter für den 16.04.2022 ist bedeckt bei 20,9°C

Bearbeitungszeit:

    180 Minuten
*/

public class WeatherApp {

    public static void main(String[] args) {

    }
}
