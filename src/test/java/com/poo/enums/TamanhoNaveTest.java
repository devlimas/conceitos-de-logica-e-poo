package com.poo.enums;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TamanhoNaveTest {

    @Test
    public void testTamanhoP() {
        assertEquals(4, TamanhoNave.P.getMaxTripulantes());
    }

    @Test
    public void testTamanhoM() {
        assertEquals(6, TamanhoNave.M.getMaxTripulantes());
    }

    @Test
    public void testTamanhoG() {
        assertEquals(8, TamanhoNave.G.getMaxTripulantes());
    }
}