package com.poo.queries;

import com.poo.entities.Astronauta;
import com.poo.entities.Nave;

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
