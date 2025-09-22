package br.com.alura.reservas.service;

import br.com.alura.reservas.domain.reserva.Reserva;
import br.com.alura.reservas.domain.reserva.ReservaCadastro;
import br.com.alura.reservas.domain.reserva.ReservaDetalhe;
import br.com.alura.reservas.domain.sala.Sala;
import br.com.alura.reservas.domain.usuario.Usuario;
import br.com.alura.reservas.repository.ReservaRepository;
import br.com.alura.reservas.repository.SalaRepository;
import br.com.alura.reservas.repository.UsuarioRepository;
import org.springframework.stereotype.Service;

@Service
public class ReservaService {

    private final ReservaRepository reservaRepository;

    private final UsuarioRepository usuarioRepository;

    private final SalaRepository salaRepository;

    public ReservaService(ReservaRepository repository, UsuarioRepository usuarioRepository, SalaRepository salaRepository) {
        this.reservaRepository = repository;
        this.usuarioRepository = usuarioRepository;
        this.salaRepository = salaRepository;
    }

    public Reserva registrarReserva(ReservaCadastro cadastro) {
        if (!usuarioRepository.existsById(cadastro.usuarioId())) {
            throw new RuntimeException("Usuário " + cadastro.usuarioId() + " não encontrado!");
        }

        if (!salaRepository.existsById(cadastro.salaId())) {
            throw new RuntimeException("Sala " + cadastro.salaId() + " não encontrada!");
        }

        Usuario usuario = usuarioRepository.getReferenceById(cadastro.usuarioId());
        Sala sala = salaRepository.getReferenceById(cadastro.salaId());

        Reserva reserva = new Reserva(sala, usuario, cadastro.inicio(), cadastro.fim());

        return reservaRepository.save(reserva);
    }


}
