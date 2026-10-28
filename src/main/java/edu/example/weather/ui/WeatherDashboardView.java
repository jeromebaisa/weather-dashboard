package edu.example.weather.ui;

import edu.example.weather.model.WeatherData;
import edu.example.weather.service.WeatherService;
import org.apache.commons.lang3.StringUtils;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.io.IOException;

public class WeatherDashboardView extends BorderPane {

    private final WeatherService service = new WeatherService();

    private final ComboBox<String> cityPicker = new ComboBox<>();

    private final Label cityLabel = new Label();
    private final Label temperatureLabel = new Label();
    private final Label conditionLabel = new Label();
    private final Label humidityLabel = new Label();

    public WeatherDashboardView() {

        setPadding(new Insets(25));
        setStyle("-fx-background-color: #eef5fc;");

        Label title = new Label("Weather Dashboard");
        title.setStyle(
            "-fx-font-size: 30px; -fx-font-weight: bold;"
        );

        cityPicker.getItems().addAll(service.getCities());
        cityPicker.setValue("Seattle");

        Button refreshButton = new Button("Refresh Weather");

        refreshButton.setOnAction(event -> loadWeather());
        cityPicker.setOnAction(event -> loadWeather());

        HBox controls = new HBox(15, cityPicker, refreshButton);
        controls.setAlignment(Pos.CENTER);

        VBox header = new VBox(20, title, controls);
        header.setAlignment(Pos.CENTER);

        setTop(header);

        temperatureLabel.setStyle(
            "-fx-font-size: 55px; -fx-font-weight: bold;"
        );

        cityLabel.setStyle("-fx-font-size: 24px;");
        conditionLabel.setStyle("-fx-font-size: 20px;");
        humidityLabel.setStyle("-fx-font-size: 18px;");

        VBox weatherDisplay = new VBox(
            15,
            cityLabel,
            temperatureLabel,
            conditionLabel,
            humidityLabel
        );

        weatherDisplay.setAlignment(Pos.CENTER);
        setCenter(weatherDisplay);

        loadWeather();
    }

    
private void loadWeather() {

    try {
        WeatherData data = service.load(cityPicker.getValue());

        cityLabel.setText(data.city);
        temperatureLabel.setText(data.temperature + "°F");

        String formattedCondition = StringUtils.capitalize(
            StringUtils.lowerCase(StringUtils.trimToEmpty(data.condition))
        );

        conditionLabel.setText("Condition: " + formattedCondition);
        humidityLabel.setText("Humidity: " + data.humidity + "%");

    } catch (IOException | IllegalArgumentException e) {

        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Weather Error");
        alert.setHeaderText("Unable to load weather data");
        alert.setContentText(e.getMessage());
        alert.showAndWait();
    }
}
}