package com.example.obter_diploma2.exercicio_obter_diploma.utils;


import com.example.obter_diploma2.exercicio_obter_diploma.exceptions.StudentInvalidException;

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

}
