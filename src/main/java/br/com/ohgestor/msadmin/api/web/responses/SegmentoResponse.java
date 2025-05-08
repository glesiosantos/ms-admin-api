package br.com.ohgestor.msadmin.api.web.responses;

import br.com.ohgestor.msadmin.api.enuns.SegmentoComercial;

public record SegmentoResponse(
        String sigla,
        String descricao
) {
    public static SegmentoResponse from(SegmentoComercial segmento) {
        return new SegmentoResponse(segmento.name(), segmento.getDescricao());
    }
}
