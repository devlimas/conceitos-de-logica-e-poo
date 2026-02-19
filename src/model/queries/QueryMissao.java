package model.queries;

import model.entities.Missao;
import model.entities.Tarefa;

public class QueryMissao {

    public QueryMissao() {
    }

    public String BuscarTarefas(Missao missao) {
        for (Tarefa leitor: missao.getTarefas()){
            System.out.println(
                "Nome da tarefa: " + leitor.getNomeTarefa() + "\n" +
                "Conclusão: " + leitor.getConcluida() + "\n"
            );
        }
        return "Fim da lista de tarefas da missão";
    }

    public String BuscarTarefaPorNome(Missao missao ,String nomeTarefa) {
        for (Tarefa leitor: missao.getTarefas()){
            if (leitor.getNomeTarefa().equals(nomeTarefa)){
                return "Nome da tarefa: " + leitor.getNomeTarefa() + "\n" +
                        "Conclusão: " + leitor.getConcluida() + "\n";
            }
        }
        return "Tarefa não encontrada";
    }
}
