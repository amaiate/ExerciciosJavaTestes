package com.example.obter_diploma2.exercicio_obter_diploma;

import com.example.obter_diploma2.exercicio_obter_diploma.dto.DiplomaDTO;
import com.example.obter_diploma2.exercicio_obter_diploma.form.StudentForm;
import com.example.obter_diploma2.exercicio_obter_diploma.service.DiplomaService;
import com.example.obter_diploma2.exercicio_obter_diploma.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api")
public class DiplomaController {

    private StudentService studentService;

    private DiplomaService diplomaService;

    public DiplomaController() {
    }

    @Autowired
    public DiplomaController(StudentService studentService, DiplomaService diplomaService) {
        this.studentService = studentService;
        this.diplomaService = diplomaService;
    }

    @PostMapping("/diploma")
    public ResponseEntity<DiplomaDTO> postAluno (@RequestBody @Valid StudentForm student) throws Exception {
        studentService.addStudent(student);
        return ResponseEntity.accepted().body(diplomaService.gerarDiploma(student));

    }

}
