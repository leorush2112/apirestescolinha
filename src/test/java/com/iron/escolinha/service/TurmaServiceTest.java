package com.iron.escolinha.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import java.time.LocalDate;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TurmaServiceTest {

    TurmaService turmaService;

    @BeforeEach
    public void preparar() {
        turmaService = new TurmaService();
    }

    private Aluno getAluno(int ano) {
        Aluno aluno = new Aluno();
        aluno.nome = "Joaquim";
        aluno.sobreNome = "Zezinho";
        aluno.dataNasc = LocalDate.of(ano, 2, 2);
        return aluno;
    }

    @Test
    public void deveInicializarListaVaziaDeTurmas() {
        for (int i = 1; i < 10; i++) {
            int tamanhoLista = turmaService.obterTurma(i).size();
            assertEquals(0, tamanhoLista);
        }
    }

    // inserirAluno checar Turma recebeu aluno e se numero da turma está correto.
    @Test
    public void deveInserirAlunoTurmaCorreta() {

        turmaService.inserirAluno(getAluno(2011));

        assertEquals(1, turmaService.obterTurma(5).size());

    }

    // Não Inserir aluno fora da faixa
    @Test
    public void naoInsereAlunoForadaFaixa() {
        assertThrows(IdadeForaFaixaException.class, () -> {
            turmaService.inserirAluno(getAluno(2000));
        });
    }

    @Test
    public void deveRetornarTodosAlunos() {
        turmaService.inserirAluno(getAluno(2011));
        turmaService.inserirAluno(getAluno(2012));
        turmaService.inserirAluno(getAluno(2013));

        assertEquals(3, turmaService.obterTodosAlunos().size());

    }
    // Aluno sem com Idade vazia
}
