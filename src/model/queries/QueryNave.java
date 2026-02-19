package model.queries;

import model.entities.Astronauta;
import model.entities.Nave;

public class QueryNave {

    public QueryNave() {
    }

    public String BuscarTodosAstronautas(Nave nave) {
        for (Astronauta leitor: nave.getTripulantes()){
            System.out.println(
                "Id: " + leitor.getId() + "\n" +
                "Nome: " + leitor.getNome() + "\n" +
                "Especialidade: " + leitor.getEspecialidade() + "\n" +
                "Saúde: " + leitor.getStatusSaude() + "\n" +
                "Fadiga: " + leitor.getFadiga() + "\n"
            );
        }
        return "Fim da lista de tripulantes da nave\n";
    }

    public String BuscarAstronautaPorNome(Nave nave, String nomeAstronauta) {
        for (Astronauta leitor: nave.getTripulantes()){
            if (leitor.getNome().equals(nomeAstronauta)){
                return "Id: " + leitor.getId() + "\n" +
                        "Nome: " + leitor.getNome() + "\n" +
                        "Especialidade: " + leitor.getEspecialidade() + "\n" +
                        "Saúde: " + leitor.getStatusSaude() + "\n" +
                        "Fadiga: " + leitor.getFadiga();
            }
        }
        return "Astronata não encontrado";
    }
}
