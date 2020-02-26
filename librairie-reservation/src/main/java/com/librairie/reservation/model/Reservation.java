package com.librairie.reservation.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@Entity
@JsonIgnoreProperties(value = {"userId"})
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "LIVREID")
    private String livreId;

    @Column(name = "USERID")
    private long userId;

    @Column(name = "DATERESERVATION")
    private LocalDate dateReservation;

    @Column(name = "DATELIMITE")
    private LocalDate dateLimite;

    private boolean extended;

    private boolean finished;
}
