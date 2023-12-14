package ar.com.codoacodo.flysky.exception;

//@NoArgsConstructor
@SuppressWarnings("SpellCheckingInspection")
public class AvionNoEncontrado extends RuntimeException {


    public AvionNoEncontrado() {
    }

    public AvionNoEncontrado(String message) {
        super(message);
    }

    @Override
    public String getMessage() {
        return "¡El avión solicitado no existe!";
    }

}
