package ar.com.codoacodo.flysky.model.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Data;

@Data
@SuppressWarnings("SpellCheckingInspection")
public class DtoAeronave {

    @NotNull
    private DtoAvion avion;

    @NotNull
    private DtoAsiento asiento;

}
