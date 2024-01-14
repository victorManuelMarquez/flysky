package ar.com.codoacodo.flysky.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * Clase que permite modelar los datos de la tabla {@code pasajeros}
 *
 * @author victor
 * @version 1.0
 * @since 1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "pasajeros")
@SuppressWarnings("SpellCheckingInspection")
public class Pasajero {

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
