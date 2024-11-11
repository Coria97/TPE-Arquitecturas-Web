package com.tpe.microservicio_travels.controller;


import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/test")
public class controller {

    @GetMapping("")
    public String test(){
        return "Test";
    }

}
