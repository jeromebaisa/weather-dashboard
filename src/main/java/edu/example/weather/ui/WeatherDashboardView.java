package edu.example.weather.ui;
import javafx.geometry.*;import javafx.scene.control.*;import javafx.scene.layout.*;
public class WeatherDashboardView extends BorderPane {
 public WeatherDashboardView(){setPadding(new Insets(20));Label t=new Label("Weather Dashboard");t.setStyle("-fx-font-size:28;");ComboBox<String> c=new ComboBox<>();c.getItems().addAll("Seattle","Redmond","Bellevue");c.setValue("Seattle");VBox center=new VBox(10,new Label("72°F"),new Label("Rain"),new Label("TODO: Implement WeatherService"));center.setAlignment(Pos.CENTER);setTop(new VBox(t,c));setCenter(center);} }
