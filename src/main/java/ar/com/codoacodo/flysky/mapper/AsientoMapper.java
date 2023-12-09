package ar.com.codoacodo.flysky.mapper;

import ar.com.codoacodo.flysky.model.dto.DtoAsiento;
import ar.com.codoacodo.flysky.model.entity.AsientoEntity;

public final class AsientoMapper extends BaseMapper {

    public static DtoAsiento aDto(AsientoEntity entity) {
        return new AsientoMapper().getMapper().convertValue(entity, DtoAsiento.class);
    }

    public static AsientoEntity aEntidad(DtoAsiento dto) {
        return new AsientoMapper().getMapper().convertValue(dto, AsientoEntity.class);
    }

}
