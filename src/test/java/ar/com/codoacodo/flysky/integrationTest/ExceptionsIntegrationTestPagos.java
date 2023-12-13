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

@AutoConfigureMockMvc
@SpringBootTest
public class ExceptionsIntegrationTestPagos {
    @Autowired
    MockMvc mockMvc;
    
    @Test //Aeronaves
    @DisplayName("Test Integracion Camino Feliz -> Integracion pagosException -> buscarPorId")
    void pagosbuscarPorIdExceptionOkTest() throws Exception {
        mockMvc.perform(get("/api/pagos/{id}", 188)
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isNotFound())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.message").value("¡El pago solicitado no existe!"))
                .andExpect(jsonPath("$.status").value(404));
    }
    @Test //Aeronaves
    @DisplayName("Test Integracion Camino Feliz -> Integracion pagosException -> eliminar")
    void pagosEliminarExceptionOkTest() throws Exception {
        mockMvc.perform(delete("/api/pagos/{id}/eliminar", 188)
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isNotFound())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.message").value("¡El pago solicitado no existe!"))
                .andExpect(jsonPath("$.status").value(404));
    }
}
