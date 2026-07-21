package com.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PasswordValidatorTest {

    private final PasswordValidator validator = new PasswordValidator();

    @Test
    void testValidPassword() {
        assertTrue(validator.isValid("Password@123"));
    }

    @Test
    void testShortPassword() {
        assertFalse(validator.isValid("Ab1@"));
    }

    @Test
    void testMissingUpperCase() {
        assertFalse(validator.isValid("password@123"));
    }

    @Test
    void testMissingLowerCase() {
        assertFalse(validator.isValid("PASSWORD@123"));
    }

    @Test
    void testMissingDigit() {
        assertFalse(validator.isValid("Password@"));
    }

    @Test
    void testMissingSpecialCharacter() {
        assertFalse(validator.isValid("Password123"));
    }

    @Test
    void testNullPassword() {
        assertFalse(validator.isValid(null));
    }

    @Test
    void testEmptyPassword() {
        assertFalse(validator.isValid(""));
    }

    @Test
    void testMediumStrengthPassword() {
        assertEquals("Medium",
                validator.passwordStrength("Pass@123"));
    }

    @Test
    void testStrongPassword() {
        assertEquals("Strong",
                validator.passwordStrength("VeryStrong@123"));
    }

    @Test
    void testWeakPassword() {
        assertEquals("Weak",
                validator.passwordStrength("abc"));
    }

    @Test
    void testInvalidStrengthNull() {
        assertEquals("Invalid",
                validator.passwordStrength(null));
    }

    @Test
    void testInvalidStrengthEmpty() {
        assertEquals("Invalid",
                validator.passwordStrength(""));
    }
}