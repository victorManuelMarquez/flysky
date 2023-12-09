package ar.com.codoacodo.flysky.service;

import ar.com.codoacodo.flysky.exception.AvionNotFoundException;
import ar.com.codoacodo.flysky.mapper.AvionMapper;
import ar.com.codoacodo.flysky.model.dto.DtoAvion;
import ar.com.codoacodo.flysky.model.entity.AvionEntity;
import ar.com.codoacodo.flysky.repository.AvionesRepository;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Data
@AllArgsConstructor
@Service
public class AvionesServiceImpl implements AvionesService {

    @Autowired
    private AvionesRepository avionesRepository;

    @Override
    public List<DtoAvion> todosLosAviones() {
        return avionesRepository.findAll().stream().map(AvionMapper::aDto).toList();
    }

    @Override
    public DtoAvion buscarPorId(Integer id) {
        Optional<AvionEntity> entity = avionesRepository.findById(id);
        if (entity.isPresent())
            return AvionMapper.aDto(entity.get());
        else throw new AvionNotFoundException();
    }

    @Override
    public String agregarAvion(DtoAvion nuevo) {
        avionesRepository.save(AvionMapper.aEntidad(nuevo));
        return String.format("Se agregó el avión %s con capacidad para %d pasajeros.", nuevo.getModelo(), nuevo.getTotalAsientos());
    }

    @Override
    public DtoAvion eliminar(Integer id) {
        Optional<AvionEntity> entity = avionesRepository.findById(id);
        if (entity.isPresent()) {
            avionesRepository.deleteById(id);
            return AvionMapper.aDto(entity.get());
        } else throw new AvionNotFoundException();
    }

}
