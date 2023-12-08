package com.example.weatherapp;

import exceptions.WeatherControllerException;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;

public class WeatherController {
    private MainController mainController;
    @FXML
    private Label ciudadLabel;

    private Stage weatherStage;
    @FXML
    private Button backButton;


    public void initialize(String ciudadStr) {
        if (ciudadLabel!=null){
            ciudadLabel.setText(ciudadStr);
        }
        if(backButton != null){
            backButton.setOnAction(event -> onBackButtonClick());
        }
    }

    public void showWeather(String ciudadStr) {
        if(weatherStage != null){
            weatherStage.show();
        }
    }
    public WeatherController(){

    }


    public WeatherController(MainController mainController) throws WeatherControllerException {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("weatherwindow.fxml"));
            loader.setController(this);
            Parent root = loader.load();

            // Configurar la hoja de estilos después de cargar el FXML
            Scene scene = new Scene(root, 300, 550);
            scene.getStylesheets().add(getClass().getResource("style.css").toExternalForm());

            if(weatherStage == null){
                this.weatherStage = new Stage();
            }

            this.weatherStage.setScene(scene);
            this.weatherStage.setTitle("Weather Information");
            ciudadLabel = (Label) scene.lookup("#ciudadLabel");
        }catch (IOException e){
            throw new WeatherControllerException();
        }
    }

    public Stage getWeatherStage () {
        if(weatherStage == null){
            throw new RuntimeException("La vista del tiempo es nula");
        }
        return weatherStage;
    }

    public Parent getView () {
        return ciudadLabel.getParent();
    }

    private void showSearchStage(){
        if(mainController !=null){
            SearchController searchController = mainController.getSearchController();
            if(searchController!=null && searchController.getSearchStage()!=null){
                searchController.getSearchStage().show();
            }
        }
    }

    private void closeWeatherStage(){
        if(weatherStage !=null){
            weatherStage.close();
        }
    }
    @FXML
    private void onBackButtonClick(){
        closeWeatherStage();
        showSearchStage();
    }
}

