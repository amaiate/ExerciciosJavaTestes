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
    @Valid
    private String name;

    private List<Subject> subjects;

    public StudentForm(String name, List<Subject> subjects) {
        this.name = name;
        this.subjects = subjects;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Subject> getSubjects() {
        return subjects;
    }

    public void setSubjects(List<Subject> subjects) {
        this.subjects = subjects;
    }
}
