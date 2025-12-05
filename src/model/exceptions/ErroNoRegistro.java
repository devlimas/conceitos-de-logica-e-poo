package model.exceptions;

public class ErroNoRegistro extends Exception{
    public ErroNoRegistro(String message) {
        super(String.format("Erro no registro"));
    }
}
