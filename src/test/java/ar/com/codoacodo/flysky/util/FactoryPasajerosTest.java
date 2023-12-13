package ar.com.codoacodo.flysky.util;


import ar.com.codoacodo.flysky.model.dto.DtoPasajero;

import java.util.Date;

public class FactoryPasajerosTest {

    public static DtoPasajero nuevoPasajero(){
        return new DtoPasajero(55, "35658456", "Juan Pablo Montoya", "Avda Sanchez 2222",
                new Date(2023,11,30,04,15,00),
                "mail@gmail.com", "91-35658569");
    }


}
/*
@PositiveOrZero
    private Integer id;

    @NotBlank
    @Size(min = 6)
    @Size(max = 9)
    private String dni;

    @NotBlank
    @Size(max = 255)
    private String nombreCompleto;

    @NotBlank
    @Size(max = 255)
    private String domicilio;

    @Past
    private Date nacimiento;

    @Size(max = 255)
    private String email;

    @Size(max = 100)
    private String telefono;
* */