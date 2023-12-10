package ar.com.codoacodo.flysky.exception;

public class AeropuertoNotFoundException extends RuntimeException {

    @Override
    public String getMessage() {
        return "¡El aeropuerto solicitado no existe!";
    }

}
