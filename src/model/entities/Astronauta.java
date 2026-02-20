package model.entities;

import model.enums.Disponibilidade;
import model.enums.Especialidade;
import model.enums.NivelExperiencia;
import model.enums.StatusSaude;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Astronauta extends Pessoa {

    //A escolhe de Integer em vez de UUID foi feita, pelo motivo que eu nao queria um ID grande e feito com String como: 245a8650-e29b-41d4-a716-446655440000
    private Integer id;
    private Especialidade especialidade;
    private NivelExperiencia nivelExperiencia;
    private Disponibilidade disponibilidade;
    private StatusSaude statusSaude;
    private Integer fadiga;
    private Relatorio relatorioIndividual;

    //As tarefas atribuidas a esse astronauta de acordo com a missao
    private List<Tarefa> tarefas = new ArrayList<>();

    public Astronauta() {
    }

    public Astronauta(String nome, LocalDate dataNascimento, Integer id, Especialidade especialidade, NivelExperiencia nivelExperiencia, Integer fadiga) {
        super(nome, dataNascimento);

        this.id = id;
        this.especialidade = especialidade;
        this.nivelExperiencia = nivelExperiencia;

        if (fadiga <= 45){
            this.fadiga = fadiga;
            this.statusSaude = StatusSaude.SAUDAVEL;
        }
        else if (fadiga > 45 && fadiga <= 100) {
            this.fadiga = fadiga;
            this.statusSaude = StatusSaude.CANSADO;
        }
        else if (fadiga > 100) {
            this.fadiga = fadiga;
            this.statusSaude = StatusSaude.FERIDO;
        }
        this.disponibilidade = Disponibilidade.DISPONIVEL;
    }

    public Disponibilidade getDisponibilidade() {
        return disponibilidade;
    }

    public void setDisponibilidade(Disponibilidade disponibilidade) {
        this.disponibilidade = disponibilidade;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public Relatorio getRelatorioIndividual() {
        return relatorioIndividual;
    }

    public void setRelatorioIndividual(Relatorio relatorioIndividual) {
        this.relatorioIndividual = relatorioIndividual;
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
    public String getNome(){
        return super.getNome();
    }

    @Override
    public LocalDate getDataNascimento(){
        return super.getDataNascimento();
    }

    //Ações da lista
    public List<Tarefa> getTarefas() {
        return tarefas;
    }

    public void AddTarefas(Tarefa tarefa){
        for (Tarefa leitor: tarefas){
            if (leitor.getNomeTarefa().equals(tarefa.getNomeTarefa())){
                throw new IllegalArgumentException("Tarefa existente");
            }
        }
        tarefas.add(tarefa);
    }

    @Override
    public String toString() {
        return new StringBuilder()
                .append("\n")
                .append("Id: ").append(getId()).append("\n")
                .append("Astronauta: ").append(getNome()).append("\n")
                .append("Data de nascimento: ").append(getDataNascimento()).append("\n")
                .append("Status de saude: ").append(getStatusSaude()).append("\n")
                .append("Fadiga: ").append(getFadiga()).append("\n")
                .append("Nivel de experiencia: ").append(getNivelExperiencia()).append("\n")
                .append("Especialidade: ").append(getEspecialidade()).append("\n")
                .toString();
    }
}
