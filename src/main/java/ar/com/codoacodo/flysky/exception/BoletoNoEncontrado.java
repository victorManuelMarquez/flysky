package ar.com.codoacodo.flysky.exception;

//@NoArgsConstructor
public class BoletoNoEncontrado extends RuntimeException {


    public BoletoNoEncontrado() {
    }

    public BoletoNoEncontrado(String message) {
        super(message);
    }

    @Override
    public String getMessage() {
        return "¡El boleto requerido no existe!";
    }

}

