package com.example.weatherapp;

import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class MainController {
    private SearchController searchController;
    private WeatherController weatherController;

    public MainController(SearchController searchController, WeatherController weatherController) {
        this.searchController = searchController;
        this.weatherController = weatherController;
    }

    public SearchController getSearchController() {
        return searchController;
    }

    public void setSearchController(SearchController searchController) {
        this.searchController = searchController;
    }

    public WeatherController getWeatherController() {
        return weatherController;
    }

    public void setWeatherController(WeatherController weatherController) {
        this.weatherController = weatherController;
    }
    public void onSearchButtonClick(String ciudadStr){
        searchController.onSearchButtonClick(ciudadStr);
        try {
            if(weatherController == null){
                weatherController = WeatherController.create(ciudadStr);
            } else {
                weatherController.initialize(ciudadStr);
            }
            Stage weatherStage = new Stage();
            weatherStage.setScene(new Scene(weatherController.getView(),300,300));
            weatherStage.setTitle("WeatherApp " + ciudadStr);
            weatherStage.show();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
