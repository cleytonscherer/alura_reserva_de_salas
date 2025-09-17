package br.com.alura.reservas.domain.sala;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record SalaAtualizacao(
        @NotNull
        Long    id,
        @NotBlank(message = "Nome da sala deve ser informado")
        String  nome,
        @NotNull(message = "Capacidade da sala deve ser informado")
        int     capacidade
) {
}
