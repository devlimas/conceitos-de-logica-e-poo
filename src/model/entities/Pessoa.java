package model.entities;

import java.time.LocalDate;

public abstract class Pessoa {
    private int id;
    private String nome;
    private LocalDate data;

    public Pessoa(int id, String nome, LocalDate data) {
        this.id = id;
        this.nome = nome;
        this.data = data;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }
}
