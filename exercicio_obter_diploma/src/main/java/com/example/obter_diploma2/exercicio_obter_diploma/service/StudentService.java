package com.example.obter_diploma2.exercicio_obter_diploma.service;

import com.example.obter_diploma2.exercicio_obter_diploma.converter.StudentConverter;
import com.example.obter_diploma2.exercicio_obter_diploma.dto.StudentDTO;
import com.example.obter_diploma2.exercicio_obter_diploma.entity.Student;
import com.example.obter_diploma2.exercicio_obter_diploma.form.StudentForm;
import com.example.obter_diploma2.exercicio_obter_diploma.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    private StudentRepository studentRepository;

    @Autowired
    public StudentService(StudentRepository studentsRepository) {
        this.studentRepository = studentsRepository;
    }

    public List<StudentDTO> findStudents() {
        return StudentConverter.studentsEntityToDTO(studentRepository.getStudents());
    }

    public Student addStudent(StudentForm studentForm) {
        return studentRepository.addStudent(StudentConverter.studentFormForEntity(studentForm));
    }
}
