package br.com.alura.reservas.repository;

import br.com.alura.reservas.domain.sala.Sala;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SalaRepository extends JpaRepository<Sala, Long> {

    List<Sala> findAllByAtivoTrue();

    Sala findByIdAndAtivoTrue(Long id);
}
