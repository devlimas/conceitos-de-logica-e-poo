package model.entities;

import model.enums.StatusMissao;

import java.util.ArrayList;
import java.util.List;

public class Missao {
    private String nomeMissao;
    private StatusMissao statusMissao;
    private Integer prioridade;
    private Relatorio relatorioMissao;

    private List<Tarefa> tarefas = new ArrayList<>();

    public Missao(String nomeMissao, StatusMissao statusMissao, Integer prioridade, Relatorio relatorioMissao) {
        this.nomeMissao = nomeMissao;
        this.statusMissao = statusMissao;
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
