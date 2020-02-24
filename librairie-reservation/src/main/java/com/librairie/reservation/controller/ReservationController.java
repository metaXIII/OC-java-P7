package com.librairie.reservation.controller;

import com.librairie.reservation.proxies.UserServiceProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

//@RestController
@Controller
@RequestMapping("/api/reservation/")
public class ReservationController {

    @Autowired
    private UserServiceProxy userServiceProxy;


    @GetMapping("machin")
    public int info() {
        Object object = userServiceProxy.info("aze");
        System.out.println("aze");
        return 2;
    }
}
