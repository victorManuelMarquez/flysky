package ar.com.codoacodo.flysky.exception;

public class PagoNoEncontrado extends RuntimeException {

    public PagoNoEncontrado() {
    }

    public PagoNoEncontrado(String message) {
        super(message);
    }

    @Override
    public String getMessage() {
        return "¡El pago solicitado no existe!";
    }

}
