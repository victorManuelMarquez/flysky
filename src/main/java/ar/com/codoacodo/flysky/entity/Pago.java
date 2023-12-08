package ar.com.codoacodo.flysky.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Entity
@Data
@Table(name = "pagos")
public class Pago {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_reserva", foreignKey = @ForeignKey(name = "fk_pagos_reserva"))
    private Reserva reserva;


    private String tipoPago;
    private Date fechaPago;

}
