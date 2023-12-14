package ar.com.codoacodo.flysky.exception;

//@NoArgsConstructor
public class VueloNoEncontrado extends RuntimeException {

    public VueloNoEncontrado() {
    }

    public VueloNoEncontrado(String message) {
        super(message);
    }

    @Override
    public String getMessage() {
        return "¡El vuelo solicitado no existe!";
    }

}
