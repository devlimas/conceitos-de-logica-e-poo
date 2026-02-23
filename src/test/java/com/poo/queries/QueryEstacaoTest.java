package com.poo.queries;

import com.poo.entities.Astronauta;
import com.poo.entities.Estacao;
import com.poo.entities.Missao;
import com.poo.entities.Nave;
import com.poo.enums.Especialidade;
import com.poo.enums.NivelExperiencia;
import com.poo.enums.StatusMissao;
import com.poo.enums.StatusNave;
import com.poo.enums.TamanhoNave;

import java.time.LocalDate;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class QueryEstacaoTest {

    private QueryEstacao query;
    private Estacao estacao;
    private Astronauta astronauta;
    private Nave nave;
    private Missao missao;

    @BeforeEach
    public void setUp() {
        query = new QueryEstacao();
        estacao = new Estacao("Estação Alpha");

        astronauta = new Astronauta(
                "Carlos",
                LocalDate.of(1990, 5, 10),
                1,
                Especialidade.ENGENHEIRO,
                NivelExperiencia.PLENO,
                10
        );

        nave = new Nave(estacao, "Apollo-11", TamanhoNave.M, StatusNave.DISPONIVEL);
        missao = new Missao("Missão Marte", StatusMissao.PENDENTE, 2);
    }

    @Test
    public void testTodosAstronautasEstacao() {
        estacao.addAstronautas(astronauta);

        List<Astronauta> resultado = query.TodosAstronautasEstacao(estacao);
        assertEquals(1, resultado.size());
        assertEquals("Carlos", resultado.get(0).getNome());
    }

    @Test
    public void testBuscarAstronautaEstacaoPorId() {
        estacao.addAstronautas(astronauta);

        Astronauta resultado = query.BuscarAstronautaEstacaoPorId(estacao, 1);
        assertNotNull(resultado);
        assertEquals("Carlos", resultado.getNome());
    }

    @Test
    public void testBuscarAstronautaEstacaoPorIdNaoExistente() {
        Astronauta resultado = query.BuscarAstronautaEstacaoPorId(estacao, 999);
        assertNull(resultado);
    }

    @Test
    public void testTodasEstacaoNaves() {
        estacao.addNaves(nave);

        List<Nave> resultado = query.TodasEstacaoNaves(estacao);
        assertEquals(1, resultado.size());
    }

    @Test
    public void testBuscarNavePorNome() {
        estacao.addNaves(nave);

        Nave resultado = query.BuscarNavePorNome(estacao, "Apollo-11");
        assertNotNull(resultado);
        assertEquals("Apollo-11", resultado.getNomeNave());
    }

    @Test
    public void testTodasMissoes() {
        estacao.addMissao(missao);

        List<Missao> resultado = query.TodasMissoes(estacao);
        assertEquals(1, resultado.size());
    }

    @Test
    public void testBuscarMissaoPorNome() {
        estacao.addMissao(missao);

        Missao resultado = query.BuscarMissaoPorNome(estacao, "Missão Marte");
        assertNotNull(resultado);
        assertEquals("Missão Marte", resultado.getNomeMissao());
    }
}