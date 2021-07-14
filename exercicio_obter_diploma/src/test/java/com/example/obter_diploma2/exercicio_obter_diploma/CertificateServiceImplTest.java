package com.example.obter_diploma2.exercicio_obter_diploma;


import com.example.obter_diploma2.exercicio_obter_diploma.converter.StudentConverter;
import com.example.obter_diploma2.exercicio_obter_diploma.dto.DiplomaDTO;
import com.example.obter_diploma2.exercicio_obter_diploma.entity.Student;
import com.example.obter_diploma2.exercicio_obter_diploma.exceptions.StudentInvalidException;
import com.example.obter_diploma2.exercicio_obter_diploma.form.StudentForm;
import com.example.obter_diploma2.exercicio_obter_diploma.form.SubjectForm;
import com.example.obter_diploma2.exercicio_obter_diploma.repository.DiplomaRepository;
import com.example.obter_diploma2.exercicio_obter_diploma.repository.StudentRepository;
import com.example.obter_diploma2.exercicio_obter_diploma.service.DiplomaService;
import com.example.obter_diploma2.exercicio_obter_diploma.service.StudentService;
import com.example.obter_diploma2.exercicio_obter_diploma.utils.CalculaMedia;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.function.ThrowingSupplier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@SpringBootTest
@ExtendWith(SpringExtension.class)
public class CertificateServiceImplTest {

    @Autowired
    private ObjectMapper mapper = new ObjectMapper();
    @Autowired
    private StudentService studentService;
    @Autowired
    private DiplomaService diplomaService;
    @Autowired
    private DiplomaController diplomaController;
    @Autowired
    private  StudentRepository studentRepository;
    @Autowired
    private DiplomaRepository diplomaRepository;



    @Test
    public void Adicionando_aluno_com_nome_e_tres_disciplinas_corretas()  {
        SubjectForm sub1 = new SubjectForm("Matemática", 10);
        SubjectForm sub2 = new SubjectForm("Filosofia", 8);
        SubjectForm sub3 = new SubjectForm("História", 10);

        List <SubjectForm> subjectList = new ArrayList(Arrays.asList(new SubjectForm[]{sub1, sub2, sub3}));

        StudentForm s1 = new StudentForm("Adriana Maiate", subjectList);
        ThrowingSupplier<Student> s2 = ()-> studentService.addStudent(s1) ;
        Student student = Assertions.assertDoesNotThrow(s2);
        Assertions.assertNotNull(student);



    }


    @Test
    public void Adicionando_aluno_sem_nome_e_tres_disciplinas_corretas()  {
        SubjectForm sub1 = new SubjectForm("Matemática", 10);
        SubjectForm sub2 = new SubjectForm("Filosofia", 8);
        SubjectForm sub3 = new SubjectForm("História", 10);

        List <SubjectForm> subjectList = new ArrayList(Arrays.asList(new SubjectForm[]{sub1, sub2, sub3}));

        StudentForm s1 = new StudentForm();
        s1.setSubjects(subjectList);

        StudentInvalidException exception = Assertions.assertThrows(StudentInvalidException.class, () -> studentService.addStudent(s1));
        Assertions.assertNotNull(exception);



    }


    @Test
    public void Adicionando_aluno_com_nome_e_sem_disciplinas_cadastradas()  {
        StudentForm s1 = new StudentForm("Adriana", null);

        StudentInvalidException exception = Assertions.assertThrows(StudentInvalidException.class, () -> studentService.addStudent(s1));
        Assertions.assertNotNull(exception);

    }

    @Test
    public void Calculando_media_com_aluno_com_tres_notas_cadastradas_acima_de_8() throws Exception {
        SubjectForm sub1 = new SubjectForm("Matemática", 10);
        SubjectForm sub2 = new SubjectForm("Filosofia", 8);
        SubjectForm sub3 = new SubjectForm("História", 9);

        double mediaExpect = (sub1.getNote() + sub2.getNote() + sub3.getNote()) / 3;

        List <SubjectForm> subjectList = new ArrayList(Arrays.asList(new SubjectForm[]{sub1, sub2, sub3}));

        StudentForm s1 = new StudentForm("Adriana", subjectList);

        double media = CalculaMedia.calculateAverage(StudentConverter.studentFormForEntity(s1));

        Assertions.assertEquals(mediaExpect, media);


    }

    @Test
    public void Calculando_media_com_aluno_com_tres_notas_cadastradas_com_erro_na_media() throws Exception {
        SubjectForm sub1 = new SubjectForm("Matemática", 10);
        SubjectForm sub2 = new SubjectForm("Filosofia", 8);
        SubjectForm sub3 = new SubjectForm("História", 0);

        double mediaExpect = 2;

        List <SubjectForm> subjectList = new ArrayList(Arrays.asList(new SubjectForm[]{sub1, sub2, sub3}));

        StudentForm s1 = new StudentForm("Adriana Maiate ", subjectList);

        double media = CalculaMedia.calculateAverage(StudentConverter.studentFormForEntity(s1));

        Assertions.assertNotEquals(mediaExpect, media);


    }

    @Test
    public void Imprimindo_diploma_com_aluno_com_media_acima_de_9 () throws Exception {
        SubjectForm sub1 = new SubjectForm("Matemática", 10);
        SubjectForm sub2 = new SubjectForm("Filosofia", 8);
        SubjectForm sub3 = new SubjectForm("História", 10);
        List <SubjectForm> subjectList = new ArrayList(Arrays.asList(new SubjectForm[]{sub1, sub2, sub3}));

        StudentForm s1 = new StudentForm("Adriana Maiate", subjectList);
        Student s2 = studentService.addStudent(s1);

        DiplomaDTO expected = diplomaService.gerarDiploma(s1);
        diplomaRepository.addDiploma(expected);

        DiplomaDTO atual = diplomaRepository.getDiploma(s2);

        Assertions.assertEquals(atual, expected);

    }

    @Test
    public void Nao_Imprimindo_diploma_com_aluno_com_media_abaixo_de_6 () throws Exception {
        SubjectForm sub1 = new SubjectForm("Matemática", 10);
        SubjectForm sub2 = new SubjectForm("Filosofia", 5);
        SubjectForm sub3 = new SubjectForm("História", 0);
        List <SubjectForm> subjectList = new ArrayList(Arrays.asList(new SubjectForm[]{sub1, sub2, sub3}));

        StudentForm s1 = new StudentForm("Adriana Maiate", subjectList);
        Student s2 = studentService.addStudent(s1);


        StudentInvalidException exception = Assertions.assertThrows(StudentInvalidException.class, () -> diplomaService.gerarDiploma(s1));
        Assertions.assertNotNull(exception);

    }

    @Test
    public void Imprimindo_diploma_com_aluno_com_media_acima_de_9_com_honra () throws Exception {
        SubjectForm sub1 = new SubjectForm("Matemática", 10);
        SubjectForm sub2 = new SubjectForm("Filosofia", 9);
        SubjectForm sub3 = new SubjectForm("História", 10);
        List <SubjectForm> subjectList = new ArrayList(Arrays.asList(new SubjectForm[]{sub1, sub2, sub3}));

        StudentForm s1 = new StudentForm("Adriana Maiate", subjectList);
        Student s2 = studentService.addStudent(s1);

        DiplomaDTO expected = diplomaService.gerarDiploma(s1);
        diplomaRepository.addDiploma(expected);

        DiplomaDTO atual = diplomaRepository.getDiploma(s2);

        Assertions.assertEquals(atual.getMessage().toString(), "Aprovado! Parabéns você foi muito bem!");

    }


}
