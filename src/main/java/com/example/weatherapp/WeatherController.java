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

    public WeatherController(){

    }
    public void initialize(String ciudadStr) {
        ciudadLabel.setText("El tiempo en " + ciudadStr);
    }

    public void showWeather(String ciudadStr){
        //logica para mostrar la ventana
    }
    public static WeatherController create(String ciudadStr) throws IOException {
        FXMLLoader loader = new FXMLLoader(WeatherController.class.getResource("weatherwindow.fxml"));
        Parent root = loader.load();
        WeatherController weatherController = loader.getController();
        weatherController.initialize(ciudadStr);
        return weatherController;
    }
    public Parent getView(){
        return ciudadLabel.getParent();
    }
}
