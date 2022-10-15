package com.company.M2ChallengeZhengZhong.controller;

import com.company.M2ChallengeZhengZhong.model.MathSolution;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
public class MathController {

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @ResponseStatus(value = HttpStatus.CREATED)
    public MathSolution add(@RequestBody @Valid MathSolution question) {
        return new MathSolution( question.getOperand1(), question.getOperand2(), "add");
    }

    @RequestMapping(value = "/subtract", method = RequestMethod.POST)
    @ResponseStatus(value = HttpStatus.CREATED)
    public MathSolution subtract (@RequestBody @Valid MathSolution question) {
        return new MathSolution( question.getOperand1(), question.getOperand2(), "subtract");
    }

    @RequestMapping(value = "/multiply", method = RequestMethod.POST)
    @ResponseStatus(value = HttpStatus.CREATED)
    public MathSolution multiply (@RequestBody @Valid MathSolution question) {
        return new MathSolution( question.getOperand1(),question.getOperand2(), "multiply");
    }

    @RequestMapping(value = "/divide", method = RequestMethod.POST)
    @ResponseStatus(value = HttpStatus.CREATED)
    public MathSolution divide (@RequestBody @Valid MathSolution question) {
        if(question.getOperand2()==0) {
            throw new ArithmeticException("can not divided by Zero");
        }
       return new MathSolution( question.getOperand1(),question.getOperand2(), "divide");
    }
}
