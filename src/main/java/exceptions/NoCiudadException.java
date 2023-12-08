package exceptions;

public class NoCiudadException extends Exception{
    public NoCiudadException(){
        super("Error, introduce alguna ciudad para la búsqueda");
    }
}
