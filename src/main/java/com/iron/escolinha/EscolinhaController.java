package com.iron.escolinha;

import java.util.ArrayList;
import java.util.List;

import com.iron.escolinha.service.Aluno;
import com.iron.escolinha.service.TurmaService;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.server.ResponseStatusException;

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

@RestController
public class EscolinhaController {
    TurmaService turmaService = new TurmaService();

    @PostMapping("/aluno")
    public RespostaApi inserirAluno(@RequestBody Aluno aluno) {

        int turmaId = turmaService.inserirAluno(aluno);
        RespostaApi resposta = new RespostaApi("OK inserido na turma: " + turmaId + " Serie");
        return resposta;
    }

    @GetMapping("/turma/{id}")
    public List<Aluno> mostrarAluno(@PathVariable int id) {
        return turmaService.obterTurma(id);
    }

    @GetMapping("/aluno")
    public List<Aluno> mostrarTodosAlunos() {
        return turmaService.obterTodosAlunos();
    }
}
