package com.example.obter_diploma2.exercicio_obter_diploma.utils;

import com.example.obter_diploma2.exercicio_obter_diploma.dto.StudentDTO;
import com.example.obter_diploma2.exercicio_obter_diploma.exceptions.StudentInvalidException;

import java.text.DecimalFormat;

public class GerarMensagem {

    public static String gerarMensagem(double average){

        String resultado = "";
        if (average >= 9) {
            resultado = "Aprovado! Parabéns você foi muito bem!";

        } else if (average >= 6) {
            resultado = "Aprovado";
        } else {
            throw new StudentInvalidException("Reprovado! Com essa média final não é possível liberar seu diploma, estude mais!");
        }
        return resultado;
    }

    public static String arredondar(Double valor) {

        return new DecimalFormat("#,##0.00").format(valor);
    }
}
