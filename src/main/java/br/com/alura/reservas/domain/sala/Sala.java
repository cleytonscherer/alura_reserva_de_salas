package br.com.alura.reservas.domain.sala;

import br.com.alura.reservas.domain.reserva.Reserva;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
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

    @OneToMany(mappedBy="sala", fetch = FetchType.LAZY)
//    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
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

    public Sala atualizar(@Valid SalaAtualizacao atualizacao) {
        if (atualizacao.nome() != null) {
            this.nome = atualizacao.nome();
        }

        if (atualizacao.capacidade() > 0) {
            this.capacidade = atualizacao.capacidade();
        }
        return this;
    }

    public void inativar() {
        this.ativo = false;
    }
}
