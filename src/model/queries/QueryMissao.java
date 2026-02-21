package model.queries;

import model.entities.Missao;
import model.entities.Tarefa;

import java.util.List;

public class QueryMissao {

    public QueryMissao() {
    }

    public List<Tarefa> TodasTarefasDaMissao(Missao missao) {
        return missao.getTarefas();
    }

    public Tarefa BuscarTarefaPorNome(Missao missao, String nomeTarefa) {
        for (Tarefa leitor : missao.getTarefas()) {
            if (leitor.getNomeTarefa().equals(nomeTarefa)){
                return leitor;
            }
        }

        return null;
    }
}
