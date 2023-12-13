package ar.com.codoacodo.flysky.exception;

public class ClaseNoEncontrada extends RuntimeException {

    @Override
    public String getMessage() {
        return "¡La clase especificada no existe!";
    }

}
