package ar.com.codoacodo.flysky.controller;

import jakarta.validation.constraints.Null;
import org.springframework.http.ResponseEntity;
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




}
