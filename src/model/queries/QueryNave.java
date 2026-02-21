package model.queries;

import model.entities.Astronauta;
import model.entities.Nave;

import java.util.List;

public class QueryNave {

    public QueryNave() {
    }

    public List<Astronauta> TodaTripulacao(Nave nave) {
        return nave.getTripulantes();
    }

    public Astronauta TripulantePorId(Nave nave, int id) {

        for (Astronauta leitor : nave.getTripulantes()) {
            if (leitor.getId() == id) {
                return leitor;
            }
        }
        return null;
    }
}
