package br.com.ohgestor.msadmin.api.web.mappers;

import br.com.ohgestor.msadmin.api.domains.Cliente;
import br.com.ohgestor.msadmin.api.domains.Pedido;
import br.com.ohgestor.msadmin.api.web.responses.PedidoResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface PedidoMapper {

    @Mapping(target = "idPedido", source = "id")
    @Mapping(target = "modulo", expression = "java(obterNomeModulo(pedido))")
    @Mapping(target = "quantidade", source = "quantidadeDeUsuarios")
    @Mapping(target = "valor", expression = "java(obterValorModulo(pedido))")
    @Mapping(target = "encodeImage", source = "qrCode")
    @Mapping(target = "payload", source = "chaveCompartilhamento")
    @Mapping(target = "expirationDate", source = "dataExpiracao")
    PedidoResponse converterModeloParaResponse(Pedido pedido);

    default String obterNomeModulo(Pedido pedido) {
        return  pedido.getCliente().getModulo() != null ? pedido.getCliente().getModulo().getNome().toUpperCase() : "";
    }

    default Double obterValorModulo(Pedido pedido) {
        return  pedido.getCliente().getModulo() != null ? pedido.getCliente().getModulo().getPreco() : 0.0;
    }
}
