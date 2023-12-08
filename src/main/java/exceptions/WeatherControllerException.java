package exceptions;

import com.example.weatherapp.WeatherController;

public class WeatherControllerException extends Exception{
    public WeatherControllerException(){
        super("Error al inicializar el WeatherController");
    }
}
