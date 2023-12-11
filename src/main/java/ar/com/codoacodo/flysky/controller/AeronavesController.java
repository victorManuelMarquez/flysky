package ar.com.codoacodo.flysky.controller;

import ar.com.codoacodo.flysky.model.dto.DtoAeronave;
import ar.com.codoacodo.flysky.service.AeronavesServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
@RequestMapping("/api/aeronaves")
public class AeronavesController {

    @Autowired
    private AeronavesServiceImpl service;

    @GetMapping("/")
    public ResponseEntity<?> todos() {
        return new ResponseEntity<>(service.todasLasAeronaves(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> seleccionar(@PathVariable Integer id) {
        return new ResponseEntity<>(service.buscarPorId(id), HttpStatus.OK);
    }

    @PostMapping("/registrar")
    public ResponseEntity<?> registrar(@RequestBody DtoAeronave nueva) {
        return new ResponseEntity<>(service.agregarAeronave(nueva), HttpStatus.OK);
    }

    @PostMapping("/{id}/eliminar")
    public ResponseEntity<?> eliminar(@PathVariable Integer id) {
        return new ResponseEntity<>(service.eliminar(id), HttpStatus.OK);
    }

}
