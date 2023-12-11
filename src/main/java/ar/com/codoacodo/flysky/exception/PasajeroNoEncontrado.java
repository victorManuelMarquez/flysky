package ar.com.codoacodo.flysky.exception;

public class PasajeroNoEncontrado extends RuntimeException {

    @Override
    public String getMessage() {
        return "¡El pasajero solicitado no existe!";
    }

}
