import model.entities.Astronauta;
import model.entities.Missao;
import model.enums.Especialidade;
import model.enums.NivelExperiencia;
import model.enums.StatusMissao;
import model.enums.StatusSaude;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args){

        Astronauta astronauta1 = new Astronauta("Yuri Prado", LocalDate.of(2003,10,1), 19, Especialidade.ENGENHEIRO, NivelExperiencia.JUNIOR, StatusSaude.SAUDAVEL, 0, null);

        Astronauta astronauta2 = new Astronauta("Alice Ferro", LocalDate.of(2001,3,6), 12, Especialidade.ENGENHEIRO, NivelExperiencia.PLENO, StatusSaude.SAUDAVEL, 0, null);

        Astronauta astronauta3 = new Astronauta("Pedro Texeira", LocalDate.of(2005,1,8), 9, Especialidade.MEDICO, NivelExperiencia.SENIOR, StatusSaude.SAUDAVEL, 0, null);

        Astronauta astronauta4 = new Astronauta("Mario Paulo", LocalDate.of(2003,4,12), 1, Especialidade.ENGENHEIRO, NivelExperiencia.SENIOR, StatusSaude.CANSADO, 100, null);

        Astronauta astronauta5 = new Astronauta("Livia Rocha", LocalDate.of(2002,9,21), 3, Especialidade.ENGENHEIRO, NivelExperiencia.JUNIOR, StatusSaude.FERIDO, 120, null);

        //Missao disponiveis

        List<Missao> missoes = new ArrayList<>();

        Missao missoao1 = new Missao("Visita a marte" ,StatusMissao.PENDENTE, 2, null, null);
        Missao missoao2 = new Missao("Visita a lua" ,StatusMissao.PENDENTE, 1, null, null);
        Missao missoao3 = new Missao("Visita a plutao" ,StatusMissao.PENDENTE, 2, null, null);

    }

}