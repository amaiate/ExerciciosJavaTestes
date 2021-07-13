package com.example.obter_diploma2.exercicio_obter_diploma.exceptions;

import com.example.obter_diploma2.exercicio_obter_diploma.dto.ExceptionDTO;
import com.example.obter_diploma2.exercicio_obter_diploma.dto.ExceptionFieldDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingRequestHeaderException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.List;

@ControllerAdvice
public class DiplomaHandlerException {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<?> argumentNotValidHandler(MethodArgumentNotValidException e) {
        BindingResult result = e.getBindingResult();

        List<FieldError> fieldErrors = result.getFieldErrors();
        ExceptionFieldDTO exceptions = FieldErrors.processFieldErrors(fieldErrors);

        return ResponseEntity.badRequest().body(exceptions);
    }


    @ExceptionHandler(StudentInvalidException.class)
    public ResponseEntity<?> invalidLinkExceptionHandler(StudentInvalidException e) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ExceptionDTO(e.getMessage()));
    }


    @ExceptionHandler(MissingRequestHeaderException.class)
    public ResponseEntity<?> missingHeaderHandler(MissingRequestHeaderException e) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ExceptionDTO("Header not found"));
    }


}
