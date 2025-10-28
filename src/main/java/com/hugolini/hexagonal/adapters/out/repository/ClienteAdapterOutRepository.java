package com.hugolini.hexagonal.adapters.out.repository;

import com.hugolini.hexagonal.adapters.out.entity.ClienteAdapterOutEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ClienteAdapterOutRepository extends MongoRepository<ClienteAdapterOutEntity, String> {
}
