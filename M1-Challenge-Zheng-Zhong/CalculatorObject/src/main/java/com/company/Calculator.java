package com.company;

public class Calculator {
    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        calculator.add(1 , 1);
        calculator.subtract(23, 52);
        calculator.multiply(34, 2);
        calculator.divide(12, 3);
        calculator.divide(12, 7);
        calculator.add(3.4, 2.3);
        calculator.multiply(6.7, 4.4);
        calculator.subtract(5.5, 0.5);
        calculator.divide(10.8, 2.2);
        calculator.divide(0.0,1);
        calculator.divide(0, 0);
    }

    public int add(int a, int b) {
        int result = a + b;
        System.out.println(a + " + " + b + " = " + result);
        return result;
    }

    public int subtract(int a, int b) {
        int result = a - b;
        System.out.println(a + " - " + b + " = " + result);
        return result;
    }

    public int multiply(int a, int b) {
        int result = a * b;
        System.out.println(a + " * " + b + " = " + result);
        return result;
    }

    public int divide( int a, int b) {
        int result;
        try {
            result = a / b;
        } catch (ArithmeticException ex) {
            System.out.println("Error, can't divided by zero.");
            return 0;
        }
        System.out.println(a + " / " + b + " = " + result);
        return result;
    }

    public double add (double a, double b) {
        double result = a + b;
        System.out.println(a + " + " + b + " = " + result);
        return result;
    }

    public double subtract(double a, double b) {
        double result = a - b;
        System.out.println(a + " - " + b + " = " + result);
        return result;
    }

    public double multiply(double a, double b) {
        double result = a * b;
        System.out.println(a + " * " + b + " = " + result);
        return result;
    }

    public double divide(double a, double b) {
        double result = a / b;
        System.out.println(a + " / " + b + " = " + result);
        return result;
    }
}
