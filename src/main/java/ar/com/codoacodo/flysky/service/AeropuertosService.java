package ar.com.codoacodo.flysky.service;

import ar.com.codoacodo.flysky.model.dto.DtoAeropuerto;

import java.util.List;

public interface AeropuertosService {

    List<DtoAeropuerto> todosLosAeropuertos();

    DtoAeropuerto buscarPorId(Integer id);

    DtoAeropuerto agregarNuevo(DtoAeropuerto aeropuerto);

    DtoAeropuerto eliminar(Integer id);

}
