package com.tpe.microservicio_stops;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class MicroservicioStopsApplication {

    public static void main(String[] args) {
        SpringApplication.run(MicroservicioStopsApplication.class, args);
    }

}
