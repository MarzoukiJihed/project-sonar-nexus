package com.example.nexus_sonar_project.service;
import java.math.BigInteger; 
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FactorialServiceTest {

    private final FactorialService factorialService = new FactorialService();

    @Test
    void shouldReturnOneForZero() {
        assertEquals(BigInteger.ONE, factorialService.calculateFactorial(0));
    }

    @Test
    void shouldCalculateFactorial() {
        assertEquals(BigInteger.valueOf(120), factorialService.calculateFactorial(5));
    }

    @Test
    void shouldThrowExceptionForNegativeNumber() {
        assertThrows(
                IllegalArgumentException.class,
                () -> factorialService.calculateFactorial(-1)
        );
    }
}
