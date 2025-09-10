package br.com.alura.reservas.model;

import br.com.alura.reservas.domain.usuario.Usuario;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
public class Reserva {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long    id;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name="sala_id", nullable=false)
    private Sala    sala;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name="usuario_id", nullable=false)
    private Usuario usuario;

    private LocalDateTime   inicio;

    private LocalDateTime   fim;

}
