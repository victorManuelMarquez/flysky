package ar.com.codoacodo.flysky.exception;

@SuppressWarnings("SpellCheckingInspection")
public class AvionNotFoundException extends RuntimeException {

    @Override
    public String getMessage() {
        return "¡El avión solicitado no existe!";
    }

}
