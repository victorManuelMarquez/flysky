package ar.com.codoacodo.flysky.mapper;

import ar.com.codoacodo.flysky.model.dto.DtoClase;
import ar.com.codoacodo.flysky.model.entity.ClaseEntity;

public final class ClasesMapper extends BaseMapper {

    public static DtoClase aDto(ClaseEntity entity) {
        return new ClasesMapper().getMapper().convertValue(entity, DtoClase.class);
    }

    public static ClaseEntity aEntidad(DtoClase dto) {
        return new ClasesMapper().getMapper().convertValue(dto, ClaseEntity.class);
    }

}
