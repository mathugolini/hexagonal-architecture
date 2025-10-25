package com.hugolini.hexagonal.adapters.in.consumer.mapper;

import com.hugolini.hexagonal.adapters.in.consumer.message.ClienteAdapterInConsumerMessage;
import com.hugolini.hexagonal.application.core.domain.ClienteDomain;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ClienteMessageMapper {

    @Mapping(target = "endereco", ignore = true)
    ClienteDomain toDomain(ClienteAdapterInConsumerMessage message);
}
