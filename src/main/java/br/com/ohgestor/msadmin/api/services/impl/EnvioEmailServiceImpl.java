package br.com.ohgestor.msadmin.api.services.impl;

import br.com.ohgestor.msadmin.api.services.EnvioEmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EnvioEmailServiceImpl implements EnvioEmailService {

    @Autowired
    private JavaMailSender javaMailSender;

    @Override
    public void enviarEmailSimples(String para, String titulo, String texto) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("admin@ohgestor.com.br");
        message.setTo(para);
        message.setSubject(titulo);
        message.setText(texto);

        javaMailSender.send(message);
    }

    @Override
    public void enviarEmailComTemplate(String para, String titulo, String texto) {

    }
}
