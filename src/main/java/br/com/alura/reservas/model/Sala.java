package br.com.alura.reservas.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Sala {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long    id;

    private String  nome;

    private int     capacidade;

    @OneToMany(mappedBy="sala", fetch = FetchType.EAGER)
    private List<Reserva> reservas;

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public int getCapacidade() {
        return capacidade;
    }
}
