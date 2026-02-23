package com.poo.entities;

import com.poo.enums.Disponibilidade;
import com.poo.enums.Especialidade;
import com.poo.enums.NivelExperiencia;
import com.poo.enums.StatusSaude;
import com.poo.exceptions.Existente;
import com.poo.exceptions.IdadeMinima;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

public class AstronautaTest {

    private Astronauta astronauta;

    @BeforeEach
    public void setUp() {
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
    public void testCriarAstronautaComSucesso() {
        assertNotNull(astronauta);
        assertEquals("Carlos", astronauta.getNome());
        assertEquals(1, astronauta.getId().intValue());
        assertEquals(Especialidade.ENGENHEIRO, astronauta.getEspecialidade());
        assertEquals(NivelExperiencia.PLENO, astronauta.getNivelExperiencia());
    }

    @Test
    public void testAstronautaMenorDeIdadeDeveLancarExcecao() {
        assertThrows(IdadeMinima.class, () -> {
            new Astronauta(
                    "Jovem",
                    LocalDate.of(2020, 1, 1),
                    2,
                    Especialidade.PILOTO,
                    NivelExperiencia.JUNIOR,
                    10
            );
        });
    }

    @Test
    public void testStatusSaudeComFadigaBaixa() {
        //Fadiga <= 45
        assertEquals(StatusSaude.SAUDAVEL, astronauta.getStatusSaude());
    }

    @Test
    public void testStatusSaudeComFadigaMedia() {
        Astronauta a = new Astronauta(
                "Maria",
                LocalDate.of(1988, 7, 22),
                4,
                Especialidade.MEDICO,
                NivelExperiencia.SENIOR,
                70 //45 < Fadiga <= 100
        );
        assertEquals(StatusSaude.CANSADO, a.getStatusSaude());
    }

    @Test
    public void testStatusSaudeComFadigaAlta() {
        Astronauta a = new Astronauta(
                "Pedro",
                LocalDate.of(1985, 11, 8),
                5,
                Especialidade.ENGENHEIRO,
                NivelExperiencia.SENIOR,
                110 //Fadiga > 100
        );
        assertEquals(StatusSaude.FERIDO, a.getStatusSaude());
    }

    @Test
    public void testDisponibilidadeInicial() {
        assertEquals(Disponibilidade.DISPONIVEL, astronauta.getDisponibilidade());
    }

    @Test
    public void testSetDisponibilidade() {
        astronauta.setDisponibilidade(Disponibilidade.CONVOCADO);
        assertEquals(Disponibilidade.CONVOCADO, astronauta.getDisponibilidade());
    }

    @Test
    public void testSetFadiga() {
        astronauta.setFadiga(50);
        assertEquals(50, astronauta.getFadiga().intValue());
    }

    @Test
    public void testSetStatusSaude() {
        astronauta.setStatusSaude(StatusSaude.FERIDO);
        assertEquals(StatusSaude.FERIDO, astronauta.getStatusSaude());
    }

    @Test
    public void testSetEspecialidade() {
        astronauta.setEspecialidade(Especialidade.MEDICO);
        assertEquals(Especialidade.MEDICO, astronauta.getEspecialidade());
    }

    @Test
    public void testSetNivelExperiencia() {
        astronauta.setNivelExperiencia(NivelExperiencia.SENIOR);
        assertEquals(NivelExperiencia.SENIOR, astronauta.getNivelExperiencia());
    }

    @Test
    public void testAddTarefas() {
        Tarefa tarefa = new Tarefa(
                "Tarefa 1",
                Especialidade.ENGENHEIRO,
                NivelExperiencia.PLENO,
                false
        );

        astronauta.AddTarefas(tarefa);
        assertEquals(1, astronauta.getTarefas().size());
    }

    @Test
    public void testAddTarefasDuplicadas() {
        Tarefa tarefa = new Tarefa(
                "Tarefa Duplicada",
                Especialidade.ENGENHEIRO,
                NivelExperiencia.PLENO,
                false
        );

        astronauta.AddTarefas(tarefa);

        assertThrows(Existente.class, () -> {
            astronauta.AddTarefas(tarefa);
        });
    }

    @Test
    public void testAddMultiplasTarefas() {
        Tarefa t1 = new Tarefa("Tarefa 1", Especialidade.ENGENHEIRO, NivelExperiencia.PLENO, false);
        Tarefa t2 = new Tarefa("Tarefa 2", Especialidade.MEDICO, NivelExperiencia.SENIOR, false);

        astronauta.AddTarefas(t1);
        astronauta.AddTarefas(t2);
        assertEquals(2, astronauta.getTarefas().size());
    }

    @Test
    public void testToString() {
        String resultado = astronauta.toString();
        assertNotNull(resultado);
        assertTrue(resultado.contains("Carlos"));
        assertTrue(resultado.contains("ENGENHEIRO"));
    }
}