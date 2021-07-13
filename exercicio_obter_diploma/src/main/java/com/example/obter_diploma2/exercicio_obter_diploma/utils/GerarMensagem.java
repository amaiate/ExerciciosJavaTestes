package com.example.obter_diploma2.exercicio_obter_diploma.utils;

import com.example.obter_diploma2.exercicio_obter_diploma.dto.StudentDTO;

import java.text.DecimalFormat;

public class GerarMensagem {

    private String mensagem = "";

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

    public static String gerarMensagem(double average){

        String resultado = "";
        if (average >= 9) {
            resultado = "Aprovado! Parabéns você foi muito bem!";

        } else if (average >= 6) {
            resultado = "Aprovado";
        } else {
            resultado = "Reprovado! Com essa média final não é possível liberar seu diploma, estude mais!";
        }
        return resultado;
    }

    public static String arredondar(Double valor) {

        return new DecimalFormat("#,##0.00").format(valor);
    }
}
