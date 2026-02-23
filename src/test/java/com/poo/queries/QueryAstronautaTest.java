package com.poo.queries;

import com.poo.entities.Astronauta;
import com.poo.entities.Tarefa;
import com.poo.enums.Especialidade;
import com.poo.enums.NivelExperiencia;

import java.time.LocalDate;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class QueryAstronautaTest {

    private QueryAstronauta query;
    private Astronauta astronauta;

    @BeforeEach
    public void setUp() {
        query = new QueryAstronauta();

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
    public void testTodasTarefasIndividuaisSemTarefas() {
        List<Tarefa> tarefas = query.TodasTarefasIndividuais(astronauta);
        assertNotNull(tarefas);
        assertEquals(0, tarefas.size());
    }

    @Test
    public void testTodasTarefasIndividuaisComTarefas() {
        Tarefa t1 = new Tarefa("Tarefa 1", Especialidade.ENGENHEIRO, NivelExperiencia.PLENO, false);
        Tarefa t2 = new Tarefa("Tarefa 2", Especialidade.ENGENHEIRO, NivelExperiencia.PLENO, false);

        astronauta.AddTarefas(t1);
        astronauta.AddTarefas(t2);

        List<Tarefa> tarefas = query.TodasTarefasIndividuais(astronauta);
        assertEquals(2, tarefas.size());
    }

    @Test
    public void testBuscarTarefaIndividualExistente() {
        Tarefa tarefa = new Tarefa("Reparar Painel", Especialidade.ENGENHEIRO, NivelExperiencia.PLENO, false);
        astronauta.AddTarefas(tarefa);

        Tarefa resultado = query.BuscarTarefaIndividual(astronauta, "Reparar Painel");
        assertNotNull(resultado);
        assertEquals("Reparar Painel", resultado.getNomeTarefa());
    }

    @Test
    public void testBuscarTarefaIndividualNaoExistente() {
        Tarefa resultado = query.BuscarTarefaIndividual(astronauta, "Tarefa Inexistente");
        assertNull(resultado);
    }
}