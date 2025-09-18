package br.com.alura.reservas.controller;

import br.com.alura.reservas.domain.usuario.UsuarioAtualizacao;
import br.com.alura.reservas.domain.usuario.UsuarioCadastro;
import br.com.alura.reservas.domain.usuario.UsuarioDetalhe;
import br.com.alura.reservas.domain.usuario.Usuario;
import br.com.alura.reservas.service.UsuarioService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
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
        return ResponseEntity.status(HttpStatus.CREATED).body(new UsuarioDetalhe(usuario));
    }

    @GetMapping("/{id}")
    public ResponseEntity<UsuarioDetalhe> buscarPorId(@PathVariable Long id) {
        Usuario usuario = service.buscarPorId(id);
        return ResponseEntity.ok(new UsuarioDetalhe(usuario));
    }

    @GetMapping
    public ResponseEntity<List<UsuarioDetalhe>> listarTodos() {
        List<Usuario> lista = service.listarTodos();
        return ResponseEntity.ok(lista.stream().map(UsuarioDetalhe::new).toList());
    }

    @PutMapping
    @Transactional
    public ResponseEntity<UsuarioDetalhe> atualizar(@RequestBody @Valid UsuarioAtualizacao atualizacao) {
        Usuario usuario = service.atualizar(atualizacao);
        return ResponseEntity.ok(new UsuarioDetalhe(usuario));

    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<Void> excluir(@PathVariable Long id) {
        service.excluir(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
