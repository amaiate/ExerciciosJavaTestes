package com.example.obter_diploma2.exercicio_obter_diploma.repository;

import com.example.obter_diploma2.exercicio_obter_diploma.entity.Student;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;


@Repository
public class StudentRepository {

    List<Student> students = new ArrayList<>();

    public List<Student> getStudents() {
        return students;
    }

    public Student addStudent(Student student) {
        students.add(student);
        return student;
    }


}
