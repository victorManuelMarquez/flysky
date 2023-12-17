package ar.com.codoacodo.flysky.controller;

import ar.com.codoacodo.flysky.model.dto.DtoInforme;
import ar.com.codoacodo.flysky.service.InformesServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
@RequestMapping("/api/informes")
public class InformesController {

    @Autowired
    private InformesServiceImpl service;

    @GetMapping("/")
    public ResponseEntity<?> listarTodo() {
        return new ResponseEntity<>(service.todosLosInformes(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> seleccionar(@PathVariable Integer id) {
        return new ResponseEntity<>(service.buscarPorId(id), HttpStatus.OK);
    }

    @PostMapping("/registrar")
    public ResponseEntity<?> registrar(@RequestBody DtoInforme informe) {
        return new ResponseEntity<>(service.agregarNuevo(informe), HttpStatus.OK);
    }

    @DeleteMapping("/{id}/eliminar")
    public ResponseEntity<?> eliminar(@PathVariable Integer id) {
        return new ResponseEntity<>(service.eliminar(id), HttpStatus.OK);
    }

}

