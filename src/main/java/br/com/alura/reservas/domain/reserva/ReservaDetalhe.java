package br.com.alura.reservas.domain.reserva;

import br.com.alura.reservas.domain.sala.Sala;
import br.com.alura.reservas.domain.usuario.Usuario;

import java.time.LocalDateTime;

public record ReservaDetalhe(
        Long            id,
        Sala            sala,
        Usuario         usuario,
        LocalDateTime   inicio,
        LocalDateTime   fim
) {
}
