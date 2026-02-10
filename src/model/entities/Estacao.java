package model.entities;

import java.util.ArrayList;
import java.util.List;

public class Estacao {
    private String nomeDaEstacao;
    private List<Astronauta> astronautasDisponiveis = new ArrayList<>();
    private List<Missao> missoes = new ArrayList<>();

    public Estacao(String nomeDaEstacao) {
        this.nomeDaEstacao = nomeDaEstacao;
    }

    public String getNomeDaEstacao() {
        return nomeDaEstacao;
    }

    public void setNomeDaEstacao(String nomeDaEstacao) {
        this.nomeDaEstacao = nomeDaEstacao;
    }

    public void addAstronautaDisponiveis(Astronauta astronauta){
        astronautasDisponiveis.add(astronauta);
    }

    //Essas missoes podem ou nao esta disponiveis, depende do status dela, caso nao estaja, existira uma regra de negocio que nao vai permitir qu as naves aceitem a missao
    public void addMissao(Missao missao){
        missoes.add(missao);
    }

    public List<Astronauta> getAstronautasDisponiveis() {
        return astronautasDisponiveis;
    }

    public List<Missao> getMissoes() {
        return missoes;
    }
}
