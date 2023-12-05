package ar.com.codoacodo.flysky.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "pasajeros")
public class Pasajero {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //podria ser Long
    private String dni;
    private String nombres;
    private String apellidos;
    private int telefono;
    private String email;
}
