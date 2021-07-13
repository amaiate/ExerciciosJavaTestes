package com.example.obter_diploma2.exercicio_obter_diploma.converter;

import com.example.obter_diploma2.exercicio_obter_diploma.dto.StudentDTO;
import com.example.obter_diploma2.exercicio_obter_diploma.entity.Student;
import com.example.obter_diploma2.exercicio_obter_diploma.entity.Subject;
import com.example.obter_diploma2.exercicio_obter_diploma.form.StudentForm;
import com.example.obter_diploma2.exercicio_obter_diploma.form.SubjectForm;

import java.util.ArrayList;
import java.util.List;

public class SubjectConverter {

    public static Subject studentFormForEntity(SubjectForm subjectForm) {

        return new Subject(
                subjectForm.getSubject(),
                subjectForm.getNote()
        );
    }

    public static List<Subject> subjectListFormEntity(List<SubjectForm> subjectList) {
        List<Subject> subjects = new ArrayList<>();

        for (SubjectForm sub : subjectList) {
            subjects.add(studentFormForEntity(sub));
        }

        return subjects;

    }
}