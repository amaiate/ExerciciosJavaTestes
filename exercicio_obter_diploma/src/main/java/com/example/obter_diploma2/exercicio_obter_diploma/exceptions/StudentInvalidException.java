package com.example.obter_diploma2.exercicio_obter_diploma.exceptions;

public class StudentInvalidException extends RuntimeException{


    public static final String DEFAULT_MESSAGE = "Aluno inválido.";

    public StudentInvalidException() {
        this(DEFAULT_MESSAGE);
    }

    public StudentInvalidException (String message) {
        super(message);
    }

    public StudentInvalidException (Exception e) {
        super(e);
    }
}
