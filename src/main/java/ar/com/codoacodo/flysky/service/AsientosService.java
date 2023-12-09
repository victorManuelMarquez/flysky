package ar.com.codoacodo.flysky.service;

import ar.com.codoacodo.flysky.model.dto.DtoAsiento;

import java.util.List;

public interface AsientosService {

    List<DtoAsiento> todosLosAsientos();

    DtoAsiento buscarPorId(Integer id);

    String agregarAsiento(DtoAsiento nuevo);

    DtoAsiento eliminar(Integer id);

}
