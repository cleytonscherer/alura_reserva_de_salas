package br.com.alura.reservas.domain.sala;

public record SalaDetalhe(
        Long    id,
        String  nome,
        int     capacidade
) {

    public SalaDetalhe(Sala sala) {
        this(   sala.getId(),
                sala.getNome(),
                sala.getCapacidade()
        );
    }
}
