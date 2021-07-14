package com.example.obter_diploma2.exercicio_obter_diploma.repository;

import com.example.obter_diploma2.exercicio_obter_diploma.dto.DiplomaDTO;
import com.example.obter_diploma2.exercicio_obter_diploma.entity.Student;
import com.example.obter_diploma2.exercicio_obter_diploma.exceptions.StudentInvalidException;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class DiplomaRepository {

    List<DiplomaDTO> diplomas = new ArrayList<>();

    public List<DiplomaDTO> getDiplomas() {
        return diplomas;
    }

    public DiplomaDTO getDiploma(Student student) {
        Optional<DiplomaDTO> diplomaDTO =  diplomas.stream().filter(s-> s.getStudentDTO().getName() == student.getName()).findFirst();
        return diplomaDTO.get();
    }

    public DiplomaDTO addDiploma(DiplomaDTO diplomaDTO) {

        diplomas.add(diplomaDTO);
        return diplomaDTO;
    }
}
