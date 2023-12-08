package ar.com.codoacodo.flysky.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.util.Date;
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class PagoDto {
    private String tipoPago; // Tarjeta de crédito, transferencia, etc.
    private Date fechaPago;
}
