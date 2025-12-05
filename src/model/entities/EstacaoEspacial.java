package model.entities;

import model.exceptions.AlocacaoExcedidaException;

import java.util.ArrayList;
import java.util.List;

public class EstacaoEspacial {
    private String nomeDaEstacao;
    private int limiteTotalDeTripulantes;

    private List<Astronauta> tripulacao = new ArrayList<>();
    private List<Missao> missoes = new ArrayList<>();

    public EstacaoEspacial(int limiteTotalDeTripulantes, String nomeDaEstacao) {
        this.limiteTotalDeTripulantes = limiteTotalDeTripulantes;
        this.nomeDaEstacao = nomeDaEstacao;
    }

    public String getNomeDaEstacao() {
        return nomeDaEstacao;
    }

    public void setNomeDaEstacao(String nomeDaEstacao) {
        this.nomeDaEstacao = nomeDaEstacao;
    }

    public int getLimiteTotalDeTripulantes() {
        return limiteTotalDeTripulantes;
    }

    public void setLimiteTotalDeTripulantes(int limiteTotalDeTripulantes) {
        this.limiteTotalDeTripulantes = limiteTotalDeTripulantes;
    }

    public List<Astronauta> getTripulacao() {
        return tripulacao;
    }

    public List<Missao> getMissoes() {
        return missoes;
    }

    public void addMissoes(Missao missao) {
        missoes.add(missao);
    }

    //Função para verificar se o tamanho da tripulação não utrapassou o limite total dela
    public void alocarAstronauta(Astronauta novato) throws AlocacaoExcedidaException {
        if (tripulacao.size() < limiteTotalDeTripulantes){
            tripulacao.add(novato);
            System.out.println("Astronauta novo na estação");
        }

        else {
            throw new AlocacaoExcedidaException("Alocação excedida");
        }
    }

    @Override
    public String toString() {
        StringBuilder msg = new StringBuilder();
        msg.append("Nome da estação:" + nomeDaEstacao + "\n");
        msg.append("Total de tripulantes na estação:" + tripulacao.size() + "\n");
        return msg.toString();
    }
}
