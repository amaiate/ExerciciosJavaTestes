package com.example.obter_diploma2.exercicio_obter_diploma.exceptions;

import com.example.obter_diploma2.exercicio_obter_diploma.dto.ExceptionFieldDTO;
import org.springframework.validation.FieldError;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FieldErrors {

    // cria um ExceptionFieldDTO para cada atributo que viola alguma validação
    public static ExceptionFieldDTO processFieldErrors(List<FieldError> fieldErrors) {
        Map<String, String> exceptions = new HashMap<>();
        for (FieldError fieldError : fieldErrors) {
            exceptions.put(fieldError.getField(), fieldError.getDefaultMessage());
        }
        return new ExceptionFieldDTO(exceptions);
    }
}
