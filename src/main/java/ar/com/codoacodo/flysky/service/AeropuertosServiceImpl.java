package ar.com.codoacodo.flysky.service;

import ar.com.codoacodo.flysky.exception.AeropuertoNotFoundException;
import ar.com.codoacodo.flysky.mapper.AeropuertoMapper;
import ar.com.codoacodo.flysky.model.dto.DtoAeropuerto;
import ar.com.codoacodo.flysky.model.entity.AeropuertoEntity;
import ar.com.codoacodo.flysky.repository.AeropuertosRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class AeropuertosServiceImpl implements AeropuertosService {

    @Autowired
    private AeropuertosRepository aeropuertosRepository;

    @Override
    public List<DtoAeropuerto> todosLosAeropuertos() {
        return aeropuertosRepository.findAll().stream().map(AeropuertoMapper::aDto).toList();
    }

    @Override
    public DtoAeropuerto buscarPorId(Integer id) {
        Optional<AeropuertoEntity> entity = aeropuertosRepository.findById(id);
        if (entity.isPresent())
            return AeropuertoMapper.aDto(entity.get());
        else throw new AeropuertoNotFoundException();
    }

    @Override
    public String agregarAeropuerto(DtoAeropuerto nuevo) {
        AeropuertoEntity entity = aeropuertosRepository.save(AeropuertoMapper.aEntidad(nuevo));
        return String.format("Se agregó el aeropuerto \"%s\" ubicado en \"%s\".", entity.getNombre(), entity.getCiudad());
    }

    @Override
    public DtoAeropuerto eliminar(Integer id) {
        Optional<AeropuertoEntity> entity = aeropuertosRepository.findById(id);
        if (entity.isPresent()) {
            aeropuertosRepository.deleteById(id);
            return AeropuertoMapper.aDto(entity.get());
        } else throw new AeropuertoNotFoundException();
    }

}
