package ar.com.codoacodo.flysky.integrationTest;

import ar.com.codoacodo.flysky.model.dto.DtoBoleto;
import ar.com.codoacodo.flysky.util.FactoryBoletosTest;
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
public class IntegrationTestBoletos {
    @Autowired
    MockMvc mockMvc;
    @Test
    @DisplayName("Test Integracion Camino Feliz -> Buscar todos los boletos")
    void boletosTodosOkTest() throws Exception {
        mockMvc.perform(get("/api/boletos/"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].id").value(4))
                .andExpect(jsonPath("$[0].nombre").value("Aerolíneas Argentinas"));
    }
    @Test
    @DisplayName("Test Integracion Camino Feliz -> buscar un boleto por id")
    void boletosSeleccionarOkTest() throws Exception {
        mockMvc.perform(get("/api/boletos/{id}", 2))
                .andDo(print())
                .andExpect(content().contentType("application/json"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(2))
                .andExpect(jsonPath("$.nombre").value("Avianca"));
    }
    @Test
    @DisplayName("Test Integracion Camino Feliz -> Agregar un nuevo boleto")
    void boletosAgregarNuevaOkTest() throws Exception {
        DtoBoleto dtoboleto = FactoryBoletosTest.nuevoBoleto();

        ObjectWriter writer = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .writer();

        String payload = writer.writeValueAsString(dtoboleto);

        mockMvc.perform(post("/api/boletos/registrar")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(payload))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.id").value(11));
    }
    @Test
    @DisplayName("Test Integracion Camino Feliz -> /api/aerolineas/{id}/eliminar -> eliminarboletos")
    void boletosEliminarOkTest() throws Exception {
        DtoBoleto dtoboleto = FactoryBoletosTest.eliminarBoleto();

        ObjectWriter writer = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .writer();

        String payload = writer.writeValueAsString(dtoboleto);

        mockMvc.perform(delete("/api/boletos/{id}/eliminar", 13))
                .andDo(print())
                .andExpect(content().contentType("application/json"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(5));
    }

}
