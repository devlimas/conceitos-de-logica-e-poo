package com.poo.queries;

import com.poo.entities.*;

import java.util.List;

public class QueryEstacao {

    private Estacao estacaos;

    public QueryEstacao() {}

    public List<Astronauta> TodosAstronautasEstacao(Estacao estacao) {
        return estacao.getAstronautas();
    }

    public Astronauta BuscarAstronautaEstacaoPorId(Estacao estacao, int id) {
        return estacao.getAstronautas().stream()
                .filter(a -> a.getId() == id)
                .findFirst()
                .orElse(null);
    }

    public List<Nave> TodasEstacaoNaves(Estacao estacao) {
        return estacao.getNaves();
    }

    public Nave BuscarNavePorNome(Estacao estacao, String nomeNave) {
        return estacao.getNaves().stream()
                .filter(n -> n.getNomeNave().equals(nomeNave))
                .findFirst()
                .orElse(null);
    }

    public List<Missao> TodasMissoes(Estacao estacao) {
        return estacao.getMissoes();
    }

    public Missao BuscarMissaoPorNome(Estacao estacao, String nomeMissao) {
        return estacao.getMissoes().stream()
                .filter(m -> m.getNomeMissao().equals(nomeMissao))
                .findFirst()
                .orElse(null);
    }
}
