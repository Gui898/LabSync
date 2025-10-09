package com.labSync.LabSync.infra;

import com.labSync.LabSync.exception.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class RestExceptionHandler {

    //USER EXCEPTIONS

    @ExceptionHandler(UserNotFoundException.class)
    private ResponseEntity<RestErrorMessage> userNotFoundHandler(UserNotFoundException e){
        RestErrorMessage message = new RestErrorMessage(HttpStatus.NOT_FOUND.value(), HttpStatus.NOT_FOUND, e.getMessage());
        return new ResponseEntity<>(message, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(UserConflictException.class)
    private ResponseEntity<RestErrorMessage> userConflictHandler(UserConflictException e){
        RestErrorMessage message = new RestErrorMessage(HttpStatus.CONFLICT.value(), HttpStatus.CONFLICT, e.getMessage());
        return new ResponseEntity<>(message, HttpStatus.CONFLICT);
    }

    @ExceptionHandler(UserUnauthorizedException.class)
    private ResponseEntity<RestErrorMessage> userUnauthorizedHandler(UserUnauthorizedException e){
        RestErrorMessage message = new RestErrorMessage(HttpStatus.UNAUTHORIZED.value(), HttpStatus.UNAUTHORIZED, e.getMessage());
        return new ResponseEntity<>(message, HttpStatus.UNAUTHORIZED);
    }

    @ExceptionHandler(UserInvalidValuesException.class)
    private ResponseEntity<RestErrorMessage> userInvalidValuesHandler(UserInvalidValuesException e){
        RestErrorMessage message = new RestErrorMessage(HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST, e.getMessage());
        return new ResponseEntity<>(message, HttpStatus.BAD_REQUEST);
    }

    //PROJECT EXCEPTIONS

    @ExceptionHandler(ProjectNotFoundException.class)
    private ResponseEntity<RestErrorMessage> projectNotFoundException(ProjectNotFoundException e){
        RestErrorMessage message = new RestErrorMessage(HttpStatus.NOT_FOUND.value(), HttpStatus.NOT_FOUND, e.getMessage());
        return new ResponseEntity<>(message, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(ProjectConflictException.class)
    private ResponseEntity<RestErrorMessage> projectConflictException(ProjectConflictException e) {
        RestErrorMessage message = new RestErrorMessage(HttpStatus.CONFLICT.value(), HttpStatus.CONFLICT, e.getMessage());
        return new ResponseEntity<>(message, HttpStatus.CONFLICT);
    }

    //POST EXCEPTIONS

    @ExceptionHandler(PostNotFoundException.class)
    private ResponseEntity<RestErrorMessage> postNotFoundException(PostNotFoundException e) {
        RestErrorMessage message = new RestErrorMessage(HttpStatus.NOT_FOUND.value(), HttpStatus.NOT_FOUND, e.getMessage());
        return new ResponseEntity<>(message, HttpStatus.NOT_FOUND);
    }

    // FAVORITE EXCEPTIONS

    @ExceptionHandler(FavoriteNotFoundException.class)
    private ResponseEntity<RestErrorMessage> favoriteNotFoundException(FavoriteNotFoundException e) {
        RestErrorMessage message = new RestErrorMessage(HttpStatus.NOT_FOUND.value(), HttpStatus.NOT_FOUND, e.getMessage());
        return new ResponseEntity<>(message, HttpStatus.NOT_FOUND);
    }
}
