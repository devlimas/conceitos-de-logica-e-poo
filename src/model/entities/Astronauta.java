package model.entities;

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
    private StatusSaude statusSaude;
    private Integer fadiga;
    private Relatorio relatorioIndividual;

    //As tarefas atribuidas a esse astronauta de acordo com a missao
    private List<Tarefa> tarefas = new ArrayList<>();

    public Astronauta() {
    }

    public Astronauta(String nome, LocalDate dataNascimento, Integer id, Especialidade especialidade, NivelExperiencia nivelExperiencia, Integer fadiga, Relatorio relatorioIndividual) {
        super(nome, dataNascimento);

        this.id = id;
        this.especialidade = especialidade;
        this.nivelExperiencia = nivelExperiencia;

        if (fadiga <= 45){
            this.fadiga = fadiga;
            this.statusSaude = StatusSaude.SAUDAVEL;
        } else if (fadiga > 45 && fadiga <= 100) {
            this.fadiga = fadiga;
            this.statusSaude = StatusSaude.CANSADO;
        } else if (fadiga > 100) {
            this.fadiga = fadiga;
            this.statusSaude = StatusSaude.FERIDO;
        }

        this.relatorioIndividual = new Relatorio();
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

    public void AddTarefas(Tarefa tarefa){
        tarefas.add(tarefa);
    }

    public List<Tarefa> getTarefas() {
        return tarefas;
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

    @Override
    public String toString() {
        StringBuilder msg = new StringBuilder();
        msg.append("Id: " + getId() + "\n" +
                        "Astronauta: " + getNome() + "\n" +
                        "Data de nascimento: " + getDataNascimento() + "\n" +
                        "Status de saude: " + getStatusSaude() + "\n" +
                        "Fadiga: " + getFadiga() + "\n" +
                        "Nivel de experiencia: " + getNivelExperiencia() + "\n" +
                        "Especialidade: " + getEspecialidade() + "\n" +
                        "Relatorio: " + getRelatorioIndividual()
        );
        return msg.toString();
    }

}
