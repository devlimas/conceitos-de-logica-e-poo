package model.queries;

import model.entities.Astronauta;
import model.entities.Tarefa;

import java.util.List;

public class QueryAstronauta {

    public QueryAstronauta() {}

    public List<Tarefa> TodasTarefasIndividuais(Astronauta astronauta) {
        return astronauta.getTarefas();
    }

    public Tarefa BuscarTarefaIndividual(Astronauta astronauta, String nomeTarefa) {
        for (Tarefa leitor : astronauta.getTarefas()) {
            if (leitor.getNomeTarefa().equals(nomeTarefa)){
                return leitor;
            }
        }

        return null;
    }
}
