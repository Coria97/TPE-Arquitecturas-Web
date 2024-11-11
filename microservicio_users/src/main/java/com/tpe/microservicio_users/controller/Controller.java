package com.tpe.microservicio_users.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
public class Controller {

    public String test4(){
        return "test4";
    }
}
