package ar.com.codoacodo.flysky.exception;

public class AsientoNotFoundException extends RuntimeException {

    @Override
    public String getMessage() {
        return "¡El asiento solicitado no existe!";
    }

}
