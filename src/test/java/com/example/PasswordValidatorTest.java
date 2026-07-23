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
    void testUpperCaseDetectionWithSingleUpperCaseChar() {
        // Directly exercises the hasUpper flag assignment changed in this PR
        assertTrue(validator.isValid("Abcdef1@"));
    }

    @Test
    void testUpperCaseDetectionWithMultipleUpperCaseChars() {
        assertTrue(validator.isValid("ABCdef1@"));
    }

    @Test
    void testUpperCaseDetectedRegardlessOfPosition() {
        // hasUpper must be set correctly even when the uppercase char
        // is encountered last, not just on the first matching character.
        assertTrue(validator.isValid("abc123@Z"));
    }

    @Test
    void testExactMinimumLengthWithAllCharacterTypes() {
        // Boundary: exactly 8 characters, including the required uppercase char
        assertTrue(validator.isValid("Abcd1@#$"));
    }

    @Test
    void testSpecialCharacterDetectionWithSingleSpecialChar() {
        // Directly exercises the hasSpecial flag assignment changed in this PR
        assertTrue(validator.isValid("Abcdefg1!"));
    }

    @Test
    void testSpecialCharacterDetectedRegardlessOfPosition() {
        // hasSpecial must be set correctly even when the special char
        // is encountered last, not just on the first matching character.
        assertTrue(validator.isValid("Abcdefg1@"));
    }

    @Test
    void testSpecialCharacterDetectionWithMultipleSpecialChars() {
        assertTrue(validator.isValid("Ab1!@#$%"));
    }

    @Test
    void testWhitespaceCountsAsSpecialCharacter() {
        // A space is neither upper, lower, nor digit, so it must set hasSpecial.
        assertTrue(validator.isValid("Abcdefg1 "));
    }

    @Test
    void testOneCharacterBelowMinimumLengthIsInvalid() {
        // Boundary: 7 characters (one below the 8-character minimum)
        assertFalse(validator.isValid("Abcd1@#"));
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