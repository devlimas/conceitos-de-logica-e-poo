package com.poo.entities;

import com.poo.enums.Especialidade;
import com.poo.enums.NivelExperiencia;
import com.poo.enums.StatusSaude;
import com.poo.exceptions.AstronautaStatus;

import java.util.Random;

public class Tarefa {

    private static final Random aleatorio = new Random();

    private String nomeTarefa;
    private Astronauta astronautaResponsavel;
    private Especialidade especialidadeNecessaria;
    private Integer tempoTarefa;
    private NivelExperiencia nivelDaTarefa;
    private Boolean isConcluida;

    public Tarefa() {
    }

    public Tarefa(String nomeTarefa, Especialidade especialidadeNecessaria, NivelExperiencia nivelDaTarefa, Boolean isConcluida) {
        this.nomeTarefa = nomeTarefa;
        this.especialidadeNecessaria = especialidadeNecessaria;
        this.nivelDaTarefa = nivelDaTarefa;
        this.tempoTarefa = aleatorio.nextInt(60) + 1;
        this.isConcluida = isConcluida;
    }

    public Especialidade getEspecialidadeNecessaria() {
        return especialidadeNecessaria;
    }

    public void setEspecialidadeNecessaria(Especialidade especialidadeNecessaria) {
        this.especialidadeNecessaria = especialidadeNecessaria;
    }

    public void setTempoTarefa(Integer tempoTarefa) {
        this.tempoTarefa = tempoTarefa;
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

    public void setNivelDaTarefa(NivelExperiencia nivelDaTarefa) {this.nivelDaTarefa = nivelDaTarefa;}

    public Astronauta getAstronautaResponsavel() {
        return astronautaResponsavel;
    }

    //Ao atribuir o astronauta a tarefa, dentro do set fazemos a validação
    public void setAstronautaResponsavel(Astronauta astronautaResponsavel, Tarefa tarefa) {
        if (astronautaResponsavel.getFadiga() > 65 || astronautaResponsavel.getStatusSaude().equals(StatusSaude.FERIDO)) {
            throw new AstronautaStatus("Astronauta em recuperação");
        }

        if (!especialidadeNecessaria.equals(astronautaResponsavel.getEspecialidade())){
            throw new AstronautaStatus("A especialidade deste astronauta é invalida");
        }

        if (!astronautaResponsavel.getNivelExperiencia().CargoSuperior(nivelDaTarefa)) {
            throw new AstronautaStatus("Nivel de experiencia nao suficiente");
        }
        this.astronautaResponsavel = astronautaResponsavel;
        astronautaResponsavel.AddTarefas(tarefa);
    }

    public Boolean getConcluida() {
        return isConcluida;
    }

    public Boolean setConcluida(Boolean concluida) {
        isConcluida = concluida;
        return concluida;
    }

    @Override
    public String toString() {
        String nomeAstronauta = (astronautaResponsavel != null)
                ? astronautaResponsavel.getNome()
                : "Nenhum";

        return "\n" + "Nome da tarefa: " + getNomeTarefa() + "\n" +
                "Especialidade necessaria: " + getEspecialidadeNecessaria() + "\n" +
                "Tempo da tarefa: " + getTempoTarefa() + " Minutos\n" +
                "Nivel da tarefa: " + getNivelDaTarefa() + "\n" +
                "Conclusão: " + getConcluida() + "\n" +
                "Astronauta responsável: " + nomeAstronauta + "\n";
    }
}
