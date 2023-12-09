package ar.com.codoacodo.flysky.mapper;

import ar.com.codoacodo.flysky.model.dto.DtoAsiento;
import ar.com.codoacodo.flysky.model.entity.AsientoEntity;

public final class AsientosMapper extends BaseMapper {

    public static DtoAsiento aDto(AsientoEntity entity) {
        return new AsientosMapper().getMapper().convertValue(entity, DtoAsiento.class);
    }

    public static AsientoEntity aEntidad(DtoAsiento dto) {
        return new AsientosMapper().getMapper().convertValue(dto, AsientoEntity.class);
    }

}
