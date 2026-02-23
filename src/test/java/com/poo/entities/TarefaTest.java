package com.poo.entities;

import com.poo.enums.Especialidade;
import com.poo.enums.NivelExperiencia;
import com.poo.exceptions.AstronautaStatus;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

public class TarefaTest {

    private Tarefa tarefa;
    private Astronauta astronauta;

    @BeforeEach
    public void setUp() {
        tarefa = new Tarefa(
                "Reparar Painel Solar",
                Especialidade.ENGENHEIRO,
                NivelExperiencia.PLENO,
                false
        );

        astronauta = new Astronauta(
                "Carlos",
                LocalDate.of(1990, 5, 10),
                1,
                Especialidade.ENGENHEIRO,
                NivelExperiencia.PLENO,
                10
        );
    }

    @Test
    public void testCriarTarefaComSucesso() {
        assertNotNull(tarefa);
        assertEquals("Reparar Painel Solar", tarefa.getNomeTarefa());
        assertEquals(Especialidade.ENGENHEIRO, tarefa.getEspecialidadeNecessaria());
        assertEquals(NivelExperiencia.PLENO, tarefa.getNivelDaTarefa());
        assertFalse(tarefa.getConcluida());
    }

    @Test
    public void testSetAstronautaResponsavelComSucesso() {
        tarefa.setAstronautaResponsavel(astronauta, tarefa);
        assertEquals(astronauta, tarefa.getAstronautaResponsavel());
    }

    @Test
    public void testSetAstronautaComFadigaAlta() {
        //O astronauta é criado com fadiga 110
        Astronauta astronautaCansado = new Astronauta(
                "João",
                LocalDate.of(1992, 1, 1),
                2,
                Especialidade.ENGENHEIRO,
                NivelExperiencia.PLENO,
                110
        );

        assertThrows(AstronautaStatus.class, () -> {
            tarefa.setAstronautaResponsavel(astronautaCansado, tarefa);
        });
    }

    @Test
    public void testSetAstronautaComEspecialidadeInvalida() {
        //Astronauta é MÉDICO
        Astronauta astronautaMedico = new Astronauta(
                "Maria",
                LocalDate.of(1988, 1, 1),
                3,
                Especialidade.MEDICO,
                NivelExperiencia.PLENO,
                20
        );

        //A tarefa provavelmente exige outra especialidade (ex: ENGENHEIRO)
        assertThrows(AstronautaStatus.class, () -> {
            tarefa.setAstronautaResponsavel(astronautaMedico, tarefa);
        });
    }

    @Test
    public void testSetAstronautaComNivelBaixo() {
        //Astronauta é criado como JUNIOR
        Astronauta astronautaJunior = new Astronauta(
                "Pedro",
                LocalDate.of(1995, 1, 1),
                4,
                Especialidade.ENGENHEIRO,
                NivelExperiencia.JUNIOR,
                20
        );

        //A tarefa deve barrar o nível insuficiente
        assertThrows(AstronautaStatus.class, () -> {
            tarefa.setAstronautaResponsavel(astronautaJunior, tarefa);
        });
    }

    @Test
    public void testSetConcluida() {
        Boolean resultado = tarefa.setConcluida(true);
        assertTrue(tarefa.getConcluida());
        assertTrue(resultado);
    }

    @Test
    public void testSetNomeTarefa() {
        tarefa.setNomeTarefa("Nova Tarefa");
        assertEquals("Nova Tarefa", tarefa.getNomeTarefa());
    }

    @Test
    public void testGetTempoTarefa() {
        Integer tempo = tarefa.getTempoTarefa();
        assertNotNull(tempo);
        assertTrue(tempo >= 1 && tempo <= 60); //Tempo aleatório de 1 a 60
    }

    @Test
    public void testToString() {
        tarefa.setAstronautaResponsavel(astronauta, tarefa);
        String resultado = tarefa.toString();
        assertNotNull(resultado);
        assertTrue(resultado.contains("Reparar Painel Solar"));
        assertTrue(resultado.contains("Carlos"));
    }
}