package com.poo.queries;

import com.poo.entities.Astronauta;
import com.poo.entities.Tarefa;

import java.util.List;

public class QueryAstronauta {

    public QueryAstronauta() {}

    public List<Tarefa> TodasTarefasIndividuais(Astronauta astronauta) {
        return astronauta.getTarefas();
    }

    public Tarefa BuscarTarefaIndividual(Astronauta astronauta, String nomeTarefa) {
        return astronauta.getTarefas().stream()
                .filter(t -> t.getNomeTarefa().equals(nomeTarefa))
                .findFirst()
                .orElse(null);
    }
}
