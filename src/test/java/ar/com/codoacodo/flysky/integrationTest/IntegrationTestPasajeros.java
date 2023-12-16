package ar.com.codoacodo.flysky.integrationTest;

import ar.com.codoacodo.flysky.model.dto.DtoAerolinea;
import ar.com.codoacodo.flysky.model.dto.DtoPasajero;
import ar.com.codoacodo.flysky.util.FactoryAerolineasTest;
import ar.com.codoacodo.flysky.util.FactoryPasajerosTest;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
@AutoConfigureMockMvc
@SpringBootTest
public class IntegrationTestPasajeros {
    @Autowired
    MockMvc mockMvc;
    @Test
    @DisplayName("Test Integracion Camino Feliz -> Buscar todos los pasajeros")
    void pasajerosTodosOkTest() throws Exception {
        mockMvc.perform(get("/api/pasajeros/"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].nombreCompleto").value("Juan Pérez"));
    }
        @Test
    @DisplayName("Test Integracion Camino Feliz -> Buscar un pasajero por id")
    void pasajerosSeleccionarOkTest() throws Exception {
        mockMvc.perform(get("/api/pasajeros/{id}", 7))
                .andDo(print())
                .andExpect(content().contentType("application/json"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(7))
                .andExpect(jsonPath("$.nombreCompleto").value("Javier Silva"));
    }
    @Test
    @DisplayName("Test Integracion Camino Feliz -> Agregar un nuevo pasajero")
    void pasajerosAgregarNuevaOkTest() throws Exception {
        DtoPasajero dtoPasajero = FactoryPasajerosTest.nuevaPasajero();

        ObjectWriter writer = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .writer();

        String payload = writer.writeValueAsString(dtoPasajero);

        mockMvc.perform(post("/api/pasajeros/registrar")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(payload))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.nombreCompleto").value("Juan Pablo Montoya"));
    }
    @Test
    @DisplayName("Test Integracion Camino Feliz -> Eliminar un pasajero por id")
    void pasajerosEliminarOkTest() throws Exception {
        DtoPasajero dtoPasajero = FactoryPasajerosTest.eliminarPasajero();

        ObjectWriter writer = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .writer();

        String payload = writer.writeValueAsString(dtoPasajero);

        mockMvc.perform(delete("/api/pasajeros/{id}/eliminar", dtoPasajero.getId()))
                .andDo(print())
                .andExpect(content().contentType("application/json"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(10))
                .andExpect(jsonPath("$.nombreCompleto").value("Sofía López"));
    }

}
