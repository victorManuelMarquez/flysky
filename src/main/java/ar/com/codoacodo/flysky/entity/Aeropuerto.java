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
@Table(name = "aeropuertos")
public class Aeropuerto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

<<<<<<< HEAD
    @Column(name = "nombre", nullable = false)
    private String nombre;

    @Column(name = "ciudad", nullable = false)
    private String ciudad;

=======
    private String nombre;
    private String ciudad;
>>>>>>> ee6658fe82dccc5cd3b2d6b7be61ca9d68e004a4
}
