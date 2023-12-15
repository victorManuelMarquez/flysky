package ar.com.codoacodo.flysky.integrationTest;

import ar.com.codoacodo.flysky.model.dto.DtoAerolinea;
import ar.com.codoacodo.flysky.model.dto.DtoClase;
import ar.com.codoacodo.flysky.util.FactoryAerolineasTest;
import ar.com.codoacodo.flysky.util.FactoryClaseTest;
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
public class IntegrationTestClases {
    @Autowired
    MockMvc mockMvc;
    @Test
    @DisplayName("Test Integracion Camino Feliz -> Buscar todas las clases")
    void clasesTodosOkTest() throws Exception {
        mockMvc.perform(get("/api/clases/"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].id").value(8))
                .andExpect(jsonPath("$[0].nombre").value("Clase Económica"));
    }
    @Test
    @DisplayName("Test Integracion Camino Feliz -> buscar una clase por id")
    void clasesSeleccionarOkTest() throws Exception {
        mockMvc.perform(get("/api/clases/{id}", 2))
                .andDo(print())
                .andExpect(content().contentType("application/json"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(2))
                .andExpect(jsonPath("$.nombre").value("Ejecutiva"));
    }
    @Test
    @DisplayName("Test Integracion Camino Feliz -> Agregar una nueva clase")
    void clasesAgregarNuevaOkTest() throws Exception {
        DtoClase dtoClase = FactoryClaseTest.nuevaClase();

        ObjectWriter writer = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .writer();

        String payload = writer.writeValueAsString(dtoClase);

        mockMvc.perform(post("/api/clases/registrar")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(payload))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.nombre").value("Prueba 11"));
    }
    @Test
    @DisplayName("Test Integracion Camino Feliz -> Eliminar una clase por id")
    void clasesEliminarOkTest() throws Exception {
        DtoClase dtoClase = FactoryClaseTest.nuevaClase();

        ObjectWriter writer = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .writer();

        String payload = writer.writeValueAsString(dtoClase);

        mockMvc.perform(delete("/api/clases/{id}/eliminar", dtoClase.getId()))
                .andDo(print())
                .andExpect(content().contentType("application/json"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(10))
                .andExpect(jsonPath("$.nombre").value("Premium First Class"));
    }

}
