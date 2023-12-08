package ar.com.codoacodo.flysky.exception;

public class ClaseNotFoundException extends RuntimeException {

    @Override
    public String getMessage() {
        return "¡La clase solicitada no existe!";
    }

}
