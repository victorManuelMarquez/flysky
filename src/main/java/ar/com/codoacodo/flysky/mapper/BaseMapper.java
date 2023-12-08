package ar.com.codoacodo.flysky.mapper;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Getter;

@Getter
class BaseMapper {

    private final ObjectMapper mapper;

    BaseMapper() {
        this.mapper = new ObjectMapper();
    }

}
