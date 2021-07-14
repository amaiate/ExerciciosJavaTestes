package com.example.obter_diploma2.exercicio_obter_diploma.utils;

import com.example.obter_diploma2.exercicio_obter_diploma.entity.Student;
import com.example.obter_diploma2.exercicio_obter_diploma.entity.Subject;

public class CalculaMedia {

    public static double calculateAverage (Student student){

        double mediaCalculada = 0;
        double notasTotais = 0;
        int disciplinas = student.getSubjects().size();

        for (Subject s : student.getSubjects()) {
            notasTotais += s.getNote();

        }

        mediaCalculada = notasTotais / disciplinas;

        return mediaCalculada;
    }
}
