package com.company.M2ChallengeZhengZhong.controller;

import com.company.M2ChallengeZhengZhong.exception.ArgumentNotFoundException;
import com.company.M2ChallengeZhengZhong.model.CustomErrorResponse;
import com.fasterxml.jackson.databind.exc.InvalidFormatException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@RestControllerAdvice
public class ControllerExceptionHandler {
    //Customized Exception Handler for javax.validation
    @ExceptionHandler(value = {MethodArgumentNotValidException.class})
    @ResponseStatus(value = HttpStatus.UNPROCESSABLE_ENTITY)
    public ResponseEntity<List<CustomErrorResponse>> newResponseErrors(MethodArgumentNotValidException e) {
        HttpStatus status422 = HttpStatus.UNPROCESSABLE_ENTITY;
        BindingResult result = e.getBindingResult();
        List<FieldError> fieldErrors = result.getFieldErrors();
        List<CustomErrorResponse> errorResponseList = new ArrayList<>();

        for(FieldError fieldError: fieldErrors) {
            CustomErrorResponse errorResponse = new CustomErrorResponse(status422.toString(), fieldError.getDefaultMessage());
            errorResponse.setTimeStamp(LocalDateTime.now());
            errorResponse.setStatus(status422.value());
            errorResponseList.add(errorResponse);
        }

        ResponseEntity<List<CustomErrorResponse>> responseEntity = new ResponseEntity<>(errorResponseList, HttpStatus.UNPROCESSABLE_ENTITY);
        return responseEntity;
    }

    @ExceptionHandler(value = {IllegalArgumentException.class})
    @ResponseStatus(value = HttpStatus.UNPROCESSABLE_ENTITY)
    public ResponseEntity<CustomErrorResponse> outOfRangeException(IllegalArgumentException e) {
        HttpStatus status422 = HttpStatus.UNPROCESSABLE_ENTITY;
        CustomErrorResponse error = new CustomErrorResponse(status422.toString(), e.getMessage());
        error.setStatus(status422.value());
        error.setTimeStamp(LocalDateTime.now());
        ResponseEntity<CustomErrorResponse> responseEntity = new ResponseEntity<>(error, status422);
        return responseEntity;
    }

    @ExceptionHandler(value = {ArithmeticException.class})
    @ResponseStatus(value = HttpStatus.UNPROCESSABLE_ENTITY)
    public ResponseEntity<CustomErrorResponse> dividedByZeroException(ArithmeticException e) {
        HttpStatus status422 = HttpStatus.UNPROCESSABLE_ENTITY;
        CustomErrorResponse error = new CustomErrorResponse(status422.toString(), e.getMessage());
        error.setStatus(status422.value());
        error.setTimeStamp(LocalDateTime.now());
        ResponseEntity<CustomErrorResponse> responseEntity = new ResponseEntity<>(error, status422);
        return responseEntity;
    }

//    @ExceptionHandler(value = {ArgumentNotFoundException.class})
//    @ResponseStatus(value = HttpStatus.UNPROCESSABLE_ENTITY)
//    public ResponseEntity<CustomErrorResponse> argumentNotFoundException(ArgumentNotFoundException e) {
//        HttpStatus status422 = HttpStatus.UNPROCESSABLE_ENTITY;
//        CustomErrorResponse error = new CustomErrorResponse(status422.toString(), e.getMessage());
//        error.setStatus(status422.value());
//        error.setTimeStamp(LocalDateTime.now());
//        ResponseEntity<CustomErrorResponse> responseEntity = new ResponseEntity<>(error, status422);
//        return responseEntity;
//    }

    @ExceptionHandler(value = {InvalidFormatException.class})
    @ResponseStatus(value = HttpStatus.UNPROCESSABLE_ENTITY)
    public ResponseEntity<CustomErrorResponse> invalidFormatException(InvalidFormatException e) {
        HttpStatus status422 = HttpStatus.UNPROCESSABLE_ENTITY;
        CustomErrorResponse error = new CustomErrorResponse(status422.toString(), e.getMessage());
        error.setStatus(status422.value());
        error.setTimeStamp(LocalDateTime.now());
        ResponseEntity<CustomErrorResponse> responseEntity = new ResponseEntity<>(error, status422);
        return responseEntity;
    }

    @ExceptionHandler(value = {HttpMessageNotReadableException.class})
    @ResponseStatus(value = HttpStatus.UNPROCESSABLE_ENTITY)
    public ResponseEntity<CustomErrorResponse> ArgumentNotReadableException(HttpMessageNotReadableException e) {
        HttpStatus status422 = HttpStatus.UNPROCESSABLE_ENTITY;
        CustomErrorResponse error = new CustomErrorResponse(status422.toString(), e.getMessage());
        error.setStatus(status422.value());
        error.setTimeStamp(LocalDateTime.now());
        ResponseEntity<CustomErrorResponse> responseEntity = new ResponseEntity<>(error, status422);
        return responseEntity;
    }


}
