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
    @DisplayName("Test Integracion Camino Feliz -> /api/clases/ -> todasLasclases")
    void clasesTodosOkTest() throws Exception {
        mockMvc.perform(get("/api/clases/"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].id").value(8))
                .andExpect(jsonPath("$[0].nombre").value("Clase Económica"));
    }
    @Test
    @DisplayName("Test Integracion Camino Feliz -> /api/clases/{id} -> buscarPorId")
    void clasesSeleccionarOkTest() throws Exception {
        mockMvc.perform(get("/api/clases/{id}", 2))
                .andDo(print())
                .andExpect(content().contentType("application/json"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(2))
                .andExpect(jsonPath("$.nombre").value("Ejecutiva"));
    }
    @Test
    @DisplayName("Test Integracion Camino Feliz -> /api/clases/registrar -> agregarNueva")
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
                .andExpect(jsonPath("$.nombre").value("Prueba "+FactoryClaseTest.id));
    }
    @Test
    @DisplayName("Test Integracion Camino Feliz -> /api/clases/{id}/eliminar -> eliminar")
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
                .andExpect(jsonPath("$.id").value(FactoryClaseTest.id))
                .andExpect(jsonPath("$.nombre").value("Prueba "+FactoryClaseTest.id));
    }

}
