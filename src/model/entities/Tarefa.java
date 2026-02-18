package model.entities;

import model.enums.Especialidade;
import model.enums.NivelExperiencia;
import model.enums.StatusSaude;
import model.exceptions.AstronautaTarefa;

import java.util.Random;

public class Tarefa {

    private static final Random aleatorio = new Random();

    private String nomeTarefa;
    private Astronauta astronautaResponsavel;
    private Especialidade especialidadeNecessaria;
    private Integer tempoTarefa;
    private NivelExperiencia nivelDaTarefa;
    private Boolean isConcluida;

    public Tarefa(String nomeTarefa, Astronauta astronautaResponsavel, Especialidade especialidadeNecessaria, NivelExperiencia nivelDaTarefa, Boolean isConcluida) {
        this.nomeTarefa = nomeTarefa;

        if (astronautaResponsavel.getFadiga() > 65 || astronautaResponsavel.getStatusSaude().equals(StatusSaude.FERIDO)) {
            throw new AstronautaTarefa("Astronauta em recuperação");
        }
        this.astronautaResponsavel = astronautaResponsavel;

        if (!especialidadeNecessaria.equals(astronautaResponsavel.getEspecialidade())){
            throw new AstronautaTarefa("A especialidade deste astronauta é invalida");
        }
        this.especialidadeNecessaria = especialidadeNecessaria;

        if (!nivelDaTarefa.equals(astronautaResponsavel.getNivelExperiencia())){
            throw new AstronautaTarefa("Nivel de experiencia nao suficiente");
        }
        this.nivelDaTarefa = nivelDaTarefa;

        this.tempoTarefa = aleatorio.nextInt(60) + 1;
        this.isConcluida = isConcluida;
    }

    public String getNomeTarefa() {
        return nomeTarefa;
    }

    public void setNomeTarefa(String nomeTarefa) {
        this.nomeTarefa = nomeTarefa;
    }

    public Integer getTempoTarefa() {
        return tempoTarefa;
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

    public Boolean executarTarefa(Tarefa tarefa){
        astronautaResponsavel.AddTarefas(tarefa);
        int fadiga = 0;
        if (getTempoTarefa() <= 20){
            fadiga = 20;
            getAstronautaResponsavel().setFadiga(getAstronautaResponsavel().getFadiga() + fadiga);
        } else if (getTempoTarefa() > 20 && getTempoTarefa() <= 40) {
            fadiga = 40;
            getAstronautaResponsavel().setFadiga(getAstronautaResponsavel().getFadiga() + fadiga);
        } else {
            fadiga = 60;
            getAstronautaResponsavel().setFadiga(getAstronautaResponsavel().getFadiga() + fadiga);
        }

        if (getAstronautaResponsavel().getFadiga() <= 45){
            getAstronautaResponsavel().setStatusSaude(StatusSaude.SAUDAVEL);
        } else if (fadiga > 45 && fadiga <= 100) {
            getAstronautaResponsavel().setStatusSaude(StatusSaude.CANSADO);
        } else if (fadiga > 100) {
            getAstronautaResponsavel().setStatusSaude(StatusSaude.FERIDO);
        }

        System.out.println("Tarefa concluida");
        return this.isConcluida = true;
    }
}
