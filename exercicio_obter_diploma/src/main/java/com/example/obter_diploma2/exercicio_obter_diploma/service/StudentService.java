package com.example.obter_diploma2.exercicio_obter_diploma.service;

import com.example.obter_diploma2.exercicio_obter_diploma.converter.StudentConverter;
import com.example.obter_diploma2.exercicio_obter_diploma.entity.Student;
import com.example.obter_diploma2.exercicio_obter_diploma.exceptions.StudentInvalidException;
import com.example.obter_diploma2.exercicio_obter_diploma.form.StudentForm;
import com.example.obter_diploma2.exercicio_obter_diploma.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

    private StudentRepository studentRepository;

    @Autowired
    public StudentService(StudentRepository studentsRepository) {
        this.studentRepository = studentsRepository;
    }

    public Student addStudent(StudentForm studentForm) {
        if(studentForm.getSubjects() == null){
            throw new StudentInvalidException("Aluno " + studentForm.getName() + " sem notas, status: Reprovado!");
        }
        return studentRepository.addStudent(StudentConverter.studentFormForEntity(studentForm));
    }
}
