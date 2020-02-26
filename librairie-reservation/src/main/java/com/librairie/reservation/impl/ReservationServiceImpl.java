package com.librairie.reservation.impl;

import com.librairie.reservation.beans.LivreBean;
import com.librairie.reservation.beans.UserBean;
import com.librairie.reservation.dto.ReservDto;
import com.librairie.reservation.dto.ReservationDto;
import com.librairie.reservation.model.Reservation;
import com.librairie.reservation.proxies.GatewayProxy;
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
    private GatewayProxy gatewayProxy;

    @Autowired
    private ReservationRepository reservationRepository;

    @Override
    public ResponseEntity reserve(ReservDto data) {
        Reservation   reservation   = new Reservation();
        StringBuilder stringBuilder = new StringBuilder();
        Optional<UserBean> user = gatewayProxy.getUser(data.getUser().get("username")).getBody();
        if (Objects.requireNonNull(user).isPresent()) {
            try {
                for (LivreBean livre : data.getCollection()) {
                    if (Objects.requireNonNull(gatewayProxy.CheckStock(String.valueOf(livre.getId())).getBody()).isPresent())
                        stringBuilder.append(stringBuilder.toString().isEmpty() ? "" : ",").append(livre.getId());
                }
                makeReservation(reservation, stringBuilder, user);
            } catch (Exception e) {
                return new ResponseEntity<>(HttpStatus.CONFLICT);
            }
            return new ResponseEntity<>(HttpStatus.CREATED);
        }
        return new ResponseEntity<>(HttpStatus.CONFLICT);
    }

    private void makeReservation(Reservation reservation, StringBuilder stringBuilder, Optional<UserBean> user) {
        reservation.setLivreId(stringBuilder.toString());
        reservation.setUserId(user.get().getId());
        reservation.setDateReservation(LocalDate.now());
        reservation.setExtended(false);
        reservation.setFinished(false);
        reservation.setDateLimite(reservation.getDateReservation().plusWeeks(4));
        if (!stringBuilder.toString().isEmpty())
            reservationRepository.save(reservation);
    }

    @Override
    public List<Reservation> getReservations(UserBean userBean) {
        Optional<UserBean> user = gatewayProxy.getUser(userBean.getUsername()).getBody();
        if (Objects.requireNonNull(user).isPresent()) {
            return reservationRepository.findAllByUserIdAndFinishedIsFalseOrderByIdDesc(user.get().getId());
        }
        return new ArrayList<>();
    }

    @Override
    public HttpStatus extendReservation(ReservationDto reservationDto) {
        Optional<Reservation> reservation = reservationRepository.findById(reservationDto.getId());
        if (reservation.isPresent() && !reservation.get().isExtended()) {
            reservation.get().setExtended(true);
            reservation.get().setDateLimite(reservation.get().getDateLimite().plusWeeks(4));
            reservationRepository.save(reservation.get());
            return HttpStatus.ACCEPTED;
        }
        return HttpStatus.BAD_REQUEST;
    }
}
