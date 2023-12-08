package ar.com.codoacodo.flysky.controller;

import ar.com.codoacodo.flysky.dto.ClaseDto;
import ar.com.codoacodo.flysky.service.IClaseService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/clases")
public class ClaseController {

    private IClaseService claseService;

    public ClaseController(IClaseService claseService) {
        this.claseService = claseService;
    }

    @PostMapping()
    public ResponseEntity<?> guardarClase(@RequestBody ClaseDto claseDto) {
        return new ResponseEntity<>(claseService.guardarClase(claseDto), HttpStatus.OK);
    }

    @GetMapping()
    public ResponseEntity<List<ClaseDto>> listaClases() {
        List<ClaseDto> clases = claseService.listaClases();
        return new ResponseEntity<>(clases, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> buscarClasePorId(@PathVariable Long id) {
        return new ResponseEntity<>(claseService.buscarClasePorId(id), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> actualizarClasePorId(@PathVariable Long id, @RequestBody ClaseDto claseDto) {
        return new ResponseEntity<>(claseService.actualizarClasePorId(id, claseDto), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> borrarClasePorId(@PathVariable Long id) {
        return new ResponseEntity<>(claseService.borrarClasePorId(id), HttpStatus.OK);
    }
}
