package com.librairie.batch.proxies;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "librairie-gateway", url = "http://localhost:8000")
public interface GatewayProxy {
    @GetMapping("/api/batch/sendEmail")
    ResponseEntity SendEmail();
}