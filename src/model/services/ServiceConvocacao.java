package model.services;

import model.entities.Astronauta;
import model.entities.Estacao;
import model.entities.Nave;
import model.enums.Disponibilidade;
import model.exceptions.Indisponivel;

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
