package com.example.nexus_sonar_project.controller;

import com.example.nexus_sonar_project.service.FactorialService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FactorialController {
    private final FactorialService factorialService;

    public FactorialController(FactorialService factorialService) {
        this.factorialService = factorialService;
    }

    @GetMapping("/factorial/{number}")
    public long factorial(@PathVariable int number) {
        return factorialService.calculateFactorial(number);
    }
}
