package ar.com.codoacodo.flysky.service;

import ar.com.codoacodo.flysky.model.dto.DtoBoleto;

import java.util.List;

public interface BoletosService {

    List<DtoBoleto> todosLosBoletos();

    DtoBoleto buscarPorId(Integer id);

    DtoBoleto agregarBoleto(DtoBoleto nuevo);

    DtoBoleto eliminar(Integer id);

}
