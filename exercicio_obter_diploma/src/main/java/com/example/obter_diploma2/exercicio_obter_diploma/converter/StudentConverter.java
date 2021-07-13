package com.example.obter_diploma2.exercicio_obter_diploma.converter;

import com.example.obter_diploma2.exercicio_obter_diploma.dto.StudentDTO;
import com.example.obter_diploma2.exercicio_obter_diploma.entity.Student;
import com.example.obter_diploma2.exercicio_obter_diploma.form.StudentForm;

import java.util.ArrayList;
import java.util.List;

public class StudentConverter {

    public static List<StudentDTO> studentsEntityToDTO(List<Student> students) {
        List<StudentDTO> studentDTOS = new ArrayList<>();

        for (Student student : students) {
            studentDTOS.add(studentEntityToDTO(student));
        }

        return studentDTOS;

    }

    private static StudentDTO studentEntityToDTO(Student student) {
        return new StudentDTO(
               student.getName(),
               student.getSubjects()
        );
    }

    public static Student studentFormForEntity(StudentForm studentForm) {

        return new Student(
                studentForm.getName(),
                studentForm.getSubjects()
        );
    }
}
