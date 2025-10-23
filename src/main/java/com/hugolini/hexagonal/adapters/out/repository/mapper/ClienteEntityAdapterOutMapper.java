package com.hugolini.hexagonal.adapters.out.repository.mapper;

import com.hugolini.hexagonal.adapters.out.client.response.EnderecoAdapterOutResponse;
import com.hugolini.hexagonal.adapters.out.repository.entity.ClienteAdapterOutEntity;
import com.hugolini.hexagonal.application.core.domain.ClienteDomain;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ClienteEntityAdapterOutMapper {

    ClienteAdapterOutEntity toEntity(ClienteDomain cliente);

    ClienteDomain toDomain(ClienteAdapterOutEntity clienteEntity);
}
