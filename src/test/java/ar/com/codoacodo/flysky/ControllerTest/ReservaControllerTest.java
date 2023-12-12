package ar.com.codoacodo.flysky.ControllerTest;

import ar.com.codoacodo.flysky.controller.ReservaController;
import ar.com.codoacodo.flysky.dto.response.RespuestaDto;
import ar.com.codoacodo.flysky.service.ReservaServiceImp;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ReservaControllerTest {
    @Mock
    ReservaServiceImp reservaServiceImp;

    @InjectMocks
    ReservaController reservaController;

    @Test
    @DisplayName("Test ReservaController Camino Feliz -> guardarReserva")
    void guardarReserva(){
        //Arrange
        RespuestaDto body = new RespuestaDto("Reserva realizada correctamente");
        //ReservaDto reservaDto = new unaReserva();


        //ReservaDto reservaSUT;
        //Act
        //Assert

    }

    @Test
    @DisplayName("Test ReservaController Camino Feliz -> listaReservas")
    void listaReservas(){
        //Arrange

        //Act

        //Assert

    }

    @Test
    @DisplayName("Test ReservaController Camino Feliz -> buscarReservaPorId")
    void buscarReservaPorId(){
        //Arrange

        //Act

        //Assert

    }
    @Test
    @DisplayName("Test ReservaController Camino Feliz -> actualizarReservaPorId")
    void actualizarReservaPorId(){
        //Arrange

        //Act

        //Assert

    }
    @Test
    @DisplayName("Test ReservaController Camino Feliz -> borrarReservaPorId")
    void borrarReservaPorId(){
        //Arrange
        Long idSut = 1L;
        RespuestaDto body = new RespuestaDto("Reserva borrada");
        ResponseEntity<?> expected = new ResponseEntity<>(body, HttpStatus.OK);

        when(reservaServiceImp.borrarReservaPorId(any())).thenReturn(new RespuestaDto("Reserva borrada"));
        //Act
        ResponseEntity<?> actual = reservaController.borrarReservaPorId(idSut);
        //Assert
        assertEquals(expected, actual);

    }

}
