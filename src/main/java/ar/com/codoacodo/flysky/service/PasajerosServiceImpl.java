package ar.com.codoacodo.flysky.service;

import ar.com.codoacodo.flysky.exception.PasajeroNoEncontrado;
import ar.com.codoacodo.flysky.model.dto.DtoPasajero;
import ar.com.codoacodo.flysky.model.entity.Pasajero;
import ar.com.codoacodo.flysky.repository.PasajerosRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Data
@AllArgsConstructor
@Service
public class PasajerosServiceImpl implements PasajerosService {

    @Autowired
    private PasajerosRepository repository;

    private ObjectMapper mapper;

    @Override
    public List<DtoPasajero> todosLosPasajeros() {
        ArrayList<DtoPasajero> pasajeros = new ArrayList<>();
        repository.findAll().forEach(v -> pasajeros.add(getMapper().convertValue(v, DtoPasajero.class)));
        return pasajeros;
    }

    @Override
    public DtoPasajero buscarPorId(Integer id) {
        Optional<Pasajero> pasajeros = repository.findById(id);
        if (pasajeros.isPresent())
            return getMapper().convertValue(pasajeros.get(), DtoPasajero.class);
        else throw new PasajeroNoEncontrado();
    }

    @Override
    public DtoPasajero agregarNuevo(DtoPasajero pasajero) {
        Pasajero nuevo = repository.save(getMapper().convertValue(pasajero, Pasajero.class));
        return getMapper().convertValue(nuevo, DtoPasajero.class);
    }

    @Override
    public DtoPasajero eliminar(Integer id) {
        Optional<Pasajero> pasajeros = repository.findById(id);
        if (pasajeros.isPresent()) {
            repository.delete(pasajeros.get());
            return getMapper().convertValue(pasajeros.get(), DtoPasajero.class);
        } else throw new PasajeroNoEncontrado();
    }

}
