package ar.com.codoacodo.flysky.exception;

public class AeronaveNoEncontrada extends RuntimeException {


    public AeronaveNoEncontrada() {
    }

    public AeronaveNoEncontrada(String message) {
        super(message);
    }

    @Override
    public String getMessage() {
        return "¡La aeronave solicitada no existe!";
    }

}
