package br.com.ohgestor.msadmin.api.web.mappers;

import br.com.ohgestor.msadmin.api.domains.Cliente;
import br.com.ohgestor.msadmin.api.web.requests.ClienteRequest;
import br.com.ohgestor.msadmin.api.web.responses.EstabelecimentoResponse;
import org.mapstruct.*;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface ClienteMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "cpfOuCnpj", source = "documento")
    @Mapping(target = "tipo", source = "tipo")
    @Mapping(target = "nomeFantasia", source = "fantasia")
    @Mapping(target = "razaoSocial", source = "razao")
    @Mapping(target = "endereco.cep", source = "cep")
    @Mapping(target = "endereco.logradouro", source = "logradouro")
    @Mapping(target = "endereco.bairro", source = "bairro")
    @Mapping(target = "endereco.cidade", source = "cidade")
    @Mapping(target = "endereco.estado", source = "estado")
    @Mapping(target = "endereco.latitude", source = "latitude")
    @Mapping(target = "endereco.longitude", source = "longitude")
    @Mapping(target = "contatos", source = "contatos")
    Cliente converterRequestParaModel(ClienteRequest request);

    @Mapping(target = "idCliente", source = "id")
    @Mapping(target = "documento", source = "cpfOuCnpj")
    @Mapping(target = "fantasia", source = "nomeFantasia")
    @Mapping(target = "razao", source = "razaoSocial")
    @Mapping(target = "integrado", source = "integrado")
    @Mapping(target = "ativo", source = "ativo")
    @Mapping(target = "plano", expression = "java(getPlano(cliente))")
    @Mapping(target = "diaVencimento", source = "vencimento")
    @Mapping(target = "cep", source = "endereco.cep")
    @Mapping(target = "logradouro", source = "endereco.logradouro")
    @Mapping(target = "bairro", source = "endereco.bairro")
    @Mapping(target = "cidade", source = "endereco.cidade")
    @Mapping(target = "estado", source = "endereco.estado")
    @Mapping(target = "latitude", source = "endereco.latitude")
    @Mapping(target = "longitude", source = "endereco.longitude")
    @Mapping(target = "proprietario", source = "proprietario")
    @Mapping(target = "cpfProprietario", source = "cpfProprietario")
    @Mapping(target = "dataVencimentoTeste", source = "dataVencimentoTeste")
    @Mapping(target = "modulo", expression = "java(getModulo(cliente))")
    @Mapping(target = "tipoPessoa", expression = "java(getTipoPessoa(cliente))")
    @Mapping(target = "contatos", source = "contatos")
    EstabelecimentoResponse converterClienteEmEstabelecimento(Cliente cliente);

    @Mapping(target = "idCliente", source = "id")
    @Mapping(target = "documento", source = "cpfOuCnpj")
    @Mapping(target = "fantasia", source = "nomeFantasia")
    @Mapping(target = "razao", source = "razaoSocial")
    @Mapping(target = "integrado", source = "integrado")
    @Mapping(target = "ativo", source = "ativo")
    @Mapping(target = "plano", expression = "java(getPlanoDescricao(cliente))")
    @Mapping(target = "diaVencimento", source = "vencimento")
    @Mapping(target = "cep", source = "endereco.cep")
    @Mapping(target = "logradouro", source = "endereco.logradouro")
    @Mapping(target = "bairro", source = "endereco.bairro")
    @Mapping(target = "cidade", source = "endereco.cidade")
    @Mapping(target = "estado", source = "endereco.estado")
    @Mapping(target = "latitude", source = "endereco.latitude")
    @Mapping(target = "longitude", source = "endereco.longitude")
    @Mapping(target = "proprietario", source = "proprietario")
    @Mapping(target = "cpfProprietario", source = "cpfProprietario")
    @Mapping(target = "dataVencimentoTeste", source = "dataVencimentoTeste")
    @Mapping(target = "modulo", expression = "java(getModulo(cliente))")
    @Mapping(target = "tipoPessoa", expression = "java(getPlano(cliente))")
    @Mapping(target = "contatos", source = "contatos")
    EstabelecimentoResponse converterClienteEmEstabelecimentoParaListagem(Cliente cliente);

    default String getPlano(Cliente cliente) {
        return cliente.getPlano().name();
    }

    default String getPlanoDescricao(Cliente cliente) {
        return  cliente.getPlano() != null ? cliente.getPlano().getDescricao() : "";
    }

    default String getModulo(Cliente cliente) {
        return  cliente.getModulo() != null ? cliente.getModulo().getNome().toUpperCase() : "";
    }

    default String getTipoPessoa(Cliente cliente) {
        return  cliente.getTipo().getTipo().toUpperCase();
    }
}
