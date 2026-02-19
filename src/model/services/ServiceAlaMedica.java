package model.services;

import model.entities.Astronauta;
import model.entities.Nave;
import model.enums.StatusSaude;

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
