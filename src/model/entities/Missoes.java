package model.entities;

import model.enums.StatusMissao;

import java.util.ArrayList;
import java.util.List;

public class Missoes {
    private String nomeMissao;
    private StatusMissao statusMissao;
    private Integer prioridade;

    private Estacao tripulacao;
    private List<Tarefa> tarefas = new ArrayList<>();

    public Missoes(String nomeMissao, StatusMissao statusMissao, Integer prioridade, Estacao tripulacao) {
        this.nomeMissao = nomeMissao;
        this.statusMissao = statusMissao;
        this.prioridade = prioridade;
        this.tripulacao = tripulacao;
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

    public Estacao getTripulacao() {
        return tripulacao;
    }

    public void setTripulacao(Estacao tripulacao) {
        this.tripulacao = tripulacao;
    }

    public void addTarefa(Tarefa tarefa){
        tarefas.add(tarefa);
    }
}
