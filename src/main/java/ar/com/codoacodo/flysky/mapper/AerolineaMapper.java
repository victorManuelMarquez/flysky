package ar.com.codoacodo.flysky.mapper;

import ar.com.codoacodo.flysky.model.dto.DtoAerolinea;
import ar.com.codoacodo.flysky.model.entity.AerolineaEntity;

@SuppressWarnings("SpellCheckingInspection")
public class AerolineaMapper extends BaseMapper {

    public static DtoAerolinea aDto(AerolineaEntity entity) {
        return new AerolineaMapper().getMapper().convertValue(entity, DtoAerolinea.class);
    }

    public static AerolineaEntity aEntidad(DtoAerolinea dto) {
        return new AerolineaMapper().getMapper().convertValue(dto, AerolineaEntity.class);
    }

}
