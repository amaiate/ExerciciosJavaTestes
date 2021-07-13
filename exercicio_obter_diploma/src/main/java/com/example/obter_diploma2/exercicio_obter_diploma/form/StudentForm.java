package com.example.obter_diploma2.exercicio_obter_diploma.form;

import com.example.obter_diploma2.exercicio_obter_diploma.entity.Subject;

import javax.validation.Valid;
import javax.validation.constraints.*;
import javax.validation.constraints.Size;
import javax.validation.constraints.NotNull;
import java.util.List;

public class StudentForm {

    @NotNull(message = "Estudante não pode ser nulo")
    @Pattern(regexp = "[A-Za-záàâãéèêíïóôõöúçñÁÀÂÃÉÈÍÏÓÔÕÖÚÇÑ ]+$", message = "O nome deve ser composto de letras")
    @Size(min = 8, max = 50, message = "Campo com no mínimo 8 caracteres e no máximo 50")
    private String name;

    @NotNull(message = "As notas não podem ser nulas")
    @Valid
    private List<SubjectForm> subjects;

    public StudentForm(String name, List<SubjectForm> subjects) {
        this.name = name;
        this.subjects = subjects;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<SubjectForm> getSubjects() {
        return subjects;
    }

    public void setSubjects(List<SubjectForm> subjects) {
        this.subjects = subjects;
    }
}
