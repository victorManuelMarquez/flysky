package ar.com.codoacodo.flysky.exception;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class PasajeroNoEncontrado extends RuntimeException {

    @Override
    public String getMessage() {
        return "¡El pasajero solicitado no existe!";
    }

}
