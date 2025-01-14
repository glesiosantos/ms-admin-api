package br.com.ohgestor.msadmin.api.web.requests;

public record EmailRequest (
        String para,
        String titulo,
        String texto
){}
