package ar.com.codoacodo.flysky.controller;

import ar.com.codoacodo.flysky.model.dto.DtoClase;
import ar.com.codoacodo.flysky.service.ClasesServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
@RequestMapping("/api/clases")
public class ClasesController {

    @Autowired
    private ClasesServiceImpl service;

    @GetMapping("/todas")
    public ResponseEntity<?> listarTodo() {
        return new ResponseEntity<>(service.todasLasClases(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> seleccionar(@PathVariable("id") Integer id) {
        return new ResponseEntity<>(service.buscarPorId(id), HttpStatus.OK);
    }

    @PostMapping("/registrar")
    public ResponseEntity<?> crearNueva(@RequestBody DtoClase nueva) {
        return new ResponseEntity<>(service.agregarNueva(nueva), HttpStatus.OK);
    }

    @PostMapping("/eliminar/{id}")
    public ResponseEntity<?> eliminarUna(@PathVariable("id") Integer id) {
        return new ResponseEntity<>(service.eliminar(id), HttpStatus.OK);
    }

}
