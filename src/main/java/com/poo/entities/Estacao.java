package com.poo.entities;

import com.poo.exceptions.Existente;

import java.util.ArrayList;
import java.util.List;

public class Estacao {
    private String nomeDaEstacao;
    private List<Astronauta> astronautas = new ArrayList<>();
    private List<Nave> naves = new ArrayList<>();
    private List<Missao> missoes = new ArrayList<>();

    public Estacao() {
    }

    public Estacao(String nomeDaEstacao) {
        this.nomeDaEstacao = nomeDaEstacao;
    }

    public String getNomeDaEstacao() {
        return nomeDaEstacao;
    }

    public void setNomeDaEstacao(String nomeDaEstacao) {
        this.nomeDaEstacao = nomeDaEstacao;
    }

    public void setAstronautas(List<Astronauta> astronautas) {
        this.astronautas = astronautas;
    }

    public List<Astronauta> getAstronautas() {
        return astronautas;
    }

    public void addAstronautas(Astronauta astronauta){
        for (Astronauta leitor: astronautas){
            if (astronauta.getId().equals(leitor.getId())){
                throw new Existente("Esse Id está sendo usado por outro astronauta da estação");
            }
        }
        astronautas.add(astronauta);
    }

    public String AstronautasRemove(Astronauta astronauta){
        astronautas.remove(astronauta);
        return "Astronauta removido";
    }

    public void setNaves(List<Nave> naves) {
        this.naves = naves;
    }

    public List<Nave> getNaves() {
        return naves;
    }

    public void addNaves(Nave nave){
        for (Nave leitor: naves){
            if (nave.getNomeNave().equals(leitor.getNomeNave())){
                throw new Existente("Essa nave já está registrada nesta estação");
            }
        }
        naves.add(nave);
    }

    public List<Missao> getMissoes() {
        return missoes;
    }

    public void setMissoes(List<Missao> missoes) {
        this.missoes = missoes;
    }

    public void addMissao(Missao missao){
        for (Missao leitor: missoes){
            if (leitor.getNomeMissao().equals(missao.getNomeMissao())){
                throw new Existente("Esta missão já está registrada nesta estação");
            }
        }
        missoes.add(missao);
    }

    @Override
    public String toString() {
        return "nome Da Estação: " + getNomeDaEstacao() + "\n\n";
    }
}

