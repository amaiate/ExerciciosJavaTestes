package com.example.obter_diploma2.exercicio_obter_diploma.repository;

import com.example.obter_diploma2.exercicio_obter_diploma.converter.StudentConverter;
import com.example.obter_diploma2.exercicio_obter_diploma.dto.DiplomaDTO;
import com.example.obter_diploma2.exercicio_obter_diploma.dto.StudentDTO;
import com.example.obter_diploma2.exercicio_obter_diploma.entity.Student;
import com.example.obter_diploma2.exercicio_obter_diploma.exceptions.StudentInvalidException;
import com.example.obter_diploma2.exercicio_obter_diploma.utils.CalculaMedia;
import com.example.obter_diploma2.exercicio_obter_diploma.utils.GerarMensagem;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;


@Repository
public class StudentRepository {

    List<Student> students = new ArrayList<>();


    public Student addStudent(Student student) {
       if(!validar(student)){
           throw new StudentInvalidException("Não é possível cadastrar diploma para aluno sem nome");
       };

        students.add(student);
        return student;
    }

    public DiplomaDTO calculaNotas (Student student) {

        try{
        StudentDTO studentDTO = StudentConverter.studentEntityToDTO(student);
        return new DiplomaDTO(
                GerarMensagem.gerarMensagem(CalculaMedia.calculateAverage(student)),
                CalculaMedia.calculateAverage(student),
                studentDTO

        );
        }catch (StudentInvalidException e){
            throw new StudentInvalidException("Não foi possível gerar diploma");
        }
    }

    public boolean validar(Student student){
        if(student.getName() == null || student.getSubjects() == null){
            return false;
        }
            return true;
    }

}
