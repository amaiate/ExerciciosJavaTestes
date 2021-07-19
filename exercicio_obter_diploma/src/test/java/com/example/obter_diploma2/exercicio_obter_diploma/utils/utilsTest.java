package com.example.obter_diploma2.exercicio_obter_diploma.utils;

import com.example.obter_diploma2.exercicio_obter_diploma.dto.DiplomaDTO;
import com.example.obter_diploma2.exercicio_obter_diploma.entity.Student;
import com.example.obter_diploma2.exercicio_obter_diploma.form.StudentForm;
import com.example.obter_diploma2.exercicio_obter_diploma.form.SubjectForm;
import com.example.obter_diploma2.exercicio_obter_diploma.service.DiplomaService;
import com.example.obter_diploma2.exercicio_obter_diploma.service.StudentService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.ThrowingSupplier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@SpringBootTest
public class utilsTest {

    @Autowired
    private StudentService studentService;

    @Autowired
    private DiplomaService diplomaService;

    @Test
    public void deve_GerarMensagemAlunosCorretamente_Media7() throws Exception {
        SubjectForm sub1 = new SubjectForm("Matemática", 7);
        SubjectForm sub2 = new SubjectForm("Filosofia", 7);
        SubjectForm sub3 = new SubjectForm("História", 7);

        List<SubjectForm> subjectList = new ArrayList(Arrays.asList(new SubjectForm[]{sub1, sub2, sub3}));

        StudentForm s1 = new StudentForm("Adriana Maiate", subjectList);
        ThrowingSupplier<Student> s2 = ()-> studentService.addStudent(s1);
        DiplomaDTO diplomaDTO = diplomaService.gerarDiploma(s1);



        Assertions.assertEquals("Aprovado",diplomaDTO.getMessage());




    }
}
