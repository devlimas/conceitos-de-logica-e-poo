import model.entities.Astronauta;
import model.entities.EstacaoEspacial;
import model.entities.Missao;
import model.entities.Tarefa;
import model.enums.StatusDaMissao;
import model.enums.StatusDeSaude;
import model.exceptions.AlocacaoExcedidaException;
import model.exceptions.AstronautaNaoAptoException;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Random;

public class Main {
    public static void main(String[] args){

        Astronauta a1 = new Astronauta(14, "Pedro", LocalDate.of(2008, 9, 21), "engenheiro", 8, StatusDeSaude.valueOf("SAUDAVEL"));
        Astronauta a2 = new Astronauta(21, "Mario", LocalDate.of(2004, 1, 11), "faxineiro", 4, StatusDeSaude.valueOf("SAUDAVEL"));
        Astronauta a3 = new Astronauta(3, "Lucas", LocalDate.of(2006, 2, 6), "mecanico", 6, StatusDeSaude.valueOf("FERIDO"));
        Astronauta a4 = new Astronauta(4, "Maria", LocalDate.of(2002, 9, 10), "medica", 10, StatusDeSaude.valueOf("SAUDAVEL"));
        Astronauta a5 = new Astronauta(1, "Alice", LocalDate.of(2003, 6, 19), "piloto", 7, StatusDeSaude.valueOf("CANSADO"));
        Astronauta a6 = new Astronauta(23, "Sabrina", LocalDate.of(2001, 5, 14), "engenheiro", 9, StatusDeSaude.valueOf("SAUDAVEL"));

        EstacaoEspacial estacaoEspacial = new EstacaoEspacial(4, "Base-A1");

        try{
            estacaoEspacial.alocarAstronauta(a1);
            estacaoEspacial.alocarAstronauta(a2);
            estacaoEspacial.alocarAstronauta(a3);
            estacaoEspacial.alocarAstronauta(a4);
            System.out.println();
            /*
            estacaoEspacial.alocandoAstronauta(a5);
            estacaoEspacial.alocandoAstronauta(a6);
            Tratamento de exceção usado para respeitar o limite total de tripulantes*/
        }

        catch (AlocacaoExcedidaException e) {
            System.out.println(e.getMessage());
        }

        System.out.println("Tripulação:");
        for (Astronauta leitor: estacaoEspacial.getTripulacao()){
            System.out.println(leitor.toString());
        }

        //Criando as tarefas para as missões, com um random para definir a quantidade do tempo da tarefa
        Random random = new Random();
        int tempo = random.nextInt(60);
        LocalTime tempoDaTarefa = LocalTime.of(0, tempo);
        Tarefa tarefa1 = new Tarefa("Consertar todas placas do satelite", tempoDaTarefa, a1, false);
        Tarefa tarefa2 = new Tarefa("Limpar todas as placas do satelite", tempoDaTarefa, a2, false);
        Tarefa tarefa3 = new Tarefa("Verificar a saúde de todos", tempoDaTarefa, a4, true);

        //Após crio cada missão e adiciono a cada missão suas tarefas, junto recruto o astronauta com a função necessaria para tal missao
        Missao missao1 = new Missao("Manutenção de satélites", "Consertar os satelite e limpar todos eles", StatusDaMissao.valueOf("ATIVA"), 5, "engenheiro");
        Missao missao2 = new Missao("Saúde da tripulação", "Verificar se todos estão com saúde", StatusDaMissao.valueOf("CONCLUIDA"), 10, "medica");

        try {
            missao1.recrutarAstronauta(a1);
            /*missao1.recrutarAstronauta(a2); Não tem especialidade, sua função não atende a missão então cai na exceção*/
            missao2.recrutarAstronauta(a4);
        }
        catch (AstronautaNaoAptoException a){
            System.out.println(a.getMessage());
        }

        missao1.addTarefasDaMissao(tarefa1);
        missao1.addTarefasDaMissao(tarefa2);
        missao2.addTarefasDaMissao(tarefa3);

        estacaoEspacial.addMissoes(missao1);
        estacaoEspacial.addMissoes(missao2);

        System.out.println("Todas as missões da estação:");
        for (Missao leitor : estacaoEspacial.getMissoes()){
            System.out.println();
            System.out.println(leitor.toString());
        }

        System.out.println("Tarefas da missão 1:");
        for (Tarefa leitor : missao1.getTarefasDaMissao()){
            System.out.println();
            System.out.println(leitor.toString());
        }

        System.out.println("Tarefas da missão 2:");
        for (Tarefa leitor : missao2.getTarefasDaMissao()){
            System.out.println();
            System.out.println(leitor.toString());
        }
    }
}