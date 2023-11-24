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

        public void onSearchButtonClick (String ciudadStr){
            if(ciudadStr.isEmpty()){
                System.out.println("Introduce alguna ciudad, por favor");
            }
        }

        public void handleSearchButtonClick(String ciudadStr) {
            onSearchButtonClick(ciudadStr);

            try {
                if (weatherController == null) {
                    weatherController = new WeatherController();
                } else {
                    weatherController.initialize(ciudadStr);
                }

                Stage weatherStage = weatherController.getWeatherStage();
                if (!weatherStage.isShowing()) {
                    weatherStage.show();
                }

            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            searchController.closeSearchStage();
        }
    }
