package br.com.alura.reservas.service;

import br.com.alura.reservas.domain.usuario.UsuarioCadastro;
import br.com.alura.reservas.domain.usuario.Usuario;
import br.com.alura.reservas.repository.UsuarioRepository;
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
        return repository.getReferenceById(id);
    }

    public List<Usuario> listarTodos() {
        return repository.findAll();
    }
}
