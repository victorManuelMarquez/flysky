package ar.com.codoacodo.flysky.service;

import ar.com.codoacodo.flysky.model.dto.DtoPago;

import java.util.List;

public interface PagosService {

    List<DtoPago> todosLosPagos();

    DtoPago buscarPorId(Integer id);

    DtoPago agregarNuevo(DtoPago nuevo);

    DtoPago eliminar(Integer id);

}
