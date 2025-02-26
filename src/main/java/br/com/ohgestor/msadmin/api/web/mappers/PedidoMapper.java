package br.com.ohgestor.msadmin.api.web.mappers;

import br.com.ohgestor.msadmin.api.domains.Cliente;
import br.com.ohgestor.msadmin.api.domains.Pedido;
import br.com.ohgestor.msadmin.api.web.responses.PedidoResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

import java.time.LocalDate;
import java.time.ZoneOffset;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface PedidoMapper {

    @Mapping(target = "idPedido", source = "id")
    @Mapping(target = "cliente", expression = "java(obterCliente(pedido))")
    @Mapping(target = "modulo", expression = "java(obterNomeModulo(pedido))")
    @Mapping(target = "asaasId", source = "codigoAsaasCobranca")
    @Mapping(target = "situacao", expression = "java(obterSituacao(pedido))")
    @Mapping(target = "quantidade", source = "quantidadeDeUsuarios")
    @Mapping(target = "valor", expression = "java(obterValorModulo(pedido))")
    @Mapping(target = "total", expression = "java(calcularTotal(pedido))")
    @Mapping(target = "encodeImage", source = "qrCode")
    @Mapping(target = "payload", source = "chaveCompartilhamento")
    @Mapping(target = "dataCriadoEm", expression = "java(converterData(pedido))")
    @Mapping(target = "expirationDate", source = "dataExpiracao")
    PedidoResponse converterModeloParaResponse(Pedido pedido);

    default String obterNomeModulo(Pedido pedido) {
        return  pedido.getCliente().getModulo() != null ? pedido.getCliente().getModulo().getNome().toUpperCase() : "";
    }

    default Double obterValorModulo(Pedido pedido) {
        return  pedido.getCliente().getModulo() != null ?  pedido.getCliente().getModulo().getPreco() : 0.0;
    }

    default String obterSituacao(Pedido pedido) {
        return  pedido.getSituacao() != null ? pedido.getSituacao().name() : "";
    }

    default String obterCliente(Pedido pedido) {
        return  pedido.getCliente() != null ? unificarDadosCliente(pedido.getCliente()) : "";
    }

    default String calcularTotal(Pedido pedido) {
        return  pedido != null ? String.format("R$ %.2f", calcular(pedido)) : "R$ 0.00";
    }

    default String converterData(Pedido pedido) {
        return LocalDate.ofInstant(pedido.getDataCriadoEm(), ZoneOffset.UTC).toString();
    }

    private String unificarDadosCliente(Cliente cliente) {
        return String.format("%s - %s", cliente.getCpfOuCnpj(), cliente.getRazaoSocial());
    }

    private Double calcular(Pedido pedido) {
        return pedido.getQuantidadeDeUsuarios() * pedido.getModulo().getPreco();
    }
}
