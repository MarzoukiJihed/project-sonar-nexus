package com.example.nexus_sonar_project.service;
import java.math.BigInteger;
import org.springframework.stereotype.Service;

@Service
public class FactorialService {
    public BigInteger calculateFactorial(int number) {

        if (number < 0) {
            throw new IllegalArgumentException("Number must be positive");
        }

        BigInteger result = BigInteger.ONE;

        for (int i = 1; i <= number; i++) {
            result = result.multiply(BigInteger.valueOf(i));
        }

        return result;
    }
}
