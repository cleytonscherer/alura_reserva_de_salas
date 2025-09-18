package br.com.alura.reservas.domain.usuario;

import br.com.alura.reservas.domain.reserva.Reserva;
import jakarta.persistence.*;
import jakarta.validation.Valid;

import java.util.List;

@Entity
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long    id;
    private String  nome;
    private String  cpf;
    private String  email;
    private String  telefone;
    private String  senha;
    private Boolean ativo;

    @OneToMany(mappedBy="usuario", fetch = FetchType.EAGER)
    private List<Reserva> reservas;

    public Usuario() {
    }

    public Usuario(@Valid UsuarioCadastro cadastro) {
        this.nome = cadastro.nome();
        this.email = cadastro.email();
        this.cpf = cadastro.cpf();
        this.telefone = cadastro.telefone();
        this.senha = cadastro.senha();
        this.ativo = true;
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public String getTelefone() {
        return telefone;
    }

    public List<Reserva> getReservas() {
        return reservas;
    }

    public String getSenha() {
        return senha;
    }

    public String getCpf() {
        return cpf;
    }

    public void inativar() {
        this.ativo = false;
    }

    public void atualizar(UsuarioAtualizacao atualizacao) {
        if (atualizacao.nome() != null) {
            this.nome = atualizacao.nome();
        }

        if (atualizacao.cpf() != null) {
            this.cpf = atualizacao.cpf();
        }

        if (atualizacao.telefone() != null) {
            this.telefone = atualizacao.telefone();
        }

         if (atualizacao.email() != null) {
             this.email = atualizacao.email();
         }
    }
}
