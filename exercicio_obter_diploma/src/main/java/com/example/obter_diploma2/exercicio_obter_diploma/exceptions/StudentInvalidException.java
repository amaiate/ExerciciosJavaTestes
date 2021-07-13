package com.example.obter_diploma2.exercicio_obter_diploma.exceptions;

public class StudentInvalidException extends RuntimeException{


    public StudentInvalidException (String message) {
        super(message);
    }

    public StudentInvalidException (Exception e) {
        super(e);
    }
}
