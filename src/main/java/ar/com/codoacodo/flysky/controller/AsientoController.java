package ar.com.codoacodo.flysky.controller;

import ar.com.codoacodo.flysky.dto.AsientoDto;
import ar.com.codoacodo.flysky.dto.ClaseaDto;
import ar.com.codoacodo.flysky.dto.response.RespuestaDto;
import ar.com.codoacodo.flysky.service.IAsientoService;
import ar.com.codoacodo.flysky.service.IClaseaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping ("/api/asientos")
public class AsientoController {
    private IAsientoService service;
    private IClaseaService cservice;

    public AsientoController(IAsientoService service, IClaseaService cservice) {
        this.service = service;
        this.cservice = cservice;
    }

    @PostMapping("/asientos")
    public ResponseEntity<RespuestaDto> guardarAsiento(@RequestBody AsientoDto asientoDto) {
        return new ResponseEntity<>(service.guardarAsiento(asientoDto), HttpStatus.OK);
    }

    @GetMapping("/asientos")
    public ResponseEntity<List<AsientoDto>> listaAsientos() {
        return new ResponseEntity<>(service.listaAsientos(), HttpStatus.OK);
    }

    @GetMapping("/asientos/{id}")
    public ResponseEntity<AsientoDto> buscarAsientoPorId(@PathVariable Long id) {
        return new ResponseEntity<>(service.buscarAsientoPorId(id), HttpStatus.OK);
    }

    @PutMapping("/asientos/{id}")
    public ResponseEntity<RespuestaDto> actualizarAsientoPorId(@PathVariable Long id, @RequestBody AsientoDto asientoDto) {
        return new ResponseEntity<>(service.actualizarAsientoPorId(id, asientoDto), HttpStatus.OK);
    }

    @DeleteMapping("/asientos/{id}")
    public ResponseEntity<RespuestaDto> borrarAsientoPorId(@PathVariable Long id) {
        return new ResponseEntity<>(service.borrarAsientoPorId(id), HttpStatus.OK);
    }

    // Endpoints para Clases

    @PostMapping("/clases")
    public ResponseEntity<RespuestaDto> guardarClase(@RequestBody ClaseaDto claseaDto) {
        return new ResponseEntity<>(cservice.guardarClasea(claseaDto), HttpStatus.OK);
    }

    @GetMapping("/clases")
    public ResponseEntity<List<ClaseaDto>> listaClases() {
        List<ClaseaDto> clases = cservice.listaClasesa();
        return new ResponseEntity<>(clases, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClaseaDto> buscarClasePorId(@PathVariable Long id) {
        return new ResponseEntity<>(cservice.buscarClaseaPorId(id), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<RespuestaDto> borrarClasePorId(@PathVariable Long id) {
        return new ResponseEntity<>(cservice.borrarClaseaPorId(id), HttpStatus.OK);
    }

}
