package com.example.obter_diploma2.exercicio_obter_diploma.form;

public class SubjectForm {

    private String subject;

    private double note;

    public SubjectForm(String subject, double note) {
        this.subject = subject;
        this.note = note;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public double getNote() {
        return note;
    }

    public void setNote(double note) {
        this.note = note;
    }
}
