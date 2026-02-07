package model.entities;

import java.util.ArrayList;
import java.util.List;

public class Estacao {
    private String nomeEstacao;
    private Integer maxTripulantes;
    private Relatorio relatorioEstacao;

    private List<Astronauta> astronautas = new ArrayList<>();
    private List<Missoes> missoes = new ArrayList<>();

    public Estacao(String nomeEstacao, Integer maxTripulantes, Relatorio relatorioEstacao) {
        this.nomeEstacao = nomeEstacao;
        this.maxTripulantes = maxTripulantes;
        this.relatorioEstacao = relatorioEstacao;
    }

    public String getNomeEstacao() {
        return nomeEstacao;
    }

    public void setNomeEstacao(String nomeEstacao) {
        this.nomeEstacao = nomeEstacao;
    }

    public Integer getMaxTripulantes() {
        return maxTripulantes;
    }

    public void setMaxTripulantes(Integer maxTripulantes) {
        this.maxTripulantes = maxTripulantes;
    }

    public Relatorio getRelatorioEstacao() {
        return relatorioEstacao;
    }

    public void setRelatorioEstacao(Relatorio relatorioEstacao) {
        this.relatorioEstacao = relatorioEstacao;
    }

    public void addAstronauta(Astronauta astronauta){
        astronautas.add(astronauta);
    }

    public void addMissao(Missoes missao){
        missoes.add(missao);
    }
}
