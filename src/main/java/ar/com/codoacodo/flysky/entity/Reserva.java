package ar.com.codoacodo.flysky.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Entity
@Data
@Table(name = "reservas")
public class Reserva {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_usuario", foreignKey = @ForeignKey(name = "fk_reservas_usuario"))
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name = "id_vuelo", foreignKey = @ForeignKey(name = "fk_reservas_vuelo"))
    private Vuelo vuelo;

    @ManyToOne
    @JoinColumn(name = "id_pasajero", foreignKey = @ForeignKey(name = "fk_reservas_pasajero"))
    private Pasajero pasajero;

    private Date fechaReserva;

    //podria ser boolean
    private String comprobante;

    private byte cancelada;

}
