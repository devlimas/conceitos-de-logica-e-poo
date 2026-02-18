package model.entities;

import model.enums.StatusMissao;

import java.util.ArrayList;
import java.util.List;

public class Missao {
    private String nomeMissao;
    private StatusMissao statusMissao;
    private Integer prioridade;
    private Relatorio relatorioMissao;

    public Missao() {
    }

    private List<Tarefa> tarefas = new ArrayList<>();

    public Missao(String nomeMissao, StatusMissao statusMissao, Integer prioridade, Relatorio relatorioMissao) {
        this.nomeMissao = nomeMissao;
        this.statusMissao = statusMissao;

        // Fiz a escolha de fazer a prioridade com int, em vez de enum apenas para mostrar outra maneira de ser feita, por mais que não seja recomendado já que enum brilha aqui
        if(prioridade > 3){
            throw new IllegalArgumentException("O nivel de prioridade é definido de 1 a 3");
        }

        this.prioridade = prioridade;
        this.relatorioMissao = relatorioMissao;
    }

    public String getNomeMissao() {
        return nomeMissao;
    }

    public void setNomeMissao(String nomeMissao) {
        this.nomeMissao = nomeMissao;
    }

    public StatusMissao getStatusMissao() {
        return statusMissao;
    }

    public void setStatusMissao(StatusMissao statusMissao) {
        this.statusMissao = statusMissao;
    }

    public Integer getPrioridade() {
        return prioridade;
    }

    public void setPrioridade(Integer prioridade) {
        this.prioridade = prioridade;
    }

    public Relatorio getRelatorioMissao() {
        return relatorioMissao;
    }

    public void setRelatorioMissao(Relatorio relatorioMissao) {
        this.relatorioMissao = relatorioMissao;
    }

    public void addTarefa(Tarefa tarefa){
        tarefas.add(tarefa);
    }

    public List<Tarefa> getTarefas() {
        return tarefas;
    }
}
