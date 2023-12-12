package ar.com.codoacodo.flysky.ServiceTest;

import ar.com.codoacodo.flysky.exception.VueloNoEncontrado;
import ar.com.codoacodo.flysky.repository.VuelosRepository;
import ar.com.codoacodo.flysky.service.VuelosServiceImpl;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class ServiceVuelosTest {

    @Mock
    private VuelosRepository repository;

    @InjectMocks
    private VuelosServiceImpl vuelosService;



/*
    @Test
    @DisplayName("Camino Feliz todosLosVuelos")
    void todosLosVuelosTest() {
        // Arrange
        List<Vuelo> vuelos = new ArrayList<>();
        vuelos.add(new Vuelo(1, 2, 1, "2023-01-01", "2023-01-02"));
        vuelos.add(new Vuelo(3, 4, 2, "2023-02-01", "2023-02-02"));
        when(repository.findAll()).thenReturn(vuelos);

        // Act
        List<DtoVuelo> result = vuelosService.todosLosVuelos();

        // Assert
        assertEquals(2, result.size());
    }

    @Test
    @DisplayName("Camino Feliz buscarPorId")
    void buscarPorIdTest() {
        // Arrange
        int id = 1;
        Vuelo vuelo = new Vuelo(1, 2, 1, "2023-01-01", "2023-01-02");
        when(repository.findById(id)).thenReturn(Optional.of(vuelo));

        // Act
        DtoVuelo result = vuelosService.buscarPorId(id);

        // Assert
        assertEquals(2, result.getAerolinea().getId());
        assertEquals(1, result.getOrigen().getId());
    }
*/
    @Test
    @DisplayName("Camino NO feliz buscarPorId - VueloNoEncontrado")
    void buscarPorIdThrowExceptionTest() {
        // Arrange
        int id = 1;
        when(repository.findById(id)).thenReturn(Optional.empty());

        // Act and Assert
        assertThrows(VueloNoEncontrado.class, () -> vuelosService.buscarPorId(id));
    }
/*
    @Test
    @DisplayName("Camino Feliz agregarVuelo")
    void agregarVueloTest() {
        // Arrange
        DtoVuelo dtoVuelo = new DtoVuelo(null, new Aerolinea(5, "Aerolinea Name"), new Aeropuerto(6, "Aeropuerto Destino"), new Aeropuerto(3, "Aeropuerto Origen"), new Date(), new Date());
        Vuelo vuelo = new Vuelo(null, 5, 6, 3, "2023-03-01", "2023-03-02");
        when(repository.save(any(Vuelo.class))).thenReturn(vuelo);

        // Act
        DtoVuelo result = vuelosService.agregarVuelo(dtoVuelo);

        // Assert
        assertEquals(5, result.getAerolinea().getId());
        assertEquals(6, result.getDestino().getId());
        assertEquals(3, result.getOrigen().getId());
    }

    @Test
    @DisplayName("Camino Feliz eliminar")
    void eliminarTest() {
        // Arrange
        int id = 1;
        Vuelo vuelo = new Vuelo(1, 2, 1, "2023-01-01", "2023-01-02");
        when(repository.findById(id)).thenReturn(Optional.of(vuelo));

        // Act
        DtoVuelo result = vuelosService.eliminar(id);

        // Assert
        assertEquals(2, result.getAerolinea().getId());
        assertEquals(1, result.getOrigen().getId());
        verify(repository, times(1)).deleteById(id);
    }
*/
    @Test
    @DisplayName("Camino NO feliz eliminar - VueloNoEncontrado")
    void eliminarThrowExceptionTest() {
        // Arrange
        int id = 1;
        when(repository.findById(id)).thenReturn(Optional.empty());

        // Act and Assert
        assertThrows(VueloNoEncontrado.class, () -> vuelosService.eliminar(id));
        verify(repository, never()).deleteById(id);
    }
}
