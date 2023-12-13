package ar.com.codoacodo.flysky.integrationTest;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@AutoConfigureMockMvc
@SpringBootTest
public class IntegrationTestPasajeros {
    @Autowired
    MockMvc mockMvc;
    @Test
    @DisplayName("Test Integracion Camino Feliz -> /api/aerolineas/todos()")
    void aerolineasTodosOkTest() throws Exception {
        mockMvc.perform(get("/api/aerolineas"))
                .andDo(print())
                .andExpect(status().isNotFound())
                .andExpect(jsonPath("$[0].nombre").value("LATAM Airlines"));
    }

    @Test
    @DisplayName("Test Integracion Camino Feliz -> /api/aerolineas/todos()")
    void aerolineasTodosOkTeste() throws Exception {
        mockMvc.perform(get("/api/aerolineas"))
                .andDo(print())
                .andExpect(status().isNotFound())
                .andExpect(jsonPath("$[0].nombre").value("LATAM Airlines"));
    }

}
