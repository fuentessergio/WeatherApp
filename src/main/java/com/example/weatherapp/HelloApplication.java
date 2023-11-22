package com.example.weatherapp;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {

    private MainController mainController;
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Parent root = fxmlLoader.load();

        // Obtén el controlador de búsqueda y configura la instancia de HelloApplication
        SearchController searchController = fxmlLoader.getController();

        mainController = new MainController(searchController,WeatherController.create("Madrid"));
        searchController.setHelloApplication(this,stage,mainController);

        Scene scene = new Scene(root, 320, 240);
        stage.setTitle("Búsqueda de ciudad");
        stage.setScene(scene);
        stage.show();

    }

    public MainController getMainController(){
        return mainController;
    }


    public static void main(String[] args) {
        launch();
    }

    /*public static void showWeatherView(String ciudadStr) {
        try {
            FXMLLoader loader = new FXMLLoader(HelloApplication.class.getResource("weatherwindow.fxml"));
            Parent root = loader.load();

            WeatherController weatherController = loader.getController();
            weatherController.initialize(ciudadStr);

            Scene scene = new Scene(root,350,200);
            Stage stage = new Stage();
            stage.setTitle("Pronostico del tiempo");
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }*/
}