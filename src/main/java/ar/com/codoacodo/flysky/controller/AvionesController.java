package ar.com.codoacodo.flysky.controller;

import ar.com.codoacodo.flysky.model.dto.DtoAvion;
import ar.com.codoacodo.flysky.service.AvionesServicioImpl;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
@RequestMapping("/api/aviones")
@SuppressWarnings("SpellCheckingInspection")
public class AvionesController {

    @Autowired
    private AvionesServicioImpl servicio;

    @GetMapping("/")
    public ResponseEntity<?> listarTodo() {
        return new ResponseEntity<>(servicio.todosLosAviones(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> seleccionar(@PathVariable Integer id) {
        return new ResponseEntity<>(servicio.buscarPorId(id), HttpStatus.OK);
    }

    @PostMapping("/registrar")
    public ResponseEntity<?> registrar(@RequestBody DtoAvion avion) {
        return new ResponseEntity<>(servicio.agregarNuevo(avion), HttpStatus.OK);
    }

    @DeleteMapping("/{id}/eliminar")
    public ResponseEntity<?> eliminar(@PathVariable Integer id) {
        return new ResponseEntity<>(servicio.eliminar(id), HttpStatus.OK);
    }

}
