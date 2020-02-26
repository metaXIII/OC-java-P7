package com.librairie.batch.task;

import com.librairie.batch.proxies.GatewayProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

public class CustomTask {

    @Autowired
    private GatewayProxy gatewayProxy;

    public void init() {
        ResponseEntity responseEntity = gatewayProxy.SendEmail();
    }
}
