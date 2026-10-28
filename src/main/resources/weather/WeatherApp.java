package edu.example.weather;
import edu.example.weather.ui.WeatherDashboardView;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
public class WeatherApp extends Application {
 public void start(Stage stage){stage.setScene(new Scene(new WeatherDashboardView(),900,600));stage.setTitle("Weather Dashboard");stage.show();}
 public static void main(String[] args){launch(args);} }
