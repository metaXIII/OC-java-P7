package com.librairie.reservation.dto;

import lombok.Data;

import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Data
public class ReservationDto {
    @NotNull
    private long id;

    @NotNull
    private String livreId;

    @NotNull
    private LocalDate dateReservation;

    @NotNull
    private LocalDate dateLimite;

    @NotNull
    private boolean extended;

    @NotNull
    private boolean finished;
}
