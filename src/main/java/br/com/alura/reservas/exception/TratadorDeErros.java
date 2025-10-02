package br.com.alura.reservas.exception;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;

@RestControllerAdvice
public class TratadorDeErros {

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<Void> trarErro404() {
        return ResponseEntity.notFound().build();
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<List<DadosErroValidacao>> tratarErro400(MethodArgumentNotValidException ex) {
        var erros = ex.getFieldErrors();
        return ResponseEntity.badRequest().body(erros.stream().map(DadosErroValidacao::new).toList());
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<String> tratarErro400(HttpMessageNotReadableException ex) {
        return ResponseEntity.badRequest().body(ex.getMessage());
    }

//    @ExceptionHandler(BadCredentialsException.class)
//    public ResponseEntity tratarErroBadCredentials() {
//        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Credenciais inválidas");
//    }

//    @ExceptionHandler(AuthenticationException.class)
//    public ResponseEntity tratarErroAuthentication() {
//        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Falha na autenticação");
//    }

//    @ExceptionHandler(AccessDeniedException.class)
//    public ResponseEntity tratarErroAcessoNegado() {
//        return ResponseEntity.status(HttpStatus.FORBIDDEN).body("Acesso negado");
//    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> tratarErro500(Exception ex) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro: " + ex.getLocalizedMessage());
    }

    private record DadosErroValidacao(String campo, String mensagem) {
        public DadosErroValidacao(FieldError erro) {
            this(erro.getField(), erro.getDefaultMessage());
        }
    }

    @ExceptionHandler(ValidacaoException.class)
    public ResponseEntity<String> tratarErroRegraDeNegocio(ValidacaoException ex) {
        return ResponseEntity.badRequest().body(ex.getMessage());
    }

    @ExceptionHandler(ReservaJaExistenteException.class)
    public ResponseEntity<String> tratarErroReservaJaExistente(ReservaJaExistenteException ex) {
        return ResponseEntity.badRequest().body(ex.getMessage());
    }

    @ExceptionHandler(UsuarioJaCadastradoException.class)
    public ResponseEntity<String> tratarErroUsuarioJaCadastrado(UsuarioJaCadastradoException ex) {
        return ResponseEntity.badRequest().body(ex.getMessage());
    }


//    @ExceptionHandler(HttpClientErrorException.Forbidden.class)
//    public ResponseEntity trarErro403() {
//        return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
//    }
}