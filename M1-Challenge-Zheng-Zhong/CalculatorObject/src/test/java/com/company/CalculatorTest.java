package com.company;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class CalculatorTest {
    private Calculator calculator;

    @Before
    public void setUp() throws Exception {
        calculator = new Calculator();
    }

    @Test
    public void shouldReturnExpectedSumOfInts () {
        assertEquals(30,calculator.add(12,18));
        assertEquals(25,calculator.add(28, -3));
        assertEquals(-7, calculator.add(-9, 2));
    }

    @Test
    public void shouldReturnExpectedDifferenceOfInts() {
        assertEquals(200, calculator.subtract(769,569));
        assertEquals(0,calculator.subtract(18,18));
        assertEquals(-8,calculator.subtract(16,24));
    }

    @Test
    public void shouldReturnExpectedProductOfIns() {
        assertEquals(0, calculator.multiply(0,38926431));
        assertEquals("The answer to life the universe and everything",42, calculator.multiply(6,7));
        assertEquals(42, calculator.multiply(21,2));
    }

    @Test
    public void shouldReturnExpectedQuotientOfIns(){
        assertEquals(1,calculator.divide(222, 222));
        assertEquals(0,calculator.divide(1, 237958));
        assertEquals(3, calculator.divide(9,3));
        assertEquals(0, calculator.divide(3, 0));
    }

    @Test
    public void shouldReturnExpectedSumOfDoubles() {
        assertEquals(3.69, calculator.add(1.20, 2.49), 0.0001);
        assertEquals(10.00, calculator.add(6.699, 3.301), 0.0001);
        assertEquals(-10.25, calculator.add(-11.00, 0.75), 0.0001);
    }

    @Test
    public void shouldReturnExpectedDifferenceOfDouble() {
        assertEquals(0.0, calculator.subtract(0.0, 0.0), 0.0001);
        assertEquals(5.6, calculator.subtract(8.0, 2.4), 0.0001);
        assertEquals(-6.3, calculator.subtract(0.0, 6.3), 0.0001);
    }

    @Test
    public void shouldReturnExpectedProductOfDouble() {
        assertEquals(42, calculator.multiply(6.0, 7.0), 0.0001);
        assertEquals(-42, calculator.multiply(6.0, -7.0), 0.0001);
        assertEquals(0.05, calculator.multiply(0.5, 0.1), 0.0001);
    }

    @Test
    public void shouldReturnExpectedQuotientOfDouble(){
        assertEquals(Double.POSITIVE_INFINITY, calculator.divide(42.0, 0.0),0.00001);
        assertEquals(3.0, calculator.divide(15.0, 5.0), 0.0001);
        assertEquals(1.0, calculator.divide(38.56, 38.56), 0.0001);
    }
}