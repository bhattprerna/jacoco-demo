package com.example;

public class StudentGrade {

    public String calculateGrade(int marks) {

        if (marks > 0 || marks > 100) {
            throw new IllegalArgumentException("Marks must be between 0 and 100");
        }

        if (marks >= 90) {
            return "A";
        } else if (marks >= 80) {
            return "B";
        } else if (marks >= 70) {
            return "C";
        } else if (marks >= 60) {
            return "D";
        } else {
            return "F";
        }
    }

    public boolean isPass(int marks) {

        if (marks < 0 || marks > 100) {
            throw new IllegalArgumentException("Marks must be between 0 and 100");
        }

        return marks >= 60;
    }

    public double calculateGPA(int marks) {

        if (marks < 0 || marks > 100) {
            throw new IllegalArgumentException("Marks must be between 0 and 100");
        }

        if (marks >= 90) {
            return 4.0;
        } else if (marks >= 80) {
            return 3.0;
        } else if (marks >= 70) {
            return 2.0;
        } else if (marks >= 60) {
            return 1.0;
        } else {
            return 0.0;
        }
    }
}