package com.poo.entities;

import com.poo.enums.Especialidade;
import com.poo.enums.NivelExperiencia;
import com.poo.enums.StatusMissao;
import com.poo.enums.StatusNave;
import com.poo.enums.TamanhoNave;
import com.poo.exceptions.Existente;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class EstacaoTest {

    private Estacao estacao;
    private Astronauta astronauta1;
    private Astronauta astronauta2;
    private Nave nave;
    private Missao missao;

    @BeforeEach
    public void setUp() {
        estacao = new Estacao("Estação Orbital Alpha");

        astronauta1 = new Astronauta(
                "Carlos",
                LocalDate.of(1990, 5, 10),
                1,
                Especialidade.ENGENHEIRO,
                NivelExperiencia.PLENO,
                10
        );

        astronauta2 = new Astronauta(
                "Maria",
                LocalDate.of(1988, 3, 15),
                2,
                Especialidade.MEDICO,
                NivelExperiencia.SENIOR,
                20
        );

        nave = new Nave(estacao, "Apollo-11", TamanhoNave.M, StatusNave.DISPONIVEL);
        missao = new Missao("Missão Marte", StatusMissao.PENDENTE, 2);
    }

    @Test
    public void testCriarEstacaoComSucesso() {
        assertNotNull(estacao);
        assertEquals("Estação Orbital Alpha", estacao.getNomeDaEstacao());
    }

    @Test
    public void testAddAstronautas() {
        estacao.addAstronautas(astronauta1);
        assertEquals(1, estacao.getAstronautas().size());
    }

    @Test
    public void testAddAstronautasComIdDuplicada() {
        //Preparação do cenário
        estacao.addAstronautas(astronauta1);

        Astronauta astronautaDuplicado = new Astronauta(
                "João",
                LocalDate.of(1992, 7, 20),
                1, // ID duplicado propositalmente
                Especialidade.PILOTO,
                NivelExperiencia.JUNIOR,
                15
        );

        //Ação que deve disparar uma exceção
        assertThrows(Existente.class, () -> {
            estacao.addAstronautas(astronautaDuplicado);
        });
    }

    @Test
    public void testAddMultiplosAstronautas() {
        estacao.addAstronautas(astronauta1);
        estacao.addAstronautas(astronauta2);
        assertEquals(2, estacao.getAstronautas().size());
    }

    @Test
    public void testRemoveAstronauta() {
        estacao.addAstronautas(astronauta1);
        String resultado = estacao.AstronautasRemove(astronauta1);
        assertEquals(0, estacao.getAstronautas().size());
        assertNotNull(resultado);
    }

    @Test
    public void testAddMissoes() {
        estacao.addMissao(missao);
        assertEquals(1, estacao.getMissoes().size());
    }

    @Test
    public void testAddMissoesDuplicadas() {
        //A primeira adição deve ocorrer normalmente
        estacao.addMissao(missao);

        //A segunda adição do mesmo objeto deve lançar a exceção
        assertThrows(Existente.class, () -> {
            estacao.addMissao(missao);
        });
    }

    @Test
    public void testAddNaves() {
        estacao.addNaves(nave);
        assertEquals(1, estacao.getNaves().size());
    }

    @Test
    public void testAddNavesDuplicadas() {
        //A primeira inserção deve funcionar normalmente
        estacao.addNaves(nave);

        //A segunda inserção da mesma nave deve disparar a exceção
        assertThrows(Existente.class, () -> {
            estacao.addNaves(nave);
        });
    }

    @Test
    public void testSetNomeDaEstacao() {
        estacao.setNomeDaEstacao("Estação Beta");
        assertEquals("Estação Beta", estacao.getNomeDaEstacao());
    }

    @Test
    public void testToString() {
        String resultado = estacao.toString();
        assertNotNull(resultado);
        assertTrue(resultado.contains("Estação Orbital Alpha"));
    }
}