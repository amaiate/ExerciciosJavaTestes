package com.example.obter_diploma2.exercicio_obter_diploma.dto;

public class DiplomaDTO {

    private String message;

    private double avarage;

    private StudentDTO studentDTO;

    public DiplomaDTO(String message, double avarage, StudentDTO studentDTO) {
        this.message = message;
        this.avarage = avarage;
        this.studentDTO = studentDTO;
    }

    public DiplomaDTO() {

    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public double getAvarage() {
        return avarage;
    }

    public void setAvarage(double avarage) {
        this.avarage = avarage;
    }

    public StudentDTO getStudentDTO() {
        return studentDTO;
    }

    public void setStudentDTO(StudentDTO studentDTO) {
        this.studentDTO = studentDTO;
    }
}
