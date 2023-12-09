package ar.com.codoacodo.flysky.controller;

import ar.com.codoacodo.flysky.model.dto.DtoAsiento;
import ar.com.codoacodo.flysky.service.AsientosServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
@RequestMapping("/api/asientos")
public class AsientosController {

    @Autowired
    private AsientosServiceImpl service;

    @GetMapping("/todos")
    public ResponseEntity<?> listarTodo() {
        return new ResponseEntity<>(service.todosLosAsientos(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> seleccionar(@PathVariable("id") Integer id) {
        return new ResponseEntity<>(service.buscarPorId(id), HttpStatus.OK);
    }

    @PostMapping("/registrar")
    public ResponseEntity<?> crearNuevo(@RequestBody DtoAsiento nuevo) {
        return new ResponseEntity<>(service.agregarAsiento(nuevo), HttpStatus.OK);
    }

    @PostMapping("/eliminar/{id}")
    public ResponseEntity<?> eliminar(@PathVariable("id") Integer id) {
        return new ResponseEntity<>(service.eliminar(id), HttpStatus.OK);
    }

}
