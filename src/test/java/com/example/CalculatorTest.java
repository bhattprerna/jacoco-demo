package com.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {

    Calculator calculator = new Calculator();

    @Test
    void testAdd() {
        assertEquals(8.0, calculator.add(5.0, 3));
    }

    @Test
    void testSubtract() {
        assertEquals(2, calculator.subtract(5, 3));
    }

    @Test
    void testMultiply() {
        assertEquals(15, calculator.multiply(5, 3));
    }

    @Test
    void testDivide() {
        assertEquals(2, calculator.divide(6, 3));
    }

    @Test
    void testDivideByZero() {
        assertThrows(IllegalArgumentException.class,
                () -> calculator.divide(10, 0));
    }

    @Test
    void testEven() {
        assertTrue(calculator.isEven(10));
        assertFalse(calculator.isEven(7));
    }
}