package com.tpe.microservicio_travels;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class MicroservicioTravelsApplication {

    public static void main(String[] args) {
        SpringApplication.run(MicroservicioTravelsApplication.class, args);
    }

}
