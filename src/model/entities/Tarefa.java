package model.entities;

import model.enums.NivelExperiencia;

import java.util.Random;

public class Tarefa {
    private String nomeTarefa;
    private Astronauta astronauta;
    private Random tempoTarefa;
    private NivelExperiencia nivelDaTarefa;
    private Boolean isConcluida;

    public Tarefa(String nomeTarefa, Astronauta astronauta, Random tempoTarefa, NivelExperiencia nivelDaTarefa, Boolean isConcluida) {
        this.nomeTarefa = nomeTarefa;
        this.astronauta = astronauta;
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

    public Astronauta getAstronauta() {
        return astronauta;
    }

    public void setAstronauta(Astronauta astronauta) {
        this.astronauta = astronauta;
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

    public Boolean getConcluida() {
        return isConcluida;
    }

    public void setConcluida(Boolean concluida) {
        isConcluida = concluida;
    }
}
