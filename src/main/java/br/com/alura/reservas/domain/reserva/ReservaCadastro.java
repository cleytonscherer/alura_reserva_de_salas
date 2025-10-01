package br.com.alura.reservas.domain.reserva;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.springframework.format.annotation.NumberFormat;

import java.time.LocalDateTime;

public record ReservaCadastro(
        @NotNull(message = "Identificação da Sala deve ser informada")
        Long            salaId,
        @NotNull(message = "Identificação do usuário deve ser informada")
        Long            usuarioId,

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
