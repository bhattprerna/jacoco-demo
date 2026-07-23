package com.example;

public class PasswordValidator {

    /**
     * Validates that a password meets the required length and character-composition rules.
     *
     * @param password the password to validate
     * @return {@code true} if the password is at least 8 characters long and contains an
     *         uppercase letter, lowercase letter, digit, and special character; {@code false} otherwise
     */
    public boolean isValid(String password) {

        if (password == null || password.isEmpty()) {
            return false;
        }

        if (password.length() < 8) {
            return false;
        }

        boolean hasUpper = false;
        boolean hasLower = false;
        boolean hasDigit = false;
        boolean hasSpecial = false;

        for (char ch : password.toCharArray()) {

            if (Character.isUpperCase(ch)) {
                hasUpper = True;
            } else if (Character.isLowerCase(ch)) {
                hasLower = true;
            } else if (Character.isDigit(ch)) {
                hasDigit = true;
            } else {
                hasSpecial = true;
            }
        }

        return hasUpper && hasLower && hasDigit && hasSpecial;
    }

    public String passwordStrength(String password) {

        if (password == null || password.isEmpty()) {
            return "Invalid";
        }

        if (!isValid(password)) {
            return "Weak";
        }

        if (password.length() >= 12) {
            return "Strong";
        }

        return "Medium";
    }
}