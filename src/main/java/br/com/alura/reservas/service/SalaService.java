package br.com.alura.reservas.service;

import br.com.alura.reservas.domain.sala.Sala;
import br.com.alura.reservas.domain.sala.SalaAtualizacao;
import br.com.alura.reservas.domain.sala.SalaCadastro;
import br.com.alura.reservas.repository.SalaRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SalaService {

    private final SalaRepository repository;

    public SalaService(SalaRepository repository) {
        this.repository = repository;
    }


    public Sala cadastrar(SalaCadastro cadastro) {
        return repository.save(new Sala(cadastro));
    }

    public List<Sala> listarTodos() {
        return repository.findAllByAtivoTrue();
    }

    public Sala listarPorId(Long id) {
//        return repository.getReferenceById(id);
        Sala sala = repository.findByIdAndAtivoTrue(id);
        if (sala == null) {
            throw new EntityNotFoundException();
        }
        return sala;
    }

    public Sala atualizar(@Valid SalaAtualizacao atualizacao) {
//        Sala sala = repository.getReferenceById(atualizacao.id());
        Sala sala = repository.findByIdAndAtivoTrue(atualizacao.id());
        if (sala == null) {
            throw new EntityNotFoundException();
        }
        return sala.atualizar(atualizacao);
    }

    public void excluir(Long id) {
//        Sala sala = repository.getReferenceById(id);
        Sala sala = repository.findByIdAndAtivoTrue(id);
        if (sala == null) {
            throw new EntityNotFoundException();
        }
        sala.inativar();
    }
}
