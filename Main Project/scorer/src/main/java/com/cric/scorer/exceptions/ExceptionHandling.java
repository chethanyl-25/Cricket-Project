package com.cric.scorer.exceptions;

import org.springframework.aop.AopInvocationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.NoSuchElementException;

@ControllerAdvice
public class ExceptionHandling {
    @ExceptionHandler(NoSuchElementException.class)
    public ResponseEntity<Object> noSuchElement(NoSuchElementException e){
        return new ResponseEntity<>("No data with given information", HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler(StackOverflowError.class)
    public ResponseEntity<Object> stackOverFlowError(StackOverflowError stackOverflowError){
        return new ResponseEntity<>("Some Internal Server error",HttpStatus.INTERNAL_SERVER_ERROR);
    }
    @ExceptionHandler(AopInvocationException.class)
    public ResponseEntity<Object> aopInvocationException(AopInvocationException e)
    {
        return new ResponseEntity<>("No such id/name exists",HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<Object> httpMessageNotReadableException(HttpMessageNotReadableException httpMessageNotReadableException)
    {
        return new ResponseEntity<>("Please send correct JSON object",HttpStatus.BAD_REQUEST);
    }
}
