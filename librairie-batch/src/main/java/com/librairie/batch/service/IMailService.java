package com.librairie.batch.service;

import com.librairie.batch.model.Reservation;
import com.librairie.batch.model.User;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

public interface IMailService {
    ResponseEntity<List<Reservation>> getReservations();

    Optional<User> getUser(long userId);
}
