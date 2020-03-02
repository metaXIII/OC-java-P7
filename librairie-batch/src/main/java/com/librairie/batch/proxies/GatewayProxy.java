package com.librairie.batch.proxies;

import com.librairie.batch.model.Reservation;
import com.librairie.batch.model.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

@FeignClient(name = "librairie-gateway", url = "http://localhost:8000")
public interface GatewayProxy {
    @GetMapping(value = "/api/reservation/validate")
    ResponseEntity<List<Reservation>> getInvalidReservations();

    @GetMapping("/api/reservation/test")
    String hello();

    @GetMapping("/api/user/get/{id}")
    Optional<User> getUserWithId(@PathVariable("id") long id);
}