package com.example.obter_diploma2.exercicio_obter_diploma.form;

import javax.validation.Valid;
import javax.validation.constraints.*;

public class SubjectForm {


    @NotNull(message = "Disciplina não pode ser nula")
    @Pattern(regexp = "[A-Za-záàâãéèêíïóôõöúçñÁÀÂÃÉÈÍÏÓÔÕÖÚÇÑ ]+$", message = "O nome deve ser composto de letras")
    @Size(min = 8, max = 50, message = "Campo com no mínimo 8 caracteres e no máximo 50")
    @Valid
    private String subject;

    @Max(value = 10, message = "a nota não pode ser maior que 10")
    @NotNull(message = "A nota não pode ser nula")
    @Positive(message = "A nota não pode ser negativa")
    @Valid
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
