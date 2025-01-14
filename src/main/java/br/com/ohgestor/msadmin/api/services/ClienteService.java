package br.com.ohgestor.msadmin.api.services;

import br.com.ohgestor.msadmin.api.domains.Cliente;
import br.com.ohgestor.msadmin.api.web.requests.ClienteRequest;

import java.util.List;

public interface ClienteService {

    Cliente addCliente(ClienteRequest request);

    List<Cliente> filtrarClientes();
}
