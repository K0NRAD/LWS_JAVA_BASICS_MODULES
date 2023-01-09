## __Konventionelle Commit Message__

Konventionelle Commit Messages, ist ein von der Industrie befolgter Standard, der die automatische Versionierung und Dokumentation der Release Changes vereinfacht.

### __Semantic Versioning__

Bevor wir uns die Konventionellen Commit Messages anschauen, werfen wir einen Blick auf das Semantic Versioning, die Basis zum Bilden von Versions-Bezeichnern.
Eine typische Versions-Bezeichnung sieht folgendermaßen aus.

```text
<MAJOR>.<MINOR>.<PATCH>.[<BUILD>]
```

- __MAJOR__ wird erhöht, wenn API-inkompatible Änderungen veröffentlicht werden.
- __MINOR__ wird erhöht, wenn neue Funktionalitäten, welche kompatibel zur bisherigen API sind, veröffentlicht werden.
- __PATCH__ wird erhöht, wenn die Änderungen ausschließlich API-kompatible Bugfixes umfassen.
- __BUILD__ sind Build-Metadaten, z.B. Kennzeichnung für Daily-Builds  oder EAP-Builds. Der BUILD Versions-Bezeichner ist optional.

### __Konventionelle Commit Message__

Eine typische Git Konventionelle Commit Message sieht so aus:

```shell
<TYPE>(<SCOPE>): <SUBJECT>
```

### __TYPE__  muss einer der folgenden sein

- __build__: Build-bezogene Änderungen (z. B.: npm-bezogen/Hinzufügen externer Abhängigkeiten)
- __chore__: Eine Codeänderung, die externe Benutzer nicht sehen (z. B.: Änderung an .gitignore-Datei oder .prettierrc-Datei)
- __feat__: Eine neue Funktion. Die Abwärts-Kompatibilität zur Vorgängerversion ist gewährleistet, es erhöht sich die Minor Version.
- __fix__: Eine Fehlerbehebung. Die Abwärts-Kompatibilität zur Vorgängerversion ist gewährleistet, es erhöht sich die Patch Version
- __docs__: Dokumentationsbezogene Änderungen
- __refactor__: Ein Code, der weder einen Fehler behebt noch ein Feature hinzufügt. (z.B. wenn es semantische Änderungen wie das Umbenennen eines Variablen- / Funktionsnamens gibt)
- __perf__: Ein Code, der die Leistung verbessert
- __style__: Ein Code, der sich auf das Styling bezieht
- __test__: Einen neuen Test hinzufügen oder einen bestehenden Test ändern

### __SCOPE__ ist optional

Scope muss ein Substantiv sein und repräsentiert einen Abschnitt der Codebasis.

### __SUBJECT__ ist das Thema des Commits

- Verwende den Imperativ, Präsens (z. B.: __add__ anstelle von added oder adds).
- Verwende keinen Punkt (.) am Ende.
- Anfangsbuchstaben werden nicht groß geschrieben.

### __!__ breaking Changes

Ein Ausrufezeichen (!) vor dem Doppelpunkt zeigt an, dass der Commit Änderungen enthält, die nicht kompatibel zur Vorgängerversion sind.
In deiesem Fall würde sich die Major Version erhöhen.
