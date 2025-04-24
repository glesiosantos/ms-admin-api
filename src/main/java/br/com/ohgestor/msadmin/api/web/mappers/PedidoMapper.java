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
    @Mapping(target = "plano", expression = "java(obterNomePlano(pedido))")
    @Mapping(target = "valor", expression = "java(obterValorPlano(pedido))")
    @Mapping(target = "encodeImage", source = "qrCode")
    @Mapping(target = "payload", source = "chaveCompartilhamento")
    @Mapping(target = "dataCriadoEm", expression = "java(converterData(pedido))")
    @Mapping(target = "expirationDate", source = "dataExpiracaoPagamento")
    @Mapping(target = "dataExpiracaoTeste", source = "cliente.dataVencimentoTeste")
    PedidoResponse converterModeloParaResponse(Pedido pedido);

    @Mapping(target = "idPedido", source = "id")
    @Mapping(target = "cliente", expression = "java(obterCliente(pedido))")
    @Mapping(target = "modulo", expression = "java(obterNomeDescritivoDoModulo(pedido))")
    @Mapping(target = "asaasId", source = "codigoAsaasCobranca")
    @Mapping(target = "situacao", expression = "java(obterSituacao(pedido))")
    @Mapping(target = "plano", expression = "java(obterNomeDescritivoDoPlano(pedido))")
    @Mapping(target = "valor", expression = "java(obterValorPlano(pedido))")
    @Mapping(target = "encodeImage", source = "qrCode")
    @Mapping(target = "payload", source = "chaveCompartilhamento")
    @Mapping(target = "dataCriadoEm", expression = "java(converterData(pedido))")
    @Mapping(target = "expirationDate", source = "dataExpiracaoPagamento")
    @Mapping(target = "dataExpiracaoTeste", source = "cliente.dataVencimentoTeste")
    PedidoResponse converterModeloParaResponseParaListagem(Pedido pedido);

    default String obterNomeModulo(Pedido pedido) {
        return pedido.getCliente().getModulo() == null ? null : pedido.getCliente().getModulo().name();
    }

    default String obterNomeDescritivoDoModulo(Pedido pedido) {
        return pedido.getCliente().getModulo().getNome();
    }

    default String obterNomePlano(Pedido pedido) {
        return pedido.getCliente().getPlano() == null ? null : pedido.getCliente().getPlano().name();
    }

    default String obterNomeDescritivoDoPlano(Pedido pedido) {
        return pedido.getCliente().getPlano().getDescricao();
    }

    default Double obterValorPlano(Pedido pedido) {
        return pedido.getCliente().getPlano() != null ?  pedido.getCliente().getPlano().getValor() : 0.0;
    }

    default String obterSituacao(Pedido pedido) {
        return  pedido.getSituacao() != null ? pedido.getSituacao().name() : "";
    }

    default String obterCliente(Pedido pedido) {
        return  pedido.getCliente() != null ? unificarDadosCliente(pedido.getCliente()) : "";
    }

    default String converterData(Pedido pedido) {
        return LocalDate.ofInstant(pedido.getDataCriadoEm(), ZoneOffset.UTC).toString();
    }

    default String converterModulo(Pedido pedido) {
        return pedido.getCliente().getModulo().getNome();
    }

    private String unificarDadosCliente(Cliente cliente) {
        return String.format("%s - %s", cliente.getCpfOuCnpj(), cliente.getRazaoSocial());
    }
}
