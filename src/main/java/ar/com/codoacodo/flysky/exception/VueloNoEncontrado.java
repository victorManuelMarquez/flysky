package ar.com.codoacodo.flysky.exception;

public class VueloNoEncontrado extends RuntimeException {

    public VueloNoEncontrado() {
    }

    public VueloNoEncontrado(String message) {
        super(message);
    }

    @Override
    public String getMessage() {
        return "¡El vuelo solicitado no existe!";
    }

}
