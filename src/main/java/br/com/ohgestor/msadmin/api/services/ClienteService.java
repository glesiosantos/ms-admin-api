package br.com.ohgestor.msadmin.api.services;

import br.com.ohgestor.msadmin.api.domains.Cliente;
import br.com.ohgestor.msadmin.api.web.requests.ClienteRequest;
import br.com.ohgestor.msadmin.api.web.requests.VenderRequest;
import br.com.ohgestor.msadmin.api.web.responses.ClienteResponse;
import org.apache.coyote.BadRequestException;

import java.util.List;

public interface ClienteService {

    Cliente addCliente(ClienteRequest request) throws BadRequestException;

    void registrarModulo(VenderRequest request) throws Exception;

    void notificarRabbitMQ(Cliente cliente, String exchange);

    List<ClienteResponse> carregarClientes();
}
