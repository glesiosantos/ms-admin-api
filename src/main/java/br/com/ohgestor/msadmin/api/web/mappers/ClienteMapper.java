package br.com.ohgestor.msadmin.api.web.mappers;

import br.com.ohgestor.msadmin.api.domains.Cliente;
import br.com.ohgestor.msadmin.api.web.requests.ClienteRequest;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface ClienteMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "razaoSocial", source = "razaoSocial")
    @Mapping(target = "nomeFantasia", source = "nomeFantasia")
    @Mapping(target = "nomeDoProprietario", source = "nomeDoProprietario")
    @Mapping(target = "numeroDeUsuario", constant = "0")
    @Mapping(target = "dataVencimento", constant = "0")
    @Mapping(target = "contatos", source = "contatos")
    Cliente converterRequestParaModel(ClienteRequest request);
}
