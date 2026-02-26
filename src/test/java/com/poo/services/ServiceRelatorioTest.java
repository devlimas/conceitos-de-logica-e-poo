package com.poo.services;

import com.poo.entities.Astronauta;
import com.poo.entities.Estacao;
import com.poo.entities.Missao;
import com.poo.entities.Nave;
import com.poo.entities.Tarefa;
import com.poo.enums.Especialidade;
import com.poo.enums.NivelExperiencia;
import com.poo.enums.StatusMissao;
import com.poo.enums.StatusNave;
import com.poo.enums.TamanhoNave;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ServiceRelatorioTest{

    private ServiceRelatorio relatorio;
    private Astronauta astronauta;
    private Estacao estacao;
    private Missao missao;
    private Nave nave;

    @BeforeEach
    public void setUp() {
        relatorio = new ServiceRelatorio();

        estacao = new Estacao("Estação Alpha");

        astronauta = new Astronauta(
                "Carlos",
                LocalDate.of(1990, 5, 10),
                1,
                Especialidade.ENGENHEIRO,
                NivelExperiencia.PLENO,
                10
        );

        estacao.addAstronautas(astronauta);

        nave = new Nave(estacao, "Apollo-11", TamanhoNave.M, StatusNave.DISPONIVEL);
        estacao.addNaves(nave);

        missao = new Missao("Missão Marte", StatusMissao.PENDENTE, 2);
        estacao.addMissao(missao);
    }

    @Test
    public void testTaxaDeSucessoDoAstronautaSemTarefas() {
        double taxa = relatorio.taxaDeSucessoDoAstronauta(astronauta);
        assertEquals(0.0, taxa, 0.01);
    }

    @Test
    public void testTaxaDeSucessoDoAstronautaComTarefas() {
        Tarefa t1 = new Tarefa("Tarefa 1", Especialidade.ENGENHEIRO, NivelExperiencia.PLENO, false);
        Tarefa t2 = new Tarefa("Tarefa 2", Especialidade.ENGENHEIRO, NivelExperiencia.PLENO, false);

        t1.setAstronautaResponsavel(astronauta, t1);
        t2.setAstronautaResponsavel(astronauta, t2);

        t1.setConcluida(true);
        t2.setConcluida(false);

        double taxa = relatorio.taxaDeSucessoDoAstronauta(astronauta);
        assertEquals(50.0, taxa, 0.01);
    }

    @Test
    public void testTaxaDeSucessoMissao() {
        Tarefa t1 = new Tarefa("Tarefa 1", Especialidade.ENGENHEIRO, NivelExperiencia.PLENO, false);
        Tarefa t2 = new Tarefa("Tarefa 2", Especialidade.ENGENHEIRO, NivelExperiencia.PLENO, false);

        t1.setAstronautaResponsavel(astronauta, t1);
        t2.setAstronautaResponsavel(astronauta, t2);

        t1.setConcluida(true);
        t2.setConcluida(true);

        missao.addTarefa(t1);
        missao.addTarefa(t2);

        double taxa = relatorio.taxaDeSucessoMissao(missao);
        assertEquals(100.0, taxa, 0.01);
    }
}
