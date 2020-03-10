package com.librairie.batch.model;

import lombok.Data;

import java.time.LocalDate;

@Data
public class Reservation {
    private long id;

    private String livreId;

    private LocalDate dateReservation;

    private LocalDate dateLimite;

    private boolean extended;

    private boolean finished;

    private long userId;
}
