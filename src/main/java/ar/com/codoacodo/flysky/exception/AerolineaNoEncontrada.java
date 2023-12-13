package ar.com.codoacodo.flysky.exception;

import lombok.NoArgsConstructor;

@NoArgsConstructor
@SuppressWarnings("SpellCheckingInspection")
public class AerolineaNoEncontrada extends RuntimeException {

    @Override
    public String getMessage() {
        return "¡La aerolínea especificada no existe!";
    }

}
