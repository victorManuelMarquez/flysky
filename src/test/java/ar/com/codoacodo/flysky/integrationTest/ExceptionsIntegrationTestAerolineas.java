package ar.com.codoacodo.flysky.integrationTest;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

@AutoConfigureMockMvc
@SpringBootTest
public class ExceptionsIntegrationTestAerolineas {
    @Autowired
    MockMvc mockMvc;
    @Test //Aerolinas
    @DisplayName("Test Integracion Camino Feliz -> Integracion AerolineasException -> buscarPorId")
    void aerolineasbuscarPorIdExceptionOkTest() throws Exception {
        mockMvc.perform(get("/api/aerolineas/{id}", 188)
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isNotFound())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.message").value("¡La aerolínea especificada no existe!"))
                .andExpect(jsonPath("$.status").value(404));
    }
    @Test //Aerolinas
    @DisplayName("Test Integracion Camino Feliz -> Integracion AerolineasException -> eliminar")
    void aerolineasEliminarExceptionOkTest() throws Exception {
        mockMvc.perform(delete("/api/aerolineas/{id}/eliminar", 188)
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isNotFound())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.message").value("¡La aerolínea especificada no existe!"))
                .andExpect(jsonPath("$.status").value(404));
    }

}
