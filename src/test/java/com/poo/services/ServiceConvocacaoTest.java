package com.poo.services;

import com.poo.entities.Astronauta;
import com.poo.entities.Estacao;
import com.poo.entities.Nave;
import com.poo.enums.Disponibilidade;
import com.poo.enums.Especialidade;
import com.poo.enums.NivelExperiencia;
import com.poo.enums.StatusNave;
import com.poo.enums.TamanhoNave;
import com.poo.exceptions.Indisponivel;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ServiceConvocacaoTest {

    private ServiceConvocacao convocacao;
    private Estacao estacao;
    private Nave nave;
    private Astronauta astronauta;

    @BeforeEach
    public void setUp() {
        convocacao = new ServiceConvocacao();
        estacao = new Estacao("Estação Alpha");
        nave = new Nave(estacao, "Apollo-11", TamanhoNave.M, StatusNave.DISPONIVEL);

        astronauta = new Astronauta(
                "Carlos",
                LocalDate.of(1990, 5, 10),
                1,
                Especialidade.ENGENHEIRO,
                NivelExperiencia.PLENO,
                10
        );

        estacao.addAstronautas(astronauta);
    }

    @Test
    public void testConvocarComSucesso() {
        String resultado = convocacao.Convocar(nave, astronauta);

        assertEquals(Disponibilidade.CONVOCADO, astronauta.getDisponibilidade());
        assertEquals(1, nave.getTripulantes().size());
        assertNotNull(resultado);
        assertTrue(resultado.contains("Apollo-11"));
    }

    @Test
    public void testConvocarAstronautaJaConvocado() {
        //A primeira convocação deve ocorrer sem erros
        convocacao.Convocar(nave, astronauta);

        //A segunda convocação do mesmo astronauta deve lançar Indisponivel
        assertThrows(Indisponivel.class, () -> {
            convocacao.Convocar(nave, astronauta);
        });
    }

    @Test
    public void testConvocarMultiplosAstronautas() {
        Astronauta a2 = new Astronauta(
                "Maria",
                LocalDate.of(1988, 1, 1),
                2,
                Especialidade.MEDICO,
                NivelExperiencia.SENIOR,
                20
        );

        estacao.addAstronautas(a2);

        convocacao.Convocar(nave, astronauta);
        convocacao.Convocar(nave, a2);

        assertEquals(2, nave.getTripulantes().size());
    }
}