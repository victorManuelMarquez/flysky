package ar.com.codoacodo.flysky.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data

@Table(name = "usuarios")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String email;
    private String clave;

}
