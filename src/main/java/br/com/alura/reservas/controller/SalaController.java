package br.com.alura.reservas.controller;

import br.com.alura.reservas.domain.sala.Sala;
import br.com.alura.reservas.domain.sala.SalaAtualizacao;
import br.com.alura.reservas.domain.sala.SalaCadastro;
import br.com.alura.reservas.domain.sala.SalaDetalhe;
import br.com.alura.reservas.service.SalaService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("salas")
public class SalaController {

    private final SalaService service;

    public SalaController(SalaService service) {
        this.service = service;
    }

    @PostMapping
    @Transactional
    public ResponseEntity<SalaDetalhe> cadastrar(@RequestBody @Valid SalaCadastro cadastro) {
        Sala sala = service.cadastrar(cadastro);
        return ResponseEntity.status(HttpStatus.CREATED).body(new SalaDetalhe(sala));
    }

    @GetMapping
    public ResponseEntity<List<SalaDetalhe>> listarTodos() {
        List<Sala> salas = service.listarTodos();
        return ResponseEntity.ok(salas.stream().map(SalaDetalhe::new).toList());
    }

    @GetMapping("/{id}")
    public ResponseEntity<SalaDetalhe> listarPorId(@PathVariable Long id) {
        Sala sala = service.listarPorId(id);
        return ResponseEntity.ok(new SalaDetalhe(sala));
    }

    @PutMapping
    @Transactional
    public ResponseEntity<SalaDetalhe> atualizar(@RequestBody @Valid SalaAtualizacao atualizacao) {
        Sala sala = service.atualizar(atualizacao);
        return ResponseEntity.ok(new SalaDetalhe(sala));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<Void> excluir(@PathVariable Long id) {
        service.excluir(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
