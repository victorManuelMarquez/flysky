package ar.com.codoacodo.flysky.service;

import ar.com.codoacodo.flysky.exception.AerolineaNoEncontrada;
import ar.com.codoacodo.flysky.model.dto.DtoAerolinea;
import ar.com.codoacodo.flysky.model.entity.Aerolineas;
import ar.com.codoacodo.flysky.repository.AerolineasRepository;
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
@SuppressWarnings("SpellCheckingInspection")
public class AerolineasServiceImpl implements AerolineasService {

    @Autowired
    private AerolineasRepository repository;

    private ObjectMapper mapper;

    @Override
    public List<DtoAerolinea> todasLasAerolineas() {
        List<DtoAerolinea> aerolineas = new ArrayList<>();
        repository.findAll().forEach(v -> aerolineas.add(getMapper().convertValue(v, DtoAerolinea.class)));
        return aerolineas;
    }

    @Override
    public DtoAerolinea buscarPorId(Integer id) {
        Optional<Aerolineas> aerolineas = repository.findById(id);
        if (aerolineas.isPresent())
            return getMapper().convertValue(aerolineas.get(), DtoAerolinea.class);
        else throw new AerolineaNoEncontrada();
    }

    @Override
    public DtoAerolinea agregarNueva(DtoAerolinea aerolinea) {
        Aerolineas aerolineas = repository.save(getMapper().convertValue(aerolinea, Aerolineas.class));
        return getMapper().convertValue(aerolineas, DtoAerolinea.class);
    }

    @Override
    public DtoAerolinea eliminar(Integer id) {
        Optional<Aerolineas> aerolineas = repository.findById(id);
        if (aerolineas.isPresent()) {
            repository.deleteById(id);
            return getMapper().convertValue(aerolineas.get(), DtoAerolinea.class);
        } else throw new AerolineaNoEncontrada();
    }

}
