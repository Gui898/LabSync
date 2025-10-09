package com.labSync.LabSync.infra;

import com.labSync.LabSync.exception.UserNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class RestExceptionHandler {

    @ExceptionHandler(UserNotFoundException.class)
    private ResponseEntity<RestErrorMessage> userNotFoundHandler(UserNotFoundException e){
        RestErrorMessage message = new RestErrorMessage(HttpStatus.NOT_FOUND.value(), HttpStatus.NOT_FOUND, e.getMessage());
        return new ResponseEntity<>(message, HttpStatus.NOT_FOUND);

    }

}
