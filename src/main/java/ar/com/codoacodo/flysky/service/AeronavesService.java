package ar.com.codoacodo.flysky.service;

import ar.com.codoacodo.flysky.model.dto.DtoAeronave;

import java.util.List;

public interface AeronavesService {

    List<DtoAeronave> todasLasAeronaves();

    DtoAeronave buscarPorId(Integer id);

    DtoAeronave agregarAeronave(DtoAeronave nueva);

    DtoAeronave eliminar(Integer id);

}
