package com.tpe.microservicio_stops.controller;


import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/stops")
public class controller {

    @GetMapping("")
    public String test2(){
        return "Stop";
    }

}
