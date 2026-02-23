package com.poo.services;

import com.poo.entities.*;

import java.util.List;

public class ServiceRelatorio {

    private Double porcetagem;

    public ServiceRelatorio() {
    }

    //ServiceRelatorio individual do astronauta
    public double taxaDeSucessoDoAstronauta(Astronauta astronauta){
        int contador = 0;

        if (astronauta.getTarefas().isEmpty()){
            System.out.print("O astronauta não possui nenhuma tarefa registrada, quantidade: ");
            return 0;
        }

        for (Tarefa leitor: astronauta.getTarefas()){
            if (leitor.getConcluida()){
                contador++;
            }
        }

        return ( (double) contador/astronauta.getTarefas().size()) * 100;
    }

    //ServiceRelatorio de tarefas finalizadas da missao
    public double taxaDeSucessoMissao(Missao missao){
        int contador = 0;

        if (missao.getTarefas().isEmpty()){
            System.out.print("A missão não possui nenhuma tarefa registrada, quantidade: ");
            return 0;
        }

        for (Tarefa leitor: missao.getTarefas()){
            if (leitor.getConcluida()){
                contador++;
            }
        }


        return ( (double) contador/missao.getTarefas().size()) * 100;
    }

    //Astronautas e suas taxas de sucesso por tarefa
    public double taxaDeEstacaoAstronauta(Estacao estacao){
        int contador = 0;
        int totalGeralTarefas = 0;

        if (estacao.getAstronautas().isEmpty()){
            System.out.print("A estação não possui nenhum astronauta registrado, quantidade: ");
            return 0;
        }

        for (Astronauta leitor : estacao.getAstronautas()){

            //Pegar a quantidade de tarefas de cada astronauta
            totalGeralTarefas += leitor.getTarefas().size();

            for (Tarefa leitor2 : leitor.getTarefas()){
                if (leitor2.getConcluida()){
                    contador++;
                }
            }
        }

        if (totalGeralTarefas == 0){
            System.out.print("Lista de tarefas não possui nenhuma tarefa, lista total: ");
            return 0;
        }
        return  ( (double) contador/totalGeralTarefas) * 100;
    }

    //Naves da estação, suas missões e suas tarefas com sucesso
    public double taxaDeEstacaoNave(Estacao estacao) {
        int contador = 0;
        int totalGeralTarefas = 0;

        if (estacao.getNaves().isEmpty()) {
            System.out.print("A estação não possui naves registradas, quantidade: ");
            return 0;
        }

        for (Nave leitor : estacao.getNaves()) {

            if (leitor.getMissao() == null) {
                continue;
            }

            List<Tarefa> tarefas = leitor.getMissao().getTarefas();
            totalGeralTarefas += tarefas.size();

            for (Tarefa tarefa : tarefas) {
                if (tarefa.getConcluida()) {
                    contador++;
                }
            }
        }

        if (totalGeralTarefas == 0) {
            System.out.print("As missões não possui tarefas, quantidade: ");
            return 0;
        }
        return ( (double) contador / totalGeralTarefas) * 100;
    }

    public double taxaDeEstacaoMissao(Estacao estacao){
        int contador = 0;
        int totalGeralTarefas = 0;

        if (estacao.getMissoes().isEmpty()){
            System.out.print("A estação não possui nenhuma missão registradas, quantidade: ");
            return 0;
        }

        for (Missao leitor: estacao.getMissoes()){
            totalGeralTarefas += leitor.getTarefas().size();

            for (Tarefa leitor2: leitor.getTarefas()){
                if (leitor2.getConcluida()){
                    contador++;
                }
            }
        }

        if (totalGeralTarefas == 0) {
            System.out.print("As missões não possui tarefas, quantidade: ");
            return 0;
        }
        return ( (double) contador / totalGeralTarefas) * 100;
    }

    public double taxaDeNave(Nave nave){

        if (nave.getMissao() == null){
            System.out.print("A Nave não possui nenhuma missão registradas, quantidade: ");
            return 0;
        }

        List<Tarefa> tarefas = nave.getMissao().getTarefas();

        if (tarefas.isEmpty()) {
            System.out.print("A missão não possui nenhuma tarefa");
            return 0;
        }

        int contador = 0;

        for (Tarefa tarefa : tarefas){
            if (tarefa.getConcluida()){
                contador++;
            }
        }
        return ((double) contador / tarefas.size()) * 100;
    }
}