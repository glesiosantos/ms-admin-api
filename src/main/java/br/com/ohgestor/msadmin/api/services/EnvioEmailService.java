package br.com.ohgestor.msadmin.api.services;

public interface EnvioEmailService {

    void enviarEmailSimples(String para, String titulo, String texto);

    void enviarEmailComTemplate(String para, String titulo, String texto);
}
