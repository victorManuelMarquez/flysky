package ar.com.codoacodo.flysky.controller;

import ar.com.codoacodo.flysky.dto.VueloDto;
import ar.com.codoacodo.flysky.service.IVueloService;
import ar.com.codoacodo.flysky.service.VueloServiceImp;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/vuelos")
public class VueloController {

    private IVueloService service;

    public VueloController(VueloServiceImp service){
        this.service = service;
    }

    @PostMapping()
    public ResponseEntity<?> guardarVuelo(@RequestBody VueloDto vueloDto){
        return new ResponseEntity<>(service.guardarVuelo(vueloDto), HttpStatus.OK);
    }

    @GetMapping()
    public ResponseEntity<?> listaVuelos(){
        return new ResponseEntity<>(service.listaVuelos(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> consultarVueloPorId(@PathVariable Long id){
        return new ResponseEntity<>(service.buscarVueloPorId(id), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> actualizarVueloPorId(@PathVariable Long id){
        return  new ResponseEntity<>(service.actualizarVueloPorId(id), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> borrarVueloPorId(@PathVariable Long id){
        return  new ResponseEntity<>(service.borrarVueloPorId(id), HttpStatus.OK);
    }
}
