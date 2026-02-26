package com.poo.services;

import com.poo.entities.Tarefa;
import com.poo.enums.StatusSaude;

public class ServiceTarefa {

    public ServiceTarefa() {
    }

    public Boolean executarTarefa(Tarefa tarefa){
        int fadiga = 0;

        if (tarefa.getTempoTarefa() <= 20){
            fadiga = 20;
            tarefa.getAstronautaResponsavel().setFadiga(tarefa.getAstronautaResponsavel().getFadiga() + fadiga);
        } else if (tarefa.getTempoTarefa() > 20 && tarefa.getTempoTarefa() <= 40) {
            fadiga = 40;
            tarefa.getAstronautaResponsavel().setFadiga(tarefa.getAstronautaResponsavel().getFadiga() + fadiga);
        } else {
            fadiga = 60;
            tarefa.getAstronautaResponsavel().setFadiga(tarefa.getAstronautaResponsavel().getFadiga() + fadiga);
        }

        //Fadiga após a tarefa
        if (tarefa.getAstronautaResponsavel().getFadiga() <= 45){
            tarefa.getAstronautaResponsavel().setStatusSaude(StatusSaude.SAUDAVEL);
        } else if (tarefa.getAstronautaResponsavel().getFadiga() > 45 && fadiga <= 100) {
            tarefa.getAstronautaResponsavel().setStatusSaude(StatusSaude.CANSADO);
        } else if (tarefa.getAstronautaResponsavel().getFadiga() > 100) {
            tarefa.getAstronautaResponsavel().setStatusSaude(StatusSaude.FERIDO);
        }

        if (tarefa.getAstronautaResponsavel().getFadiga() > 100){
            return tarefa.setConcluida(false);
        }
        return tarefa.setConcluida(true);
    }

}
