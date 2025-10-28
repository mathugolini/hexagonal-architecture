package com.hugolini.hexagonal.adapters.in.mapper;

import com.hugolini.hexagonal.adapters.in.request.ClienteAdapterInRequest;
import com.hugolini.hexagonal.adapters.in.response.ClienteAdapterInResponse;
import com.hugolini.hexagonal.application.core.domain.ClienteDomain;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ClienteAdapterInMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "endereco", ignore = true)
    @Mapping(target = "cpfValido", ignore = true)
    ClienteDomain toDomain(ClienteAdapterInRequest clienteAdapterInRequest);

    ClienteAdapterInResponse toResponse(ClienteDomain clienteDomain);
}
