package br.com.ohgestor.msadmin.api.services;

import br.com.ohgestor.msadmin.api.domains.Cliente;
import br.com.ohgestor.msadmin.api.web.requests.ClienteRequest;
import br.com.ohgestor.msadmin.api.web.responses.ClienteResponse;
import org.apache.coyote.BadRequestException;

import java.util.List;

public interface ClienteService {

    Cliente addCliente(ClienteRequest request) throws BadRequestException;

    List<Cliente> filtrarClientes();
}
