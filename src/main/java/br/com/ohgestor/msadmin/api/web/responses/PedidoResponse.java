package br.com.ohgestor.msadmin.api.web.responses;

import java.time.Instant;
import java.time.LocalDate;

public record PedidoResponse (
        Long idPedido,
        String cliente,
        String asaasId,
        String situacao,
        String modulo,
        int quantidade,
        Double valor,
        String total,
        String encodeImage,
        String payload,
        String dataCriadoEm,
        String expirationDate
) {
}
