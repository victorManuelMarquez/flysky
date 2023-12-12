package ar.com.codoacodo.flysky.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class PasajeroDto {

    private Long id;
    private String nombres;
    private String apellidos;
    private String dni;

}