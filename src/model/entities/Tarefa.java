package model.entities;

import model.enums.NivelExperiencia;

import java.util.Random;

public class Tarefa {
    private String nomeTarefa;
    private Random tempoTarefa;
    private NivelExperiencia nivelDaTarefa;
    private Astronauta astronautaResponsavel;
    private Boolean isConcluida;

    public Tarefa(String nomeTarefa, Random tempoTarefa, NivelExperiencia nivelDaTarefa, Boolean isConcluida) {
        this.nomeTarefa = nomeTarefa;
        this.tempoTarefa = tempoTarefa;
        this.nivelDaTarefa = nivelDaTarefa;
        this.isConcluida = isConcluida;
    }

    public String getNomeTarefa() {
        return nomeTarefa;
    }

    public void setNomeTarefa(String nomeTarefa) {
        this.nomeTarefa = nomeTarefa;
    }

    public Random getTempoTarefa() {
        return tempoTarefa;
    }

    public void setTempoTarefa(Random tempoTarefa) {
        this.tempoTarefa = tempoTarefa;
    }

    public NivelExperiencia getNivelDaTarefa() {
        return nivelDaTarefa;
    }

    public void setNivelDaTarefa(NivelExperiencia nivelDaTarefa) {
        this.nivelDaTarefa = nivelDaTarefa;
    }

    public Astronauta getAstronautaResponsavel() {
        return astronautaResponsavel;
    }

    public void setAstronautaResponsavel(Astronauta astronautaResponsavel) {
        this.astronautaResponsavel = astronautaResponsavel;
    }

    public Boolean getConcluida() {
        return isConcluida;
    }

    public void setConcluida(Boolean concluida) {
        isConcluida = concluida;
    }
}
