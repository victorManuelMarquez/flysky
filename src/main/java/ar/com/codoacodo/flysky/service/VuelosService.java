package ar.com.codoacodo.flysky.service;

import ar.com.codoacodo.flysky.model.dto.DtoVuelo;

import java.util.List;

public interface VuelosService {
    
    List<DtoVuelo> todosLosVuelos();

    DtoVuelo buscarPorId(Integer id);

    DtoVuelo agregarVuelo(DtoVuelo nuevo);

    DtoVuelo eliminar(Integer id);

}
