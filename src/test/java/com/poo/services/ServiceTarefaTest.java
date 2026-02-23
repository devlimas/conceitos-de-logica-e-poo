package com.poo.services;

import com.poo.entities.Astronauta;
import com.poo.entities.Tarefa;
import com.poo.enums.Especialidade;
import com.poo.enums.NivelExperiencia;

import java.time.LocalDate;

import com.poo.exceptions.AstronautaStatus;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ServiceTarefaTest {

    private ServiceTarefa serviceTarefa;
    private Tarefa tarefa;
    private Astronauta astronauta;

    @BeforeEach
    public void setUp() {
        serviceTarefa = new ServiceTarefa();

        astronauta = new Astronauta(
                "Carlos",
                LocalDate.of(1990, 5, 10),
                1,
                Especialidade.ENGENHEIRO,
                NivelExperiencia.PLENO,
                10
        );

        tarefa = new Tarefa(
                "Reparar Painel",
                Especialidade.ENGENHEIRO,
                NivelExperiencia.PLENO,
                false
        );

        tarefa.setAstronautaResponsavel(astronauta, tarefa);
    }

    @Test
    public void testExecutarTarefa() {
        Boolean resultado = serviceTarefa.executarTarefa(tarefa);
        assertTrue(resultado);
        assertTrue(tarefa.getConcluida());
    }

    @Test
    public void testExecutarTarefaAlteraFadiga() {
        Integer fadigaAntes = astronauta.getFadiga();
        serviceTarefa.executarTarefa(tarefa);
        Integer fadigaDepois = astronauta.getFadiga();

        assertTrue(fadigaDepois > fadigaAntes);
    }

    @Test
    public void testExecutarTarefaAlteraStatusSaude() {
        //Astronauta com pouca fadiga
        Astronauta a = new Astronauta(
                "João",
                LocalDate.of(1992, 1, 1),
                2,
                Especialidade.ENGENHEIRO,
                NivelExperiencia.PLENO,
                5
        );

        Tarefa t = new Tarefa(
                "Tarefa Curta",
                Especialidade.ENGENHEIRO,
                NivelExperiencia.PLENO,
                false
        );

        t.setAstronautaResponsavel(a, t);
        serviceTarefa.executarTarefa(t);

        // Após execução, status deve refletir a fadiga
        assertNotNull(a.getStatusSaude());
    }

    @Test
    public void testExecutarTarefaComAstronautaComFadigaAlta() {
        Astronauta aAlto = new Astronauta(
                "Pedro",
                LocalDate.of(1990, 1, 1),
                3,
                Especialidade.ENGENHEIRO,
                NivelExperiencia.PLENO,
                95 //Fadiga inicial alta
        );

        Tarefa tAlta = new Tarefa(
                "Tarefa Pesada",
                Especialidade.ENGENHEIRO,
                NivelExperiencia.PLENO,
                false
        );

        //O erro estoura já no setAstronautaResponsavel
        assertThrows(AstronautaStatus.class, () -> {
            tAlta.setAstronautaResponsavel(aAlto, tAlta);
        });
    }
}