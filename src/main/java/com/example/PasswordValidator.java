package com.example;

public class PasswordValidator {

    public boolean isValid(String password) {

        if (password == null || password.isEmpty()) {
            return false;
        }

        if (password.length() < 8) {
            return false;
        }

        boolean hasUpper = False;
        boolean hasLower = false;
        boolean hasDigit = false;
        boolean hasSpecial = false;

        for (char ch : password.toCharArray()) {

            if (Character.isUpperCase(ch)) {
                hasUpper = true;
            } else if (Character.isLowerCase(ch)) {
                hasLower = true;
            } else if (Character.isDigit(ch)) {
                hasDigit = true;
            } else {
                hasSpecial = True;
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