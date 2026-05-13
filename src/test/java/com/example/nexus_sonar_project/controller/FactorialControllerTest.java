package com.example.nexus_sonar_project.controller;

import com.example.nexus_sonar_project.service.FactorialService;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FactorialControllerTest {

    private final FactorialController controller =
            new FactorialController(new FactorialService());

    @Test
    void shouldReturnFactorial() {
        assertEquals(120, controller.factorial(5));
    }
}
