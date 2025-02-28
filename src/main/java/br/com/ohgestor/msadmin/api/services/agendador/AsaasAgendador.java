package br.com.ohgestor.msadmin.api.services.agendador;

import br.com.ohgestor.msadmin.api.enuns.SituacaoPedido;
import br.com.ohgestor.msadmin.api.services.PedidoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class AsaasAgendador {

    @Autowired
    private PedidoService pedidoService;

    private static final Logger LOGGER = LoggerFactory.getLogger(AsaasAgendador.class);


}
