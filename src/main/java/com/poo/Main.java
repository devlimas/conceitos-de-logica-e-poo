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
    public static void main(String[] args) {

        ServiceConvocacao convocacao = new ServiceConvocacao();
        ServiceTarefa serviceTarefa = new ServiceTarefa();
        ServiceAlaMedica alaMedica = new ServiceAlaMedica();
        ServiceRelatorio relatorio = new ServiceRelatorio();

        // ======================================================
        // ESTAÇÃO ALPHA
        // ======================================================
        Estacao estacaoAlpha = new Estacao("Estação Orbital Alpha");

        Astronauta a1 = new Astronauta("Carlos",   LocalDate.of(1990, 5, 10), 1,  Especialidade.ENGENHEIRO, NivelExperiencia.PLENO,  10);
        Astronauta a2 = new Astronauta("Fernanda", LocalDate.of(1985, 3, 22), 2,  Especialidade.MEDICO,     NivelExperiencia.SENIOR, 20);
        Astronauta a3 = new Astronauta("Marcos",   LocalDate.of(1988, 11,15), 3,  Especialidade.PILOTO,     NivelExperiencia.SENIOR, 15);
        Astronauta a4 = new Astronauta("Juliana",  LocalDate.of(1995, 7, 30), 4,  Especialidade.MEDICO,     NivelExperiencia.JUNIOR, 40);
        Astronauta a5 = new Astronauta("Roberto",  LocalDate.of(1982, 1, 12), 5,  Especialidade.PILOTO,     NivelExperiencia.PLENO,  25);
        Astronauta a6 = new Astronauta("Beatriz",  LocalDate.of(1992, 9,  5), 6,  Especialidade.ENGENHEIRO, NivelExperiencia.SENIOR, 12);
        Astronauta a7 = new Astronauta("André",    LocalDate.of(1987, 4, 18), 7,  Especialidade.CIENTISTA,  NivelExperiencia.SENIOR, 18);
        Astronauta a8 = new Astronauta("Camila",   LocalDate.of(1998, 12, 2), 8,  Especialidade.ZELADOR,    NivelExperiencia.JUNIOR,  3);

        estacaoAlpha.addAstronautas(a1);
        estacaoAlpha.addAstronautas(a2);
        estacaoAlpha.addAstronautas(a3);
        estacaoAlpha.addAstronautas(a4);
        estacaoAlpha.addAstronautas(a5);
        estacaoAlpha.addAstronautas(a6);
        estacaoAlpha.addAstronautas(a7);
        estacaoAlpha.addAstronautas(a8);

        // Nave 1 - Missão marte (várias tarefas, algumas concluídas)
        Nave nave1 = new Nave(estacaoAlpha, "Apollo-11", TamanhoNave.G, StatusNave.DISPONIVEL);
        estacaoAlpha.addNaves(nave1);

        Missao missaoMarte = new Missao("Missão Marte", StatusMissao.PENDENTE, 3);
        estacaoAlpha.addMissao(missaoMarte);
        nave1.setMissao(missaoMarte);

        Tarefa tM1 = new Tarefa("Reparar Painel Solar",              Especialidade.ENGENHEIRO, NivelExperiencia.PLENO,  false);
        Tarefa tM2 = new Tarefa("Análise Médica da Tripulação",      Especialidade.MEDICO,     NivelExperiencia.SENIOR, false);
        Tarefa tM3 = new Tarefa("Assumir a Pilotagem",               Especialidade.PILOTO,     NivelExperiencia.PLENO,  false);
        Tarefa tM4 = new Tarefa("Ajudar os Feridos",                 Especialidade.MEDICO,     NivelExperiencia.JUNIOR, false);
        Tarefa tM5 = new Tarefa("Manutenção do Sistema de Oxigênio", Especialidade.ENGENHEIRO, NivelExperiencia.SENIOR, false);
        Tarefa tM6 = new Tarefa("Limpeza dos Dutos de Ventilação",   Especialidade.ZELADOR,    NivelExperiencia.JUNIOR, false);
        Tarefa tM7 = new Tarefa("Cálculo de Rota Hiperespaço",       Especialidade.PILOTO,     NivelExperiencia.SENIOR, false);

        missaoMarte.addTarefa(tM1);
        missaoMarte.addTarefa(tM2);
        missaoMarte.addTarefa(tM3);
        missaoMarte.addTarefa(tM4);
        missaoMarte.addTarefa(tM5);
        missaoMarte.addTarefa(tM6);
        missaoMarte.addTarefa(tM7);

        convocacao.Convocar(nave1, a1);
        convocacao.Convocar(nave1, a2);
        convocacao.Convocar(nave1, a3);
        convocacao.Convocar(nave1, a4);
        convocacao.Convocar(nave1, a5);
        convocacao.Convocar(nave1, a6);
        convocacao.Convocar(nave1, a7);
        convocacao.Convocar(nave1, a8);

        tM1.setAstronautaResponsavel(a1, tM1);
        tM2.setAstronautaResponsavel(a2, tM2);
        tM3.setAstronautaResponsavel(a5, tM3);
        tM4.setAstronautaResponsavel(a4, tM4);
        tM5.setAstronautaResponsavel(a6, tM5);
        tM6.setAstronautaResponsavel(a8, tM6);
        tM7.setAstronautaResponsavel(a3, tM7);

        // Executando algumas tarefas (não todas, para criar uma taxa variada)
        serviceTarefa.executarTarefa(tM1);
        serviceTarefa.executarTarefa(tM2);
        serviceTarefa.executarTarefa(tM3);
        serviceTarefa.executarTarefa(tM6);
        // tM4, tM5, tM7 não executadas — ficam como false

        // Nave 2 - missão Lua (poucos tripulantes, alta taxa de sucesso)
        Nave nave2 = new Nave(estacaoAlpha, "Artemis-I", TamanhoNave.P, StatusNave.DISPONIVEL);
        estacaoAlpha.addNaves(nave2);

        // Recuperando astronautas usados na nave1 para usar na nave2
        alaMedica.recuperação(a1);
        alaMedica.recuperação(a2);
        alaMedica.recuperação(a3);
        alaMedica.recuperação(a4);
        alaMedica.recuperação(a5);
        alaMedica.recuperação(a6);
        alaMedica.recuperação(a7);
        alaMedica.recuperação(a8);

        // Resetando disponibilidade manualmente para reutilizar no exemplo
        a6.setDisponibilidade(Disponibilidade.DISPONIVEL);
        a7.setDisponibilidade(Disponibilidade.DISPONIVEL);
        a8.setDisponibilidade(Disponibilidade.DISPONIVEL);

        Missao missaoLua = new Missao("Missão Lua", StatusMissao.PENDENTE, 1);
        estacaoAlpha.addMissao(missaoLua);
        nave2.setMissao(missaoLua);

        Tarefa tL1 = new Tarefa("Instalar Antena de Comunicação",  Especialidade.ENGENHEIRO, NivelExperiencia.SENIOR, false);
        Tarefa tL2 = new Tarefa("Coleta de Amostras Lunares",      Especialidade.CIENTISTA,  NivelExperiencia.SENIOR, false);
        Tarefa tL3 = new Tarefa("Esterilização do Módulo",         Especialidade.ZELADOR,    NivelExperiencia.JUNIOR, false);

        missaoLua.addTarefa(tL1);
        missaoLua.addTarefa(tL2);
        missaoLua.addTarefa(tL3);

        convocacao.Convocar(nave2, a6);
        convocacao.Convocar(nave2, a7);
        convocacao.Convocar(nave2, a8);

        tL1.setAstronautaResponsavel(a6, tL1);
        tL2.setAstronautaResponsavel(a7, tL2);
        tL3.setAstronautaResponsavel(a8, tL3);

        // Todas as tarefas da missão Lua concluídas - taxa 100%
        serviceTarefa.executarTarefa(tL1);
        serviceTarefa.executarTarefa(tL2);
        serviceTarefa.executarTarefa(tL3);

        // ======================================================
        // ESTAÇÃO BETA
        // ======================================================
        Estacao estacaoBeta = new Estacao("Estação Orbital Beta");

        Astronauta b1 = new Astronauta("Sofia",    LocalDate.of(1993, 2, 14), 11, Especialidade.CIENTISTA,  NivelExperiencia.SENIOR, 5);
        Astronauta b2 = new Astronauta("Diego",    LocalDate.of(1989, 7,  3), 12, Especialidade.PILOTO,     NivelExperiencia.PLENO,  30);
        Astronauta b3 = new Astronauta("Leticia",  LocalDate.of(1996, 11,22), 13, Especialidade.MEDICO,     NivelExperiencia.PLENO,  18);
        Astronauta b4 = new Astronauta("Ricardo",  LocalDate.of(1983, 4, 10), 14, Especialidade.ENGENHEIRO, NivelExperiencia.SENIOR, 8);
        Astronauta b5 = new Astronauta("Priscila", LocalDate.of(1991, 9, 17), 15, Especialidade.ZELADOR,    NivelExperiencia.PLENO,  22);
        Astronauta b6 = new Astronauta("Gustavo",  LocalDate.of(1986, 6, 29), 16, Especialidade.PILOTO,     NivelExperiencia.SENIOR, 14);

        estacaoBeta.addAstronautas(b1);
        estacaoBeta.addAstronautas(b2);
        estacaoBeta.addAstronautas(b3);
        estacaoBeta.addAstronautas(b4);
        estacaoBeta.addAstronautas(b5);
        estacaoBeta.addAstronautas(b6);

        // Nave 3 — Missão Europa (taxa baixa - muitas tarefas, poucas concluídas)
        Nave nave3 = new Nave(estacaoBeta, "Voyager-X", TamanhoNave.M, StatusNave.DISPONIVEL);
        estacaoBeta.addNaves(nave3);

        Missao missaoEuropa = new Missao("Missão Europa", StatusMissao.PENDENTE, 2);
        estacaoBeta.addMissao(missaoEuropa);
        nave3.setMissao(missaoEuropa);

        Tarefa tE1 = new Tarefa("Perfurar Crosta de Gelo",               Especialidade.ENGENHEIRO, NivelExperiencia.SENIOR, false);
        Tarefa tE2 = new Tarefa("Analisar Composição da Água",           Especialidade.CIENTISTA,  NivelExperiencia.SENIOR, false);
        Tarefa tE3 = new Tarefa("Monitorar Sinais de Vida",              Especialidade.CIENTISTA,  NivelExperiencia.SENIOR, false);
        Tarefa tE4 = new Tarefa("Manobra de Aproximação",                Especialidade.PILOTO,     NivelExperiencia.SENIOR, false);
        Tarefa tE5 = new Tarefa("Triagem Médica Pós-Mergulho",           Especialidade.MEDICO,     NivelExperiencia.PLENO,  false);
        Tarefa tE6 = new Tarefa("Descarte de Resíduos Químicos",         Especialidade.ZELADOR,    NivelExperiencia.PLENO,  false);

        missaoEuropa.addTarefa(tE1);
        missaoEuropa.addTarefa(tE2);
        missaoEuropa.addTarefa(tE3);
        missaoEuropa.addTarefa(tE4);
        missaoEuropa.addTarefa(tE5);
        missaoEuropa.addTarefa(tE6);

        convocacao.Convocar(nave3, b1);
        convocacao.Convocar(nave3, b2);
        convocacao.Convocar(nave3, b3);
        convocacao.Convocar(nave3, b4);
        convocacao.Convocar(nave3, b5);
        convocacao.Convocar(nave3, b6);

        tE1.setAstronautaResponsavel(b4, tE1);
        tE2.setAstronautaResponsavel(b1, tE2);
        tE3.setAstronautaResponsavel(b1, tE3);
        tE4.setAstronautaResponsavel(b6, tE4);
        tE5.setAstronautaResponsavel(b3, tE5);
        tE6.setAstronautaResponsavel(b5, tE6);

        // Apenas 2 de 6 tarefas concluídas — taxa ~33%
        serviceTarefa.executarTarefa(tE1);
        serviceTarefa.executarTarefa(tE4);
        // tE2, tE3, tE5, tE6 não executadas

        // ======================================================
        // RELATÓRIOS FINAIS
        // ======================================================
        System.out.println("\n╔══════════════════════════════════════════════════╗");
        System.out.println("║             RELATÓRIO GERAL DO SISTEMA           ║");
        System.out.println("╚══════════════════════════════════════════════════╝\n");

        System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
        System.out.println("  ESTAÇÃO ALPHA");
        System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
        System.out.println(String.format("  Taxa de sucesso por astronautas : %.2f%%", relatorio.taxaDeEstacaoAstronauta(estacaoAlpha)));
        System.out.println(String.format("  Taxa de sucesso por missões     : %.2f%%", relatorio.taxaDeEstacaoMissao(estacaoAlpha)));
        System.out.println(String.format("  Taxa de sucesso por naves       : %.2f%%", relatorio.taxaDeEstacaoNave(estacaoAlpha)));
        System.out.println();
        System.out.println("OBS: existe apenas uma missão e uma nave em cada estação, por isso as taxas iguais");

        System.out.println("\n  [ Missão Marte ]");
        System.out.println(String.format("    Taxa da missão   : %.2f%%", relatorio.taxaDeSucessoMissao(missaoMarte)));

        System.out.println("\n  [ Missão Lua ]");
        System.out.println(String.format("    Taxa da missão   : %.2f%%", relatorio.taxaDeSucessoMissao(missaoLua)));

        System.out.println("\n  [ Astronautas Destaque - Alpha ]");
        System.out.println(String.format("    Carlos  (Engenheiro PLENO)  : %.2f%%", relatorio.taxaDeSucessoDoAstronauta(a1)));
        System.out.println(String.format("    Fernanda (Médico SENIOR)    : %.2f%%", relatorio.taxaDeSucessoDoAstronauta(a2)));
        System.out.println(String.format("    Beatriz (Engenheiro SENIOR) : %.2f%%", relatorio.taxaDeSucessoDoAstronauta(a6)));
        System.out.println(String.format("    André   (Cientista SENIOR)  : %.2f%%", relatorio.taxaDeSucessoDoAstronauta(a7)));

        System.out.println("\n━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
        System.out.println("  ESTAÇÃO BETA");
        System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
        System.out.println(String.format("  Taxa de sucesso por astronautas : %.2f%%", relatorio.taxaDeEstacaoAstronauta(estacaoBeta)));
        System.out.println(String.format("  Taxa de sucesso por missões     : %.2f%%", relatorio.taxaDeEstacaoMissao(estacaoBeta)));
        System.out.println(String.format("  Taxa de sucesso por naves       : %.2f%%", relatorio.taxaDeEstacaoNave(estacaoBeta)));
        System.out.println();
        System.out.println("OBS: existe apenas uma missão e uma nave em cada estação, por isso as taxas iguais");

        System.out.println("\n  [ Missão Europa ]");
        System.out.println(String.format("    Taxa da missão   : %.2f%%", relatorio.taxaDeSucessoMissao(missaoEuropa)));

        System.out.println("\n  [ Astronautas Destaque - Beta ]");
        System.out.println(String.format("    Sofia   (Cientista SENIOR)   : %.2f%%", relatorio.taxaDeSucessoDoAstronauta(b1)));
        System.out.println(String.format("    Ricardo (Engenheiro SENIOR)  : %.2f%%", relatorio.taxaDeSucessoDoAstronauta(b4)));
        System.out.println(String.format("    Gustavo (Piloto SENIOR)      : %.2f%%", relatorio.taxaDeSucessoDoAstronauta(b6)));

        System.out.println("\n━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");

        // ======================================================
        // QUERIES
        // ======================================================
        QueryNave queryNave           = new QueryNave();
        QueryMissao queryMissao       = new QueryMissao();
        QueryEstacao queryEstacao     = new QueryEstacao();
        QueryAstronauta queryAstronauta = new QueryAstronauta();

        System.out.println("\n╔══════════════════════════════════════════════════╗");
        System.out.println("║                    QUERIES                       ║");
        System.out.println("╚══════════════════════════════════════════════════╝\n");

        System.out.println("[ Tripulação da Apollo-11 ]");
        System.out.println(queryNave.TodaTripulacao(nave1));

        System.out.println("[ Busca tripulante por ID=2 na Apollo-11 ]");
        System.out.println(queryNave.TripulantePorId(nave1, 2));

        System.out.println("[ Tarefas da Missão Europa ]");
        System.out.println(queryMissao.TodasTarefasDaMissao(missaoEuropa));

        System.out.println("[ Busca missão 'Missão Lua' na Estação Alpha ]");
        System.out.println(queryEstacao.BuscarMissaoPorNome(estacaoAlpha, "Missão Lua"));

        System.out.println("[ Tarefas individuais do astronauta Carlos ]");
        System.out.println(queryAstronauta.TodasTarefasIndividuais(a1));

        System.out.println("[ Busca nave 'Voyager-X' na Estação Beta ]");
        System.out.println(queryEstacao.BuscarNavePorNome(estacaoBeta, "Voyager-X"));
    }
}
