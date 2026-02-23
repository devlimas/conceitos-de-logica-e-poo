package com.poo;

import com.poo.entities.*;
import com.poo.enums.*;
import com.poo.queries.QueryAstronauta;
import com.poo.queries.QueryEstacao;
import com.poo.queries.QueryMissao;
import com.poo.queries.QueryNave;
import com.poo.services.ServiceAlaMedica;
import com.poo.services.ServiceConvocacao;
import com.poo.services.ServiceRelatorio;
import com.poo.services.ServiceTarefa;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args){

        // ==============================
        // Criando Estação
        // ==============================
        Estacao estacaoA = new Estacao("Estação Orbital Alpha");

        // ==============================
        // Criando Astronautas
        // ==============================
        Astronauta a1 = new Astronauta(
                "Carlos", LocalDate.of(1990, 5, 10), 1,
                Especialidade.ENGENHEIRO, NivelExperiencia.PLENO, 10
        );

        Astronauta a2 = new Astronauta(
                "Fernanda", LocalDate.of(1985, 3, 22), 2,
                Especialidade.MEDICO, NivelExperiencia.SENIOR, 20
        );

        Astronauta a3 = new Astronauta(
                "Marcos", LocalDate.of(1988, 11, 15), 3,
                Especialidade.PILOTO, NivelExperiencia.SENIOR, 15
        );

        Astronauta a4 = new Astronauta(
                "Juliana", LocalDate.of(1995, 7, 30), 4,
                Especialidade.MEDICO, NivelExperiencia.JUNIOR, 64
        );

        Astronauta a5 = new Astronauta(
                "Roberto", LocalDate.of(1982, 1, 12), 5,
                Especialidade.PILOTO, NivelExperiencia.PLENO, 25
        );

        Astronauta a6 = new Astronauta(
                "Beatriz", LocalDate.of(1992, 9, 05), 6,
                Especialidade.ENGENHEIRO, NivelExperiencia.SENIOR, 12
        );

        Astronauta a7 = new Astronauta(
                "André", LocalDate.of(1987, 4, 18), 7,
                Especialidade.CIENTISTA, NivelExperiencia.SENIOR, 18
        );

        Astronauta a8 = new Astronauta(
                "Camila", LocalDate.of(1998, 12, 02), 8,
                Especialidade.ZELADOR, NivelExperiencia.JUNIOR, 3
        );

        Astronauta a9 = new Astronauta(
                "Thiago", LocalDate.of(1991, 6, 25), 9,
                Especialidade.CIENTISTA, NivelExperiencia.PLENO, 11
        );

        Astronauta a10 = new Astronauta(
                "Larissa", LocalDate.of(1984, 8, 14), 10,
                Especialidade.ZELADOR, NivelExperiencia.PLENO, 22
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

        // ==============================
        // Criando Nave
        // ==============================
        Nave nave1 = new Nave(
                estacaoA,
                "Apollo-11",
                TamanhoNave.G,
                StatusNave.DISPONIVEL
        );
        estacaoA.addNaves(nave1);


        // ==============================
        // Criando Missão
        // ==============================
        Missao m1 = new Missao(
                "Missão Marte",
                StatusMissao.PENDENTE,
                2
        );
        estacaoA.addMissao(m1);

        // ==============================
        // Adicionando Missão a nave
        // ==============================
        nave1.setMissao(m1);

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
                NivelExperiencia.SENIOR,
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

        Tarefa t5 = new Tarefa(
                "Coleta de Amostras de Solo",
                Especialidade.CIENTISTA,
                NivelExperiencia.PLENO,
                false
        );

        Tarefa t6 = new Tarefa(
                "Manutenção do Sistema de Oxigênio",
                Especialidade.ENGENHEIRO,
                NivelExperiencia.SENIOR,
                false
        );

        Tarefa t7 = new Tarefa(
                "Limpeza dos Dutos de Ventilação",
                Especialidade.ZELADOR,
                NivelExperiencia.JUNIOR,
                false
        );

        Tarefa t8 = new Tarefa(
                "Cálculo de Rota Hiperespaço",
                Especialidade.PILOTO,
                NivelExperiencia.SENIOR,
                false
        );

        Tarefa t9 = new Tarefa(
                "Sequenciamento Genético Alienígena",
                Especialidade.CIENTISTA,
                NivelExperiencia.SENIOR,
                false
        );

        Tarefa t10 = new Tarefa(
                "Gestão de Resíduos Radioativos",
                Especialidade.ZELADOR,
                NivelExperiencia.PLENO,
                false
        );

        Tarefa t11 = new Tarefa(
                "Recalibrar Propulsores de Manobra",
                Especialidade.ENGENHEIRO,
                NivelExperiencia.PLENO,
                false
        );

        Tarefa t12 = new Tarefa(
                "Substituir Filtros de Sedimentos",
                Especialidade.ENGENHEIRO,
                NivelExperiencia.JUNIOR,
                true
        );

        Tarefa t13 = new Tarefa(
                "Reforçar Blindagem Contra Micrometeoritos",
                Especialidade.ENGENHEIRO,
                NivelExperiencia.PLENO,
                false
        );

        Tarefa t14 = new Tarefa(
                "Inspeção de Rotina nos Cabos de Força",
                Especialidade.ENGENHEIRO,
                NivelExperiencia.JUNIOR,
                false
        );

// Adicionando à missão
        m1.addTarefa(t1);
        m1.addTarefa(t2);
        m1.addTarefa(t3);
        m1.addTarefa(t4);
        m1.addTarefa(t5);
        m1.addTarefa(t6);
        m1.addTarefa(t7);
        m1.addTarefa(t8);
        m1.addTarefa(t9);
        m1.addTarefa(t10);
        m1.addTarefa(t11);
        m1.addTarefa(t12);
        m1.addTarefa(t13);
        m1.addTarefa(t14);
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
        convocacao.Convocar(nave1, a7);
        convocacao.Convocar(nave1, a8);

        // ==============================
        // Atribuindo tarefas
        // ==============================
        t1.setAstronautaResponsavel(a1, t1);
        t1.setAstronautaResponsavel(a1, t11);
        t1.setAstronautaResponsavel(a1, t12);
        t1.setAstronautaResponsavel(a1, t13);
        t1.setAstronautaResponsavel(a1, t14);
        t2.setAstronautaResponsavel(a2, t2);
        t3.setAstronautaResponsavel(a5, t3);
        t4.setAstronautaResponsavel(a4, t4);
        t5.setAstronautaResponsavel(a9, t5);
        t6.setAstronautaResponsavel(a6, t6);
        t7.setAstronautaResponsavel(a8, t7);
        t8.setAstronautaResponsavel(a3, t8);
        t9.setAstronautaResponsavel(a7, t9);
        t10.setAstronautaResponsavel(a10, t10);

        // ==============================
        // QueryDaTripulação
        // ==============================
        QueryNave ListaTripulantes = new QueryNave();

        System.out.println("Lista da Tripulação");
        System.out.println(ListaTripulantes.TodaTripulacao(nave1));
        System.out.println();

        ServiceAlaMedica alaMedica = new ServiceAlaMedica();
        // ==============================
        // Executando tarefas
        // ==============================
        ServiceTarefa serviceTarefa = new ServiceTarefa();

        System.out.println(serviceTarefa.executarTarefa(t1) + "\n");
        System.out.println(serviceTarefa.executarTarefa(t2) + "\n");
        System.out.println(serviceTarefa.executarTarefa(t3) + "\n");
        System.out.println(serviceTarefa.executarTarefa(t4) + "\n");
        System.out.println(serviceTarefa.executarTarefa(t5) + "\n");
        System.out.println(serviceTarefa.executarTarefa(t6) + "\n");
        System.out.println(serviceTarefa.executarTarefa(t7) + "\n");
        System.out.println(serviceTarefa.executarTarefa(t8) + "\n");
        System.out.println(serviceTarefa.executarTarefa(t9) + "\n");
        System.out.println(serviceTarefa.executarTarefa(t10) + "\n");

        System.out.println("\nTarefas executadas.\n");

        // ==============================
        // QueryDaTripulaçãoApósTarefas
        // ==============================
        System.out.println("Lista da Tripulação Após Tarefas");
        System.out.println(ListaTripulantes.TodaTripulacao(nave1));

        // ==============================
        // AlaMedica
        // ==============================
        alaMedica.recuperação(a1);
        alaMedica.recuperação(a2);
        alaMedica.recuperação(a3);
        alaMedica.recuperação(a4);
        alaMedica.recuperação(a5);
        alaMedica.recuperação(a6);
        alaMedica.recuperação(a7);
        alaMedica.recuperação(a8);
        alaMedica.recuperação(a9);
        alaMedica.recuperação(a10);
        System.out.println();

        // ==============================
        // QueryDaTripulaçãoApósAlaMédica
        // ==============================
        System.out.println("Lista da Tripulação Após Ala Médica");
        System.out.println(ListaTripulantes.TodaTripulacao(nave1));
        System.out.println();

        // ==============================
        // Verificando estado final
        // ==============================
        System.out.println("=== MISSÃO ===");
        System.out.println(m1);

        System.out.println();

        System.out.println("=== NAVE ===");
        System.out.println(nave1);

        System.out.println();
        System.out.println("-----------------------------------------------------------------------------------------");
        // ==============================
        // Querys
        // ==============================
        QueryMissao ListaTarefas = new QueryMissao();
        QueryEstacao ListaEstacao = new QueryEstacao();
        QueryAstronauta ListaTarefasIndividual = new QueryAstronauta();
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

        //Busca especifica dentro da estação
        if (ListaEstacao.BuscarMissaoPorNome(estacaoA, "Missão Marte") != null) {
            System.out.println(ListaEstacao.BuscarMissaoPorNome(estacaoA, "Missão Marte"));
        } else {
            System.out.println("Nada encontrado");
        }
        System.out.println("-----------------------------------------------------------------------------------------");

        //Listas dos Astronautas da Estação
        System.out.println("Astronautas:");
        System.out.println(ListaEstacao.TodosAstronautasEstacao(estacaoA));

        System.out.println();

        //Busca especifica dentro da estação
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

        //Busca especifica dentro da estação
        if (ListaEstacao.BuscarNavePorNome(estacaoA, "Apollo-11") != null) {
            System.out.println(ListaEstacao.BuscarNavePorNome(estacaoA, "Apollo-11"));
        } else {
            System.out.println("Nada encontrado");
        }

        //Busca especifica dentro da estação
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

        //Busca especifica de tarefas dentro do astronauta
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

        //Busca especifica dentro da nave da tripulação
        if (ListaTripulantes.TripulantePorId(nave1, 2) != null) {
            System.out.println(ListaTripulantes.TripulantePorId(nave1, 2));
        } else {
            System.out.println("Nada encontrado");
        }
        System.out.println();
        System.out.println("-----------------------------------------------------------------------------------------");
        //--------------------------------------------------------------

        System.out.println("Relatórios");
        ServiceRelatorio serviceRelatorio = new ServiceRelatorio();

        System.out.println("-----------------------------------------------------------------------------------------");

        //Taxa de sucesso individual do astronauta por tarefa
        System.out.println(String.format("Taxa de sucesso individual do astronauta por tarefa: %.2f%%", serviceRelatorio.taxaDeSucessoDoAstronauta(a1)));

        System.out.println("-----------------------------------------------------------------------------------------");

        //Taxa de sucesso dos astronautas daquela estação
        System.out.println(String.format("Taxa de sucesso dos astronautas daquela estação: %.2f%%", serviceRelatorio.taxaDeEstacaoAstronauta(estacaoA)));

        System.out.println("-----------------------------------------------------------------------------------------");

        //Taxa de sucesso das missões da estação
        System.out.println(String.format("Taxa de sucesso das missões da estação: %.2f%%", serviceRelatorio.taxaDeEstacaoMissao(estacaoA)));

        System.out.println("-----------------------------------------------------------------------------------------");

        //Taxa de sucesso das naves por estação
        System.out.println(String.format("Taxa de sucesso das naves por estação: %.2f%%", serviceRelatorio.taxaDeEstacaoNave(estacaoA)));

        System.out.println("-----------------------------------------------------------------------------------------");

        //Taxa de sucesso de tarefas por missão
        System.out.println(String.format("Taxa de sucesso de tarefas por missão: %.2f%%", serviceRelatorio.taxaDeSucessoMissao(m1)));


        System.out.println("-----------------------------------------------------------------------------------------");

        //Taxa de sucesso de tarefas por nave
        System.out.println(String.format("Taxa de sucesso de tarefas por nave: %.2f%%", serviceRelatorio.taxaDeNave(nave1)));
    }

}