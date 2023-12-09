package ar.com.codoacodo.flysky.exception;

@SuppressWarnings("SpellCheckingInspection")
public class AerolineaNotFoundException extends RuntimeException {

    @Override
    public String getMessage() {
        return "¡La aerolínea solicitada no existe!";
    }

}
