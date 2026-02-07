package model.entities;

import model.enums.Especialidade;
import model.enums.NivelExperiencia;
import model.enums.StatusSaude;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Astronauta extends Pessoa {
    private Especialidade especialidade;
    private NivelExperiencia nivelExperiencia;
    private StatusSaude statusSaude;
    private Integer fadiga;

    private List<Tarefa> tarefas = new ArrayList<>();

    public Astronauta(UUID id, String nome, LocalDate dataNascimento, Especialidade especialidade, NivelExperiencia nivelExperiencia, StatusSaude statusSaude, Integer fadiga) {
        super(id, nome, dataNascimento);
        this.especialidade = especialidade;
        this.nivelExperiencia = nivelExperiencia;
        this.statusSaude = statusSaude;
        this.fadiga = fadiga;
    }

    public Especialidade getEspecialidade() {
        return especialidade;
    }

    public void setEspecialidade(Especialidade especialidade) {
        this.especialidade = especialidade;
    }

    public NivelExperiencia getNivelExperiencia() {
        return nivelExperiencia;
    }

    public void setNivelExperiencia(NivelExperiencia nivelExperiencia) {
        this.nivelExperiencia = nivelExperiencia;
    }

    public StatusSaude getStatusSaude() {
        return statusSaude;
    }

    public void setStatusSaude(StatusSaude statusSaude) {
        this.statusSaude = statusSaude;
    }

    public Integer getFadiga() {
        return fadiga;
    }

    public void setFadiga(Integer fadiga) {
        this.fadiga = fadiga;
    }

    public void AddTarefas(Tarefa addTarefas){
        this.tarefas.add(addTarefas);
    }

    @Override
    public void setId(UUID id) {
        super.setId(id);
    }

    @Override
    public void setNome(String nome) {
        super.setNome(nome);
    }

    @Override
    public void setDataNascimento(LocalDate dataNascimento) {
        super.setDataNascimento(dataNascimento);
    }

    @Override
    public UUID getId() {
        return super.getId();
    }

    @Override
    public String getNome(){
        return super.getNome();
    }

    @Override
    public LocalDate getDataNascimento(){
        return super.getDataNascimento();
    }

    @Override
    public String toString() {
        return  "Id" + getId() + "\n" +
                "Astronauta:" + getNome() + "\n" +
                "Data de nascimento:" + getDataNascimento() + "\n" +
                "Status de saude:" + statusSaude + "\n" +
                "Nivel de experiencia:" + nivelExperiencia + "\n" +
                "Especialidade:" + especialidade;
    }


}
