package ar.com.codoacodo.flysky.controller;

import ar.com.codoacodo.flysky.dto.AvionDto;
import ar.com.codoacodo.flysky.service.implementaciones.AvionServiceImp;
import ar.com.codoacodo.flysky.service.interfaces.IAvionService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/aviones")
public class AvionController {
    private IAvionService service;

    public AvionController(AvionServiceImp service){
        this.service = service;
    }

    @PostMapping()
    public ResponseEntity<?> guardarAvion(@RequestBody AvionDto avionDto){
        return new ResponseEntity<>(service.guardarAvion(avionDto), HttpStatus.OK);
    }

    @GetMapping()
    public ResponseEntity<?> listaAviones(){
        return new ResponseEntity<>(service.listaAviones(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> buscarAvionPorId(@PathVariable Long id){
        return new ResponseEntity<>(service.buscarAvionPorId(id), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> actualizarAvionPorId(@PathVariable Long id, @RequestBody AvionDto avionDto){
        return  new ResponseEntity<>(service.actualizarAvionPorId(id,avionDto), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> borrarAvionPorId(@PathVariable Long id){
        return  new ResponseEntity<>(service.borrarAvionPorId(id), HttpStatus.OK);
    }
}
