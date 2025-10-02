package br.com.alura.reservas.exception;

public class UsuarioJaCadastradoException extends RuntimeException {

    public UsuarioJaCadastradoException(String message) {
        super(message);
    }
}
