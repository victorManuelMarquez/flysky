package ar.com.codoacodo.flysky.service;

import ar.com.codoacodo.flysky.dto.ClaseDto;
import ar.com.codoacodo.flysky.dto.ClaseaDto;
import ar.com.codoacodo.flysky.dto.response.RespuestaDto;
import ar.com.codoacodo.flysky.repository.IClaseRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClaseServiceImp implements IClaseService{
    private IClaseRepository repository;
    public ClaseServiceImp(IClaseRepository repository) {        this.repository = repository;    }


    @Override
    public RespuestaDto guardarClase(ClaseDto claseDto) {
        return null;
    }

    @Override
    public List<ClaseDto> listaClases() {
        ObjectMapper mapper = new ObjectMapper();
        return repository.findAll().stream().map(clase -> mapper.convertValue(clase, ClaseDto.class)).toList();
    }

    @Override
    public ClaseaDto buscarClasePorId(Long id) {
        return null;
    }

    @Override
    public ClaseDto actualizarClasePorId(Long id, ClaseDto claseDto) {
        return null;
    }

    @Override
    public RespuestaDto borrarClasePorId(Long id) {
        return null;
    }
}
