package ar.com.codoacodo.flysky.exception;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class BoletoNoEncontrado extends RuntimeException {

    @Override
    public String getMessage() {
        return "¡El boleto requerido no existe!";
    }

}

