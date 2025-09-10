package br.com.alura.reservas.service;

import br.com.alura.reservas.repository.SalaRepository;
import org.springframework.stereotype.Service;

@Service
public class SalaService {

    private final SalaRepository repository;

    public SalaService(SalaRepository repository) {
        this.repository = repository;
    }


}
