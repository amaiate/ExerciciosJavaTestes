package com.example.obter_diploma2.exercicio_obter_diploma.service;

import com.example.obter_diploma2.exercicio_obter_diploma.converter.StudentConverter;
import com.example.obter_diploma2.exercicio_obter_diploma.dto.DiplomaDTO;
import com.example.obter_diploma2.exercicio_obter_diploma.dto.StudentDTO;
import com.example.obter_diploma2.exercicio_obter_diploma.entity.Student;
import com.example.obter_diploma2.exercicio_obter_diploma.form.StudentForm;
import com.example.obter_diploma2.exercicio_obter_diploma.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DiplomaService {

    private StudentRepository studentRepository;

    @Autowired
    public DiplomaService(StudentRepository studentsRepository) {
        this.studentRepository = studentsRepository;
    }


    public DiplomaDTO gerarDiploma(StudentForm studentForm) throws Exception {

        return studentRepository.calculaNotas(StudentConverter.studentFormForEntity(studentForm));
    }
}
