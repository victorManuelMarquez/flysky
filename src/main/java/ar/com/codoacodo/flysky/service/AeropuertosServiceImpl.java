package ar.com.codoacodo.flysky.service;

import ar.com.codoacodo.flysky.exception.AeropuertoNoEncontrado;
import ar.com.codoacodo.flysky.model.dto.DtoAeropuerto;
<<<<<<< HEAD
import ar.com.codoacodo.flysky.model.entity.Aeropuertos;
=======
import ar.com.codoacodo.flysky.model.entity.Aeropuerto;
>>>>>>> db269efdddf305e63acb66105951da99a0ab8eeb
import ar.com.codoacodo.flysky.repository.AeropuertosRepository;
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
public class AeropuertosServiceImpl implements AeropuertosService {

    @Autowired
    private AeropuertosRepository repository;

    private ObjectMapper mapper;

    @Override
    public List<DtoAeropuerto> todosLosAeropuertos() {
        List<DtoAeropuerto> aeropuertos = new ArrayList<>();
        repository.findAll().forEach(v -> aeropuertos.add(getMapper().convertValue(v, DtoAeropuerto.class)));
        return aeropuertos;
    }

    @Override
    public DtoAeropuerto buscarPorId(Integer id) {
        return getMapper().convertValue(repository.findById(id), DtoAeropuerto.class);
    }

    @Override
    public DtoAeropuerto agregarNuevo(DtoAeropuerto aeropuerto) {
<<<<<<< HEAD
        Aeropuertos aeropuertos = repository.save(getMapper().convertValue(aeropuerto, Aeropuertos.class));
=======
        Aeropuerto aeropuertos = repository.save(getMapper().convertValue(aeropuerto, Aeropuerto.class));
>>>>>>> db269efdddf305e63acb66105951da99a0ab8eeb
        return getMapper().convertValue(aeropuertos, DtoAeropuerto.class);
    }

    @Override
    public DtoAeropuerto eliminar(Integer id) {
<<<<<<< HEAD
        Optional<Aeropuertos> aeropuertos = repository.findById(id);
=======
        Optional<Aeropuerto> aeropuertos = repository.findById(id);
>>>>>>> db269efdddf305e63acb66105951da99a0ab8eeb
        if (aeropuertos.isPresent()) {
            repository.deleteById(id);
            return getMapper().convertValue(aeropuertos.get(), DtoAeropuerto.class);
        } else throw new AeropuertoNoEncontrado();
    }

}
