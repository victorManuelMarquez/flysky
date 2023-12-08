package ar.com.codoacodo.flysky.controller;

import ar.com.codoacodo.flysky.dto.FlotaDto;
import ar.com.codoacodo.flysky.service.implementaciones.FlotaServiceImp;
import ar.com.codoacodo.flysky.service.interfaces.IFlotaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/flotas")
public class FlotaController {
    private IFlotaService service;

    public FlotaController(FlotaServiceImp service){
        this.service = service;
    }

    @PostMapping()
    public ResponseEntity<?> guardarFlota(@RequestBody FlotaDto flotaDto){
        return new ResponseEntity<>(service.guardarFlota(flotaDto), HttpStatus.OK);
    }

    @GetMapping()
    public ResponseEntity<?> listaFlotas(){
        return new ResponseEntity<>(service.listaFlotas(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> buscarFlotaPorId(@PathVariable Long id){
        return new ResponseEntity<>(service.buscarFlotaPorId(id), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> actualizarFlotaPorId(@PathVariable Long id, @RequestBody FlotaDto flotaDto){
        return  new ResponseEntity<>(service.actualizarFlotaPorId(id,flotaDto), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> borrarFlotaPorId(@PathVariable Long id){
        return  new ResponseEntity<>(service.borrarFlotaPorId(id), HttpStatus.OK);
    }
}
