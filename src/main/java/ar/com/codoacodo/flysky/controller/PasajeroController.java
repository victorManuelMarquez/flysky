package ar.com.codoacodo.flysky.controller;

import ar.com.codoacodo.flysky.dto.PasajeroDto;
import ar.com.codoacodo.flysky.service.implementaciones.PasajeroServiceImp;
import ar.com.codoacodo.flysky.service.interfaces.IPasajeroService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/pasajeros")
public class PasajeroController {
    private IPasajeroService service;

    public PasajeroController(PasajeroServiceImp service){
        this.service = service;
    }

    @PostMapping()
    public ResponseEntity<?> guardarPasajero(@RequestBody PasajeroDto pasajeroDto){
        return new ResponseEntity<>(service.guardarPasajero(pasajeroDto), HttpStatus.OK);
    }

    @GetMapping()
    public ResponseEntity<?> listaPasajeros(){
        return new ResponseEntity<>(service.listaPasajeros(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> buscarPasajeroPorId(@PathVariable Long id){
        return new ResponseEntity<>(service.buscarPasajeroPorId(id), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> actualizarPasajeroPorId(@PathVariable Long id, @RequestBody PasajeroDto pasajeroDto){
        return  new ResponseEntity<>(service.actualizarPasajeroPorId(id,pasajeroDto), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> borrarPasajeroPorId(@PathVariable Long id){
        return  new ResponseEntity<>(service.borrarPasajeroPorId(id), HttpStatus.OK);
    }
}
