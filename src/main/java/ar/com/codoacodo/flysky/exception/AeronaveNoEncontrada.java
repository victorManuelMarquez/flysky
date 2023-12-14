package ar.com.codoacodo.flysky.exception;

import lombok.NoArgsConstructor;

<<<<<<< HEAD

    public AeronaveNoEncontrada() {
    }

    public AeronaveNoEncontrada(String message) {
        super(message);
    }

=======
@NoArgsConstructor
public class AeronaveNoEncontrada extends RuntimeException {
>>>>>>> 00b00d4c579324d9519344571ffbca249acd86e3
    @Override
    public String getMessage() {
        return "¡La aeronave solicitada no existe!";
    }

}
