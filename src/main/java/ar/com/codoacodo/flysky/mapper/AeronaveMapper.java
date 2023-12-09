package ar.com.codoacodo.flysky.mapper;

import ar.com.codoacodo.flysky.model.dto.DtoAeronave;
import ar.com.codoacodo.flysky.model.entity.AeronaveEntity;

public final class AeronaveMapper extends BaseMapper {

    public static DtoAeronave aDto(AeronaveEntity entity) {
        return new AeronaveMapper().getMapper().convertValue(entity, DtoAeronave.class);
    }

    public static AeronaveEntity aEntidad(DtoAeronave dto) {
        return new AeronaveMapper().getMapper().convertValue(dto, AeronaveEntity.class);
    }

}
