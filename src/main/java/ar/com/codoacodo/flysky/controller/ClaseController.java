package ar.com.codoacodo.flysky.controller;

import ar.com.codoacodo.flysky.dto.ClaseDto;
import ar.com.codoacodo.flysky.service.ClaseServiceImp;
import ar.com.codoacodo.flysky.service.IClaseService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/clases")
public class ClaseController {
    private IClaseService service;

    public ClaseController(ClaseServiceImp service) {
        this.service = service;
    }

    @PostMapping()
    public ResponseEntity<?> guardarClase(@RequestBody ClaseDto claseDto) {
        return new ResponseEntity<>(service.guardarClase(claseDto), HttpStatus.OK);
    }

    @GetMapping()
    public ResponseEntity<?> listaClases() {
        return new ResponseEntity<>(service.listaClases(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> buscarClasePorId(@PathVariable Long id) {
        return new ResponseEntity<>(service.buscarClasePorId(id), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> actualizarClasePorId(@PathVariable Long id,@RequestBody ClaseDto claseDto) {
        return new ResponseEntity<>(service.actualizarClasePorId(id,claseDto), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> borrarClasePorId(@PathVariable Long id) {
        return new ResponseEntity<>(service.borrarClasePorId(id), HttpStatus.OK);
    }
}
