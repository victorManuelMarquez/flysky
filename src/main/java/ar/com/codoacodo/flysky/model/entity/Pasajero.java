package ar.com.codoacodo.flysky.model.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.Date;

@Getter
@Setter
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
    @Column
    private LocalDate nacimiento;

    @Column
    private String email;

    @Column
    private String telefono;

}
