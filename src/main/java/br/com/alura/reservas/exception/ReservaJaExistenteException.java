package br.com.alura.reservas.exception;

public class ReservaJaExistenteException extends RuntimeException {

    public ReservaJaExistenteException(String mensagem) {
        super(mensagem);
    }
}
