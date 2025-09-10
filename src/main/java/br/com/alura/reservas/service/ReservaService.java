package br.com.alura.reservas.service;

import br.com.alura.reservas.repository.ReservaRepository;
import org.springframework.stereotype.Service;

@Service
public class ReservaService {

    private final ReservaRepository repository;

    public ReservaService(ReservaRepository repository) {
        this.repository = repository;
    }


}
