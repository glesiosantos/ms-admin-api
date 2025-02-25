package br.com.ohgestor.msadmin.api.services;

import br.com.ohgestor.msadmin.api.domains.Cliente;
import br.com.ohgestor.msadmin.api.domains.Pedido;
import br.com.ohgestor.msadmin.api.domains.Usuario;
import br.com.ohgestor.msadmin.api.enuns.Modulo;
import br.com.ohgestor.msadmin.api.enuns.SituacaoPedido;
import br.com.ohgestor.msadmin.api.web.responses.PedidoResponse;
import org.springframework.http.ResponseEntity;

public interface AsaasClientService {

    ResponseEntity<String> cadastrarClienteAsaas(Cliente cliente);

    ResponseEntity<String> buscarClienteAsaas(Cliente cliente);

    String gerarCobrancaPixAsaas(Cliente cliente, int quantidade) throws Exception;

    ResponseEntity<String> carregarCobrancasAsaas();
    Pedido carregarCobrancasPixComQrCode(Cliente cliente, Usuario responsavel, SituacaoPedido situacao, Modulo modulo, int quantidade) throws Exception;
}
