package com.librairie.reservation.proxies;

import com.librairie.reservation.beans.UserBean;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Optional;

@FeignClient(name = "librairie-gateway", url = "http://localhost:8000")
public interface UserServiceProxy {
    @GetMapping("/api/user/me/{username}")
    ResponseEntity<Optional<UserBean>> info(@PathVariable("username") String username);
}
