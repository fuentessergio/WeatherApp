package com.example.weatherapp;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class WeatherController {

    @FXML
    private Label ciudadLabel;

    public WeatherController(){

    }
    public WeatherController(String ciudadStr) {
        ciudadLabel.setText("El tiempo en " + ciudadStr);
    }

    public void initialize(String ciudadStr){
        ciudadLabel.setText("El tiempo en " + ciudadStr);
    }
}
