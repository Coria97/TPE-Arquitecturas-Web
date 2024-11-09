package com.tpe.microservicio_travels;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;


@SpringBootApplication
@EnableDiscoveryClient
public class MicroservicioTravelsApplication {

    public static void main(String[] args) {
        SpringApplication.run(MicroservicioTravelsApplication.class, args);
    }

}
