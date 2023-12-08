package ar.com.codoacodo.flysky.controller;

import ar.com.codoacodo.flysky.dto.UsuarioDto;
import ar.com.codoacodo.flysky.service.implementaciones.UsuarioServiceImp;
import ar.com.codoacodo.flysky.service.interfaces.IUsuarioService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {
    private IUsuarioService service;

    public UsuarioController(UsuarioServiceImp service){
        this.service = service;
    }

    @PostMapping()
    public ResponseEntity<?> guardarUsuario(@RequestBody UsuarioDto usuarioDto){
        return new ResponseEntity<>(service.guardarUsuario(usuarioDto), HttpStatus.OK);
    }

    @GetMapping()
    public ResponseEntity<?> listaUsuarios(){
        return new ResponseEntity<>(service.listaUsuarios(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> buscarUsuarioPorId(@PathVariable Long id){
        return new ResponseEntity<>(service.buscarUsuarioPorId(id), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> actualizarUsuarioPorId(@PathVariable Long id, @RequestBody UsuarioDto usuarioDto){
        return  new ResponseEntity<>(service.actualizarUsuarioPorId(id,usuarioDto), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> borrarUsuarioPorId(@PathVariable Long id){
        return  new ResponseEntity<>(service.borrarUsuarioPorId(id), HttpStatus.OK);
    }
}
