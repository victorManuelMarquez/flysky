package ar.com.codoacodo.flysky.service;

import ar.com.codoacodo.flysky.exception.AeronaveNoEncontrada;
import ar.com.codoacodo.flysky.model.dto.DtoAeronave;
<<<<<<< HEAD
import ar.com.codoacodo.flysky.model.entity.Aeronaves;
=======
import ar.com.codoacodo.flysky.model.entity.Aeronave;
>>>>>>> db269efdddf305e63acb66105951da99a0ab8eeb
import ar.com.codoacodo.flysky.repository.AeronavesRepository;
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
public class AeronavesServiceImpl implements AeronavesService {

    @Autowired
    private AeronavesRepository repository;

    private ObjectMapper mapper;

    @Override
    public List<DtoAeronave> todasLasAeronaves() {
        List<DtoAeronave> aeronaves = new ArrayList<>();
        repository.findAll().forEach(v -> aeronaves.add(getMapper().convertValue(v, DtoAeronave.class)));
        return aeronaves;
    }

    @Override
    public DtoAeronave buscarPorId(Integer id) {
<<<<<<< HEAD
        Optional<Aeronaves> aeronaves = repository.findById(id);
=======
        Optional<Aeronave> aeronaves = repository.findById(id);
>>>>>>> db269efdddf305e63acb66105951da99a0ab8eeb
        if (aeronaves.isPresent())
            return getMapper().convertValue(aeronaves.get(), DtoAeronave.class);
        else throw new AeronaveNoEncontrada();
    }

    @Override
    public DtoAeronave agregarAeronave(DtoAeronave nueva) {
<<<<<<< HEAD
        Aeronaves aeronaves = repository.save(getMapper().convertValue(nueva, Aeronaves.class));
        return getMapper().convertValue(aeronaves, DtoAeronave.class);
=======
        Aeronave aeronave = repository.save(getMapper().convertValue(nueva, Aeronave.class));
        return getMapper().convertValue(aeronave, DtoAeronave.class);
>>>>>>> db269efdddf305e63acb66105951da99a0ab8eeb
    }

    @Override
    public DtoAeronave eliminar(Integer id) {
<<<<<<< HEAD
        Optional<Aeronaves> aeronaves = repository.findById(id);
=======
        Optional<Aeronave> aeronaves = repository.findById(id);
>>>>>>> db269efdddf305e63acb66105951da99a0ab8eeb
        if (aeronaves.isPresent()) {
            repository.deleteById(id);
            return getMapper().convertValue(aeronaves.get(), DtoAeronave.class);
        } else throw new AeronaveNoEncontrada();
    }

}
