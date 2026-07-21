package com.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StudentGradeTest {

    private final StudentGrade grade = new StudentGrade();

    // Grade Calculation

    @Test
    void testGradeA() {
        assertEquals("A", grade.calculateGrade(95));
    }

    @Test
    void testGradeB() {
        assertEquals("B", grade.calculateGrade(85));
    }

    @Test
    void testGradeC() {
        assertEquals("C", grade.calculateGrade(75));
    }

    @Test
    void testGradeD() {
        assertEquals("D", grade.calculateGrade(65));
    }

    @Test
    void testGradeF() {
        assertEquals("F", grade.calculateGrade(45));
    }

    @Test
    void testGradeZero() {
        assertEquals("F", grade.calculateGrade(0));
    }

    @Test
    void testGradeHundred() {
        assertEquals("A", grade.calculateGrade(100));
    }

    @Test
    void testInvalidMarksNegative() {
        assertThrows(IllegalArgumentException.class,
                () -> grade.calculateGrade(-5));
    }

    @Test
    void testInvalidMarksAboveHundred() {
        assertThrows(IllegalArgumentException.class,
                () -> grade.calculateGrade(120));
    }

    // Pass / Fail

    @Test
    void testPass() {
        assertTrue(grade.isPass(60));
    }

    @Test
    void testFail() {
        assertFalse(grade.isPass(59));
    }

    @Test
    void testPassInvalidMarks() {
        assertThrows(IllegalArgumentException.class,
                () -> grade.isPass(101));
    }

    // GPA

    @Test
    void testGPAA() {
        assertEquals(4.0, grade.calculateGPA(95));
    }

    @Test
    void testGPAB() {
        assertEquals(3.0, grade.calculateGPA(82));
    }

    @Test
    void testGPAC() {
        assertEquals(2.0, grade.calculateGPA(73));
    }

    @Test
    void testGPAD() {
        assertEquals(1.0, grade.calculateGPA(61));
    }

    @Test
    void testGPAF() {
        assertEquals(0.0, grade.calculateGPA(40));
    }

    @Test
    void testGPAInvalidMarks() {
        assertThrows(IllegalArgumentException.class,
                () -> grade.calculateGPA(-1));
    }
}