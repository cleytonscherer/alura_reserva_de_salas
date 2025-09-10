package br.com.alura.reservas.domain.usuario;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import org.springframework.format.annotation.NumberFormat;

public record UsuarioCadastro(
        @NotBlank
        String  nome,
        @NotBlank
        @NumberFormat
        String  cpf,
        @NotBlank
        @Email
        String  email,
        @NotBlank
        String  telefone,
        @NotBlank
        String  senha
) {
}
