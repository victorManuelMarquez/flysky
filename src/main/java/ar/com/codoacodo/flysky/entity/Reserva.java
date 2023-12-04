package ar.com.codoacodo.flysky.entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@Entity
@Table(name = "reservas")
public class Reserva {

    @Id
    @ManyToOne
    @JoinColumn(name = "id_usuario", nullable = false)
    private Usuario usuario;

    @Id
    @ManyToOne
    @JoinColumn(name = "id_vuelo", nullable = false)
    private Vuelo vuelo;

    @Id
    @ManyToOne
    @JoinColumn(name = "id_pasajero", nullable = false)
    private Pasajero pasajero;

    @Column(name = "fechaReserva", nullable = false)
    private Date fechaReserva;

    @Column(name = "comprobante", nullable = false)
    private String comprobante;

    @Column(name = "cancelada", nullable = false)
    private boolean cancelada;


}
