package ar.com.codoacodo.flysky.controller;

import ar.com.codoacodo.flysky.model.dto.DtoAerolinea;
import ar.com.codoacodo.flysky.service.AerolineasServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
@RequestMapping("/api/aerolineas")
@SuppressWarnings("SpellCheckingInspection")
public class AerolineasController {

    @Autowired
    private AerolineasServiceImpl service;

    @GetMapping("/todas")
    public ResponseEntity<?> listarTodo() {
        return new ResponseEntity<>(service.todasLasAerolineas(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> seleccionar(@PathVariable("id") Integer id) {
        return new ResponseEntity<>(service.buscarPorId(id), HttpStatus.OK);
    }

    @PostMapping("/registrar")
    public ResponseEntity<?> crearNueva(@RequestBody DtoAerolinea nueva) {
        return new ResponseEntity<>(service.agregarAerolinea(nueva), HttpStatus.OK);
    }

    @PostMapping("/eliminar/{id}")
    public ResponseEntity<?> eliminar(@PathVariable("id") Integer id) {
        return new ResponseEntity<>(service.eliminar(id), HttpStatus.OK);
    }

}
