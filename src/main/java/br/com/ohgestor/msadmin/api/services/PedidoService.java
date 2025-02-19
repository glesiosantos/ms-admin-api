package br.com.ohgestor.msadmin.api.services;

import br.com.ohgestor.msadmin.api.domains.Pedido;
import br.com.ohgestor.msadmin.api.domains.Usuario;
import br.com.ohgestor.msadmin.api.web.requests.PedidoRequest;

import java.util.List;

public interface PedidoService {
    Pedido registrarPedido(PedidoRequest request) throws Exception;

    List<Pedido> carregarMeusPedido(Usuario usuario);
}
