package model.entities;

import java.time.LocalTime;

public class Tarefa {
    private String descricaoDaTarefa;
    private LocalTime tempoEstimativo;
    private Astronauta responsavel;
    private boolean concluida;

    public Tarefa(String descricaoDaTarefa, LocalTime tempoEstimativo, Astronauta responsavel, boolean concluida) {
        this.descricaoDaTarefa = descricaoDaTarefa;
        this.tempoEstimativo = tempoEstimativo;
        this.responsavel = responsavel;
        this.concluida = concluida;
    }

    public String getDescricaoDaTarefa() {
        return descricaoDaTarefa;
    }

    public void setDescricaoDaTarefa(String descricaoDaTarefa) {
        this.descricaoDaTarefa = descricaoDaTarefa;
    }

    public LocalTime getTempoEstimativo() {
        return tempoEstimativo;
    }

    public void setTempoEstimativo(LocalTime tempoEstimativo) {
        this.tempoEstimativo = tempoEstimativo;
    }

    public Astronauta getResponsavel() {
        return responsavel;
    }

    public void setResponsavel(Astronauta responsavel) {
        this.responsavel = responsavel;
    }

    public boolean isConcluida() {
        return concluida;
    }

    public void setConcluida(boolean concluida) {
        this.concluida = concluida;
    }

    @Override
    public String toString() {
        StringBuilder msg = new StringBuilder();
        msg.append("Descrição da tarefa:" + descricaoDaTarefa + "\n");
        msg.append("Tempo da tarefa:" + tempoEstimativo + " Minutos\n");
        msg.append("Responsavel:" + responsavel.getNome() + "\n");
        msg.append("Concluida:" + concluida + "\n");
        return msg.toString();
    }
}
