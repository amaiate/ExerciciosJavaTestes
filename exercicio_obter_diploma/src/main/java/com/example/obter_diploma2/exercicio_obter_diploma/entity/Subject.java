package com.example.obter_diploma2.exercicio_obter_diploma.entity;

public class Subject {

    private String subject;

    private double note;

    public Subject(String subject, double note) {
        this.subject = subject;
        this.note = note;
    }

    public String getSubject() {
        return subject;
    }


    public double getNote() {
        return note;
    }


    @Override
    public String toString() {
        return "Subject{" +
                "subject='" + subject + '\'' +
                ", note=" + note +
                '}';
    }
}
