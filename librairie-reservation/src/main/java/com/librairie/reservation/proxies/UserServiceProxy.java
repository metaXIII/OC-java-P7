package com.librairie.reservation.proxies;

import com.librairie.reservation.model.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "librairie-gateway", url = "http://localhost:8000")
public interface UserServiceProxy {
    @GetMapping("/api/user/me/{username}")
    ResponseEntity<User> info(@PathVariable("username") String username);
}
