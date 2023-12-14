package ar.com.codoacodo.flysky.exception;

//@NoArgsConstructor
public class PasajeroNoEncontrado extends RuntimeException {

    public PasajeroNoEncontrado() {
    }

    public PasajeroNoEncontrado(String message) {
        super(message);
    }

    @Override
    public String getMessage() {
        return "¡El pasajero solicitado no existe!";
    }

}
