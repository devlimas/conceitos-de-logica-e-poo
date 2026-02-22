package com.poo.entities;

import com.poo.enums.StatusMissao;
import com.poo.exceptions.Existente;
import com.poo.exceptions.Prioridade;

import java.util.ArrayList;
import java.util.List;

public class Missao {
    private String nomeMissao;
    private StatusMissao statusMissao;
    private Integer prioridade;

    public Missao() {
    }

    private List<Tarefa> tarefas = new ArrayList<>();

    public Missao(String nomeMissao, StatusMissao statusMissao, Integer prioridade) {
        this.nomeMissao = nomeMissao;
        this.statusMissao = statusMissao;

        // Fiz a escolha de fazer a prioridade com int, em vez de enum apenas para mostrar outra maneira de ser feita, por mais que não seja recomendado já que enum brilha aqui
        if(prioridade > 3){
            throw new Prioridade("O nivel de prioridade é de 1 a 3");
        }

        this.prioridade = prioridade;
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

    public void setTarefas(List<Tarefa> tarefas) {
        this.tarefas = tarefas;
    }

    public List<Tarefa> getTarefas() {
        return tarefas;
    }

    public void addTarefa(Tarefa tarefa){
        for(Tarefa leitor: tarefas){
            if (leitor.getNomeTarefa().equals(tarefa.getNomeTarefa())){
                throw new Existente("Tarefa já existente dentro da lista da missão");
            }
        }
        tarefas.add(tarefa);
    }

    @Override
    public String toString() {
        return "Missao:" + "\n" +
                "Nome da Missao: " + nomeMissao + "\n" +
                "Status da Missao: " + statusMissao + "\n" +
                "Prioridade: " + prioridade +  "\n\n";
    }
}
