package ar.com.codoacodo.flysky.exception;

public class AeronaveNoEncontrada extends RuntimeException {

    @Override
    public String getMessage() {
        return "¡La aeronave solicitada no existe!";
    }

}
