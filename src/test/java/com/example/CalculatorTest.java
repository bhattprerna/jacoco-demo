package com.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {

    Calculator calculator = new Calculator();

    @Test
    void testAdd() {
        assertEquals(8, calculator.add(5, 3));
    }

    @Test
    void testAddNegativeNumbers() {
        assertEquals(-8, calculator.add(-5, -3));
    }

    @Test
    void testAddPositiveAndNegative() {
        assertEquals(2, calculator.add(5, -3));
    }

    @Test
    void testAddWithZero() {
        assertEquals(5, calculator.add(5, 0));
        assertEquals(0, calculator.add(0, 0));
    }

    @Test
    void testAddIntegerOverflowBoundary() {
        // Regression: add now takes ints (not doubles), so results wrap around
        // on overflow instead of rounding as a double would.
        assertEquals(Integer.MIN_VALUE, calculator.add(Integer.MAX_VALUE, 1));
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