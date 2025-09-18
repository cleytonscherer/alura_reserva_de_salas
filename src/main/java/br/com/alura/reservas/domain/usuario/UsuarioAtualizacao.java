package br.com.alura.reservas.domain.usuario;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.springframework.format.annotation.NumberFormat;

public record UsuarioAtualizacao(
        @NotNull(message = "identificação do usuário deve ser informado")
        Long    id,
        @NotBlank(message = "nome do usuário deve ser informado")
        String  nome,
        @NotBlank(message = "CPF deve ser informado")
        @NumberFormat
        String  cpf,
        @NotBlank(message = "endereço de e-mail deve ser informado")
        @Email(message = "formato de endereço de e-mail inválido")
        String  email,
        @NotBlank(message = "telefone deve ser informado")
        String  telefone,
        @NotBlank(message = "senha deve ser informada")
        String  senha
) {
}
