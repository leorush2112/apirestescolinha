package com.iron.escolinha;

import java.time.LocalDate;
import java.time.Period;

public class Aluno {
    public String nome;
    public String sobreNome;
    public LocalDate dataNasc;

    public int getIdade() {
        return Period.between(dataNasc, LocalDate.now()).getYears();
    }

}
