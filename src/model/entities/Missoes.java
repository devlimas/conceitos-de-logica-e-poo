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
}
