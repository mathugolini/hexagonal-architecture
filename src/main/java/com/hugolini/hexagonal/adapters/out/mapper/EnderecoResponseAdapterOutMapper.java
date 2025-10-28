package com.hugolini.hexagonal.adapters.out.mapper;

import com.hugolini.hexagonal.adapters.out.client.response.EnderecoAdapterOutResponse;
import com.hugolini.hexagonal.application.core.domain.EnderecoDomain;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface EnderecoResponseAdapterOutMapper {

    EnderecoDomain toDomain(EnderecoAdapterOutResponse enderecoResponse);
}
