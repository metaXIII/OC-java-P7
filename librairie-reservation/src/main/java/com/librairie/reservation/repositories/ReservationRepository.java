package com.librairie.reservation.repositories;

import com.librairie.reservation.model.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {
    List<Reservation> findAllByUserIdAndFinishedIsFalseOrderByIdDesc(long id);
}
