package com.hugolini.hexagonal.adapters.out.mapper;

import com.hugolini.hexagonal.adapters.out.entity.ClienteAdapterOutEntity;
import com.hugolini.hexagonal.application.core.domain.ClienteDomain;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ClienteEntityAdapterOutMapper {

    ClienteAdapterOutEntity toEntity(ClienteDomain cliente);

    ClienteDomain toDomain(ClienteAdapterOutEntity clienteEntity);
}
