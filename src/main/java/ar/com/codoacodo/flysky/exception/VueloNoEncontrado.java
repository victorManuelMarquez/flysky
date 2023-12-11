package ar.com.codoacodo.flysky.exception;

public class VueloNoEncontrado extends RuntimeException {

    @Override
    public String getMessage() {
        return "¡El vuelo solicitado no existe!";
    }

}
