package com.hugolini.hexagonal.adapters.out;

import com.hugolini.hexagonal.adapters.out.repository.ClienteAdapterOutRepository;
import com.hugolini.hexagonal.adapters.out.repository.mapper.ClienteEntityAdapterOutMapper;
import com.hugolini.hexagonal.application.core.domain.ClienteDomain;
import com.hugolini.hexagonal.application.ports.out.RegistrarClienteOutPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RegistrarClienteAdapterOut implements RegistrarClienteOutPort {

    @Autowired
    private ClienteAdapterOutRepository clienteAdapterOutRepository;

    @Autowired
    private ClienteEntityAdapterOutMapper clienteEntityAdapterOutMapper;

    @Override
    public void registrarCliente(ClienteDomain cliente) {
        var clienteEntity = clienteEntityAdapterOutMapper.toEntity(cliente);
        clienteAdapterOutRepository.save(clienteEntity);
    }
}
