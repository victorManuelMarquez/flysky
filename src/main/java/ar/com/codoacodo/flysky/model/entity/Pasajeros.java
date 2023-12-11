package ar.com.codoacodo.flysky.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "pasajeros")
@SuppressWarnings("SpellCheckingInspection")
public class Pasajeros {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    private String dni;

    @Column(name = "nombre_completo")
    private String nombreCompleto;

    @Column
    private String domicilio;

    @Temporal(TemporalType.DATE)
    private Date nacimiento;

    @Column
    private String email;

    @Column
    private String telefono;

}
