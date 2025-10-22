package com.hugolini.hexagonal.adapters.in.controller.mapper;

import com.hugolini.hexagonal.adapters.in.controller.request.ClienteAdapterInControllerRequest;
import com.hugolini.hexagonal.application.core.domain.ClienteDomain;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ClienteAdapterInControllerMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "endereco", ignore = true)
    @Mapping(target = "cpf", ignore = true)
    ClienteDomain toDomain(ClienteAdapterInControllerRequest clienteAdapterInControllerRequest);
}
