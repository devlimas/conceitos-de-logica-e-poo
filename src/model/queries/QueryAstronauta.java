package model.queries;

import model.entities.Astronauta;
import model.entities.Tarefa;

public class QueryAstronauta {

    public QueryAstronauta() {}

    public String TodasTarefas(Astronauta astronauta) {
        for (Tarefa leitor: astronauta.getTarefas()){
            System.out.print("Nome da tarefa: " + leitor.getNomeTarefa() + "\n" + "Conclusão: " + leitor.getConcluida() + "\n\n");
        }
        return "Fim da lista";
    }

    public String buscarTarefaPorNome(Astronauta astronauta, String nomeTarefa) {
        for (Tarefa leitor: astronauta.getTarefas()){
            if (leitor.getNomeTarefa().equals(nomeTarefa)){
                return "Tarefa encontrada: " + leitor.getNomeTarefa() + "\n" +
                        "Conclusão: " + leitor.getConcluida() + "\n";
            }
        }
        return "Tarefa não contrada";
    }
}
