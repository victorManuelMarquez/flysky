package ar.com.codoacodo.flysky.entity;

<<<<<<< HEAD
import lombok.Getter;
import lombok.Setter;

import jakarta.persistence.*;

@Getter
@Setter
@Entity
=======
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
>>>>>>> ee6658fe82dccc5cd3b2d6b7be61ca9d68e004a4
@Table(name = "aerolineas")
public class Aerolinea {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
<<<<<<< HEAD

    @Column(name = "nombre", nullable = false)
    private String nombre;

}
=======
    private String nombre;
}
>>>>>>> ee6658fe82dccc5cd3b2d6b7be61ca9d68e004a4
