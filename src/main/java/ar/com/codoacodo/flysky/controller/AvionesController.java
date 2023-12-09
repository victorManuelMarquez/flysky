package ar.com.codoacodo.flysky.controller;

import ar.com.codoacodo.flysky.model.dto.DtoAvion;
import ar.com.codoacodo.flysky.service.AvionesServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
@RequestMapping("/api/aviones")
public class AvionesController {

    @Autowired
    private AvionesServiceImpl service;

    @GetMapping("/todos")
    public ResponseEntity<?> listarTodo() {
        return new ResponseEntity<>(service.todosLosAviones(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> seleccionar(@PathVariable("id") Integer id) {
        return new ResponseEntity<>(service.buscarPorId(id), HttpStatus.OK);
    }

    @PostMapping("/registrar")
    public ResponseEntity<?> crearNuevo(@RequestBody DtoAvion nuevo) {
        return new ResponseEntity<>(service.agregarAvion(nuevo), HttpStatus.OK);
    }

    @PostMapping("/eliminar/{id}")
    public ResponseEntity<?> eliminar(@PathVariable Integer id) {
        return new ResponseEntity<>(service.eliminar(id), HttpStatus.OK);
    }

}
