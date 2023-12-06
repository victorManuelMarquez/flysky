package ar.com.codoacodo.flysky.entity;

import jakarta.persistence.*;
<<<<<<< HEAD
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "pasajeros")
public class Pasajero {


=======
import lombok.Data;

@Entity
@Data
@Table(name = "pasajeros")
public class Pasajero {

>>>>>>> ee6658fe82dccc5cd3b2d6b7be61ca9d68e004a4
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

<<<<<<< HEAD
    @Column(name = "dni", nullable = false)
    private String dni;

    @Column(name = "nombres", nullable = false)
    private String nombres;

    @Column(name = "apellidos", nullable = false)
    private String apellidos;

    @Column(name = "telefono")
    private String telefono;

    @Column(name = "email")
    private String email;


=======
    //podria ser Long
    private String dni;
    private String nombres;
    private String apellidos;
    private int telefono;
    private String email;
>>>>>>> ee6658fe82dccc5cd3b2d6b7be61ca9d68e004a4
}
