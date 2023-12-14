package ar.com.codoacodo.flysky.service;

import ar.com.codoacodo.flysky.exception.AerolineaNoEncontrada;
import ar.com.codoacodo.flysky.model.dto.DtoAerolinea;
import ar.com.codoacodo.flysky.model.entity.Aerolinea;
import ar.com.codoacodo.flysky.repository.AerolineasRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Data;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Data
//@AllArgsConstructor
@Service
@SuppressWarnings("SpellCheckingInspection")
public class AerolineasServiceImpl implements AerolineasService {

  //  @Autowired
    private AerolineasRepository repository;

    private ObjectMapper mapper;

    public AerolineasServiceImpl(AerolineasRepository repository, ObjectMapper mapper) {
        this.repository = repository;
        this.mapper = (mapper != null) ? mapper : new ObjectMapper();
    }

    @Override
    public List<DtoAerolinea> todasLasAerolineas() {
        List<DtoAerolinea> aerolineas = new ArrayList<>();
        repository.findAll().forEach(v -> aerolineas.add(getMapper().convertValue(v, DtoAerolinea.class)));
        return aerolineas;
    }

    @Override
    public DtoAerolinea buscarPorId(Integer id) {
        Optional<Aerolinea> aerolineas = repository.findById(id);
        if (aerolineas.isPresent())
            return getMapper().convertValue(aerolineas.get(), DtoAerolinea.class);
        else throw new AerolineaNoEncontrada();
    }

    @Override
    public DtoAerolinea agregarNueva(DtoAerolinea aerolinea) {
        Aerolinea aerolineas = repository.save(getMapper().convertValue(aerolinea, Aerolinea.class));
        return getMapper().convertValue(aerolineas, DtoAerolinea.class);
    }

    @Override
    public DtoAerolinea eliminar(Integer id) {
        Optional<Aerolinea> aerolineas = repository.findById(id);
        if (aerolineas.isPresent()) {
            repository.deleteById(id);
            return getMapper().convertValue(aerolineas.get(), DtoAerolinea.class);
        } else throw new AerolineaNoEncontrada();
    }

}
