package ar.com.codoacodo.flysky.service;

import ar.com.codoacodo.flysky.dto.ClaseaDto;
import ar.com.codoacodo.flysky.dto.response.RespuestaDto;
import ar.com.codoacodo.flysky.entity.Clasea;
import ar.com.codoacodo.flysky.repository.IClaseaRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClaseaServiceImp implements IClaseaService {

    private IClaseaRepository repository;

    public ClaseaServiceImp(IClaseaRepository repository) {
        this.repository = repository;
    }

    @Override
    public RespuestaDto guardarClasea(ClaseaDto claseaDto) {
        return null;
    }

    @Override
    public List<ClaseaDto> listaClasesa() {
        ObjectMapper mapper = new ObjectMapper();
        return repository.findAll().stream().map(clasea -> mapper.convertValue(clasea, ClaseaDto.class)).toList();
    }

    @Override
    public ClaseaDto buscarClaseaPorId(Long id) {
        ModelMapper mapper = new ModelMapper();

        Optional<Clasea> claseaOptional = repository.findById(id);

        return claseaOptional.map(clasea -> mapper.map(clasea, ClaseaDto.class)).orElse(null);
    }

    @Override
    public ClaseaDto actualizarClaseaPorId(Long id, ClaseaDto claseaDto) {
        return null;
    }

    @Override
    public RespuestaDto borrarClaseaPorId(Long id) {
        repository.deleteById(id);
        return new RespuestaDto("Clasea borrada correctamente");
    }
}
