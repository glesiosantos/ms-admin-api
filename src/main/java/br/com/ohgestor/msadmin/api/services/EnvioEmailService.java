package br.com.ohgestor.msadmin.api.services;

import br.com.ohgestor.msadmin.api.web.requests.EmailRequest;
import org.thymeleaf.context.Context;

public interface EnvioEmailService {

    void enviarEmailSimples(EmailRequest request);

    void enviarEmailComTemplate(EmailRequest request, String templateName, Context context);
}
