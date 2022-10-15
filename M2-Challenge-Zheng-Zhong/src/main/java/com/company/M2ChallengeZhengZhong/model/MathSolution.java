package com.company.M2ChallengeZhengZhong.model;

import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;

public class MathSolution {

    @NotNull(message = "operand1 cannot be null")
    @Digits(integer = 10, fraction = 0, message = "invalid input")
    private Integer operand1;
    @NotNull(message = "operand2 cannot be null")
    @Digits(integer = 10, fraction = 0, message = "invalid Input")
    private Integer operand2;
    private String operation;
    private int answer;
    public MathSolution(){}
    public MathSolution (int operand1, int operand2, String operation){
        this.operand1 = operand1;
        this.operand2 = operand2;
        this.operation = operation;
        this.answer = calculateAnswer(operand1, operand2, operation);
    }

    public int add(int a, int b) {
        return a + b;
    }
    public int subtract(int a, int b) {
        return a - b;
    }
    public int multiply(int a, int b) {
        return a * b;
    }
    //divide by zero error will be handled at the controller
    public int divide(int a, int b) {
        return b == 0 ? 0 : a / b;
    }
    public int calculateAnswer (int a, int b,String operation) {
        switch (operation) {
            case "add":
                return add(a, b);
            case "subtract":
                return subtract(a, b);
            case "multiply":
                return multiply(a, b);
            case "divide":
                return divide(a, b);
            default:
                return 0;
        }
    }
    public int getOperand1() {
        return operand1;
    }
    public void setOperand1(int operand1) {
        this.operand1 = operand1;
    }
    public int getOperand2() {
        return operand2;
    }
    public void setOperand2(int operand2) {
        this.operand2 = operand2;
    }

    public String getOperation() {
        return operation;
    }
    public void setOperation(String operation) {
        this.operation = operation;
    }

    public int getAnswer() {
        return answer;
    }
    public void setAnswer(int answer) {
        this.answer = answer;
    }
}
