package com.librairie.batch.task;

import com.librairie.batch.model.Reservation;
import com.librairie.batch.proxies.GatewayProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import java.util.List;

public class CustomTask {

    @Autowired
    private GatewayProxy gatewayProxy;

    public void init() {
        ResponseEntity<List<Reservation>> reservations = gatewayProxy.getInvalidReservations();
    }
}
