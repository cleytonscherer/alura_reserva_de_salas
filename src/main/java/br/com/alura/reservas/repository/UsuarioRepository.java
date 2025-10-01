package br.com.alura.reservas.repository;

import br.com.alura.reservas.domain.usuario.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, String> {

    List<Usuario> findAllByAtivoTrue();

//    Usuario findByIdAndAtivoTrue(Long id);
    Usuario findByCpfAndAtivoTrue(String cpf);

//    Usuario findByCpf(String cpf);
}
