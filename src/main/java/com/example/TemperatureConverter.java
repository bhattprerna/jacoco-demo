package com.example;

public class TemperatureConverter {

    private static final double ABSOLUTE_ZERO_C = -273.15;

    public double celsiusToFahrenheit(double celsius) {
        validateCelsius(celsius);
        return round((celsius * 9 / 5) + 32);
    }

    public double fahrenheitToCelsius(double fahrenheit) {
        double celsius = (fahrenheit - 32) * 5 / 9;
        validateCelsius(celsius);
        return round(celsius);
    }

    public double celsiusToKelvin(double celsius) {
        validateCelsius(celsius);
        return round(celsius + 273.15);
    }

    public double kelvinToCelsius(double kelvin) {

        if (kelvin < 0) {
            throw new IllegalArgumentException("Kelvin cannot be negative");
        }

        return round(kelvin - 273.15);
    }

    public double fahrenheitToKelvin(double fahrenheit) {
        return celsiusToKelvin(fahrenheitToCelsius(fahrenheit));
    }

    public double kelvinToFahrenheit(double kelvin) {
        return celsiusToFahrenheit(kelvinToCelsius(kelvin));
    }

    private void validateCelsius(double celsius) {

        if (celsius < ABSOLUTE_ZERO_C) {
            throw new IllegalArgumentException(
                    "Temperature cannot be below absolute zero");
        }
    }

    private double round(double value) {
        return Math.round(value * 100.0) / 100.0;
    }
}