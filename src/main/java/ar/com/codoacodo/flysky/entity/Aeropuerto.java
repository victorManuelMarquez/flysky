package ar.com.codoacodo.flysky.entity;

import jakarta.persistence.*;

import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
@Entity


@Table(name = "aeropuertos")
public class Aeropuerto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;
    private String ciudad;

}
