package br.com.ohgestor.msadmin.api.services.impl;

import br.com.ohgestor.msadmin.api.services.EnvioEmailService;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Service;

@Service
public class EnvioEmailServiceImpl implements EnvioEmailService {
    @Override
    public void enviarEmailSimples(String para, String titulo, String texto) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("admin@ohgestor.com.br");
        message.setTo(para);
        message.setSubject(titulo);
        message.setText(texto);
    }

    @Override
    public void enviarEmailComTemplate(String para, String titulo, String texto) {

    }
}
