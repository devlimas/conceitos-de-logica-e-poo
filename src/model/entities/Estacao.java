package model.entities;

import java.util.ArrayList;
import java.util.List;

public class Estacao {
    private String nomeEstacao;
    private Integer maxTripulantes;
    private Relatorio relatorioEstacao;

    private List<Astronauta> astronautas = new ArrayList<>();
    private List<Missoes> missoes = new ArrayList<>();
}
