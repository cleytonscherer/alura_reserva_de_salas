package br.com.alura.reservas.domain.reserva;

import br.com.alura.reservas.domain.sala.Sala;
import br.com.alura.reservas.domain.usuario.Usuario;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import jakarta.validation.Valid;

import java.time.LocalDateTime;

@Entity
public class Reserva {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long    id;

//    @JsonIgnoreProperties(value = {"applications", "hibernateLazyInitializer"})
    @ManyToOne(fetch = FetchType.LAZY) //, cascade = CascadeType.PERSIST)
    @JoinColumn(name="sala_id", nullable=false)
    private Sala sala;

//    @JsonIgnoreProperties(value = {"applications", "hibernateLazyInitializer"})
    @ManyToOne(fetch = FetchType.LAZY) //, cascade = CascadeType.PERSIST)
    @JoinColumn(name="usuario_id", nullable=false)
    private Usuario usuario;

    private LocalDateTime   inicio;

    private LocalDateTime   fim;

    @Enumerated(EnumType.STRING)
    private StatusReserva   status;

    public Reserva() {
    }

    public Reserva(Sala sala, Usuario usuario, LocalDateTime inicio, int duracaoEmHoras) {
        this.sala = sala;
        this.usuario = usuario;
        this.inicio = inicio;
        this.fim = inicio.plusHours(duracaoEmHoras);
        this.status = StatusReserva.ATIVA;
    }

    public Long getId() {
        return id;
    }

    public Sala getSala() {
        return sala;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public LocalDateTime getInicio() {
        return inicio;
    }

    public LocalDateTime getFim() {
        return fim;
    }

    public StatusReserva getStatus() {
        return status;
    }

    public void cancelar() {
        this.status = StatusReserva.CANCELADA;
    }
}
