package com.example.weatherapp;

import exceptions.WeatherControllerException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class SearchApplication extends Application {

    private MainController mainController;

    @Override
    public void start(Stage stage) throws WeatherControllerException {
        try{
            FXMLLoader fxmlLoader = new FXMLLoader(SearchApplication.class.getResource("hello-view.fxml"));
            Parent root = fxmlLoader.load();

            // Obtén el controlador de búsqueda y configura la instancia de HelloApplication
            SearchController searchController = fxmlLoader.getController();
            mainController = new MainController(searchController, new WeatherController());
            searchController.setMainController(mainController);
            searchController.setSearchStage(stage);

            Scene scene = new Scene(root, 320, 260);
            stage.setTitle("Búsqueda de ciudad");
            stage.setScene(scene);
            stage.show();
        } catch (IOException e){
            e.printStackTrace();
        }

    }

    public MainController getMainController() {
        return mainController;
    }


    public static void main(String[] args) {
        launch();
    }

}