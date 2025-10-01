package br.com.alura.reservas.repository;

import br.com.alura.reservas.domain.usuario.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    List<Usuario> findAllByAtivoTrue();

    Usuario findByIdAndAtivoTrue(Long id);
}
