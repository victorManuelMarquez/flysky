package ar.com.codoacodo.flysky.service;

import ar.com.codoacodo.flysky.model.dto.DtoPasajero;

import java.util.List;

public interface PasajerosService {

    List<DtoPasajero> todosLosPasajeros();

    DtoPasajero buscarPorId(Integer id);

    DtoPasajero agregarNuevo(DtoPasajero pasajero);

    DtoPasajero eliminar(Integer id);

}
