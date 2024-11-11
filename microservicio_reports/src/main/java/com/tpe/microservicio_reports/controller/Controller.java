package com.tpe.microservicio_reports.controller;


import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/reports")
public class Controller {

    @GetMapping("")
    public String test3(){
        return "reports";
    }
}
