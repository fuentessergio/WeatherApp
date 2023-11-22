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
    private Stage searchStage;
    private MainController mainController;


    @FXML
    protected void onSearchButtonClick() {
        String ciudadStr = ciudad.getText();
        // HelloApplication.showWeatherView(ciudadStr);
        helloApplication.getMainController().onSearchButtonClick(ciudadStr);

        //Cierra la ventana de búsqueda
        searchStage.close();
    }

    public void onSearchButtonClick (String ciudadStr){

    }

    public void setHelloApplication(HelloApplication helloApplication, Stage searchStage, MainController mainController) {
        this.helloApplication = helloApplication;
        this.searchStage = searchStage;
        this.mainController = mainController;


    }
}