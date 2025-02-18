package br.com.ohgestor.msadmin.api.services;

import br.com.ohgestor.msadmin.api.domains.Cliente;
import br.com.ohgestor.msadmin.api.web.requests.ClienteRequest;
import br.com.ohgestor.msadmin.api.web.requests.VenderRequest;
import br.com.ohgestor.msadmin.api.web.responses.EstabelecimentoResponse;
import org.apache.coyote.BadRequestException;

import java.util.List;

public interface ClienteService {

    Cliente addCliente(ClienteRequest request) throws BadRequestException, Exception;

    EstabelecimentoResponse registrarModulo(VenderRequest request) throws Exception;

    void notificarRabbitMQ(EstabelecimentoResponse response, String exchange);

    List<EstabelecimentoResponse> carregarClientes();
}
