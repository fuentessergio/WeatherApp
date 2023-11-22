package com.example.weatherapp;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class SearchController {
    @FXML
    private TextField ciudad;

    private HelloApplication helloApplication;

    @FXML
    protected void onSearchButtonClick() {
        String ciudadStr = ciudad.getText();
        HelloApplication.showWeatherView(ciudadStr);

        //Cierra la ventana de búsqueda
        ((Stage) ciudad.getScene().getWindow()).close();
    }

    public void setHelloApplication(HelloApplication helloApplication) {
        this.helloApplication = helloApplication;
    }
}