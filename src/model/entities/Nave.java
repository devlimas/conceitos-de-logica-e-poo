package model.entities;

import model.enums.TamanhoNave;

import java.util.ArrayList;
import java.util.List;

public class Nave {

    //A estacao de origem dessa nave e onde vamos pegar os astronautas disponiveis, com um metodo vamos adicionar os tripulantes e remover dos astronautas disponiveis desta estacao
    private Estacao estacao;
    private String nomeNave;
    private TamanhoNave tamanhoNave;

    //Uma missao por nave
    private Missao missao;

    //Um relatorio geral sobre o desempenho geral da equipe
    private Relatorio relatorioEquipe;

    private List<Astronauta> tripulantes = new ArrayList<>();

    public Nave(Estacao estacao, String nomeNave, TamanhoNave tamanhoNave, Missao missao, Relatorio relatorioEquipe) {
        this.estacao = estacao;
        this.nomeNave = nomeNave;
        this.tamanhoNave = tamanhoNave;
        this.missao = missao;
        this.relatorioEquipe = relatorioEquipe;
    }

    public String getNomeNave() {
        return nomeNave;
    }

    public void setNomeNave(String nomeNave) {
        this.nomeNave = nomeNave;
    }

    public Missao getMissao() {
        return missao;
    }

    public void setMissao(Missao missao) {
        this.missao = missao;
    }

    public Estacao getEstacao() {
        return estacao;
    }

    public void setEstacao(Estacao estacao) {
        this.estacao = estacao;
    }

    public Relatorio getRelatorioEquipe() {
        return relatorioEquipe;
    }

    public void setRelatorioEquipe(Relatorio relatorioEquipe) {
        this.relatorioEquipe = relatorioEquipe;
    }

    public TamanhoNave getTamanhoNave() {
        return tamanhoNave;
    }

    public void setTamanhoNave(TamanhoNave tamanhoNave) {
        this.tamanhoNave = tamanhoNave;
    }

    public void addTripulantes(Astronauta tripulante){
        tripulantes.add(tripulante);
    }

    public List<Astronauta> getTripulantes() {
        return tripulantes;
    }
}
