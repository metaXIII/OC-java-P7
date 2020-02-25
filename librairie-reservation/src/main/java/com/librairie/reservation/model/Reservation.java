package com.librairie.reservation.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDate;

@Data
@Entity
@JsonIgnoreProperties(value = {"userId"})
public class Reservation {
    @Id
    @GeneratedValue
    private long id;

    private String livreId;

    private long userId;

    private LocalDate dateReservation;

    private boolean extended;

    private boolean finished;
}
