package com.example;

public class StringUtils {

    public String reverse(String input) {
        if (input == null) {
            throw new IllegalArgumentException("Input cannot be null");
        }
        return new StringBuilder(input).reverse().toString();
    }

    public boolean isPalindrome(String input) {
        if (input == null) {
            return false;
        }

        String cleaned = input.replaceAll("\\s+", "").toLowerCase();
        return cleaned.equals(new StringBuilder(cleaned).reverse().toString());
    }

    public int countVowels(String input) {
        if (input == null || input.isEmpty()) {
            return 0;
        }

        int count = 0;

        for (char c : input.toLowerCase().toCharArray()) {
            if ("aeiou".indexOf(c) != -1) {
                count++;
            }
        }

        return count;
    }

    public String capitalize(String input) {
        if (input == null) {
            throw new IllegalArgumentException("Input cannot be null");
        }

        if (input.isEmpty()) {
            return "";
        }

        return Character.toUpperCase(input.charAt(0))
                + input.substring(1).toLowerCase();
    }
}