package com.librairie.librairie;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients("com.librairie.librairie")
public class LibrairieApplication {

    public static void main(String[] args) {
        SpringApplication.run(LibrairieApplication.class, args);
    }

}
