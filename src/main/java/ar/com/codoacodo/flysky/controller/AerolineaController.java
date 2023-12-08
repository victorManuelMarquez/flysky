package ar.com.codoacodo.flysky.controller;

import ar.com.codoacodo.flysky.dto.AerolineaDto;
import ar.com.codoacodo.flysky.service.implementaciones.AerolineaServiceImp;
import ar.com.codoacodo.flysky.service.interfaces.IAerolineaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/aerolineas")
public class AerolineaController {
    private IAerolineaService service;

    public AerolineaController(AerolineaServiceImp service){
        this.service = service;
    }

    @PostMapping()
    public ResponseEntity<?> guardarAerolinea(@RequestBody AerolineaDto aerolineaDto){
        return new ResponseEntity<>(service.guardarAerolinea(aerolineaDto), HttpStatus.OK);
    }

    @GetMapping()
    public ResponseEntity<?> listaAerolineas(){
        return new ResponseEntity<>(service.listaAerolineas(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> buscarAerolineaPorId(@PathVariable Long id){
        return new ResponseEntity<>(service.buscarAerolineaPorId(id), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> actualizarAerolineaPorId(@PathVariable Long id, @RequestBody AerolineaDto aerolineaDto){
        return  new ResponseEntity<>(service.actualizarAerolineaPorId(id,aerolineaDto), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> borrarAerolineaPorId(@PathVariable Long id){
        return  new ResponseEntity<>(service.borrarAerolineaPorId(id), HttpStatus.OK);
    }
}
