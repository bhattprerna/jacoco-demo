package com.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TemperatureConverterTest {

    private final TemperatureConverter converter =
            new TemperatureConverter();

    @Test
    void testCelsiusToFahrenheit() {
        assertEquals(32.0, converter.celsiusToFahrenheit(0));
    }

    @Test
    void testBoilingPoint() {
        assertEquals(212.0, converter.celsiusToFahrenheit(100));
    }

    @Test
    void testFahrenheitToCelsius() {
        assertEquals(0.0, converter.fahrenheitToCelsius(32));
    }

    @Test
    void testCelsiusToKelvin() {
        assertEquals(273.15, converter.celsiusToKelvin(0));
    }

    @Test
    void testKelvinToCelsius() {
        assertEquals(0.0, converter.kelvinToCelsius(273.15));
    }

    @Test
    void testFahrenheitToKelvin() {
        assertEquals(273.15, converter.fahrenheitToKelvin(32));
    }

    @Test
    void testKelvinToFahrenheit() {
        assertEquals(32.0, converter.kelvinToFahrenheit(273.15));
    }

    @Test
    void testAbsoluteZeroCelsius() {
        assertEquals(-273.15,
                converter.kelvinToCelsius(0));
    }

    @Test
    void testBelowAbsoluteZeroCelsius() {
        assertThrows(IllegalArgumentException.class,
                () -> converter.celsiusToFahrenheit(-274));
    }

    @Test
    void testNegativeKelvin() {
        assertThrows(IllegalArgumentException.class,
                () -> converter.kelvinToCelsius(-1));
    }

    @Test
    void testBelowAbsoluteZeroFahrenheit() {
        assertThrows(IllegalArgumentException.class,
                () -> converter.fahrenheitToCelsius(-500));
    }

    @Test
    void testDecimalConversion() {
        assertEquals(98.6,
                converter.celsiusToFahrenheit(37));
    }
}