package ar.com.codoacodo.flysky.controller;

import ar.com.codoacodo.flysky.dto.VueloDto;
import ar.com.codoacodo.flysky.service.IVueloService;
import ar.com.codoacodo.flysky.service.VueloServiceImp;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class VueloController {

    private IVueloService service;

    public VueloController(VueloServiceImp service){
        this.service = service;
    }

    @PostMapping("/reservar")
    public ResponseEntity<?> reservarVuelo(@RequestBody VueloDto vueloDto){
        return new ResponseEntity<>(service.guardarVuelo(vueloDto), HttpStatus.OK);
    }

    @GetMapping("/vuelos-disponibles")
    public ResponseEntity<?> vuelosDisponibles(){
        return null;
    }
}
