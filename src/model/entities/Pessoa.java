package model.entities;

import model.exceptions.IdadeMinima;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

//Classe abstrata de Pessoa para Astronauta
public abstract class Pessoa {
    private String nome;
    private LocalDate dataNascimento;

    public Pessoa() {
    }

    public Pessoa(String nome, LocalDate dataNascimento) {
        this.nome = nome;

        if (ChronoUnit.YEARS.between(dataNascimento, LocalDate.now()) < 18) {
            throw new IdadeMinima("Erro, idade minima de 18 anos");
        }

        this.dataNascimento = dataNascimento;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }
}
