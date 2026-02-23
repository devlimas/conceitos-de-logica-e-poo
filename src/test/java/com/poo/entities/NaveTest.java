package com.poo.entities;

import com.poo.enums.*;
import com.poo.exceptions.Indisponivel;
import com.poo.exceptions.LimiteTripulantes;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

public class NaveTest {

    private Nave nave;
    private Estacao estacao;
    private Astronauta astronauta1;
    private Astronauta astronauta2;

    @BeforeEach
    public void setUp() {
        estacao = new Estacao("Estação Orbital Alpha");

        nave = new Nave(
                estacao,
                "Apollo-11",
                TamanhoNave.M, //Máximo 6 tripulantes
                StatusNave.DISPONIVEL
        );

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

        estacao.addAstronautas(astronauta1);
        estacao.addAstronautas(astronauta2);
    }

    @Test
    public void testCriarNaveComSucesso() {
        assertNotNull(nave);
        assertEquals("Apollo-11", nave.getNomeNave());
        assertEquals(TamanhoNave.M, nave.getTamanhoNave());
        assertEquals(StatusNave.DISPONIVEL, nave.getStatusNave());
    }

    @Test
    public void testAddTripulante() {
        nave.addTripulantes(astronauta1);
        assertEquals(1, nave.getTripulantes().size());
    }

    @Test
    public void testAddTripulanteAcimaDeLimite() {
        //Definimos a exceção esperada e o código que deve dispará-la
        assertThrows(LimiteTripulantes.class, () -> {
            //Nave M tem limite de 6
            for (int i = 0; i < 7; i++) {
                Astronauta a = new Astronauta(
                        "Tripulante " + i,
                        LocalDate.of(1990, 1, 1),
                        100 + i,
                        Especialidade.ENGENHEIRO,
                        NivelExperiencia.JUNIOR,
                        10
                );
                estacao.addAstronautas(a);
                nave.addTripulantes(a);
            }
        });
    }

    @Test
    public void testSetMissao() {
        Missao missao = new Missao("Missão Marte", StatusMissao.PENDENTE, 2);
        nave.setMissao(missao);

        assertEquals(missao, nave.getMissao());
        assertEquals(StatusMissao.ATIVA, missao.getStatusMissao());
        assertEquals(StatusNave.OCUPADA, nave.getStatusNave());
    }

    @Test
    public void testSetMissaoEmNaveComMissaoExistente() {
        Missao m1 = new Missao("Missão 1", StatusMissao.PENDENTE, 1);
        Missao m2 = new Missao("Missão 2", StatusMissao.PENDENTE, 2);

        nave.setMissao(m1);

        //O assertThrows deve envolver apenas a linha que deve falhar
        assertThrows(Indisponivel.class, () -> {
            nave.setMissao(m2); //lança uma exceção
        });
    }

    @Test
    public void testSetMissaoEmNaveAvariada() {
        Nave naveAvariada = new Nave(
                estacao,
                "Apollo-X",
                TamanhoNave.P,
                StatusNave.AVARIADA
        );
        Missao missao = new Missao("Missão", StatusMissao.PENDENTE, 1);

        assertThrows(Indisponivel.class, () -> {
            naveAvariada.setMissao(missao); // Deve lançar exceção
        });
    }

    @Test
    public void testSetNomeNave() {
        nave.setNomeNave("Apollo-X");
        assertEquals("Apollo-X", nave.getNomeNave());
    }

    @Test
    public void testSetStatusNave() {
        nave.setStatusNave(StatusNave.AVARIADA);
        assertEquals(StatusNave.AVARIADA, nave.getStatusNave());
    }

    @Test
    public void testGetEstacao() {
        assertEquals(estacao, nave.getEstacao());
    }
}