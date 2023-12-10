package ar.com.codoacodo.flysky.service;

import ar.com.codoacodo.flysky.model.dto.DtoAeropuerto;

import java.util.List;

public interface AeropuertosService {

    List<DtoAeropuerto> todosLosAeropuertos();

    DtoAeropuerto buscarPorId(Integer id);

    String agregarAeropuerto(DtoAeropuerto nuevo);

    DtoAeropuerto eliminar(Integer id);

}
