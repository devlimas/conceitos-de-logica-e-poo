package com.poo.entities;

import com.poo.enums.Especialidade;
import com.poo.enums.NivelExperiencia;
import com.poo.enums.StatusMissao;
import com.poo.exceptions.Existente;
import com.poo.exceptions.Prioridade;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MissaoTest {

    private Missao missao;

    @BeforeEach
    public void setUp() {
        missao = new Missao(
                "Missão Marte",
                StatusMissao.PENDENTE,
                2
        );
    }

    @Test
    public void testCriarMissaoComSucesso() {
        assertNotNull(missao);
        assertEquals("Missão Marte", missao.getNomeMissao());
        assertEquals(StatusMissao.PENDENTE, missao.getStatusMissao());
        assertEquals(2, missao.getPrioridade().intValue());
    }

    @Test
    public void testPrioridadeAcimaDeLimite() {
        //Verificamos se a criação da Missão lança a exceção Prioridade
        assertThrows(Prioridade.class, () -> {
            new Missao(
                    "Missão Zeta",
                    StatusMissao.PENDENTE,
                    5 //Acima do limite de 3
            );
        });
    }

    @Test
    public void testPrioridadeNegativa() {
        // Verificamos se a criação da Missão com prioridade negativa lança a exceção Prioridade
        assertThrows(Prioridade.class, () -> {
            new Missao(
                    "Missão Negativa",
                    StatusMissao.PENDENTE,
                    -1
            );
        });
    }

    @Test
    public void testSetNomeMissao() {
        missao.setNomeMissao("Novo Nome");
        assertEquals("Novo Nome", missao.getNomeMissao());
    }

    @Test
    public void testSetStatusMissao() {
        missao.setStatusMissao(StatusMissao.ATIVA);
        assertEquals(StatusMissao.ATIVA, missao.getStatusMissao());
    }

    @Test
    public void testSetPrioridade() {
        missao.setPrioridade(1);
        assertEquals(1, missao.getPrioridade().intValue());
    }

    @Test
    public void testAddTarefa() {
        Tarefa tarefa = new Tarefa(
                "Reparar Painel",
                Especialidade.ENGENHEIRO,
                NivelExperiencia.PLENO,
                false
        );

        missao.addTarefa(tarefa);
        assertEquals(1, missao.getTarefas().size());
    }

    @Test
    public void testAddTarefaDuplicada() {
        //Criamos a tarefa e adicionamos a primeira vez
        Tarefa tarefa = new Tarefa(
                "Reparar Painel",
                Especialidade.ENGENHEIRO,
                NivelExperiencia.PLENO,
                false
        );

        missao.addTarefa(tarefa);

        //A segunda tentativa deve lançar a exceção Existente
        assertThrows(Existente.class, () -> {
            missao.addTarefa(tarefa);
        });
    }

    @Test
    public void testAddMultiplasTarefas() {
        Tarefa t1 = new Tarefa("Tarefa 1", Especialidade.ENGENHEIRO, NivelExperiencia.PLENO, false);
        Tarefa t2 = new Tarefa("Tarefa 2", Especialidade.MEDICO, NivelExperiencia.SENIOR, false);

        missao.addTarefa(t1);
        missao.addTarefa(t2);
        assertEquals(2, missao.getTarefas().size());
    }

    @Test
    public void testToString() {
        String resultado = missao.toString();
        assertNotNull(resultado);
        assertTrue(resultado.contains("Missão Marte"));
        assertTrue(resultado.contains("PENDENTE"));
    }
}