package br.com.alura.reservas.service;

import br.com.alura.reservas.domain.usuario.UsuarioAtualizacao;
import br.com.alura.reservas.domain.usuario.UsuarioCadastro;
import br.com.alura.reservas.domain.usuario.Usuario;
import br.com.alura.reservas.repository.UsuarioRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {

    private final UsuarioRepository repository;

    public UsuarioService(UsuarioRepository repository) {
        this.repository = repository;
    }

    public Usuario cadastrar(@Valid UsuarioCadastro cadastro) {
        return repository.save(new Usuario(cadastro));
    }

    public Usuario buscarPorId(Long id) {
//        return repository.getReferenceById(id);
        Usuario usuario = repository.findByIdAndAtivoTrue(id);
        if (usuario == null) {
            throw new EntityNotFoundException();
        }
        return usuario;
    }

    public List<Usuario> listarTodos() {
        return repository.findAllByAtivoTrue();
    }

    public void excluir(Long id) {
//        Usuario usuario = repository.getReferenceById(id);
        Usuario usuario = repository.findByIdAndAtivoTrue(id);
        if (usuario == null) {
            throw new EntityNotFoundException();
        }
        usuario.inativar();
    }

    public Usuario atualizar(UsuarioAtualizacao atualizacao) {
//        Usuario usuario = repository.getReferenceById(atualizacao.id());
        Usuario usuario = repository.findByIdAndAtivoTrue(atualizacao.id());
        if (usuario == null) {
            throw new EntityNotFoundException();
        }
        return usuario.atualizar(atualizacao);
    }
}
