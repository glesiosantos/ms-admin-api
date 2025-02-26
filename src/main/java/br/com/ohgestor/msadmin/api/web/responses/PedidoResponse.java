package br.com.ohgestor.msadmin.api.web.responses;

public record PedidoResponse (
        Long idPedido,
        String asaasId,
        String situacao,
        String modulo,
        int quantidade,
        double valor,
        String encodeImage,
        String payload,
        String expirationDate
) {
}
