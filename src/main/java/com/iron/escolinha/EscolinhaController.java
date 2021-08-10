package com.iron.escolinha;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EscolinhaController {

    List<List<Aluno>> turmas = new ArrayList<>();
    // REGRAS PARA INSERIR ALUNOS
    // turmaList [0] "1 Serie" = 6 anos
    // turmaList [1] "2 Serie" = 7 anos
    // turmaList [2] "3 Serie" = 8 anos
    // turmaList [3] "4 Serie" = 9 anos
    // turmaList [4] "5 Serie" = 10 anos
    // turmaList [5] "6 Serie" = 11 anos
    // turmaList [6] "7 Serie" = 12 anos
    // turmaList [7] "8 Serie" = 13 anos
    // turmaList [8] "9 Serie" = 14 anos

    @PostMapping("/aluno")
    public String inserirAluno(@RequestBody Aluno aluno) {

        for (int i = 0; i < 9; i++) {
            List<Aluno> turma = new ArrayList<>();
            turmas.add(turma);
        }
        if (aluno.getIdade() < 6 || aluno.getIdade() > 14) {
            return "Fora da faixa";
        }
        int turmaId = aluno.getIdade() - 6;
        turmas.get(turmaId).add(aluno);
        turmaId += 1;
        return "OK inserido na turma: " + turmaId + " Serie";
    }

    @GetMapping("/turma/{id}")
    public List<Aluno> mostrarAluno(@PathVariable int id) {
        id -= 1;
        return turmas.get(id);
    }
}
