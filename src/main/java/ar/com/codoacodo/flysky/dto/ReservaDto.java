package ar.com.codoacodo.flysky.dto;

import lombok.Data;
import java.util.Date;

@Data
public class ReservaDto {

    private Long id;
    private UsuarioDto usuario;
    private VueloDto vuelo;
    private PasajeroDto pasajero;
    private Date fechaReserva;
    private String comprobante;
    private byte cancelada;

}
