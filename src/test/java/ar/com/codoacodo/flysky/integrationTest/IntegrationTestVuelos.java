package ar.com.codoacodo.flysky.integrationTest;

import ar.com.codoacodo.flysky.model.dto.DtoAerolinea;
import ar.com.codoacodo.flysky.model.dto.DtoVuelo;
import ar.com.codoacodo.flysky.util.FactoryAerolineasTest;
import ar.com.codoacodo.flysky.util.FactoryVuelosTest;
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
public class IntegrationTestVuelos {
    @Autowired
    MockMvc mockMvc;
    @Test
    @DisplayName("Test Integracion Camino Feliz -> Buscar todos los vuelos")
    void todosLosvueloOkTest() throws Exception {
        mockMvc.perform(get("/api/vuelos/"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].id").value(4))
                .andExpect(jsonPath("$[0].nombre").value("Aerolíneas Argentinas"));
    }
    @Test
    @DisplayName("Test Integracion Camino Feliz -> Buscar un vuelo por id")
    void vueloSeleccionarOkTest() throws Exception {
        mockMvc.perform(get("/api/vuelos/{id}", 2))
                .andDo(print())
                .andExpect(content().contentType("application/json"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(2))
                .andExpect(jsonPath("$.nombre").value("Avianca"));
    }
    @Test
    @DisplayName("Test Integracion Camino Feliz -> Agregar un nuevo vuelo")
    void vueloAgregarNuevaOkTest() throws Exception {
        DtoVuelo dtoVuelo = FactoryVuelosTest.nuevoVuelo();

        ObjectWriter writer = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .writer();

        String payload = writer.writeValueAsString(dtoVuelo);

        mockMvc.perform(post("/api/vuelos/registrar")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(payload))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.id").value(11));
    }
    @Test
    @DisplayName("Test Integracion Camino Feliz -> Eliminar un vuelo por id")
    void vueloEliminarOkTest() throws Exception {
        DtoVuelo dtoVuelo = FactoryVuelosTest.eliminarVuelo();

        ObjectWriter writer = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .writer();

        String payload = writer.writeValueAsString(dtoVuelo);

        mockMvc.perform(delete("/api/vuelos/{id}/eliminar", 6))
                .andDo(print())
                .andExpect(content().contentType("application/json"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(6));
    }

}
