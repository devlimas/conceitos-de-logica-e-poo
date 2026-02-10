package model.enums;

public enum TamanhoNave {
    P(4),
    M(6),
    G(8);

    final int maxTripulantes;

    TamanhoNave(int maxTripulantes) {
        this.maxTripulantes = maxTripulantes;
    }
}
