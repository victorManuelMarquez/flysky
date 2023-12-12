package ar.com.codoacodo.flysky.service;

import ar.com.codoacodo.flysky.exception.PasajeroNoEncontrado;
import ar.com.codoacodo.flysky.model.dto.DtoPasajero;
<<<<<<< HEAD
import ar.com.codoacodo.flysky.model.entity.Pasajeros;
=======
import ar.com.codoacodo.flysky.model.entity.Pasajero;
>>>>>>> db269efdddf305e63acb66105951da99a0ab8eeb
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
<<<<<<< HEAD
        Optional<Pasajeros> pasajeros = repository.findById(id);
=======
        Optional<Pasajero> pasajeros = repository.findById(id);
>>>>>>> db269efdddf305e63acb66105951da99a0ab8eeb
        if (pasajeros.isPresent())
            return getMapper().convertValue(pasajeros.get(), DtoPasajero.class);
        else throw new PasajeroNoEncontrado();
    }

    @Override
    public DtoPasajero agregarNuevo(DtoPasajero pasajero) {
<<<<<<< HEAD
        Pasajeros nuevo = repository.save(getMapper().convertValue(pasajero, Pasajeros.class));
=======
        Pasajero nuevo = repository.save(getMapper().convertValue(pasajero, Pasajero.class));
>>>>>>> db269efdddf305e63acb66105951da99a0ab8eeb
        return getMapper().convertValue(nuevo, DtoPasajero.class);
    }

    @Override
    public DtoPasajero eliminar(Integer id) {
<<<<<<< HEAD
        Optional<Pasajeros> pasajeros = repository.findById(id);
=======
        Optional<Pasajero> pasajeros = repository.findById(id);
>>>>>>> db269efdddf305e63acb66105951da99a0ab8eeb
        if (pasajeros.isPresent()) {
            repository.delete(pasajeros.get());
            return getMapper().convertValue(pasajeros.get(), DtoPasajero.class);
        } else throw new PasajeroNoEncontrado();
    }

}
