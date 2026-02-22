package com.poo.enums;

public enum NivelExperiencia {
    JUNIOR,
    PLENO,
    SENIOR;

    public boolean CargoSuperior(NivelExperiencia nivelExigido) {
        return this.ordinal() >= nivelExigido.ordinal();
    }
}
