package ar.com.codoacodo.flysky.controller;

import ar.com.codoacodo.flysky.model.dto.DtoVuelo;
import ar.com.codoacodo.flysky.service.VuelosServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
@RequestMapping("/api/vuelos")
public class VuelosController {

    @Autowired
    private VuelosServiceImpl service;

    @GetMapping("/")
    public ResponseEntity<?> listarTodo() {
        return new ResponseEntity<>(service.todosLosVuelos(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> seleccionar(@PathVariable Integer id) {
        return new ResponseEntity<>(service.buscarPorId(id), HttpStatus.OK);
    }

    @PostMapping("/registrar")
    public ResponseEntity<?> registrar(@RequestBody DtoVuelo vuelo) {
        return new ResponseEntity<>(service.agregarVuelo(vuelo), HttpStatus.OK);
    }

    @PostMapping("/{id}/eliminar")
    public ResponseEntity<?> eliminar(@PathVariable Integer id) {
        return new ResponseEntity<>(service.eliminar(id), HttpStatus.OK);
    }

}
