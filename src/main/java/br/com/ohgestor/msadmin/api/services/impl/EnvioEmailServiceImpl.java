package br.com.ohgestor.msadmin.api.services.impl;

import br.com.ohgestor.msadmin.api.services.EnvioEmailService;
import br.com.ohgestor.msadmin.api.web.requests.EmailRequest;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

@Service
public class EnvioEmailServiceImpl implements EnvioEmailService {

    @Autowired
    private JavaMailSender javaMailSender;

    @Autowired
    private TemplateEngine templateEngine;

    @Override
    public void enviarEmailSimples(EmailRequest request) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("admin@glesi5459.c44.integrator.host");
        message.setTo(request.para());
        message.setSubject(request.titulo());
        message.setText(request.texto());

        javaMailSender.send(message);
    }

    @Override
    public void enviarEmailComTemplate(EmailRequest request, String templateName, Context context) {
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, "UTF-8");

        try {
            helper.setFrom("admin@glesi5459.c44.integrator.host");
            helper.setTo(request.para());
            helper.setSubject(request.titulo());
            helper.setText(templateEngine.process(templateName, context), true);
            javaMailSender.send(mimeMessage);
        } catch (MessagingException e) {
            throw  new RuntimeException("*** *** "+e.getMessage());
        }
    }
}
