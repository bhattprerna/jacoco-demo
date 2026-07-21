package com.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StringUtilsTest {

    private final StringUtils utils = new StringUtils();

    // Reverse

    @Test
    void testReverse() {
        assertEquals("olleH", utils.reverse("Hello"));
    }

    @Test
    void testReverseEmpty() {
        assertEquals("", utils.reverse(""));
    }

    @Test
    void testReverseNull() {
        assertThrows(IllegalArgumentException.class,
                () -> utils.reverse(null));
    }

    // Palindrome

    @Test
    void testPalindromeTrue() {
        assertTrue(utils.isPalindrome("madam"));
    }

    @Test
    void testPalindromeIgnoreCase() {
        assertTrue(utils.isPalindrome("RaceCar"));
    }

    @Test
    void testPalindromeWithSpaces() {
        assertTrue(utils.isPalindrome("nurses run"));
    }

    @Test
    void testPalindromeFalse() {
        assertFalse(utils.isPalindrome("OpenAI"));
    }

    @Test
    void testPalindromeNull() {
        assertFalse(utils.isPalindrome(null));
    }

    // Count Vowels

    @Test
    void testCountVowels() {
        assertEquals(5, utils.countVowels("Education"));
    }

    @Test
    void testCountVowelsZero() {
        assertEquals(0, utils.countVowels("rhythm"));
    }

    @Test
    void testCountVowelsEmpty() {
        assertEquals(0, utils.countVowels(""));
    }

    @Test
    void testCountVowelsNull() {
        assertEquals(0, utils.countVowels(null));
    }

    // Capitalize

    @Test
    void testCapitalize() {
        assertEquals("Java", utils.capitalize("java"));
    }

    @Test
    void testCapitalizeMixedCase() {
        assertEquals("Hello", utils.capitalize("hELLo"));
    }

    @Test
    void testCapitalizeEmpty() {
        assertEquals("", utils.capitalize(""));
    }

    @Test
    void testCapitalizeNull() {
        assertThrows(IllegalArgumentException.class,
                () -> utils.capitalize(null));
    }
}