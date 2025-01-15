package br.com.ohgestor.msadmin.api.web.mappers;

import br.com.ohgestor.msadmin.api.domains.Cliente;
import br.com.ohgestor.msadmin.api.web.requests.ClienteRequest;
import br.com.ohgestor.msadmin.api.web.responses.ClienteResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface ClienteMapper {

    @Mapping(target = "razaoSocial", source = "razaoSocial")
    @Mapping(target = "nomeFantasia", source = "nomeFantasia")
    @Mapping(target = "dataVencimento", source = "dataVencimento")
    @Mapping(target = "nomeDoProprietario", source = "nomeDoProprietario")
    @Mapping(target = "numeroDeUsuario", ignore = true)
    @Mapping(target = "contatos", source = "contatos")
    Cliente converterRequestParaModel(ClienteRequest request);

    @Mapping(target = "razao", source = "razaoSocial")
    @Mapping(target = "fantasia", source = "nomeFantasia")
    @Mapping(target = "cpfCnpj", source = "cpfCnpj")
    @Mapping(target = "contatos", source = "contatos")
    @Mapping(target = "vencimento", source = "dataVencimento")
    @Mapping(target = "totalUsuario", source = "numeroDeUsuario")
    @Mapping(target = "modulos", ignore = true)
    ClienteResponse converterModelParaResponse(Cliente cliente);
}
