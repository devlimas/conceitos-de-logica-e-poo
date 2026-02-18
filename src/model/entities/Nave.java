package model.entities;

import model.enums.StatusMissao;
import model.enums.StatusNave;
import model.enums.StatusSaude;
import model.enums.TamanhoNave;
import model.exceptions.LimiteTripulantes;

import java.util.ArrayList;
import java.util.List;

public class Nave {

    //A estacao de origem dessa nave e onde vamos pegar os astronautas disponiveis, com um metodo vamos adicionar os tripulantes e remover dos astronautas disponiveis desta estacao
    private Estacao estacao;
    private String nomeNave;
    private TamanhoNave tamanhoNave;
    private StatusNave statusNave;

    //Uma missao por nave
    private Missao missao;

    //Um relatorio geral sobre o desempenho geral da equipe
    private Relatorio relatorioEquipe;

    private List<Astronauta> tripulantes = new ArrayList<>();

    public Nave(Estacao estacao, String nomeNave, TamanhoNave tamanhoNave, StatusNave statusNave,Missao missao, Relatorio relatorioEquipe) {
        this.estacao = estacao;
        this.nomeNave = nomeNave;
        this.tamanhoNave = tamanhoNave;
        this.statusNave = statusNave;
        this.missao = new Missao();
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
        this.missao.setStatusMissao(StatusMissao.ATIVA);
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

    public List<Astronauta> getTripulantes() {
        return tripulantes;
    }


    public void addTripulantes(Astronauta tripulante){
        if (tripulantes.size() >= this.tamanhoNave.getMaxTripulantes()){
            throw new LimiteTripulantes("Limite de tripulantes atingidos");
        }
        estacao.AstronautaConvocado(tripulante);
        tripulantes.add(tripulante);
    }

    public String alaMedica(Astronauta tripulante){
        tripulante.setFadiga(0);
        tripulante.setStatusSaude(StatusSaude.SAUDAVEL);

        return "Tripulante:" + tripulante.getNome() + "\n" +
                "Saúde:" + tripulante.getStatusSaude() + "\n" +
                "Fadiga:" + tripulante.getFadiga();
    }
}
