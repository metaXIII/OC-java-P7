package com.librairie.reservation.service;

import com.librairie.reservation.beans.UserBean;
import com.librairie.reservation.dto.ReservDto;
import com.librairie.reservation.dto.ReservationDto;
import com.librairie.reservation.model.Reservation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface IReservationService {
    ResponseEntity reserve(ReservDto data);

    List<Reservation> getReservations(UserBean user);

    HttpStatus extendReservation(ReservationDto reservationDto);

    List<Reservation> getInvalidReservations();
}
