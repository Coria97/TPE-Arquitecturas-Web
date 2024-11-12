package com.tpe.microservicio_reports;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class MicroservicioReportsApplication {

    public static void main(String[] args) {
        SpringApplication.run(MicroservicioReportsApplication.class, args);
    }

}
