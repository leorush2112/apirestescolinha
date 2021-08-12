package com.iron.escolinha.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

//Gerenciar as turmas
@Service
public class TurmaService {

    private List<List<Aluno>> turmas = new ArrayList<>();

    public TurmaService() {
        for (int i = 0; i < 9; i++) {
            List<Aluno> turma = new ArrayList<>();
            turmas.add(turma);
        }
    }

    public int inserirAluno(Aluno aluno) {
        if (aluno.getIdade() < 6 || aluno.getIdade() > 14) {
            throw new IdadeForaFaixaException();
        }
        int turmaId = aluno.getIdade() - 6;
        turmas.get(turmaId).add(aluno);
        return turmaId + 1;
    }

    public List<Aluno> obterTurma(int id) {
        return turmas.get(id - 1);
    }

    public List<Aluno> obterTodosAlunos() {
        List<Aluno> alunos = new ArrayList<>();
        for (List<Aluno> turma : turmas) {
            for (Aluno aluno : turma) {
                alunos.add(aluno);
            }
        }
        return alunos;
    }

}
