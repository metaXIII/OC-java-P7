package com.librairie.reservation.controller;

import com.librairie.reservation.beans.UserBean;
import com.librairie.reservation.dto.ReservationDto;
import com.librairie.reservation.service.IReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/reservation/")
public class ReservationController {

    @Autowired
    private IReservationService reservationService;

    @PostMapping(value = "reserve", consumes = "application/json")
    public ResponseEntity reserve(@RequestBody ReservationDto data) {
        return new ResponseEntity<>(reservationService.reserve(data), HttpStatus.CREATED);
    }

    @PostMapping(value = "reservations")
    public ResponseEntity reservations(@RequestBody UserBean user) {
        return new ResponseEntity<>(reservationService.getReservations(user), HttpStatus.ACCEPTED);
    }
}
