package com.poo.services;

import com.poo.entities.Astronauta;
import com.poo.entities.Nave;
import com.poo.enums.Disponibilidade;
import com.poo.exceptions.Indisponivel;

public class ServiceConvocacao {

    public ServiceConvocacao() {
    }

    public String Convocar(Nave nave, Astronauta astronauta){
        if (astronauta.getDisponibilidade() != Disponibilidade.DISPONIVEL){
            throw new Indisponivel("O astronauta:" + astronauta.getNome() + "não está disponivel");
        }

        astronauta.setDisponibilidade(Disponibilidade.CONVOCADO);
        nave.addTripulantes(astronauta);
        return "Astronauta convocado para a nave: " + nave.getNomeNave();
    }
}
