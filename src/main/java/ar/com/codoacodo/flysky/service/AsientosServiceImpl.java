package ar.com.codoacodo.flysky.service;

import ar.com.codoacodo.flysky.exception.AsientoNotFoundException;
import ar.com.codoacodo.flysky.mapper.AsientosMapper;
import ar.com.codoacodo.flysky.model.dto.DtoAsiento;
import ar.com.codoacodo.flysky.model.entity.AsientoEntity;
import ar.com.codoacodo.flysky.repository.AsientosRepository;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Data
@AllArgsConstructor
@Service
public class AsientosServiceImpl implements AsientosService {

    @Autowired
    private AsientosRepository asientosRepository;

    @Override
    public List<DtoAsiento> todosLosAsientos() {
        return asientosRepository.findAll().stream().map(AsientosMapper::aDto).toList();
    }

    @Override
    public DtoAsiento buscarPorId(Integer id) {
        Optional<AsientoEntity> entity = asientosRepository.findById(id);
        if (entity.isPresent())
            return AsientosMapper.aDto(entity.get());
        else throw new AsientoNotFoundException();
    }

    @Override
    public String agregarAsiento(DtoAsiento nuevo) {
        AsientoEntity entity = asientosRepository.save(AsientosMapper.aEntidad(nuevo));
        return String.format("Se registró %d asientos en \"%s\" a $%.2f.", entity.getCantidad(), entity.getClase().getNombre(), entity.getPrecio());
    }

    @Override
    public DtoAsiento eliminar(Integer id) {
        Optional<AsientoEntity> entity = asientosRepository.findById(id);
        if (entity.isPresent()) {
            asientosRepository.deleteById(id);
            return AsientosMapper.aDto(entity.get());
        } else throw new AsientoNotFoundException();
    }

}
