package ar.com.codoacodo.flysky.exception;

import lombok.NoArgsConstructor;

@NoArgsConstructor
@SuppressWarnings("SpellCheckingInspection")
public class AvionNoEncontrado extends RuntimeException {

    @Override
    public String getMessage() {
        return "¡El avión solicitado no existe!";
    }

}
