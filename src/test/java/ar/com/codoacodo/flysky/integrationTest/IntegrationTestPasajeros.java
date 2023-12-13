package ar.com.codoacodo.flysky.integrationTest;

import ar.com.codoacodo.flysky.model.dto.DtoAerolinea;
import ar.com.codoacodo.flysky.util.FactoryAerolineasTest;
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

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

@AutoConfigureMockMvc
@SpringBootTest
public class IntegrationTestPasajeros {
    @Autowired
    MockMvc mockMvc;
    @Test
    @DisplayName("Test Integracion Camino Feliz -> /api/pasajeros/todos()")
    void pasajerosTodosOkTest() throws Exception {
        mockMvc.perform(get("/api/pasajeros"))
                .andDo(print())
                .andExpect(status().isNotFound())
                .andExpect(jsonPath("$[0].nombre").value("LATAM Airlines"));
    }

    @Test
    @DisplayName("Test Integracion Camino Feliz -> /api/pasajeros/ -> todosLosPasajeros")
    void pasajeroTodosOkTest() throws Exception {
        mockMvc.perform(get("/api/pasajeros/"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].id").value(4))
                .andExpect(jsonPath("$[0].nombre").value("Aerolíneas Argentinas"));
    }
    @Test
    @DisplayName("Test Integracion Camino Feliz -> /api/pasajeros/{id} -> buscarPorId")
    void pasajerosSeleccionarOkTest() throws Exception {
        mockMvc.perform(get("/api/pasajeros/{id}", 2))
                .andDo(print())
                .andExpect(content().contentType("application/json"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(2))
                .andExpect(jsonPath("$.nombre").value("Avianca"));
    }
    @Test
    @DisplayName("Test Integracion Camino Feliz -> /api/pasajeros/registrar -> agregarNueva")
    void pasajerosAgregarNuevaOkTest() throws Exception {
        DtoAerolinea dtoAerolinea = FactoryAerolineasTest.nuevaAerolinea();

        ObjectWriter writer = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .writer();

        String payload = writer.writeValueAsString(dtoAerolinea);

        mockMvc.perform(post("/api/pasajeros/registrar")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(payload))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.nombre").value("Aerolineas Nueva 55"));
    }
    /*@Test
    @DisplayName("Test Integracion Camino Feliz -> /api/pasajeros/{id}/eliminar -> eliminar")
    void pasajerosEliminarOkTest() throws Exception {
        DtoAerolinea dtoAerolinea = FactoryAerolineasTest.nuevaAerolinea();

        ObjectWriter writer = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .writer();

        String payload = writer.writeValueAsString(dtoAerolinea);

        mockMvc.perform(delete("/api/pasajeros/{id}/eliminar", 13))
                .andDo(print())
                .andExpect(content().contentType("application/json"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(13))
                .andExpect(jsonPath("$.nombre").value("Aerolineas Nueva 55"));
    }*/

}
