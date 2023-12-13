package ar.com.codoacodo.flysky.exception;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class VueloNoEncontrado extends RuntimeException {

    @Override
    public String getMessage() {
        return "¡El vuelo solicitado no existe!";
    }

}
