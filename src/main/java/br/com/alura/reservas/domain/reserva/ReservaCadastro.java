package br.com.alura.reservas.domain.reserva;

import jakarta.validation.constraints.*;
import org.springframework.format.annotation.NumberFormat;

import java.time.LocalDateTime;

public record ReservaCadastro(
        @NotNull(message = "Identificação da Sala deve ser informada")
        Long            salaId,

//        @NotNull(message = "Identificação do usuário deve ser informada")
//        Long            usuarioId,
        @NotBlank(message = "CPF deve ser informado")
        @Pattern(regexp = "^\\d{3}\\.\\d{3}\\.\\d{3}-\\d{2}$", message = "CPF inválido")
        String          cpf,

        @Future(message = "Data e Hora de reserva deve ser no futuro")
        @NotNull(message = "Data e Hora da reserva deve ser informada")
//        @JsonSerialize(using = LocalDateTimeSerializer.class)
//        @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
//        @JsonProperty("date")
        LocalDateTime   inicio,

        @NotNull(message = "Duração deve ser informada")
        @NumberFormat
        @Min(value = 1, message = "Duração mínima de 1 hora")
//        @JsonSerialize(using = LocalDateTimeSerializer.class)
//        @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
//        @JsonProperty("date")
        int             duracaoEmHoras
) {
}
