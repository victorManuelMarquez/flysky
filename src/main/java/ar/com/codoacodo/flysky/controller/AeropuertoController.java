package ar.com.codoacodo.flysky.controller;

import ar.com.codoacodo.flysky.dto.AeropuertoDto;
import ar.com.codoacodo.flysky.service.implementaciones.AeropuertoServiceImp;
import ar.com.codoacodo.flysky.service.interfaces.IAeropuertoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/aeropuertos")
public class AeropuertoController {
    private IAeropuertoService service;

    public AeropuertoController(AeropuertoServiceImp service){
        this.service = service;
    }

    @PostMapping()
    public ResponseEntity<?> guardarAeropuerto(@RequestBody AeropuertoDto aeropuertoDto){
        return new ResponseEntity<>(service.guardarAeropuerto(aeropuertoDto), HttpStatus.OK);
    }

    @GetMapping()
    public ResponseEntity<?> listaAeropuertos(){
        return new ResponseEntity<>(service.listaAeropuertos(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> buscarAeropuertoPorId(@PathVariable Long id){
        return new ResponseEntity<>(service.buscarAeropuertoPorId(id), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> actualizarAeropuertoPorId(@PathVariable Long id, @RequestBody AeropuertoDto aeropuertoDto){
        return  new ResponseEntity<>(service.actualizarAeropuertoPorId(id,aeropuertoDto), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> borrarAerolineaPorId(@PathVariable Long id){
        return  new ResponseEntity<>(service.borrarAeropuertoPorId(id), HttpStatus.OK);
    }
}
