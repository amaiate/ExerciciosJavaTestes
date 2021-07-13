package com.example.obter_diploma2.exercicio_obter_diploma.dto;

import com.example.obter_diploma2.exercicio_obter_diploma.entity.Subject;

import java.util.List;

public class StudentDTO {


    private String name;

    private List<SubjectDTO> subjects;


    public StudentDTO(String name, List<SubjectDTO> subjects)
    {
        this.name = name;
        this.subjects = subjects;
    }

    public String getName() {
        return name;
    }

    public List<SubjectDTO> getSubjects() {
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
