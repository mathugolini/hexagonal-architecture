package com.hugolini.hexagonal.adapters.out.service;

import com.hugolini.hexagonal.adapters.out.repository.ClienteAdapterOutRepository;
import com.hugolini.hexagonal.adapters.out.mapper.ClienteEntityAdapterOutMapper;
import com.hugolini.hexagonal.application.core.domain.ClienteDomain;
import com.hugolini.hexagonal.application.ports.out.AtualizarClienteOutPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AtualizarClienteAdapterOutService implements AtualizarClienteOutPort {

    @Autowired
    private ClienteAdapterOutRepository clienteAdapterOutRepository;

    @Autowired
    private ClienteEntityAdapterOutMapper clienteEntityAdapterOutMapper;

    @Override
    public void atualizarCliente(ClienteDomain cliente) {
        var clienteEntity = clienteEntityAdapterOutMapper.toEntity(cliente);
        clienteAdapterOutRepository.save(clienteEntity);
    }
}
