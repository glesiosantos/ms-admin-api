package br.com.ohgestor.msadmin.api.web.mappers;

import br.com.ohgestor.msadmin.api.domains.Cliente;
import br.com.ohgestor.msadmin.api.enuns.EstabelecimentoComercial;
import br.com.ohgestor.msadmin.api.web.requests.ClienteRequest;
import br.com.ohgestor.msadmin.api.web.responses.EstabelecimentoResponse;
import org.mapstruct.*;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface ClienteMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "cpfOuCnpj", source = "documento")
    @Mapping(target = "nomeFantasia", source = "fantasia")
    @Mapping(target = "razaoSocial", source = "razao")
    @Mapping(target = "estabelecimento", source = "estabelecimento")
    @Mapping(target = "endereco.cep", source = "cep")
    @Mapping(target = "endereco.logradouro", source = "logradouro")
    @Mapping(target = "endereco.bairro", source = "bairro")
    @Mapping(target = "endereco.cidade", source = "cidade")
    @Mapping(target = "endereco.estado", source = "estado")
    @Mapping(target = "endereco.latitude", source = "latitude")
    @Mapping(target = "endereco.longitude", source = "longitude")
    @Mapping(target = "contatos", source = "contatos")
    Cliente converterRequestParaModel(ClienteRequest request);

    @Mapping(target = "id", source = "id")
    @Mapping(target = "cpfOuCnpj", source = "cpfOuCnpj")
    @Mapping(target = "nomeFantasia", source = "nomeFantasia")
    @Mapping(target = "razaoSocial", source = "razaoSocial")
    @Mapping(target = "totalDeUsuario", source = "numeroUsuario")
    @Mapping(target = "vencimento", source = "vencimento")
    @Mapping(target = "cep", source = "endereco.cep")
    @Mapping(target = "logradouro", source = "endereco.logradouro")
    @Mapping(target = "bairro", source = "endereco.bairro")
    @Mapping(target = "cidade", source = "endereco.cidade")
    @Mapping(target = "estado", source = "endereco.estado")
    @Mapping(target = "latitude", source = "endereco.latitude")
    @Mapping(target = "longitude", source = "endereco.longitude")
    @Mapping(target = "proprietario", source = "proprietario")
    @Mapping(target = "cpfProprietario", source = "cpfProprietario")
    @Mapping(target = "estabelecimento", expression = "java(getTipoDeEstabelecimento(cliente))")
    @Mapping(target = "contatos", source = "contatos")
    EstabelecimentoResponse converterClienteEmEstabelecimento(Cliente cliente);

    default String getTipoDeEstabelecimento(Cliente cliente) {
        return cliente.getEstabelecimento().getNome().toUpperCase();
    }
}
