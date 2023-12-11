package ar.com.codoacodo.flysky.service;

import ar.com.codoacodo.flysky.model.dto.DtoAvion;

import java.util.List;

public interface AvionesServicio {

    List<DtoAvion> todosLosAviones();

    DtoAvion buscarPorId(Integer id);

    DtoAvion agregarNuevo(DtoAvion nuevo);

    DtoAvion eliminar(Integer id);

}
