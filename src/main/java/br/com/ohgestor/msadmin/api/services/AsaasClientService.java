package br.com.ohgestor.msadmin.api.services;

import br.com.ohgestor.msadmin.api.domains.Cliente;
import br.com.ohgestor.msadmin.api.domains.Pedido;
import org.springframework.http.ResponseEntity;

public interface AsaasClientService {

    ResponseEntity<String> cadastrarClienteAsaas(Cliente cliente);

    ResponseEntity<String> buscarClienteAsaas(Cliente cliente);

    ResponseEntity<String> gerarCobrancaPixAsaas(Pedido pedido) throws Exception;
}
