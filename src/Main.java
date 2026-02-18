import model.entities.*;
import model.enums.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args){

        //Adição da estação-mãe
        Estacao estacao = new Estacao("Nimb-64");

        //Astronautas
        Astronauta astronauta0 = new Astronauta("Luiz Piolho", LocalDate.of(2002,11,11), 8, Especialidade.PILOTO, NivelExperiencia.SENIOR, 46, new Relatorio());

        Astronauta astronauta1 = new Astronauta("Yuri Prado", LocalDate.of(2003,10,1), 19, Especialidade.ENGENHEIRO, NivelExperiencia.PLENO, 79, new Relatorio());

        Astronauta astronauta2 = new Astronauta("Alice Ferro", LocalDate.of(2001,3,6), 12, Especialidade.ENGENHEIRO, NivelExperiencia.PLENO, 0, new Relatorio());

        Astronauta astronauta3 = new Astronauta("Afolso Texeira", LocalDate.of(2005,1,8), 9, Especialidade.MEDICO, NivelExperiencia.SENIOR, 25, new Relatorio());

        Astronauta astronauta4 = new Astronauta("Mario Paulo", LocalDate.of(2003,4,12), 1, Especialidade.ENGENHEIRO, NivelExperiencia.SENIOR, 100, new Relatorio());

        Astronauta astronauta5 = new Astronauta("Livia Rocha", LocalDate.of(2002,9,21), 3, Especialidade.ENGENHEIRO, NivelExperiencia.JUNIOR, 120, new Relatorio());

        Astronauta astronauta6 = new Astronauta("Pedro Texeira", LocalDate.of(2005,1,8), 35, Especialidade.MEDICO, NivelExperiencia.JUNIOR, 0, new Relatorio());

        Astronauta astronauta7 = new Astronauta("Lucas Peixes", LocalDate.of(2000,7,2), 75, Especialidade.ZELADOR, NivelExperiencia.JUNIOR, 23, new Relatorio());

        //Astronauta menor de idade
        //Astronauta astronauta8 = new Astronauta("Lucas Peixes", LocalDate.of(2016,7,2), 99, Especialidade.PILOTO, NivelExperiencia.SENIOR, 1, new Relatorio());

        //Adicionando os astronautas a estação-mãe
        estacao.addAstronautaDisponiveis(astronauta0);
        estacao.addAstronautaDisponiveis(astronauta1);
        estacao.addAstronautaDisponiveis(astronauta2);
        estacao.addAstronautaDisponiveis(astronauta3);
        estacao.addAstronautaDisponiveis(astronauta4);
        estacao.addAstronautaDisponiveis(astronauta5);
        estacao.addAstronautaDisponiveis(astronauta6);
        estacao.addAstronautaDisponiveis(astronauta7);

        //Nave e sua estação de origem
        Nave nave0 = new Nave(estacao, "Apolo-11", TamanhoNave.M, StatusNave.DISPONIVEL, new Missao(), new Relatorio());

        nave0.addTripulantes(astronauta0);
        nave0.addTripulantes(astronauta1);
        nave0.addTripulantes(astronauta2);
        nave0.addTripulantes(astronauta3);
        nave0.addTripulantes(astronauta4);
        nave0.addTripulantes(astronauta5);

        //Limite de tripulantes atingido, limite baseado em enum
        //nave0.addTripulantes(astronauta6);

        Missao missao0 = new Missao("Visita a Lua", StatusMissao.PENDENTE, 3, new Relatorio());

        //Limite de valor da prioridade ultrapassado
        //Missao missao1 = new Missao("Visita a Marte", StatusMissao.PENDENTE, 733, new Relatorio());

        //Adicionando a nave e missão na lista da estação-mãe
        estacao.addNaves(nave0);
        estacao.addMissao(missao0);

        nave0.setMissao(missao0);

        //Nova tarefa sendo adicionada na lista da missão pendente
        Tarefa tarefa0 = new Tarefa("Ajudar feridos", astronauta3, Especialidade.MEDICO, NivelExperiencia.SENIOR, false);

        //Erro no nivel de experiência
        //Tarefa tarefa1 = new Tarefa("Limpar a nave", astronauta7, Especialidade.ZELADOR, NivelExperiencia.SENIOR, false);

        //Astronauta exausto
        //Tarefa tarefa2 = new Tarefa("Ajudar feridos", astronauta1, Especialidade.ENGENHEIRO, NivelExperiencia.PLENO, false);

        missao0.addTarefa(tarefa0);
        //missao0.addTarefa(tarefa1);
        //missao0.addTarefa(tarefa2);

        System.out.println(astronauta3.toString());

        System.out.println();
        System.out.println(tarefa0.executarTarefa(tarefa0));

        System.out.println();
        System.out.println(astronauta3.toString());

        System.out.println();
        System.out.println(nave0.alaMedica(astronauta3));

        System.out.println(astronauta3.getTarefas());
    }

}