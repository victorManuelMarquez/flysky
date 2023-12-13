package ar.com.codoacodo.flysky.exception;

public class AeropuertoNoEncontrado extends RuntimeException {

    @Override
    public String getMessage() {
        return "¡El aeropuerto solicitado no existe!";
    }

}
