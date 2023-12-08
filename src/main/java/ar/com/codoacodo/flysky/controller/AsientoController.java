package ar.com.codoacodo.flysky.controller;

import ar.com.codoacodo.flysky.service.IAsientoService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping ("/api/asientos")
public class AsientoController {
    private IAsientoService service;
/*
    @GetMapping
    public ResponseEntity<List<Asiento>> listaAsientos() {
        List<Asiento> asientos = service.listaAsientos();
        return new ResponseEntity<>(asientos, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Asiento> consultarAsientoPorId(@PathVariable Long id) {
        Asiento asiento = service.buscarAsientoPorId(id);
        return new ResponseEntity<>(asiento, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Asiento> guardarAsiento(@RequestBody Asiento asiento) {
        Asiento nuevoAsiento = service.guardarAsiento(asiento);
        return new ResponseEntity<>(nuevoAsiento, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Asiento> actualizarAsientoPorId(@PathVariable Long id, @RequestBody Asiento asiento) {
        Asiento asientoActualizado = service.actualizarAsientoPorId(id, asiento);
        return new ResponseEntity<>(asientoActualizado, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> borrarAsientoPorId(@PathVariable Long id) {
        service.borrarAsientoPorId(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

*/

}
