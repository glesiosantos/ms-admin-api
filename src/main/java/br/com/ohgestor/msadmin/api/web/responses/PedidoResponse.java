package br.com.ohgestor.msadmin.api.web.responses;

public record PedidoResponse (
        Long idPedido,
        String modulo,
        int quantidade,
        double valor,
        String chavePix
) {
}
