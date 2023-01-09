# GIT Basics

## Grundbegriffe

### Versionskontrollsystem (Version Control System, VCS)

Ein System zur Verwaltung und Versionierung von Software oder anderer digitaler
Informationen. (Git, Subversion, CVS, ...)

### Repository

Das Repository ist eine Datenbank, in der Git die verschiedenen Zustände jeder
Datei eines Projekts über die Zeit hinweg ablegt.

### Commit

Veränderungen am Working Tree, also z.B. modifizierte oder neue Dateien, werden
im Repository als Commits gespeichert.

### HEAD

Eine symbolische Referenz auf den neuesten Commit im aktuellen Branch.

### Index

Der Index ist eine Zwischenstufe zwischen Working Tree und Repository,
in der die Dateien für einen Commit vorbereitet werden.

### Clone

Wenn ein Git-Repository von einem entfernten Server (GitHub, Azure)
herunterladen wird, erzeugt dies einen Klon (Clone) dieses Repositorys.

### Branch

Eine Abzweigung in der Entwicklung. Branches werden in der verwendet,
um beispielsweise neue Features zu entwickeln, Releases vorzubereiten
oder Bugfixes vorzunehmen.

### Main (Master)

Beim Initialisieren eines neuen Repositorys wird der Branch __main__
erstellt.  

### Tag
Tags sind symbolische Namen für schwer zu merkende SHA-1-Summen. Wichtige
Commits, wie z.B. Releases, können mit Tags gekennzeichnet werden.

## Erste Schritte

Damit Git einen Commit einem Autor zuordnen kann, müssen Namen und EMail-Adresse
hinterlegt werden.
Vorher wird der Name des Default-Branches von __master__ auf __main__ geändert.

```shell
# change the default-branch name from master to main
git config --global init.defaultBranch main

git config --global user.name "John Doe"
git config --global user.email "john.doe@home.com"
```

## Ein Repository erstellen

### git init

Bevor mit Git Dateien verwaltet werden können, muß ein Repository für
das Beispiel-Projekt erstellt werden.

```shell
git init lws_development_basics
```

### git status

Git status ist ein wichtiger Befehl, er gibt Informationen über den aktuellen
Status des Repositories zurück.

- Ist alles auf dem neuesten Stand?
- Was ist neu?
- Was hat sich geändert?

Nach dem Wechseln in das Verzeichnis __lws_development_basics__ kann der
aktuelle Status mit __git status__

```shell
cd lws_development_basics
git status
```

### git add

Git kennt das Konzept einer __Staging Area__, sie wie eine leere Leinwand,
die die Änderungen enthält, die du gerne committen (festschreiben) möchtest.

Mit dem Befehl __git add__ werden Dateien hinzugefügt.

```shell
# Add the file README.md to the staging area
git add README.md

# Add all files to the staging area
git add -a
```

### git commit

Ein Commit repräsentiert den Zustand eines Repositorys zu einem bestimmten
Zeitpunkt. Es ist wie ein Schnappschuss, zu dem zurückgegangen werden kann.

Um einen neuen Commit zu erstellen, müssen mindestens eine Änderung im
Staging-Bereich vorliegen (das wurde gerade mit __git add__ gemacht).

```shell
git commit -m "Initial Commit"
```

Der Parameter -m folgt eine Commit-Message, diese beschreibt den Grund für
diesen Commit, wie z.B. "Bugfix ID12345"

## Remote-Repository

### git remote add

Um etwas in ein Remote Repo hochzuladen, muß zuerst eine Verbindung mit
ihm herstellt werden.

Für die Zwecke dieses Tutorials wird die Adresse unseres Repositorys
__<https://github.com/lws/lws_development_basics.git>__ verwendet.

```shell
git remote add origin https://github.com/lws/lws_development_basics.git
```

Ein Projekt kann mehrere Remote-Repositories zur gleichen Zeit haben.
Um sie zu unterscheiden, haben sie verschiedene Namen. In der Praxis wird
das Haupt-Remote-Repository mit dem Wort "origin" (Ursprung) bezeichnet.

### git push

Um lokale Commits auf den Remote-Server zu übertragen kommt der Befehl __git push__
zu Einsatz. Dieser Prozess wird Push genannt und wird jedes Mal durchgeführt,
wenn das Remote-Repository aktualisiert werden soll.

```shell
git push origin main
```

### git pull

Wenn Updates in Remote-Repository gemacht wurden, können die Änderungen mit
einem einzigen Befehl __git pull__ heruntergeladen werden.

```shell
git pull origin main
```

### git clone

Mit __git clone__ wird eine voll funktionsfähige lokale Kopie eines Remote-Repositories
erstellt.

```shell
git clone https://github.com/lws/lws_development_basics.git
```

## Branches

Wenn man neue Feature entwickelt, oder Bugfixes erstellt werden, ist es gute Praxis,
an einer Kopie des Originalprojekts zu arbeiten, die als Branch bezeichnet wird.
Branches haben ihre eigene Historie und isolieren ihre Änderungen voneinander,
bis man sie wieder zusammenführt.

### git branch

Der Default-Branch jedes Repositorys heißt __main__ (früher master). Um zusätzliche
Branches zu erstellen, wird __git branch__ verwendet.

```shell
git branch feature/config_api 
```

### git checkout

Um auf den neu erstellen Branch "feature/config_api" zu wechseln, kommt der Befehl
__git checkout__ zur Anwendung, wobei ein Parameter erwartet wird, der Branch-Name.

```shell
git checkout feature/config_api 
```

### git merge

Das neue Feature (feature/config_api) ist erstellt und mit einem Commit in das lokale
Repository eingefügt worden.

```shell
git add .
git commit -m 'config_api implemented'
```

Das neue Feature ist komplett, wir können zurück zum Master-Branch wechseln.

```shell
git checkout main
```

Nach dem Checkout sind alle Dateien des "feature/config_api" Branches verschwunden,
keine Angst, nach dem Mergen des "feature/config_api" Branch in den "main" branch
sind sie wieder zu sehen.

```shell
git merge feature/config_api
```

### Commits prüfen

Jeder Commit hat eine eindeutige ID in Form einer Reihe von Zahlen und
Symbolen (SHA). Um eine Liste aller Commits und ihrer IDs zu sehen,
wird __git log__ benutzt.

```shell
git log
```

### git stash

Während der Arbeit an einer bestimmten Funktion eines Projekts, ist es oft so,
dass der Branch gewechselt werden muss, um an etwas anderem weiterzuarbeiten.
Meist ist dann auch das Arbeitsverzeichnis in einem chaotischen Zustand, der
nicht mit einem Commit in das lokale Repository übernommen werden soll.

```shell
git stash
```
