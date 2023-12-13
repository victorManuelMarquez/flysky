package ar.com.codoacodo.flysky.integrationTest;

import ar.com.codoacodo.flysky.model.dto.DtoAerolinea;
import ar.com.codoacodo.flysky.model.dto.DtoAeronave;
import ar.com.codoacodo.flysky.util.FactoryAerolineasTest;
import ar.com.codoacodo.flysky.util.FactoryAeronavesTest;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

@AutoConfigureMockMvc
@SpringBootTest
public class IntegrationTestAeronaves {
    @Autowired
    MockMvc mockMvc;
    @Test
    @DisplayName("Test Integracion Camino Feliz -> /api/aeronaves/ -> todasLasAeronaves")
    void aeronavesTodosOkTest() throws Exception {
        mockMvc.perform(get("/api/aeronaves/"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].id").value(1)) //????????????????????
                .andExpect(jsonPath("$[0].asientos").value(150)); //????????????????????
    }
    @Test
    @DisplayName("Test Integracion Camino Feliz -> /api/aeronaves/{id} -> buscarPorId")
    void aeronavesSeleccionarOkTest() throws Exception {
        mockMvc.perform(get("/api/aeronaves/{id}", 4))
                .andDo(print())
                .andExpect(content().contentType("application/json"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(4))
                .andExpect(jsonPath("$.asientos").value(200));
    }
    @Test
    @DisplayName("Test Integracion Camino Feliz -> /api/aeronaves/registrar -> agregarNueva")
    void aeronavesAgregarNuevaOkTest() throws Exception {
        DtoAeronave dtoAeronave = FactoryAeronavesTest.nuevaAeronave();

        ObjectWriter writer = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .writer();

        String payload = writer.writeValueAsString(dtoAeronave);

        mockMvc.perform(post("/api/aeronaves/registrar")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(payload))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.id").value(FactoryAeronavesTest.id))
                .andExpect(jsonPath("$.asientos").value(300));
    }
    @Test
    @DisplayName("Test Integracion Camino Feliz -> /api/aeronaves/{id}/eliminar -> eliminar")
    void aeronavesEliminarOkTest() throws Exception {
        DtoAeronave dtoAeronave = FactoryAeronavesTest.nuevaAeronave();

        ObjectWriter writer = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .writer();

        String payload = writer.writeValueAsString(dtoAeronave);

        mockMvc.perform(delete("/api/aeronaves/{id}/eliminar", dtoAeronave.getId()))
                .andDo(print())
                .andExpect(content().contentType("application/json"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(FactoryAeronavesTest.id))
               .andExpect(jsonPath("$.asientos").value(300));
    }

}
