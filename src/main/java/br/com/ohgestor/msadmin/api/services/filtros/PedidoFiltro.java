package br.com.ohgestor.msadmin.api.services.filtros;

public record PedidoFiltro(
        String dataInicial,
        String dataFinal,
        String situacao
) {
}
