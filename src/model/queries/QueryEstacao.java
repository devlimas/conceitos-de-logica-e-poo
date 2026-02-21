package model.queries;

import model.entities.*;

import java.util.List;

public class QueryEstacao {

    private Estacao estacaos;

    public QueryEstacao() {}

    public List<Astronauta> TodosAstronautasEstacao(Estacao estacao) {
        return estacao.getAstronautas();
    }

    public Astronauta BuscarAstronautaEstacaoPorId(Estacao estacao, int id) {
        for (Astronauta leitor : estacao.getAstronautas()) {
            if (leitor.getId() == id){
                return leitor;
            }
        }
        return null;
    }

    public List<Nave> TodasEstacaoNaves(Estacao estacao) {
        return estacao.getNaves();
    }

    public Nave BuscarNavePorNome(Estacao estacao, String nomeNave) {
        for (Nave leitor : estacao.getNaves()) {
            if (leitor.getNomeNave().equals(nomeNave)){
                return leitor;
            }
        }
        return null;
    }

    public List<Missao> TodasMissoes(Estacao estacao) {
        return estacao.getMissoes();
    }

    public Missao BuscarMissaoPorNome(Estacao estacao, String nomeMissao) {
        for (Missao leitor : estacao.getMissoes()) {
            if (leitor.getNomeMissao().equals(nomeMissao)){
                return leitor;
            }
        }
        return null;
    }
}
