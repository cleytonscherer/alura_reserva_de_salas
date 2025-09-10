package br.com.alura.reservas.domain.usuario;

public record UsuarioDetalhe(
        Long    id,
        String  nome,
        String  cpf,
        String  email,
        String  telefone
) {
    public UsuarioDetalhe(Usuario usuario) {
        this(   usuario.getId(),
                usuario.getNome(),
                usuario.getCpf(),
                usuario.getEmail(),
                usuario.getTelefone()
        );
    }
}
