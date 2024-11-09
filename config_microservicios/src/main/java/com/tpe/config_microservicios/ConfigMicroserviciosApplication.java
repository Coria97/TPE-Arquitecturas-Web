package com.tpe.config_microservicios;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer
public class ConfigMicroserviciosApplication {

    public static void main(String[] args) {
        SpringApplication.run(ConfigMicroserviciosApplication.class, args);
    }

}
