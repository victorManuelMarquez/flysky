package ar.com.codoacodo.flysky.service.interfaces;

import ar.com.codoacodo.flysky.dto.UsuarioDto;
import ar.com.codoacodo.flysky.dto.response.RespuestaDto;

import java.util.List;

public interface IUsuarioService {
//CRUD

    RespuestaDto guardarUsuario(UsuarioDto usuarioDto);

    List<UsuarioDto> listaUsuarios();

    UsuarioDto buscarUsuarioPorId(Long id);

    RespuestaDto actualizarUsuarioPorId(Long id, UsuarioDto usuarioDto);

    RespuestaDto borrarUsuarioPorId(Long id);
}
