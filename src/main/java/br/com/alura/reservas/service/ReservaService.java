package br.com.alura.reservas.service;

import br.com.alura.reservas.domain.reserva.Reserva;
import br.com.alura.reservas.domain.reserva.ReservaCadastro;
import br.com.alura.reservas.domain.reserva.ReservaDetalhe;
import br.com.alura.reservas.domain.reserva.StatusReserva;
import br.com.alura.reservas.domain.sala.Sala;
import br.com.alura.reservas.domain.usuario.Usuario;
import br.com.alura.reservas.exception.ReservaJaExistenteException;
import br.com.alura.reservas.repository.ReservaRepository;
import br.com.alura.reservas.repository.SalaRepository;
import br.com.alura.reservas.repository.UsuarioRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

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
//        if (!usuarioRepository.existsById(cadastro.usuarioId())) {
        Usuario usuario = usuarioRepository.findByIdAndAtivoTrue(cadastro.usuarioId());
        if (usuario == null) {
            throw new EntityNotFoundException();
        }

//        if (!salaRepository.existsById(cadastro.salaId())) {
        Sala sala = salaRepository.findByIdAndAtivoTrue(cadastro.salaId());
        if (sala == null) {
            throw new EntityNotFoundException();
        }

//        Usuario usuario = usuarioRepository.getReferenceById(cadastro.usuarioId());
//        Sala sala = salaRepository.getReferenceById(cadastro.salaId());

        Reserva reservaJaExistente = reservaRepository.findBySalaAndInicioAndStatus(sala, cadastro.inicio(), StatusReserva.ATIVA);

        if (reservaJaExistente != null) {
            throw new ReservaJaExistenteException("Sala " + cadastro.salaId() + " já está reservada em " + cadastro.inicio());
        }

        Reserva reserva = new Reserva(sala, usuario, cadastro.inicio(), cadastro.duracaoEmHoras());

        return reservaRepository.save(reserva);
    }


//    public Reserva cadastrar(@Valid ReservaCadastro cadastro) {
//        Usuario usuario = usuarioRepository.getReferenceById(cadastro.usuarioId());
//
//        Sala sala = salaRepository.getReferenceById(cadastro.salaId());
//
//        Reserva reserva = reservaRepository.save(new Reserva(sala, usuario, cadastro.inicio(), cadastro.duracaoEmHoras()));
//
//        return reserva;
//    }

    public List<Reserva> listarTodos() {
//        return reservaRepository.findAll();
        return reservaRepository.findAllByStatus(StatusReserva.ATIVA);
    }

    public void cancelar(Long id) {
        Reserva reserva = reservaRepository.findByIdAndStatus(id, StatusReserva.ATIVA);
        if (reserva == null) {
            throw new EntityNotFoundException();
        }
        reserva.cancelar();

    }
}
