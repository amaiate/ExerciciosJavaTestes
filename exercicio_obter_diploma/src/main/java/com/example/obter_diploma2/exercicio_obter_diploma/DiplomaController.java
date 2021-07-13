package com.example.obter_diploma2.exercicio_obter_diploma;

import com.example.obter_diploma2.exercicio_obter_diploma.converter.StudentConverter;
import com.example.obter_diploma2.exercicio_obter_diploma.entity.Student;
import com.example.obter_diploma2.exercicio_obter_diploma.form.StudentForm;
import com.example.obter_diploma2.exercicio_obter_diploma.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api")
public class DiplomaController {

    private StudentService studentService;

    public DiplomaController() {
    }

    @Autowired
    public DiplomaController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping
    public ResponseEntity<Student> postAluno (@RequestBody @Valid StudentForm student){
        studentService.addStudent(student);
        return ResponseEntity.accepted().body(StudentConverter.studentFormForEntity(student));

    }

}
