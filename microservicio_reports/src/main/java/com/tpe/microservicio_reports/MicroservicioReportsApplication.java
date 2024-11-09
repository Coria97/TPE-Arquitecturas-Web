package com.tpe.microservicio_reports;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class MicroservicioReportsApplication {

    public static void main(String[] args) {
        SpringApplication.run(MicroservicioReportsApplication.class, args);
    }

}
