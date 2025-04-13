package br.com.ohgestor.msadmin.api.web.responses;

import java.time.LocalDate;

public record PedidoResponse (
        String idPedido,
        String cliente,
        String asaasId,
        String situacao,
        String modulo,
        String plano,
        Double valor,
        String encodeImage,
        String payload,
        String dataCriadoEm,
        String expirationDate,
        boolean periodoTeste,
        LocalDate dataExpiracaoTeste
) {
}
