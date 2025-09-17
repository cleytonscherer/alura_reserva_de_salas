package br.com.alura.reservas.domain.sala;

import br.com.alura.reservas.model.Reserva;
import jakarta.persistence.*;
import jakarta.validation.Valid;

import java.util.List;

@Entity
public class Sala {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long    id;

    private String  nome;

    private int     capacidade;

    private Boolean ativo;

    @OneToMany(mappedBy="sala", fetch = FetchType.EAGER)
    private List<Reserva> reservas;

    public Sala() {
    }

    public Sala(SalaCadastro cadastro) {
        this.nome = cadastro.nome();
        this.capacidade = cadastro.capacidade();
        this.ativo = true;
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public int getCapacidade() {
        return capacidade;
    }

    public void atualizar(@Valid SalaAtualizacao atualizacao) {
        if (atualizacao.nome() != null) {
            this.nome = atualizacao.nome();
        }

        if (atualizacao.capacidade() > 0) {
            this.capacidade = atualizacao.capacidade();
        }
    }

    public void Inativar() {
        this.ativo = false;
    }
}
