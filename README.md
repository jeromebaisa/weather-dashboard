# Weather Dashboard

A simple JavaFX application that displays sample weather information for Seattle, Redmond, and Bellevue.

## Features

- Select a city to view its weather.
- Display temperature, humidity, and conditions.
- Refresh weather information.

## Technologies

- Java 21 and JavaFX
- Gradle
- Jackson for reading JSON files
- Apache Commons Lang for formatting weather conditions using `StringUtils`

## How to Run

Build the project:

```bash
make build
```

Run the application:

```bash
make run
```

Create the fat JAR:

```bash
make jar
```

Run the JAR:

```bash
java -jar build/libs/weather-dashboard-all.jar
```

Copy the JAR to your Desktop:

```bash
cp build/libs/weather-dashboard-all.jar ~/Desktop/
```

Clean the project:

```bash
make clean
```

## GitHub Actions

GitHub Actions builds and tests the project using Java 21 when a pull request targets `main`. It also uploads the fat JAR as an artifact.

## Weather Data

The app uses sample JSON files stored in `src/main/resources/weather/`. It does not fetch live weather.