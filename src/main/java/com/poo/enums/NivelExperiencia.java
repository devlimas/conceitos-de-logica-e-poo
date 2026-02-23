package com.poo.enums;

public enum NivelExperiencia {
    JUNIOR,
    PLENO,
    SENIOR;

    //Junior < Pleno < Senior, O senior consegue fazer atividade do pleno e junior, mas o junior não consegue fazer do pleno e senior, por ser de experiência baixa
    public boolean CargoSuperior(NivelExperiencia nivelExigido) {
        return this.ordinal() >= nivelExigido.ordinal();
    }
}
