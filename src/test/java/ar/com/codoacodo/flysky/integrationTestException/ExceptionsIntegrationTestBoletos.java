package ar.com.codoacodo.flysky.integrationTestException;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
@AutoConfigureMockMvc
@SpringBootTest
public class ExceptionsIntegrationTestBoletos {
    @Autowired
    MockMvc mockMvc;
    
    @Test //Aeronaves
    @DisplayName("Test Integracion Camino Feliz -> Integracion boletosException -> buscarPorId")
    void boletosbuscarPorIdExceptionOkTest() throws Exception {
        mockMvc.perform(get("/api/boletos/{id}", 188)
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isNotFound())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.message").value("¡El boleto requerido no existe!"))
                .andExpect(jsonPath("$.status").value(404));
    }
    @Test //Aeronaves
    @DisplayName("Test Integracion Camino Feliz -> Integracion boletosException -> eliminar")
    void boletosEliminarExceptionOkTest() throws Exception {
        mockMvc.perform(delete("/api/boletos/{id}/eliminar", 188)
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isNotFound())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.message").value("¡El boleto requerido no existe!"))
                .andExpect(jsonPath("$.status").value(404));
    }
}
