package ar.com.codoacodo.flysky.service.implementaciones;

import ar.com.codoacodo.flysky.dto.UsuarioDto;
import ar.com.codoacodo.flysky.dto.response.RespuestaDto;
import ar.com.codoacodo.flysky.entity.Usuario;
import ar.com.codoacodo.flysky.repository.IUsuarioRepository;
import ar.com.codoacodo.flysky.service.interfaces.IUsuarioService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioServiceImp implements IUsuarioService {

    private IUsuarioRepository repository;

    public UsuarioServiceImp(IUsuarioRepository repository){
        this.repository = repository;
    }

    @Override
    public RespuestaDto guardarUsuario(UsuarioDto usuarioDto) {
        ObjectMapper mapper = new ObjectMapper();
        Usuario usuario = mapper.convertValue(usuarioDto, Usuario.class);

        usuario = repository.save(usuario);

        if(usuario.getId() == null){
            return new RespuestaDto("No sea ha podido guardar el usuario, por favor vuelva a intentarlo");
        }

        return new RespuestaDto("Usuario Guardado Correctamente");
    }

    @Override
    public List<UsuarioDto> listaUsuarios() {
        ObjectMapper mapper = new ObjectMapper();
        return repository.findAll().stream().map(usuario -> mapper.convertValue(usuario, UsuarioDto.class)).toList();
    }

    @Override
    public UsuarioDto buscarUsuarioPorId(Long id) {
        ModelMapper mapper = new ModelMapper();

        Optional<Usuario> usuarioOptional = repository.findById(id);

        UsuarioDto respuesta = usuarioOptional.map(usuario -> mapper.map(usuario, UsuarioDto.class)).orElse(null);

        return respuesta;
    }

    @Override
    public RespuestaDto actualizarUsuarioPorId(Long id, UsuarioDto usuarioDto) {
        Optional<Usuario> usuarioOptional = repository.findById(id);

        if (usuarioOptional.isPresent()) {
            Usuario unew = usuarioOptional.get();

            unew.setEmail(usuarioDto.getEmail());
            unew.setClave(usuarioDto.getClave());

            repository.save(unew);
            return new RespuestaDto("Usuario actualizado correctamente");
        } else {
            return new RespuestaDto("No se encontró un Usuario con el ID proporcionado");
        }
    }

    @Override
    public RespuestaDto borrarUsuarioPorId(Long id) {

        //hacer un try catch con exception

        //Si existe lo borro
        if(repository.existsById(id)){
            repository.deleteById(id);
            return new RespuestaDto("Usuario borrado");
        }else {
            return new RespuestaDto("No hay un Usuario correspondiente a ese ID \nNo fue posible borrarlo");
        }



    }
}
