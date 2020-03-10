package com.librairie.batch.impl;

import com.librairie.batch.model.Livre;
import com.librairie.batch.model.Reservation;
import com.librairie.batch.model.User;
import com.librairie.batch.proxies.GatewayProxy;
import com.librairie.batch.service.IMailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class DetailServiceImpl implements IMailService {
    @Autowired
    private GatewayProxy gatewayProxy;

    @Override
    public ResponseEntity<List<Reservation>> getReservations() {
        return gatewayProxy.getInvalidReservations();
    }

    @Override
    public Optional<User> getUser(long userId) {
        return gatewayProxy.getUserWithId(userId);
    }

    @Override
    public Livre getLivreById(long id) {
        Optional<Livre> livre = gatewayProxy.getLivreById(id).getBody();
        return livre.orElse(new Livre());
    }
}
