package model.entities;

import model.enums.StatusDaMissao;
import model.exceptions.AstronautaNaoAptoException;

import java.util.ArrayList;
import java.util.List;

public class Missao {
    private String nomeDaMissao;
    private String objetivoDaMissao;
    private StatusDaMissao statusDaMissao;
    private int prioridade;
    private String funcao;

    private List<Astronauta> tripulacao = new ArrayList<>();
    private List<Tarefa> tarefasDaMissao = new ArrayList<>();

    public Missao(String nomeDaMissao, String objetivoDaMissao, StatusDaMissao statusDaMissao, int prioridade, String funcao) {
        this.nomeDaMissao = nomeDaMissao;
        this.objetivoDaMissao = objetivoDaMissao;
        this.statusDaMissao = statusDaMissao;
        this.prioridade = prioridade;
        this.funcao = funcao;
    }

    public String getNomeDaMissao() {
        return nomeDaMissao;
    }

    public void setNomeDaMissao(String nomeDaMissao) {
        this.nomeDaMissao = nomeDaMissao;
    }

    public String getObjetivoDaMissao() {
        return objetivoDaMissao;
    }

    public void setObjetivoDaMissao(String objetivoDaMissao) {
        this.objetivoDaMissao = objetivoDaMissao;
    }

    public StatusDaMissao getStatusDaMissao() {
        return statusDaMissao;
    }

    public void setStatusDaMissao(StatusDaMissao statusDaMissao) {
        this.statusDaMissao = statusDaMissao;
    }

    public int getPrioridade() {
        return prioridade;
    }

    public void setPrioridade(int prioridade) {
        this.prioridade = prioridade;
    }

    public String getFuncao() {
        return funcao;
    }

    public void setFuncao(String funcao) {
        this.funcao = funcao;
    }

    public List<Astronauta> getTripulacao() {
        return tripulacao;
    }

    //Função para a verificar se o funcionario tem a especialidade pedida na missao
    public void recrutarAstronauta(Astronauta funcionario) throws AstronautaNaoAptoException {
        if (!funcionario.getEspecialidade().equalsIgnoreCase(funcao)){
            throw new AstronautaNaoAptoException("O Astronauta não tem especialidade para concluir esta missão");
        }
        else {
            tripulacao.add(funcionario);
        }
    }

    public List<Tarefa> getTarefasDaMissao() {
        return tarefasDaMissao;
    }

    public void addTarefasDaMissao(Tarefa tarefas) {
        tarefasDaMissao.add(tarefas);
    }

    @Override
    public String toString() {
        StringBuilder msg = new StringBuilder();
        msg.append("Missão:" + nomeDaMissao + "\n");
        msg.append("Objetivo:" + objetivoDaMissao + "\n");
        msg.append("Status da missão:" + statusDaMissao + "\n");
        msg.append("Prioridade:" + prioridade + "\n");
        msg.append("Função requisitada:" + funcao + "\n");
        return msg.toString();
    }
}
