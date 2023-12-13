package ar.com.codoacodo.flysky.exception;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class AeropuertoNoEncontrado extends RuntimeException {

    @Override
    public String getMessage() {
        return "¡El aeropuerto solicitado no existe!";
    }

}
