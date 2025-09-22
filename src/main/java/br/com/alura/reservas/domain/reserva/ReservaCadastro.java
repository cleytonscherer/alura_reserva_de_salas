package br.com.alura.reservas.domain.reserva;

import br.com.alura.reservas.domain.sala.Sala;
import br.com.alura.reservas.domain.usuario.Usuario;

import java.time.LocalDateTime;

public record ReservaCadastro(
        Long            salaId,
        Long            usuarioId,
        LocalDateTime   inicio,
        LocalDateTime   fim
) {
}
