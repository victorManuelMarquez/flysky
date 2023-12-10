package ar.com.codoacodo.flysky.mapper;

import ar.com.codoacodo.flysky.model.dto.DtoAeropuerto;
import ar.com.codoacodo.flysky.model.entity.AeropuertoEntity;

public final class AeropuertoMapper extends BaseMapper {

    public static DtoAeropuerto aDto(AeropuertoEntity entity) {
        return new AeropuertoMapper().getMapper().convertValue(entity, DtoAeropuerto.class);
    }

    public static AeropuertoEntity aEntidad(DtoAeropuerto dto) {
        return new AeropuertoMapper().getMapper().convertValue(dto, AeropuertoEntity.class);
    }

}
