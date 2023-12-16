package ar.com.codoacodo.flysky.integrationTest;

import ar.com.codoacodo.flysky.model.dto.DtoAerolinea;
import ar.com.codoacodo.flysky.model.dto.DtoAeropuerto;
import ar.com.codoacodo.flysky.util.FactoryAerolineasTest;
import ar.com.codoacodo.flysky.util.FactoryAeropuertosTest;
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
public class IntegrationTestAeropuertos {
    @Autowired
    MockMvc mockMvc;
    @Test
    @DisplayName("Test Integracion Camino Feliz -> Buscar todos los aeropuertos")
    void aeropuertosTodosOkTest() throws Exception {
        mockMvc.perform(get("/api/aeropuertos/"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].id").value(8))
                .andExpect(jsonPath("$[0].nombre").value("Aeropuerto Internacional Comodoro Arturo Merino Benítez"));
    }
    @Test
    @DisplayName("Test Integracion Camino Feliz -> Buscar aeropuerto por id")
    void aeropuertosSeleccionarOkTest() throws Exception {
        mockMvc.perform(get("/api/aeropuertos/{id}", 8))
                .andDo(print())
                .andExpect(content().contentType("application/json"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(8))
                .andExpect(jsonPath("$.nombre").value("Aeropuerto Internacional Comodoro Arturo Merino Benítez"));
    }
    @Test
    @DisplayName("Test Integracion Camino Feliz ->  Agregar un nuevo aeropuerto")
    void aeropuertosAgregarNuevaOkTest() throws Exception {
        DtoAeropuerto dtoAeropuerto = FactoryAeropuertosTest.nuevoAeropuerto();

        ObjectWriter writer = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .writer();

        String payload = writer.writeValueAsString(dtoAeropuerto);

        mockMvc.perform(post("/api/aeropuertos/registrar")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(payload))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.nombre").value("Aeropuerto Prueba"));
    }
    @Test
    @DisplayName("Test Integracion Camino Feliz -> Eliminar aeropuerto por id")
    void aeropuertosEliminarOkTest() throws Exception {
        DtoAeropuerto dtoAeropuerto = FactoryAeropuertosTest.eliminarAeropuerto();

        ObjectWriter writer = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .writer();

        String payload = writer.writeValueAsString(dtoAeropuerto);

        mockMvc.perform(delete("/api/aeropuertos/{id}/eliminar", dtoAeropuerto.getId()))
                .andDo(print())
                .andExpect(content().contentType("application/json"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(10))
                .andExpect(jsonPath("$.nombre").value("Aeropuerto Internacional Tocumen"));
    }
}
