package br.com.ohgestor.msadmin.api.services;

import br.com.ohgestor.msadmin.api.domains.Pedido;
import br.com.ohgestor.msadmin.api.domains.Usuario;
import br.com.ohgestor.msadmin.api.services.filtros.PedidoFiltro;
import br.com.ohgestor.msadmin.api.web.requests.PedidoRequest;
import br.com.ohgestor.msadmin.api.web.responses.PedidoResponse;

import java.util.List;

public interface PedidoService {
    PedidoResponse registrarPedido(PedidoRequest request) throws Exception;

    List<Pedido> carregarMeusPedido(Usuario usuario);

    PedidoResponse buscarPedidoPeloId(Long id) throws Exception;

    List<PedidoResponse> buscarPedidos(PedidoFiltro filtro);
}
