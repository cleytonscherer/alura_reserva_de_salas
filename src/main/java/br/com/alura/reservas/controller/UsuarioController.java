package br.com.alura.reservas.controller;

import br.com.alura.reservas.domain.usuario.UsuarioCadastro;
import br.com.alura.reservas.domain.usuario.UsuarioDetalhe;
import br.com.alura.reservas.domain.usuario.Usuario;
import br.com.alura.reservas.service.UsuarioService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("usuarios")
public class UsuarioController {

    private final UsuarioService service;

    public UsuarioController(UsuarioService service) {
        this.service = service;
    }

    @PostMapping
    @Transactional
    public ResponseEntity<UsuarioDetalhe> cadastrar(@RequestBody @Valid UsuarioCadastro cadastro) {
        Usuario usuario = service.cadastrar(cadastro);
        return ResponseEntity.ok(new UsuarioDetalhe(usuario));
    }

    @GetMapping("/{id}")
    public ResponseEntity<UsuarioDetalhe> buscarPorId(@PathVariable Long id) {
        Usuario usuario = service.buscarPorId(id);
        return ResponseEntity.ok(new UsuarioDetalhe(usuario));
    }

    @GetMapping
    public ResponseEntity<List<UsuarioDetalhe>> listarTodos() {
        List<Usuario> lista = service.listarTodos();
        return ResponseEntity.ok()
    }
}
