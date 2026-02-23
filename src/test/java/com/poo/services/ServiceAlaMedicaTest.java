package com.poo.services;

import com.poo.entities.Astronauta;
import com.poo.enums.Especialidade;
import com.poo.enums.NivelExperiencia;
import com.poo.enums.StatusSaude;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ServiceAlaMedicaTest {

    private ServiceAlaMedica alaMedica;
    private Astronauta astronauta;

    @BeforeEach
    public void setUp() {
        alaMedica = new ServiceAlaMedica();

        astronauta = new Astronauta(
                "Carlos",
                LocalDate.of(1990, 5, 10),
                1,
                Especialidade.ENGENHEIRO,
                NivelExperiencia.PLENO,
                110 //Fadiga alta, status FERIDO
        );
    }

    @Test
    public void testRecuperacaoAstronauta() {
        assertEquals(StatusSaude.FERIDO, astronauta.getStatusSaude());

        String resultado = alaMedica.recuperação(astronauta);

        assertEquals(0, astronauta.getFadiga().intValue());
        assertEquals(StatusSaude.SAUDAVEL, astronauta.getStatusSaude());
        assertNotNull(resultado);
        assertTrue(resultado.contains("Carlos"));
        assertTrue(resultado.contains("SAUDAVEL"));
    }

    @Test
    public void testRecuperacaoAstronautaCansado() {
        Astronauta cansado = new Astronauta(
                "Maria",
                LocalDate.of(1988, 1, 1),
                2,
                Especialidade.MEDICO,
                NivelExperiencia.SENIOR,
                70 //Status CANSADO
        );

        assertEquals(StatusSaude.CANSADO, cansado.getStatusSaude());

        alaMedica.recuperação(cansado);

        assertEquals(0, cansado.getFadiga().intValue());
        assertEquals(StatusSaude.SAUDAVEL, cansado.getStatusSaude());
    }

    @Test
    public void testRecuperacaoRetornaString() {
        String resultado = alaMedica.recuperação(astronauta);
        assertNotNull(resultado);
    }
}