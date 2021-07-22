package com.example.obter_diploma2.exercicio_obter_diploma.entity;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.List;

public class Student {

    @NotNull(message = "Estudante não pode ser nulo")
    @Pattern(regexp = "[A-Za-záàâãéèêíïóôõöúçñÁÀÂÃÉÈÍÏÓÔÕÖÚÇÑ ]+$", message = "O nome deve ser composto de letras")
    @Size(min = 8, max = 50, message = "Campo com no mínimo 8 caracteres e no máximo 50")
    private String name;

    private List<Subject> subjects;

    public Student(String name, List<Subject> subjects)
    {
        this.name = name;
        this.subjects = subjects;
    }

    public String getName() {
        return name;
    }

    public List<Subject> getSubjects() {
        return subjects;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", subjects=" + subjects +
                '}';
    }
}
