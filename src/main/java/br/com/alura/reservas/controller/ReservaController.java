package br.com.alura.reservas.controller;

import br.com.alura.reservas.domain.reserva.Reserva;
import br.com.alura.reservas.domain.reserva.ReservaCadastro;
import br.com.alura.reservas.domain.reserva.ReservaDetalhe;
import br.com.alura.reservas.service.ReservaService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("reservas")
public class ReservaController {

    private final ReservaService service;

    public ReservaController(ReservaService service) {
        this.service = service;
    }

    @PostMapping
    @Transactional
    public ResponseEntity<ReservaDetalhe> cadastrar(@RequestBody @Valid ReservaCadastro cadastro) {
        System.out.println(cadastro);
        Reserva reserva = service.registrarReserva(cadastro);
        return ResponseEntity.status(HttpStatus.CREATED).body(new ReservaDetalhe(reserva));
    }

    @GetMapping
    public ResponseEntity<List<ReservaDetalhe>> listarTodos() {
        return ResponseEntity.ok(service.listarTodos().stream().map(ReservaDetalhe::new).toList());
    }

    @PostMapping("/cancelar/{id}")
    @Transactional
    public ResponseEntity<Void> cancelar(@PathVariable Long id) {
        service.cancelar(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
