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
@SuppressWarnings("SpellCheckingInspection")
public class AeronavesController {

    @Autowired
    private AeronavesServiceImpl service;

    @GetMapping("/todas")
    public ResponseEntity<?> listarTodo() {
        return new ResponseEntity<>(service.todasLasAeronaves(), HttpStatus.OK);
    }

    @PostMapping("/caracteristica-nueva")
    public ResponseEntity<?> relacionar(@RequestBody DtoAeronave nueva) {
        return new ResponseEntity<>(service.vincular(nueva), HttpStatus.OK);
    }

    @PostMapping("/eliminar-caracteristica")
    public ResponseEntity<?> eliminar(@RequestBody DtoAeronave activo) {
        return new ResponseEntity<>(service.desvincular(activo), HttpStatus.OK);
    }

}
