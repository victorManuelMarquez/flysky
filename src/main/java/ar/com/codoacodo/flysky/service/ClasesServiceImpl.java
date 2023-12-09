package ar.com.codoacodo.flysky.service;

import ar.com.codoacodo.flysky.exception.ClaseNotFoundException;
import ar.com.codoacodo.flysky.mapper.ClaseMapper;
import ar.com.codoacodo.flysky.model.dto.DtoClase;
import ar.com.codoacodo.flysky.model.entity.ClaseEntity;
import ar.com.codoacodo.flysky.repository.ClasesRepository;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Data
@AllArgsConstructor
@Service
public class ClasesServiceImpl implements ClasesService {

    @Autowired
    private ClasesRepository clasesRepository;

    @Override
    public List<DtoClase> todasLasClases() {
        return clasesRepository.findAll().stream().map(ClaseMapper::aDto).toList();
    }

    @Override
    public DtoClase buscarPorId(Integer id) {
        Optional<ClaseEntity> entity = clasesRepository.findById(id);
        if (entity.isPresent())
            return ClaseMapper.aDto(entity.get());
        else throw new ClaseNotFoundException();
    }

    @Override
    public String agregarNueva(DtoClase nueva) {
        clasesRepository.save(ClaseMapper.aEntidad(nueva));
        return "Se agregó la clase : \"" + nueva.getNombre() + "\"";
    }

    @Override
    public DtoClase eliminar(Integer id) {
        Optional<ClaseEntity> entity = clasesRepository.findById(id);
        if (entity.isPresent()) {
            clasesRepository.deleteById(id);
            return ClaseMapper.aDto(entity.get());
        } else throw new ClaseNotFoundException();
    }

}
