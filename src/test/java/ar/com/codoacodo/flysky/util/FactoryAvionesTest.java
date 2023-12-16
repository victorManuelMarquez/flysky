package ar.com.codoacodo.flysky.util;

import ar.com.codoacodo.flysky.model.dto.DtoAeropuerto;
import ar.com.codoacodo.flysky.model.dto.DtoAvion;

public class FactoryAvionesTest {
        public static DtoAvion nuevoAvion(){
            return new DtoAvion(11, "prueba 11");
        }
        public static DtoAvion eliminarAvion(){
            return new DtoAvion(10, "Boeing 767");
        }

}