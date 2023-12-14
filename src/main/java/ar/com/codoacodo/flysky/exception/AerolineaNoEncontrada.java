package ar.com.codoacodo.flysky.exception;

//@NoArgsConstructor
@SuppressWarnings("SpellCheckingInspection")
public class AerolineaNoEncontrada extends RuntimeException {


    public AerolineaNoEncontrada() {
    }

    public AerolineaNoEncontrada(String message) {
        super(message);
    }

    @Override
    public String getMessage() {
        return "¡La aerolínea especificada no existe!";
    }

}
