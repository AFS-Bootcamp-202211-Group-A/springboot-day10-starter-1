package com.rest.springbootemployee.advice;

import com.rest.springbootemployee.exception.IdInvalidException;
import com.rest.springbootemployee.exception.NoCompanyFoundException;
import com.rest.springbootemployee.exception.NoEmployeeFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler({IdInvalidException.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorResponse invalidId(Exception exception){
        return new ErrorResponse(HttpStatus.BAD_REQUEST.value(), exception.getMessage());
    }

    @ExceptionHandler({NoEmployeeFoundException.class, NoCompanyFoundException.class})
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ErrorResponse method(Exception exception) {
        return new ErrorResponse(HttpStatus.NOT_FOUND.value(), exception.getMessage());
    }


}
