package ar.com.codoacodo.flysky.controller;

import ar.com.codoacodo.flysky.model.dto.DtoBoleto;
import ar.com.codoacodo.flysky.service.BoletosServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
@RequestMapping("/api/boletos")
public class BoletosController {

    @Autowired
    private BoletosServiceImpl service;

    @GetMapping("/")
    public ResponseEntity<?> listarTodos() {
        return new ResponseEntity<>(service.todosLosBoletos(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> seleccionar(@PathVariable Integer id) {
        return new ResponseEntity<>(service.buscarPorId(id), HttpStatus.OK);
    }

    @PostMapping("/registrar")
    public ResponseEntity<?> registrar(@RequestBody DtoBoleto nuevo) {
        return new ResponseEntity<>(service.agregarBoleto(nuevo), HttpStatus.OK);
    }

    @DeleteMapping("/{id}/eliminar")
    public ResponseEntity<?> eliminar(@PathVariable Integer id) {
        return new ResponseEntity<>(service.eliminar(id), HttpStatus.OK);
    }

}
