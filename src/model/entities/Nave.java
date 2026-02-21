package model.entities;

import model.enums.StatusMissao;
import model.enums.StatusNave;
import model.enums.TamanhoNave;
import model.exceptions.Indisponivel;
import model.exceptions.LimiteTripulantes;

import java.util.ArrayList;
import java.util.InputMismatchException;
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

    public Nave() {
    }

    public Nave(Estacao estacao, String nomeNave, TamanhoNave tamanhoNave, StatusNave statusNave) {
        this.estacao = estacao;
        this.nomeNave = nomeNave;
        this.tamanhoNave = tamanhoNave;
        this.statusNave = statusNave;
    }

    public StatusNave getStatusNave() {
        return statusNave;
    }

    public void setStatusNave(StatusNave statusNave) {
        this.statusNave = statusNave;
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
        if (getMissao() != null){
            throw new Indisponivel("Esta nave já tem uma missão adicionada");
        }
        else if (missao.getStatusMissao() != StatusMissao.PENDENTE) {
            throw new Indisponivel("A missão adicionada já está em andamento ou finalizada");
        }
        else if (getStatusNave() != StatusNave.DISPONIVEL) {
            throw new Indisponivel("Nave indisponivel");
        }

        missao.setStatusMissao(StatusMissao.ATIVA);
        this.statusNave = StatusNave.OCUPADA;
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

    public void setTripulantes(List<Astronauta> tripulantes) {
        this.tripulantes = tripulantes;
    }

    public void addTripulantes(Astronauta tripulante){
        if (tripulantes.size() >= this.tamanhoNave.getMaxTripulantes()){
            throw new LimiteTripulantes("Limite de tripulantes atingidos");
        }
        tripulantes.add(tripulante);
    }

    @Override
    public String toString() {
        String nomeDaMissao = (missao != null) ? missao.getNomeMissao() : "Nenhuma missão atribuída";

        return "\n" + "Estação de origem: " + estacao.getNomeDaEstacao() + "\n" +
                "Nome da nave: " + getNomeNave() + "\n" +
                "Tamanho da nave: " + getTamanhoNave() + "\n" +
                "Status da nave: " + getStatusNave() + "\n" +
                "Missão da nave: " + nomeDaMissao + "\n";
    }
}
