package com.librairie.reservation.service;

import com.librairie.reservation.beans.UserBean;
import com.librairie.reservation.dto.ReservationDto;
import com.librairie.reservation.model.Reservation;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface IReservationService {
    ResponseEntity reserve(ReservationDto data);

    List<Reservation> getReservations(UserBean user);
}
