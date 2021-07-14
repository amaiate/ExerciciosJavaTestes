package com.example.obter_diploma2.exercicio_obter_diploma;

import com.example.obter_diploma2.exercicio_obter_diploma.entity.Student;
import com.example.obter_diploma2.exercicio_obter_diploma.exceptions.StudentInvalidException;
import com.example.obter_diploma2.exercicio_obter_diploma.form.StudentForm;
import com.example.obter_diploma2.exercicio_obter_diploma.form.SubjectForm;
import com.example.obter_diploma2.exercicio_obter_diploma.service.StudentService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.function.ThrowingSupplier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@SpringBootTest
@ExtendWith(SpringExtension.class)
class ExercicioObterDiplomaApplicationTests {

    @Autowired
    private ObjectMapper mapper = new ObjectMapper();
    @Autowired
    private StudentService studentService;

    @Test
    public void Adicionando_aluno_com_nome_e_tres_disciplinas_corretas()  {
        SubjectForm sub1 = new SubjectForm("Matemática", 10);
        SubjectForm sub2 = new SubjectForm("Filosofia", 8);
        SubjectForm sub3 = new SubjectForm("História", 10);

        List<SubjectForm> subjectList = new ArrayList(Arrays.asList(new SubjectForm[]{sub1, sub2, sub3}));

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

}
