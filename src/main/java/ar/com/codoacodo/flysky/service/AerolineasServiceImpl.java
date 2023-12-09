package ar.com.codoacodo.flysky.service;

import ar.com.codoacodo.flysky.exception.AerolineaNotFoundException;
import ar.com.codoacodo.flysky.mapper.AerolineaMapper;
import ar.com.codoacodo.flysky.model.dto.DtoAerolinea;
import ar.com.codoacodo.flysky.model.entity.AerolineaEntity;
import ar.com.codoacodo.flysky.repository.AerolineasRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
@SuppressWarnings("SpellCheckingInspection")
public class AerolineasServiceImpl implements AerolineasService {

    @Autowired
    private AerolineasRepository aerolineasRepository;

    @Override
    public List<DtoAerolinea> todasLasAerolineas() {
        return aerolineasRepository.findAll().stream().map(AerolineaMapper::aDto).toList();
    }

    @Override
    public DtoAerolinea buscarPorId(Integer id) {
        Optional<AerolineaEntity> entity = aerolineasRepository.findById(id);
        if (entity.isPresent())
            return AerolineaMapper.aDto(entity.get());
        else throw new AerolineaNotFoundException();
    }

    @Override
    public String agregarAerolinea(DtoAerolinea nueva) {
        AerolineaEntity entity = aerolineasRepository.save(AerolineaMapper.aEntidad(nueva));
        return "Se agregó la aerolínea : " + entity.getNombre();
    }

    @Override
    public DtoAerolinea eliminar(Integer id) {
        Optional<AerolineaEntity> entity = aerolineasRepository.findById(id);
        if (entity.isPresent()) {
            aerolineasRepository.deleteById(id);
            return AerolineaMapper.aDto(entity.get());
        } else throw new AerolineaNotFoundException();
    }

}
