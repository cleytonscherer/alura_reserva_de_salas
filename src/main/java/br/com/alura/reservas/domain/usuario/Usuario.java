package br.com.alura.reservas.domain.usuario;

import br.com.alura.reservas.domain.reserva.Reserva;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import jakarta.validation.Valid;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Usuario {

//    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
//    private Long    id;

    @Id
    private String  cpf;

    private String  nome;
    private String  email;
    private String  telefone;
    private String  senha;
    private Boolean ativo;

    @OneToMany(mappedBy="usuario", fetch = FetchType.EAGER)
//    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private List<Reserva> reservas = new ArrayList<>();

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

//    public Long getId() {
//        return id;
//    }

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

    public Usuario atualizar(UsuarioAtualizacao atualizacao) {
        if (atualizacao.nome() != null) {
            this.nome = atualizacao.nome();
        }

//        if (atualizacao.cpf() != null) {
//            this.cpf = atualizacao.cpf();
//        }

        if (atualizacao.telefone() != null) {
            this.telefone = atualizacao.telefone();
        }

         if (atualizacao.email() != null) {
             this.email = atualizacao.email();
         }

         return this;
    }

    public Boolean getAtivo() {
        return ativo;
    }

    public void adicionarReserva(Reserva reserva) {
        reserva.setUsuario(this);
        this.reservas.add(reserva);
    }


}
