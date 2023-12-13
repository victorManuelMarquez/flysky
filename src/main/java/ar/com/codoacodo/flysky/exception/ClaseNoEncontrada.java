package ar.com.codoacodo.flysky.exception;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class ClaseNoEncontrada extends RuntimeException {

    @Override
    public String getMessage() {
        return "¡La clase especificada no existe!";
    }

}
