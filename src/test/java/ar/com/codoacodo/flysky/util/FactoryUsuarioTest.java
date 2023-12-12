package ar.com.codoacodo.flysky.util;

import ar.com.codoacodo.flysky.dto.UsuarioDto;

public class FactoryUsuarioTest {
    public static UsuarioDto unUsuario(){
        return new UsuarioDto(1L, "unuarioprueba@gmail.com", "12345Nn-12");
    }

}
