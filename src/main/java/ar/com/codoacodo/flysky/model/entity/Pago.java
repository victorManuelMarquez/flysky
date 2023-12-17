package ar.com.codoacodo.flysky.model.entity;

import ar.com.codoacodo.flysky.model.dto.DtoBoleto;
import ar.com.codoacodo.flysky.model.dto.DtoPasajero;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "pagos")
public class Pago {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @OneToOne
    @JoinColumn(name = "id_boleto")
    private Boleto boleto;

    @OneToOne
    @JoinColumn(name = "id_pasajero")
    private Pasajero pasajero;

    @Column
    private Float monto;

    @Column(name = "fecha", columnDefinition = "DATE")
    private LocalDate fecha;

    @ManyToOne
    @JoinColumn(name = "metodo_pago_id")
    private MetodoPago metodoPago;

    @ManyToOne
    @JoinColumn(name = "id_informe")  //
    private Informe informe;
}
