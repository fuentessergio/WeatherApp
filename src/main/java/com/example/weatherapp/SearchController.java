package com.example.weatherapp;

import exceptions.WeatherControllerException;
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

    private MainController mainController;

    private Stage searchStage;

    @FXML
    protected void onSearchButtonClick() throws WeatherControllerException, IOException {
        String ciudadStr = ciudad.getText();
        if(mainController !=null){
            mainController.handleSearchButtonClick(ciudadStr);
        }
        // Cierra la ventana de búsqueda
        closeSearchStage();
    }

    public void setMainController(MainController mainController) {
        this.mainController = mainController;
    }

    public void closeSearchStage() {
        if(searchStage !=null) {
            searchStage.close();
        }
    }
    public void setSearchStage (Stage searchStage){
        this.searchStage = searchStage;
    }
    public Stage getSearchStage() {
        return searchStage;
    }
}
