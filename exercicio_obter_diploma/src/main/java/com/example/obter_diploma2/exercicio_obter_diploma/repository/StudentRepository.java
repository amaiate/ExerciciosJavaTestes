package com.example.obter_diploma2.exercicio_obter_diploma.repository;

import com.example.obter_diploma2.exercicio_obter_diploma.converter.StudentConverter;
import com.example.obter_diploma2.exercicio_obter_diploma.converter.SubjectConverter;
import com.example.obter_diploma2.exercicio_obter_diploma.dto.DiplomaDTO;
import com.example.obter_diploma2.exercicio_obter_diploma.dto.StudentDTO;
import com.example.obter_diploma2.exercicio_obter_diploma.entity.Student;
import com.example.obter_diploma2.exercicio_obter_diploma.form.StudentForm;
import com.example.obter_diploma2.exercicio_obter_diploma.utils.CalculaMedia;
import com.example.obter_diploma2.exercicio_obter_diploma.utils.GerarMensagem;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;


@Repository
public class StudentRepository {

    List<Student> students = new ArrayList<>();

    public List<Student> getStudents() {
        return students;
    }

    public Student addStudent(Student student) {
        students.add(student);
        return student;
    }

    public DiplomaDTO calculaNotas (Student student) throws Exception {

        try{
        StudentDTO studentDTO = StudentConverter.studentEntityToDTO(student);
        return new DiplomaDTO(
                GerarMensagem.gerarMensagem(CalculaMedia.averageCalc(student)),
                CalculaMedia.averageCalc(student),
                studentDTO

        );
        }catch (Exception e){
            throw new Exception();
        }
    }

}
