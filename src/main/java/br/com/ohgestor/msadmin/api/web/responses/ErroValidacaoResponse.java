package br.com.ohgestor.msadmin.api.web.responses;

public record ErroValidacaoResponse(
        String campo,
        String mensagem
) {
}
