package ar.com.codoacodo.flysky.exception;

//@NoArgsConstructor
public class AeropuertoNoEncontrado extends RuntimeException {



    @Override
    public String getMessage() {
        return "¡El aeropuerto solicitado no existe!";
    }

}
