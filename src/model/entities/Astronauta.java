package model.entities;

import model.enums.StatusDeSaude;

import java.time.LocalDate;
import java.util.Random;

public final class Astronauta extends Pessoa{
    private String especialidade;
    private int nivelExperiencia;
    private StatusDeSaude saude;

    public Astronauta(int id, String nome, LocalDate data, String especialidade, int nivelExperiencia, StatusDeSaude saude) {
        super(id, nome, data);
        this.especialidade = especialidade;
        this.nivelExperiencia = nivelExperiencia;
        this.saude = saude;
    }

    public String getEspecialidade() {
        return especialidade;
    }

    public void setEspecialidade(String especialidade) {
        this.especialidade = especialidade;
    }

    public int getNivelExperiencia() {
        return nivelExperiencia;
    }

    public void setNivelExperiencia(int nivelExperiencia) {
        this.nivelExperiencia = nivelExperiencia;
    }

    public StatusDeSaude getSaude() {
        return saude;
    }

    public void setSaude(StatusDeSaude saude) {
        this.saude = saude;
    }

    public void executarUmaTarefa(Tarefa t){

        //Caso o status da missão já venha concluida
        if (t.isConcluida()){
            System.out.println("A tarefa já está concluida");
            this.saude = StatusDeSaude.SAUDAVEL;
            return;
        }

        //Caso o austronauta desta missão esteja ferido
        if (this.saude == StatusDeSaude.FERIDO){
            System.out.println("Funcionario ferido, incapaz de executar sua função");
            return;
        }

        Random random = new Random();
        int chance = random.nextInt(10) + 1;

        //Adicionei um random de 1 a 10 para que crie uma possibilidade da dificuldade da tarefa ser maior que sua experiencia
        if (chance <= nivelExperiencia){
            System.out.println("Tarefa concluida");
            t.setConcluida(true);
            this.saude = StatusDeSaude.CANSADO;
            return;
        }
        else {
            System.out.println(getNome() + " Falhou em sua tarefa por falta de experiencia: " + nivelExperiencia);
            this.saude = StatusDeSaude.FERIDO;
            return;
        }

    }

    @Override
    public String toString() {
        StringBuilder msg = new StringBuilder();
        msg.append("Astronauta:" + getNome() + "\n");
        msg.append("id:" + getId() + "\n");
        msg.append("Data de nascimento:" + getData() + "\n");
        msg.append("Especialidade:" + especialidade + "\n");
        msg.append("Nivel de experiência:" + nivelExperiencia + "\n");
        msg.append("Status de saúde:" + saude + "\n");
        return msg.toString();
    }
}
