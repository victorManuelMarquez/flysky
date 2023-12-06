package ar.com.codoacodo.flysky.entity;

import jakarta.persistence.*;
<<<<<<< HEAD
import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
=======

>>>>>>> ee6658fe82dccc5cd3b2d6b7be61ca9d68e004a4
@Entity
@Table(name = "clases")
public class Clase {

<<<<<<< HEAD

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nombre", nullable = false)
=======
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
>>>>>>> ee6658fe82dccc5cd3b2d6b7be61ca9d68e004a4
    private String nombre;
}
