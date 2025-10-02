package br.com.alura.reservas.domain.usuario;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public record UsuarioCadastro(

        /*
        Para CPF
        /^\d{3}\.\d{3}\.\d{3}\-\d{2}$/

        Para CNPJ
        /^\d{2}\.\d{3}\.\d{3}\/\d{4}\-\d{2}$/

        Para ambos ao mesmo tempo
        /(^\d{3}\.\d{3}\.\d{3}\-\d{2}$)|(^\d{2}\.\d{3}\.\d{3}\/\d{4}\-\d{2}$)/
         */

        @NotBlank(message = "CPF deve ser informado")
        @Pattern(regexp = "^\\d{3}\\.\\d{3}\\.\\d{3}-\\d{2}$", message = "CPF inválido")
        String  cpf,
        @NotBlank(message = "nome do usuário deve ser informado")
        String  nome,
        @NotBlank(message = "endereço de e-mail deve ser informado")
        @Email(message = "formato de endereço de e-mail inválido")
        String  email,
        @NotBlank(message = "telefone deve ser informado")
        String  telefone,
        @NotBlank(message = "senha deve ser informada")
        String  senha
) {
}
