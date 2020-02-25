package com.librairie.reservation.impl;

import com.librairie.reservation.beans.LivreBean;
import com.librairie.reservation.beans.UserBean;
import com.librairie.reservation.dto.ReservationDto;
import com.librairie.reservation.model.Reservation;
import com.librairie.reservation.proxies.UserServiceProxy;
import com.librairie.reservation.repositories.ReservationRepository;
import com.librairie.reservation.service.IReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
@Transactional
public class ReservationServiceImpl implements IReservationService {
    @Autowired
    private UserServiceProxy userServiceProxy;

    @Autowired
    private ReservationRepository reservationRepository;

    @Override
    public ResponseEntity reserve(ReservationDto data) {
        Reservation   reservation   = new Reservation();
        StringBuilder stringBuilder = new StringBuilder();
        System.out.println(stringBuilder.toString());
        Optional<UserBean> user = userServiceProxy.info(data.getUser().get("username")).getBody();
        if (Objects.requireNonNull(user).isPresent()) {
            for (LivreBean livre : data.getCollection())
                stringBuilder.append(stringBuilder.toString().isEmpty() ? "" : ",").append(livre.getId());
            reservation.setLivreId(stringBuilder.toString());
            reservation.setUserId(user.get().getId());
            reservation.setDateReservation(LocalDate.now());
            reservation.setExtended(false);
            reservation.setFinished(false);
            reservationRepository.save(reservation);
            return new ResponseEntity<>(HttpStatus.CREATED);
        }
        return new ResponseEntity<>(HttpStatus.CONFLICT);
    }

    @Override
    public List<Reservation> getReservations(UserBean userBean) {
        Optional<UserBean> user = userServiceProxy.info(userBean.getUsername()).getBody();
        if (Objects.requireNonNull(user).isPresent()) {
            return reservationRepository.findAllByUserIdAndFinishedIsFalse(user.get().getId());
        }
        return new ArrayList<>();
    }
}
