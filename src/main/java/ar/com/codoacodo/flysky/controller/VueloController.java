package ar.com.codoacodo.flysky.controller;

<<<<<<< HEAD

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VueloController {

@GetMapping("/hola")
    public String saludar(){
    return  "Hola   Mauri";
}
    /*User Story 1:
    COMO usuario,
    QUIERO poder ver la lista de vuelos disponibles con su información detallada, como horarios, precios y aerolíneas,
    PARA poder elegir el vuelo que mejor se adapte a mis necesidades.
    voy a hacer un getall y un post para comprar boleto*/




=======
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
>>>>>>> ee6658fe82dccc5cd3b2d6b7be61ca9d68e004a4
}
