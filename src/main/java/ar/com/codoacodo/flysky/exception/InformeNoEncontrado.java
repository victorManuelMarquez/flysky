package ar.com.codoacodo.flysky.exception;

import lombok.NoArgsConstructor;

@NoArgsConstructor
@SuppressWarnings("SpellCheckingInspection")
public class InformeNoEncontrado extends RuntimeException {

    @Override
    public String getMessage() {
        return "¡El informe solicitado no existe!";
    }}
