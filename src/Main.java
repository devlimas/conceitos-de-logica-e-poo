import model.entities.*;
import model.enums.*;
import model.queries.QueryAstronauta;
import model.queries.QueryEstacao;
import model.queries.QueryMissao;
import model.queries.QueryNave;
import model.services.ServiceAlaMedica;
import model.services.ServiceConvocacao;
import model.services.ServiceTarefa;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args){

        // ==============================
        // Criando Estação
        // ==============================

        Estacao estacaoA = new Estacao("Estação Orbital Alpha");
        Estacao estacaoB = new Estacao("Estação Orbital Beta");

        // ==============================
        // Criando Astronautas
        // ==============================

        Astronauta a1 = new Astronauta(
                "Carlos",
                LocalDate.of(1990, 5, 10),
                1,
                Especialidade.ENGENHEIRO,
                NivelExperiencia.PLENO,
                10
        );

        Astronauta a2 = new Astronauta(
                "Fernanda",
                LocalDate.of(1985, 3, 22),
                2,
                Especialidade.MEDICO,
                NivelExperiencia.SENIOR,
                20
        );

        Astronauta a3 = new Astronauta(
                "Marcos",
                LocalDate.of(1988, 11, 15),
                3,
                Especialidade.PILOTO,
                NivelExperiencia.SENIOR,
                15
        );

        Astronauta a4 = new Astronauta(
                "Juliana",
                LocalDate.of(1995, 7, 30),
                4,
                Especialidade.MEDICO,
                NivelExperiencia.JUNIOR,
                76
        );

        Astronauta a5 = new Astronauta(
                "Roberto",
                LocalDate.of(1982, 1, 12),
                5,
                Especialidade.PILOTO,
                NivelExperiencia.JUNIOR,
                25
        );

        Astronauta a6 = new Astronauta(
                "Beatriz",
                LocalDate.of(1992, 9, 05),
                6,
                Especialidade.ENGENHEIRO,
                NivelExperiencia.JUNIOR,
                12
        );

        Astronauta a7 = new Astronauta(
                "André",
                LocalDate.of(1987, 4, 18),
                7,
                Especialidade.MEDICO,
                NivelExperiencia.SENIOR,
                18
        );

        Astronauta a8 = new Astronauta(
                "Camila",
                LocalDate.of(1998, 12, 02),
                8,
                Especialidade.PILOTO,
                NivelExperiencia.JUNIOR,
                3
        );

        Astronauta a9 = new Astronauta(
                "Thiago",
                LocalDate.of(1991, 6, 25),
                9,
                Especialidade.ENGENHEIRO,
                NivelExperiencia.PLENO,
                11
        );

        Astronauta a10 = new Astronauta(
                "Larissa",
                LocalDate.of(1984, 8, 14),
                10,
                Especialidade.MEDICO,
                NivelExperiencia.SENIOR,
                22
        );

        Astronauta a11 = new Astronauta(
                "Ricardo",
                LocalDate.of(1980, 2, 28),
                11,
                Especialidade.PILOTO,
                NivelExperiencia.JUNIOR,
                30
        );

        Astronauta a12 = new Astronauta(
                "Sofia",
                LocalDate.of(1996, 10, 10),
                12,
                Especialidade.ENGENHEIRO,
                NivelExperiencia.JUNIOR,
                4
        );

        Astronauta a13 = new Astronauta(
                "Gabriel",
                LocalDate.of(1989, 3, 07),
                13,
                Especialidade.CIENTISTA,
                NivelExperiencia.PLENO,
                9
        );

        Astronauta a14 = new Astronauta(
                "Helena",
                LocalDate.of(1993, 5, 19),
                14,
                Especialidade.MEDICO,
                NivelExperiencia.PLENO,
                48
        );

        Astronauta a15 = new Astronauta(
                "Bruno",
                LocalDate.of(1986, 11, 30),
                15,
                Especialidade.ENGENHEIRO,
                NivelExperiencia.SENIOR,
                116
        );

        /*
        //Menor de idade para testes
        Astronauta a16 = new Astronauta(
                "Zaun",
                LocalDate.of(2018, 11, 30),
                16,
                Especialidade.ENGENHEIRO,
                NivelExperiencia.SENIOR,
                19
        );
         */

        //Mesmo id na mesma estação
        Astronauta a17 = new Astronauta(
                "Ruth",
                LocalDate.of(1996, 11, 30),
                6,
                Especialidade.PILOTO,
                NivelExperiencia.SENIOR,
                104
        );

        // ==============================
        // Adicionando na estação
        // ==============================

        estacaoA.addAstronautas(a1);
        estacaoA.addAstronautas(a2);
        estacaoA.addAstronautas(a3);
        estacaoA.addAstronautas(a4);
        estacaoA.addAstronautas(a5);
        estacaoA.addAstronautas(a6);
        estacaoA.addAstronautas(a7);
        estacaoA.addAstronautas(a8);
        estacaoA.addAstronautas(a9);
        estacaoA.addAstronautas(a10);
        estacaoA.addAstronautas(a11);
        estacaoA.addAstronautas(a12);
        estacaoA.addAstronautas(a13);
        estacaoA.addAstronautas(a14);
        estacaoA.addAstronautas(a15);

        //estacaoA.addAstronautas(a16);
        //estacaoA.addAstronautas(a17);

        // ==============================
        // Criando Nave
        // ==============================
        Nave nave1 = new Nave(
                estacaoA,
                "Apollo-11",
                TamanhoNave.M,
                StatusNave.DISPONIVEL
        );

        Nave nave2 = new Nave(
                estacaoA,
                "Apollo-X",
                TamanhoNave.P,
                StatusNave.DISPONIVEL
        );

        Nave nave3 = new Nave(
                estacaoA,
                "Apollo-Y",
                TamanhoNave.P,
                StatusNave.AVARIADA
        );

        Nave nave4 = new Nave(
                estacaoA,
                "Apollo-Z",
                TamanhoNave.M,
                StatusNave.OCUPADA
        );

        Nave nave5 = new Nave(
                estacaoA,
                "Apollo-00",
                TamanhoNave.G,
                StatusNave.AVARIADA
        );

        estacaoA.addNaves(nave1);
        estacaoA.addNaves(nave2);
        estacaoA.addNaves(nave3);
        estacaoA.addNaves(nave4);
        estacaoA.addNaves(nave5);

        // ==============================
        // Criando Missão
        // ==============================

        Missao m1 = new Missao(
                "Missão Marte",
                StatusMissao.PENDENTE,
                2
        );

        Missao m2 = new Missao(
                "Exploração Lunar",
                StatusMissao.PENDENTE,
                1
        );

        Missao m3 = new Missao(
                "Resgate em Vênus",
                StatusMissao.FALHA,
                3
        );

        Missao m4 = new Missao(
                "Sonda de Júpiter",
                StatusMissao.ATIVA,
                3
        );

        Missao m5 = new Missao(
                "Colonização de Europa",
                StatusMissao.CONCLUIDA,
                1
        );

        //Missão acima da prioridade (0 a 3)
        /*
        Missao m6 = new Missao(
                "Invasão a Zeta",
                StatusMissao.CONCLUIDA,8
        );
        */

        estacaoA.addMissao(m1);
        estacaoA.addMissao(m2);
        estacaoA.addMissao(m3);
        estacaoA.addMissao(m4);
        estacaoA.addMissao(m5);

        //Missão já está registrada
        //estacaoA.addMissao(m1);

        nave1.setMissao(m1);

        //Nave ocupada
        //nave4.setMissao(m2);

        //Nave avariada, não pode pegar missão
        //nave3.setMissao(m2);

        //Nave tentando ativar uma missão em andamento
        //nave2.setMissao(m1);


        // ==============================
        // Criando Tarefas
        // ==============================

        Tarefa t1 = new Tarefa(
                "Reparar Painel Solar",
                Especialidade.ENGENHEIRO,
                NivelExperiencia.PLENO,
                false
        );

        Tarefa t2 = new Tarefa(
                "Análise Médica da Tripulação",
                Especialidade.MEDICO,
                NivelExperiencia.PLENO,
                false
        );

        Tarefa t3 = new Tarefa(
                "Assumir a pilotagem",
                Especialidade.PILOTO,
                NivelExperiencia.PLENO,
                false
        );

        Tarefa t4 = new Tarefa(
                "Ajudar os feridos",
                Especialidade.MEDICO,
                NivelExperiencia.JUNIOR,
                false
        );

        m1.addTarefa(t1);
        m1.addTarefa(t2);
        m1.addTarefa(t3);
        m1.addTarefa(t4);

        // ==============================
        // Convocando astronautas
        // ==============================
        ServiceConvocacao convocacao = new ServiceConvocacao();

        convocacao.Convocar(nave1, a1);
        convocacao.Convocar(nave1, a2);
        convocacao.Convocar(nave1, a3);
        convocacao.Convocar(nave1, a4);
        convocacao.Convocar(nave1, a5);
        convocacao.Convocar(nave1, a6);


        System.out.println("Tripulantes convocados com sucesso.\n");

        // ==============================
        // Atribuindo tarefas
        // ==============================
        t1.setAstronautaResponsavel(a1, t1);
        t2.setAstronautaResponsavel(a2, t2);
        t3.setAstronautaResponsavel(a3, t3);
        t4.setAstronautaResponsavel(a7, t4);

        //Nivel de fadiga alta
        //t4.setAstronautaResponsavel(a4, t4);

        //Nivel de experiencia baixo do astronauta
        //t3.setAstronautaResponsavel(a5, t3);

        //Astronauta debilitado, fadiga alta e ferido
        //t2.setAstronautaResponsavel(a17, t3);

        // ==============================
        // QueryDaTripulação
        // ==============================
        QueryNave ListaTripulantes = new QueryNave();
        QueryMissao ListaTarefas = new QueryMissao();
        QueryEstacao ListaEstacao = new QueryEstacao();
        QueryAstronauta ListaTarefasIndividual = new QueryAstronauta();

        System.out.println("Lista da Tripulação");
        System.out.println(ListaTripulantes.TodaTripulacao(nave1));
        // ==============================
        // Executando tarefas
        // ==============================
        ServiceTarefa serviceTarefa = new ServiceTarefa();

        System.out.println(serviceTarefa.executarTarefa(t1) + "\n");
        System.out.println(serviceTarefa.executarTarefa(t2) + "\n");
        System.out.println(serviceTarefa.executarTarefa(t3) + "\n");
        System.out.println(serviceTarefa.executarTarefa(t4) + "\n");

        System.out.println("\nTarefas executadas.\n");

        // ==============================
        // QueryDaTripulaçãoApósTarefas
        // ==============================
        System.out.println("Lista da Tripulação Após Tarefas");
        System.out.println(ListaTripulantes.TodaTripulacao(nave1));

        // ==============================
        // AlaMedica
        // ==============================
        ServiceAlaMedica alaMedica = new ServiceAlaMedica();

        alaMedica.recuperação(a1);
        alaMedica.recuperação(a2);
        alaMedica.recuperação(a3);
        alaMedica.recuperação(a7);

        // ==============================
        // QueryDaTripulaçãoApósAlaMédica
        // ==============================
        System.out.println("Lista da Tripulação Após Ala Médica");
        System.out.println(ListaTripulantes.TodaTripulacao(nave1));

        // ==============================
        // Verificando estado final
        // ==============================

        System.out.println("=== MISSÃO ===\n");
        System.out.println(m1);

        System.out.println("=== NAVE ===\n");
        System.out.println(nave1);

        System.out.println("-----------------------------------------------------------------------------------------");
        // ==============================
        // Querys
        // ==============================
        //--------------------------------------------------------------
        //Tarefas da Missão
        System.out.println("Tarefas da Missão");

        System.out.println(ListaTarefas.TodasTarefasDaMissao(m1));

        System.out.println();

        System.out.println(ListaTarefas.BuscarTarefaPorNome(m1, "Reparar Painel Solar"));
        System.out.println();
        System.out.println("-----------------------------------------------------------------------------------------");
        //--------------------------------------------------------------

        //Listas das Missões da Estação
        System.out.println("Listas da estação:");

        System.out.println("Missoes:");
        System.out.println(ListaEstacao.TodasMissoes(estacaoA));

        System.out.println();

        if (ListaEstacao.BuscarMissaoPorNome(estacaoA, "Missão Marte") != null) {
            System.out.println(ListaEstacao.BuscarMissaoPorNome(estacaoA, "Missão Marte"));
        } else {
            System.out.println("Nada encontrado");
        }
        System.out.println();
        System.out.println("-----------------------------------------------------------------------------------------");
        //Listas dos Astronautas da Estação
        System.out.println("Astronautas:");
        System.out.println(ListaEstacao.TodosAstronautasEstacao(estacaoA));

        System.out.println();

        if (ListaEstacao.BuscarAstronautaEstacaoPorId(estacaoA, 1) != null) {
            System.out.println(ListaEstacao.BuscarAstronautaEstacaoPorId(estacaoA, 1));
        } else {
            System.out.println("Nada encontrado");
        }

        System.out.println();
        System.out.println("-----------------------------------------------------------------------------------------");
        //Lista das Naves da Estação
        System.out.println("Naves:");
        System.out.println(ListaEstacao.TodasEstacaoNaves(estacaoA));

        System.out.println();

        if (ListaEstacao.BuscarNavePorNome(estacaoA, "Apollo-11") != null) {
            System.out.println(ListaEstacao.BuscarNavePorNome(estacaoA, "Apollo-11"));
        } else {
            System.out.println("Nada encontrado");
        }

        if (ListaEstacao.BuscarNavePorNome(estacaoA, "Apollo-00") != null) {
            System.out.println(ListaEstacao.BuscarNavePorNome(estacaoA, "Apollo-00"));
        } else {
            System.out.println("Nada encontrado");
        }

        System.out.println();
        System.out.println("-----------------------------------------------------------------------------------------");
        //--------------------------------------------------------------

        System.out.println("Tarefas individuais do Astronauta:");

        System.out.println(ListaTarefasIndividual.TodasTarefasIndividuais(a1));

        System.out.println();

        if (ListaTarefasIndividual.BuscarTarefaIndividual(a1, "Reparar Painel Solar") != null) {
            System.out.println(ListaTarefasIndividual.BuscarTarefaIndividual(a1, "Reparar Painel Solar"));
        } else {
            System.out.println("Nada encontrado");
        }
        System.out.println();
        System.out.println("-----------------------------------------------------------------------------------------");
        //--------------------------------------------------------------
        System.out.println("Tripulação da nave:");

        System.out.println(ListaTripulantes.TodaTripulacao(nave1));

        System.out.println();

        if (ListaTripulantes.TripulantePorId(nave1, 2) != null) {
            System.out.println(ListaTripulantes.TripulantePorId(nave1, 2));
        } else {
            System.out.println("Nada encontrado");
        }
        System.out.println();
        System.out.println("-----------------------------------------------------------------------------------------");
        //--------------------------------------------------------------
    }

}