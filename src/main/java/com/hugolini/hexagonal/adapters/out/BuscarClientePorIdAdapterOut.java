package com.hugolini.hexagonal.adapters.out;

import com.hugolini.hexagonal.adapters.out.repository.ClienteAdapterOutRepository;
import com.hugolini.hexagonal.adapters.out.repository.mapper.ClienteEntityAdapterOutMapper;
import com.hugolini.hexagonal.application.core.domain.ClienteDomain;
import com.hugolini.hexagonal.application.ports.out.BuscarClientePorIdOutPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class BuscarClientePorIdAdapterOut implements BuscarClientePorIdOutPort {

    @Autowired
    private ClienteAdapterOutRepository clienteAdapterOutRepository;

    @Autowired
    private ClienteEntityAdapterOutMapper clienteEntityAdapterOutMapper;

    @Override
    public Optional<ClienteDomain> buscarCliente(String id) {
        var clienteEntity = clienteAdapterOutRepository.findById(id);
        return clienteEntity.map(entity-> clienteEntityAdapterOutMapper.toDomain(entity));
    }
}
