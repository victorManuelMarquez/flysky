package ar.com.codoacodo.flysky.service;

import ar.com.codoacodo.flysky.exception.ClaseNoEncontrada;
import ar.com.codoacodo.flysky.model.dto.DtoClase;
<<<<<<< HEAD
import ar.com.codoacodo.flysky.model.entity.Clases;
=======
import ar.com.codoacodo.flysky.model.entity.Clase;
>>>>>>> db269efdddf305e63acb66105951da99a0ab8eeb
import ar.com.codoacodo.flysky.repository.ClasesRepository;
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
public class ClasesServiceImpl implements ClasesService {

    @Autowired
    private ClasesRepository repository;

    private ObjectMapper mapper;

    @Override
    public List<DtoClase> todasLasClases() {
        List<DtoClase> clases = new ArrayList<>();
        repository.findAll().forEach(v -> clases.add(getMapper().convertValue(v, DtoClase.class)));
        return clases;
    }

    @Override
    public DtoClase buscarPorId(Integer id) {
<<<<<<< HEAD
        Optional<Clases> clases = repository.findById(id);
=======
        Optional<Clase> clases = repository.findById(id);
>>>>>>> db269efdddf305e63acb66105951da99a0ab8eeb
        if (clases.isPresent())
            return getMapper().convertValue(clases.get(), DtoClase.class);
        else throw new ClaseNoEncontrada();
    }

    @Override
    public DtoClase agregarNueva(DtoClase clase) {
<<<<<<< HEAD
        Clases clases = repository.save(getMapper().convertValue(clase, Clases.class));
=======
        Clase clases = repository.save(getMapper().convertValue(clase, Clase.class));
>>>>>>> db269efdddf305e63acb66105951da99a0ab8eeb
        return getMapper().convertValue(clases, DtoClase.class);
    }

    @Override
    public DtoClase eliminar(Integer id) {
<<<<<<< HEAD
        Optional<Clases> clases = repository.findById(id);
=======
        Optional<Clase> clases = repository.findById(id);
>>>>>>> db269efdddf305e63acb66105951da99a0ab8eeb
        if (clases.isPresent()) {
            repository.deleteById(id);
            return getMapper().convertValue(clases.get(), DtoClase.class);
        } else throw new ClaseNoEncontrada();
    }

}
