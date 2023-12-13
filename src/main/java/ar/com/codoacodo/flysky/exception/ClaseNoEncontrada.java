package ar.com.codoacodo.flysky.exception;

public class ClaseNoEncontrada extends RuntimeException {

    public ClaseNoEncontrada() {
    }

    public ClaseNoEncontrada(String message) {
        super(message);
    }

    @Override
    public String getMessage() {
        return "¡La clase especificada no existe!";
    }

}
