package ar.com.codoacodo.flysky.entity;

import jakarta.persistence.*;
<<<<<<< HEAD
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
=======
import lombok.Data;

@Entity
@Data
>>>>>>> ee6658fe82dccc5cd3b2d6b7be61ca9d68e004a4
@Table(name = "usuarios")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

<<<<<<< HEAD
    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "clave", nullable = false)
    private String clave;


=======
    private String email;
    private String clave;
>>>>>>> ee6658fe82dccc5cd3b2d6b7be61ca9d68e004a4
}
