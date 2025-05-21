package br.unipar.catalogo.produtos.controller;

import br.unipar.catalogo.produtos.dto.ApiExceptionDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.ArrayList;
import java.util.List;

@RestControllerAdvice
public class ExceptionHandlerController {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ApiExceptionDTO> handleException(Exception e) {
        ApiExceptionDTO apiException = new ApiExceptionDTO(e.getMessage());
        return ResponseEntity.internalServerError().body(apiException);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ApiExceptionDTO> handleMethodArgumentNotValidException(
            MethodArgumentNotValidException e) {

        List<String> errors = new ArrayList<>();

        for (FieldError fieldError : e.getBindingResult().getFieldErrors()) {
            errors.add(fieldError.getField() + ": " +
                    fieldError.getDefaultMessage());
        }

        ApiExceptionDTO apiException = new ApiExceptionDTO(errors);

        return ResponseEntity.badRequest().body(apiException);
    }

}
