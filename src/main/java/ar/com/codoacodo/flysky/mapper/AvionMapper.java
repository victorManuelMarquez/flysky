package ar.com.codoacodo.flysky.mapper;

import ar.com.codoacodo.flysky.model.dto.DtoAvion;
import ar.com.codoacodo.flysky.model.entity.AvionEntity;

@SuppressWarnings("SpellCheckingInspection")
public final class AvionMapper extends BaseMapper {

    public static DtoAvion aDto(AvionEntity entity) {
        return new AvionMapper().getMapper().convertValue(entity, DtoAvion.class);
    }

    public static AvionEntity aEntidad(DtoAvion dto) {
        return new AvionMapper().getMapper().convertValue(dto, AvionEntity.class);
    }

}
