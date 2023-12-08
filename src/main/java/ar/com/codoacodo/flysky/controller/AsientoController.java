package ar.com.codoacodo.flysky.controller;

import ar.com.codoacodo.flysky.dto.AsientoDto;
import ar.com.codoacodo.flysky.service.AsientoServiceImp;
import ar.com.codoacodo.flysky.service.IAsientoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

public class AsientoController {
    private IAsientoService service;

    public AsientoController(AsientoServiceImp service){
        this.service = service;
    }

    @PostMapping()
    public ResponseEntity<?> guardarAsiento(@RequestBody AsientoDto asientoDto){
        return new ResponseEntity<>(service.guardarAsiento(asientoDto), HttpStatus.OK);
    }

    @GetMapping()
    public ResponseEntity<?> listaAsientos(){
        return new ResponseEntity<>(service.listaAsientos(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> buscarAsientoPorId(@PathVariable Long id){
        return new ResponseEntity<>(service.buscarAsientoPorId(id), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> actualizarAsientoPorId(@PathVariable Long id, @RequestBody AsientoDto asientoDto){
        return  new ResponseEntity<>(service.actualizarAsientoPorId(id,asientoDto), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> borrarAsientoPorId(@PathVariable Long id){
        return  new ResponseEntity<>(service.borrarAsientoPorId(id), HttpStatus.OK);
    }
}
