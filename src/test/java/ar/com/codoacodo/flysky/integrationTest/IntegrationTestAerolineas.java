package ar.com.codoacodo.flysky.integrationTest;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import ar.com.codoacodo.flysky.model.dto.DtoAerolinea;
import ar.com.codoacodo.flysky.util.FactoryAerolineasTest;;
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

@AutoConfigureMockMvc
@SpringBootTest
public class IntegrationTestAerolineas {
    @Autowired
    MockMvc mockMvc;
    @Test
    @DisplayName("Test Integracion Camino Feliz -> /api/aerolineas/ -> todasLasAerolineas")
    void aerolineasTodosOkTest() throws Exception {
        mockMvc.perform(get("/api/aerolineas/"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].id").value(4))
                .andExpect(jsonPath("$[0].nombre").value("Aerolíneas Argentinas"));
    }
    @Test
    @DisplayName("Test Integracion Camino Feliz -> /api/aerolineas/{id} -> buscarPorId")
    void aerolineasSeleccionarOkTest() throws Exception {
        mockMvc.perform(get("/api/aerolineas/{id}", 2))
                .andDo(print())
                .andExpect(content().contentType("application/json"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(2))
                .andExpect(jsonPath("$.nombre").value("Avianca"));
    }
    @Test
    @DisplayName("Test Integracion Camino Feliz -> /api/aerolineas/registrar -> agregarNueva")
    void aerolineasAgregarNuevaOkTest() throws Exception {
        DtoAerolinea dtoAerolinea = FactoryAerolineasTest.nuevaAerolinea();

        ObjectWriter writer = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .writer();

        String payload = writer.writeValueAsString(dtoAerolinea);

        mockMvc.perform(post("/api/aerolineas/registrar")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(payload))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.nombre").value("Aerolineas Nueva "+FactoryAerolineasTest.id));
    }
    @Test
    @DisplayName("Test Integracion Camino Feliz -> /api/aerolineas/{id}/eliminar -> eliminar")
    void aerolineasEliminarOkTest() throws Exception {
        DtoAerolinea dtoAerolinea = FactoryAerolineasTest.nuevaAerolinea();

        ObjectWriter writer = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .writer();

        String payload = writer.writeValueAsString(dtoAerolinea);

        mockMvc.perform(delete("/api/aerolineas/{id}/eliminar", dtoAerolinea.getId()))
                .andDo(print())
                .andExpect(content().contentType("application/json"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(FactoryAerolineasTest.id))
                .andExpect(jsonPath("$.nombre").value("Aerolineas Nueva "+FactoryAerolineasTest.id));
    }

}
