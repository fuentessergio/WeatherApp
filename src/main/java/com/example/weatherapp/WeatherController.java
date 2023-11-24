package com.example.weatherapp;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;

public class WeatherController {
    @FXML
    private Label ciudadLabel;

    private Stage weatherStage;


    public void initialize(String ciudadStr) {
            ciudadLabel.setText("El tiempo en " + ciudadStr);
        }

        public void showWeather(String ciudadStr) {
            // Puedes agregar lógica para mostrar la ventana aquí si es necesario
            if(weatherStage != null){
                weatherStage.show();
            }
        }

        public WeatherController()  throws IOException {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("weatherwindow.fxml"));
            loader.setController(this);
            Parent root = loader.load();

            // Configurar la hoja de estilos después de cargar el FXML
            Scene scene = new Scene(root, 300, 300);
            scene.getStylesheets().add(getClass().getResource("style.css").toExternalForm());

            this.weatherStage = new Stage();
            this.weatherStage.setScene(scene);
        }

            public Stage getWeatherStage () {
                return weatherStage;
            }

            public Parent getView () {
                return ciudadLabel.getParent();
            }
}

