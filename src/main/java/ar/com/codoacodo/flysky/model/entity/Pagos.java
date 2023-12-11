package ar.com.codoacodo.flysky.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "pagos")
public class Pagos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @OneToOne
    @JoinColumn(name = "id_boleto")
    private Boletos boleto;

    @OneToOne
    @JoinColumn(name = "id_pasajero")
    private Pasajeros pasajero;

    @Column
    private Float monto;

    @Column(name = "fecha", columnDefinition = "DATETIME")
    private LocalDate fecha;

}
