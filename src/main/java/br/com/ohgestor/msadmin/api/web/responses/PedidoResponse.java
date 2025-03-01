package br.com.ohgestor.msadmin.api.web.responses;

public record PedidoResponse (
        Long idPedido,
        String cliente,
        String asaasId,
        String situacao,
        String modulo,
        String plano,
        Double valor,
        String encodeImage,
        String payload,
        String dataCriadoEm,
        String expirationDate
) {
}
