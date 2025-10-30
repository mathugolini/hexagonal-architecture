package com.hugolini.hexagonal.application.core.usecase.service;

import com.hugolini.hexagonal.application.core.domain.ClienteDomain;
import com.hugolini.hexagonal.application.ports.in.BuscarClientePorIdInPort;
import com.hugolini.hexagonal.application.ports.out.BuscarClientePorIdOutPort;

public class BuscarClientePorIdUseCaseService implements BuscarClientePorIdInPort {

    // *** camada de aplicação não deve conter anotações de framework

    private final BuscarClientePorIdOutPort buscarClientePorIdOutPort;

    public BuscarClientePorIdUseCaseService(BuscarClientePorIdOutPort buscarClientePorIdOutPort) {
        this.buscarClientePorIdOutPort = buscarClientePorIdOutPort;
    }

    @Override
    public ClienteDomain buscarPorId(String id) {
        return buscarClientePorIdOutPort.buscarCliente(id).orElseThrow(()-> new RuntimeException("Cliente não encontrado"));
    }


}
