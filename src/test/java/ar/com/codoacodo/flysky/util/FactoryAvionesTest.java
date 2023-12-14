package ar.com.codoacodo.flysky.util;

import ar.com.codoacodo.flysky.model.dto.DtoAeropuerto;
import ar.com.codoacodo.flysky.model.dto.DtoAvion;

public class FactoryAvionesTest {

        public static int id = 57;
        public static DtoAvion nuevoAvion(){
            id++;
            return new DtoAvion(id, "prueba "+id);
        }
        public static DtoAvion eliminarAvion(){
            --id;
            return new DtoAvion(id, "Prueba "+id);
        }

}
/*
 @PositiveOrZero
    private Integer id;

    @NotBlank
    @Size(max = 100)
    private String marcaModelo;
*/
