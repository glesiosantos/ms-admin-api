package br.com.ohgestor.msadmin.api.web.mappers;

import br.com.ohgestor.msadmin.api.domains.Cliente;
import br.com.ohgestor.msadmin.api.enuns.EstabelecimentoComercial;
import br.com.ohgestor.msadmin.api.web.requests.ClienteRequest;
import br.com.ohgestor.msadmin.api.web.responses.ClienteResponse;
import org.mapstruct.*;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface ClienteMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "cpfCnpj", source = "documento")
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
}
