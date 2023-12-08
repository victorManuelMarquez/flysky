package ar.com.codoacodo.flysky.controller;

import ar.com.codoacodo.flysky.dto.ClasesPorAvionDto;
import ar.com.codoacodo.flysky.service.implementaciones.ClasesPorAvionServiceImp;
import ar.com.codoacodo.flysky.service.interfaces.IClasesPorAvionService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/clasesPorAviones")
public class ClasesPorAvionController {
    private IClasesPorAvionService service;

    public ClasesPorAvionController(ClasesPorAvionServiceImp service){
        this.service = service;
    }

    @PostMapping()
    public ResponseEntity<?> guardarAsiento(@RequestBody ClasesPorAvionDto clasesPorAvionDto){
        return new ResponseEntity<>(service.guardarClasesPorAvion(clasesPorAvionDto), HttpStatus.OK);
    }

    @GetMapping()
    public ResponseEntity<?> listaClasesPorAviones(){
        return new ResponseEntity<>(service.listaClasesPorAviones(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> buscarClasesPorAvionPorId(@PathVariable Long id){
        return new ResponseEntity<>(service.buscarClasesPorAvionPorId(id), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> actualizarClasesPorAvionPorId(@PathVariable Long id, @RequestBody ClasesPorAvionDto clasesPorAvionDto){
        return  new ResponseEntity<>(service.actualizarClasesPorAvionPorId(id,clasesPorAvionDto), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> borrarClasesPorAvionPorId(@PathVariable Long id){
        return  new ResponseEntity<>(service.borrarClasesPorAvionPorId(id), HttpStatus.OK);
    }
}
