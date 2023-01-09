package schwarz.it.lws.java._001_009_arrays_and_collections.tasks;

/*
Task: Wettervorhersage

    Maria sucht einen Programmierer, um ihr bei der Entwicklung ihres Wettervorhersage-Programms
    zu helfen. Sie hatte die Idee, eine Klasse namens "WeatherForecast" zu erstellen, in der eine
    URL und einen API-Schlüssel für den Zugriff auf die Wetterdaten von OpenWeatherMap verwendet
    werden soll.

    In einer Schleife wird der Benutzer auffordert, einen Ort einzugeben. Wenn der Benutzer "exit",
    "e", "q" oder "quit" eingab, soll das Programm beendet werden.

    Du rätst ihr den HttpClient aus dem Java-Package "java.net.http" zu verwenden, um eine
    HTTP-Anfrage an die Wetter-API zu senden und eine Antwort zu erhalten. Ich verarbeitete dann
    die Antwort, indem ich das Wetter und die Temperatur aus dem Payload extrahierte.

    Zuletzt soll die Wettervorhersage für den angegebenen Ort auf dem Bildschirm ausgegeben werden.

    Und jetzt ran an die Arbeit, erstelle die Weather-Forecasts App, eine Konsolen-Anwendung mit
    der die Wettervorhersage des aktuellen Tages, für einen beliebigen Ort angezeigt werden kann.

Vorbedingungen:

    Die Wetterdaten bezieht die Applikation von https://openweathermap.org. Dafür ist ein
    API-Key erforderlich, dieser kann auf der Homepage von OpenWeatherMap, nach einer
    kostenfreien Registrierung, generiert werden.
    Für diese Lerneinheit kann der folgenden Key von mir verwendet werden:
    API_KEY = "b64102f327b1ea647b1c8e508bafac87"

    Schaue dir die API-Dokumentation an und suche dir die passende API-Methode aus, mit der du
    die Daten für die Wettervorhersage eines beliebigen Ortes für die nächsten drei Tage erhältst.

Anforderungen:

    Erstelle ein Java-Konsolenprogramm, das folgende Schritte ausführt:

    Frage den Benutzer nach dem Ort, für den er die Wettervorhersage wünscht.

    Erstelle mit Hilfe der Ortsangabe und weiterer notwendiger Parameter eine URL, um eine
    Wettervorhersage von der OpenWeatherMap API abzurufen. Verwende dazu den HttpClient aus
    dem Java-Package "java.net.http".

    Extrahiere aus dem Response der API-Anfrage den Payload mit den Wetterdaten. Verwende dazu
    die JSON-Bibliothek "org.json:json:20210307".

    Parse die Wetterdaten im JSON-Format und erstelle aus ihnen die Ausgabe:
        "Das Wetter in <ORT> ist <WETTER> bei <TEMPERATUR>".

    Zeige nach der Ausgabe erneut die Eingabeaufforderung für den Ort an. Beende das Programm,
    wenn der Benutzer "Q" oder "X" eingibt anstatt eines Ortsnamens.

    Wenn der Benutzer einen falschen Ort eingibt oder der OpenWeatherMap Service nicht erreichbar
    ist, gib entsprechende Fehlermeldungen aus.

Stolperfallen:

    Achte darauf, dass auch Umlaute wie *ä,ö,ü,ß* korrekt behandelt werden, auch Ortsnamen, die aus
    mehr als einem Wort (z.B. Schwäbisch Hall) bestehen müssen korrekt behandelt werden.

Bearbeitungszeit:

    120 Minuten
*/

public class WeatherForecast {

    public static void main(String[] args) {

    }
}
