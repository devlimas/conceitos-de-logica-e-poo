package com.poo.exceptions;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class ExceptionsTest {

    @Test
    public void testIdadeMinima() {
        assertThrows(IdadeMinima.class, () -> {
            throw new IdadeMinima("Idade mínima não atingida");
        });
    }

    @Test
    public void testExistente() {
        assertThrows(Existente.class, () -> {
            throw new Existente("Entidade já existe");
        });
    }

    @Test
    public void testPrioridade() {
        assertThrows(Prioridade.class, () -> {
            throw new Prioridade("Prioridade inválida");
        });
    }

    @Test
    public void testAstronautaStatus() {
        assertThrows(AstronautaStatus.class, () -> {
            throw new AstronautaStatus("Astronauta em status inválido");
        });
    }

    @Test
    public void testIndisponivel() {
        assertThrows(Indisponivel.class, () -> {
            throw new Indisponivel("Astronauta indisponível");
        });
    }

    @Test
    public void testLimiteTripulantes() {
        assertThrows(LimiteTripulantes.class, () -> {
            throw new LimiteTripulantes("Limite de tripulantes atingido");
        });
    }

    @Test
    public void testIdadeMinimaMessage() {
        try {
            throw new IdadeMinima("Teste mensagem");
        } catch (IdadeMinima e) {
            assertEquals("Teste mensagem", e.getMessage());
        }
    }

    @Test
    public void testExistenteMessage() {
        try {
            throw new Existente("Já existe");
        } catch (Existente e) {
            assertEquals("Já existe", e.getMessage());
        }
    }
}