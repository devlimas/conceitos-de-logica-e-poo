package model.entities;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

//Classe abstrata de Pessoa para Astronauta
public abstract class Pessoa {
    private String nome;
    private LocalDate dataNascimento;

    public Pessoa(String nome, LocalDate dataNascimento) {
        this.nome = nome;

        if (ChronoUnit.YEARS.between(dataNascimento, LocalDate.now()) >= 18) {
            this.dataNascimento = dataNascimento;
        }
        else {

        }

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
