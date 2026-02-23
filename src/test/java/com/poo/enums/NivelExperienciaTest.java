package com.poo.enums;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class NivelExperienciaTest {

    @Test
    public void testCargoSuperiorJunior() {
        assertFalse(NivelExperiencia.JUNIOR.CargoSuperior(NivelExperiencia.PLENO));
        assertFalse(NivelExperiencia.JUNIOR.CargoSuperior(NivelExperiencia.SENIOR));
        assertTrue(NivelExperiencia.JUNIOR.CargoSuperior(NivelExperiencia.JUNIOR));
    }

    @Test
    public void testCargoSuperiorPleno() {
        assertTrue(NivelExperiencia.PLENO.CargoSuperior(NivelExperiencia.JUNIOR));
        assertFalse(NivelExperiencia.PLENO.CargoSuperior(NivelExperiencia.SENIOR));
        assertTrue(NivelExperiencia.PLENO.CargoSuperior(NivelExperiencia.PLENO));
    }

    @Test
    public void testCargoSuperiorSenior() {
        assertTrue(NivelExperiencia.SENIOR.CargoSuperior(NivelExperiencia.JUNIOR));
        assertTrue(NivelExperiencia.SENIOR.CargoSuperior(NivelExperiencia.PLENO));
        assertTrue(NivelExperiencia.SENIOR.CargoSuperior(NivelExperiencia.SENIOR));
    }
}