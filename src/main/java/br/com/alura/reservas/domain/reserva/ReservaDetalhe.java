package br.com.alura.reservas.domain.reserva;

import br.com.alura.reservas.domain.sala.Sala;
import br.com.alura.reservas.domain.usuario.Usuario;

import java.time.LocalDateTime;

public record ReservaDetalhe(
        Long            id,
        Long            salaId,
        String          cpf,
//        Long            usuarioId,
        LocalDateTime   inicio,
        LocalDateTime   fim
) {

    public ReservaDetalhe(Reserva reserva) {
        this(   reserva.getId(),
                reserva.getSala().getId(),
//                reserva.getUsuario().getId(),
                reserva.getUsuario().getCpf(),
                reserva.getInicio(),
                reserva.getFim()
        );
    }
}
