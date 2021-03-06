package com.example.obter_diploma2.exercicio_obter_diploma;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import com.example.obter_diploma2.exercicio_obter_diploma.dto.DiplomaDTO;
import com.example.obter_diploma2.exercicio_obter_diploma.form.StudentForm;
import com.example.obter_diploma2.exercicio_obter_diploma.form.SubjectForm;
import com.example.obter_diploma2.exercicio_obter_diploma.repository.DiplomaRepository;
import com.example.obter_diploma2.exercicio_obter_diploma.repository.StudentRepository;
import com.example.obter_diploma2.exercicio_obter_diploma.service.DiplomaService;
import com.example.obter_diploma2.exercicio_obter_diploma.service.StudentService;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.web.context.WebApplicationContext;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("test")
public class DiplomaRestControllerTest {


    @Autowired
    private MockMvc mock;

    @Autowired
    private ObjectMapper mapper = new ObjectMapper();

    @Autowired
    private StudentService studentService;

    @Autowired
    private DiplomaService diplomaService;

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private DiplomaRepository diplomaRepository;

    @Autowired
    private WebApplicationContext webApplicationContext;

    @Test
    public void deve_EmitirUmDiploma() throws Exception {
        DiplomaDTO diplomaDTO = new DiplomaDTO();
        SubjectForm sub1 = new SubjectForm("Matem??tica", 10);
        SubjectForm sub2 = new SubjectForm("Filosofia", 9);
        SubjectForm sub3 = new SubjectForm("Hist??ria", 10);
        List<SubjectForm> subjectList = new ArrayList(Arrays.asList(new SubjectForm[]{sub1, sub2, sub3}));

        StudentForm s1 = new StudentForm("Adriana Maiate", subjectList);
        studentService.addStudent(s1);

        DiplomaDTO expected = diplomaService.gerarDiploma(s1);
        diplomaRepository.addDiploma(expected);


        String payLoad = mapper.writeValueAsString(s1);
        this.mock.perform(MockMvcRequestBuilders.post("/api/diploma")
                .contentType("application/json")
                .content(payLoad))
                .andExpect(MockMvcResultMatchers.status().isAccepted());

    }


    @Test
    public void retorna_AlunoN??oAprovado() throws Exception {

        DiplomaDTO diplomaDTO = new DiplomaDTO();
        SubjectForm sub1 = new SubjectForm("Matem??tica", 10);
        SubjectForm sub2 = new SubjectForm("Filosofia", 9);
        SubjectForm sub3 = new SubjectForm("Hist??ria", 10);
        List<SubjectForm> subjectList = new ArrayList(Arrays.asList(new SubjectForm[]{sub1, sub2, sub3}));

        StudentForm s1 = new StudentForm("Adriana Maiate", subjectList);
        studentService.addStudent(s1);

        DiplomaDTO expected = diplomaService.gerarDiploma(s1);
        diplomaRepository.addDiploma(expected);


        String payLoad = mapper.writeValueAsString(s1);
        this.mock.perform(MockMvcRequestBuilders.post("/api/diploma")
                .contentType("application/json")
                .content("null"))
                .andExpect(MockMvcResultMatchers.status().isBadRequest());
    }
    }

