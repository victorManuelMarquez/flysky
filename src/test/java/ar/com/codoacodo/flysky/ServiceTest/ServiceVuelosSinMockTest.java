package ar.com.codoacodo.flysky.ServiceTest;

import ar.com.codoacodo.flysky.service.VuelosServiceImpl;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ServiceVuelosSinMockTest {

    @Autowired
    VuelosServiceImpl vuelosService;


    @Test
    @DisplayName("Test VuelosController sin Mock Camino Feliz -> listarTodo")
    void listarTodo() {

    }


}


