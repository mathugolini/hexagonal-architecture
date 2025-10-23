package com.hugolini.hexagonal.adapters.out;

import com.hugolini.hexagonal.adapters.out.repository.ClienteAdapterOutRepository;
import com.hugolini.hexagonal.application.ports.out.DeletarClientePorIdOutPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DeletarClientePorIdAdapterOut implements DeletarClientePorIdOutPort {

    @Autowired
    ClienteAdapterOutRepository clienteAdapterOutRepository;

    @Override
    public void deletarClientePorId(String id) {
        clienteAdapterOutRepository.deleteById(id);
    }
}
