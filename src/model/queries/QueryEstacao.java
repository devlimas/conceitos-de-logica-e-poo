package model.queries;

import model.entities.Astronauta;
import model.entities.Estacao;
import model.entities.Missao;
import model.entities.Nave;

public class QueryEstacao {

    private Estacao estacaos;

    public QueryEstacao() {}

    public String BuscarAstronautas(Estacao estacao) {
        for (Astronauta leitor: estacao.getAstronautas()){
            System.out.println(
                "Id: " + leitor.getId() + "\n" +
                "Nome: " + leitor.getNome() + "\n" +
                "Disponibilidade: " + leitor.getDisponibilidade() + "\n" +
                "Especialidade: " + leitor.getEspecialidade() + "\n" +
                "Saúde: " + leitor.getStatusSaude() + "\n\n"
            );
        }
        return "Fim da lista de astronautas disponiveis da estação";
    }

    public String BuscarAstronautaPorNome(Estacao estacao ,String nomeAstronauta) {
        for (Astronauta leitor: estacao.getAstronautas()){
            if (leitor.getNome().equals(nomeAstronauta)){
                return "Astronauta encontrado: " + leitor.getNome() + "\n" +
                        "Id: " + leitor.getId() + "\n";
            }
        }
        return "Astronauta não encontrado";
    }

    public String BuscarNave(Estacao estacao) {
        for (Nave leitor : estacao.getNaves()) {
            // Verifica se a missão é nula para evitar o erro
            String nomeMissao = (leitor.getMissao() != null)
                    ? leitor.getMissao().getNomeMissao()
                    : "Sem missão atribuída";

            System.out.println(
                    "Nome da nave: " + leitor.getNomeNave() + "\n" +
                            "Tamanho da nave: " + leitor.getTamanhoNave() + "\n" +
                            "Missão da nave: " + nomeMissao + "\n" + // Usando a variável segura
                            "Status da nave: " + leitor.getStatusNave() + "\n"
            );
        }
        return "Fim da listas das naves";
    }

    public String BuscarNavePorNome(Estacao estacao, String nomeNave) {
        for (Nave leitor: estacao.getNaves()){
            if (leitor.getNomeNave().equals(nomeNave)){
                return "Nome da nave: " + leitor.getNomeNave() + "\n" +
                        "Tamanho da nave: " + leitor.getTamanhoNave() + "\n" +
                        "Missão da nave" + leitor.getMissao().getNomeMissao() + "\n" +
                        "Status da nave:" + leitor.getStatusNave() + "\n";
            }
        }
        return "Nave não encontrada";
    }

    public String BucarMissoes(Estacao estacao){
        for (Missao leitor: estacao.getMissoes()){
            System.out.println(
                "Nome da missão: " + leitor.getNomeMissao() + "\n" +
                "Status da missão: " + leitor.getStatusMissao() + "\n\n"
            );
        }
        return "Fim da lista de missões";
    }

    public String buscarMissaoPorNome(Estacao estacao, String nomeMissao) {
        for (Missao leitor: estacao.getMissoes()){
            if (leitor.getNomeMissao().equals(nomeMissao)){
                return "Nome da missão: " + leitor.getNomeMissao() + "\n" +
                        "Status da missão: " + leitor.getStatusMissao() + "\n";
            }
        }
        return "Missão não encontrado";
    }
}
