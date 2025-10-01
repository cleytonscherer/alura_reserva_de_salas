package br.com.alura.reservas.repository;

import br.com.alura.reservas.domain.reserva.Reserva;
import br.com.alura.reservas.domain.reserva.StatusReserva;
import br.com.alura.reservas.domain.sala.Sala;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface ReservaRepository extends JpaRepository<Reserva, Long> {

    List<Reserva> findAllByStatus(StatusReserva statusReserva);

    Reserva findByIdAndStatus(Long id, StatusReserva statusReserva);

    Reserva findBySalaAndInicioAndStatus(Sala sala, LocalDateTime inicio, StatusReserva statusReserva);
}
