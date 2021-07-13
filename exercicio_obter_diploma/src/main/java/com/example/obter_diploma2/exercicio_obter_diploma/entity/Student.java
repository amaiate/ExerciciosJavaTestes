package com.example.obter_diploma2.exercicio_obter_diploma.entity;

import java.util.List;

public class Student {

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
