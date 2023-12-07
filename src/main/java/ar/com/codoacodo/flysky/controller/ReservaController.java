package ar.com.codoacodo.flysky.controller;

import ar.com.codoacodo.flysky.dto.ReservaDto;
import ar.com.codoacodo.flysky.service.IReservaService;
import ar.com.codoacodo.flysky.service.ReservaServiceImp;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/reservas")
public class ReservaController {
    private IReservaService service;

    public ReservaController(ReservaServiceImp service) {
        this.service = service;
    }

    @PostMapping()
    public ResponseEntity<?> guardarReserva(@RequestBody ReservaDto reservaDto) {
        return new ResponseEntity<>(service.guardarReserva(reservaDto), HttpStatus.OK);
    }

    @GetMapping()
    public ResponseEntity<?> listaReservas() {
        return new ResponseEntity<>(service.listaReservas(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> consultarReservaPorId(@PathVariable Long id) {
        return new ResponseEntity<>(service.buscarReservaPorId(id), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> actualizarReservaPorId(@PathVariable Long id,@RequestBody ReservaDto reservaDto) {
        return new ResponseEntity<>(service.actualizarReservaPorId(id,reservaDto), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> borrarReservaPorId(@PathVariable Long id) {
        return new ResponseEntity<>(service.borrarReservaPorId(id), HttpStatus.OK);
    }

}
