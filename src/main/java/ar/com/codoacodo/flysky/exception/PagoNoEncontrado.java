package ar.com.codoacodo.flysky.exception;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class PagoNoEncontrado extends RuntimeException {

    @Override
    public String getMessage() {
        return "¡El pago solicitado no existe!";
    }

}
