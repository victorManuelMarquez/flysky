package ar.com.codoacodo.flysky.mapper;

import ar.com.codoacodo.flysky.model.dto.DtoClase;
import ar.com.codoacodo.flysky.model.entity.ClaseEntity;

public final class ClaseMapper extends BaseMapper {

    public static DtoClase aDto(ClaseEntity entity) {
        return new ClaseMapper().getMapper().convertValue(entity, DtoClase.class);
    }

    public static ClaseEntity aEntidad(DtoClase dto) {
        return new ClaseMapper().getMapper().convertValue(dto, ClaseEntity.class);
    }

}
