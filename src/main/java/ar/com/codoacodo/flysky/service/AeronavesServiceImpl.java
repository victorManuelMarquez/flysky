package ar.com.codoacodo.flysky.service;

import ar.com.codoacodo.flysky.mapper.AeronaveMapper;
import ar.com.codoacodo.flysky.model.dto.DtoAeronave;
import ar.com.codoacodo.flysky.model.entity.AeronaveEntity;
import ar.com.codoacodo.flysky.repository.AeronavesRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
@SuppressWarnings("SpellCheckingInspection")
public class AeronavesServiceImpl implements AeronavesService {

    @Autowired
    private AeronavesRepository aeronavesRepository;

    @Override
    public List<DtoAeronave> todasLasAeronaves() {
        return aeronavesRepository.findAll().stream().map(AeronaveMapper::aDto).toList();
    }

    @Override
    public String vincular(DtoAeronave relacion) {
        AeronaveEntity entity = aeronavesRepository.save(AeronaveMapper.aEntidad(relacion));
        return String.format("El avión %s tiene %d asientos de %s.",
                entity.getAvion().getModelo(),
                entity.getAsiento().getCantidad(),
                entity.getAsiento().getClase().getNombre()
        );
    }

    @Override
    public DtoAeronave desvincular(DtoAeronave relacion) {
        aeronavesRepository.delete(AeronaveMapper.aEntidad(relacion));
        return relacion;
    }

}
