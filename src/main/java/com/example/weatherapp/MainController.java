package com.example.weatherapp;

import exceptions.NoCiudadException;
import exceptions.WeatherControllerException;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
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

        public void onSearchButtonClick (String ciudadStr) throws WeatherControllerException, IOException {
            try{
                validarCiudad(ciudadStr);
                handleSearchButtonClick(ciudadStr);
            } catch (NoCiudadException e){
                showAlert(Alert.AlertType.ERROR,"¡Error!", e.getMessage());
            }
        }
         private void validarCiudad(String ciudadStr) throws NoCiudadException{
             if(ciudadStr.isEmpty()){
                 throw new NoCiudadException();
             }
         }
        public void handleSearchButtonClick(String ciudadStr) throws WeatherControllerException {
            try {
                validarCiudad(ciudadStr);
                // Siempre creo una nueva instancia de WeatherController
                weatherController = new WeatherController(this);
                weatherController.initialize(ciudadStr);

                Stage weatherStage = weatherController.getWeatherStage();
                if (!weatherStage.isShowing()) {
                    weatherStage.show();
                }
            } catch (NoCiudadException e) {
                showAlert(Alert.AlertType.ERROR, "¡Error!", e.getMessage());
            }
        }
        private void showAlert(Alert.AlertType alertType, String title, String content) {
            Alert alert = new Alert(alertType);
            alert.setTitle(title);
            alert.setHeaderText(null);
            alert.setContentText(content);
            alert.showAndWait();
        }
}

