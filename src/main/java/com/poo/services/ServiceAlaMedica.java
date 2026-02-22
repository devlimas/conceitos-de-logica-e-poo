package com.poo.services;

import com.poo.entities.Astronauta;
import com.poo.entities.Nave;
import com.poo.enums.StatusSaude;

public class ServiceAlaMedica {

    private Nave nave;

    public String recuperação(Astronauta tripulante){
        tripulante.setFadiga(0);
        tripulante.setStatusSaude(StatusSaude.SAUDAVEL);

        return "Tripulante:" + tripulante.getNome() + "\n" +
                "Saúde:" + tripulante.getStatusSaude() + "\n" +
                "Fadiga:" + tripulante.getFadiga();
    }
}
