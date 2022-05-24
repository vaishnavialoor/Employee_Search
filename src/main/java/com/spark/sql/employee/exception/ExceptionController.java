package com.spark.sql.employee.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionController {

    @ExceptionHandler(value = NoResultsFoundException.class)
    public ResponseEntity<Object> exception(NoResultsFoundException exception) {
        return new ResponseEntity<>("No employee results found for the search criteria", HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(value = InvalidInputException.class)
    public ResponseEntity<Object> exception(InvalidInputException exception) {
        return new ResponseEntity<>("Sorry!your search criteria is not valid", HttpStatus.BAD_REQUEST);
    }
}
