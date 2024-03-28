package com.exemplo_projeto_java.exemploum.handler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.exemplo_projeto_java.exemploum.model.error.ErrorMessage;
import com.exemplo_projeto_java.exemploum.model.exception.ResourceNotFoundException;

@ControllerAdvice // controlador de avisos
public class RestExceptionHandler {
    @ExceptionHandler(ResourceNotFoundException.class) // quando acontecer essa exceção, vai chamar esse método
    public ResponseEntity<?> handleResourceNotFoundException(ResourceNotFoundException r){
        ErrorMessage error = new ErrorMessage("Not Found", r.getMessage());
        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }
}
