package com.hugolini.hexagonal.application.core.usecase.service;

import com.hugolini.hexagonal.application.core.domain.ClienteDomain;
import com.hugolini.hexagonal.application.ports.in.AtualizarClienteInPort;
import com.hugolini.hexagonal.application.ports.in.BuscarClientePorIdInPort;
import com.hugolini.hexagonal.application.ports.out.AtualizarClienteOutPort;
import com.hugolini.hexagonal.application.ports.out.BuscarEnderecoPorCepOutPort;

public class AtualizarClienteUseCaseService implements AtualizarClienteInPort {

    // *** camada de aplicação não deve conter anotações de framework

    private final BuscarClientePorIdInPort buscarClientePorIdInPort;
    private final BuscarEnderecoPorCepOutPort buscarEnderecoPorCepOutPort;
    private final AtualizarClienteOutPort atualizarClienteOutPort;


    public AtualizarClienteUseCaseService(BuscarClientePorIdInPort buscarClientePorIdInPort, BuscarEnderecoPorCepOutPort buscarEnderecoPorCepOutPort, AtualizarClienteOutPort atualizarClienteOutPort) {
        this.buscarClientePorIdInPort = buscarClientePorIdInPort;
        this.buscarEnderecoPorCepOutPort = buscarEnderecoPorCepOutPort;
        this.atualizarClienteOutPort = atualizarClienteOutPort;
    }

    @Override
    public void atualizarCliente(ClienteDomain cliente, String cep) {
        buscarClientePorIdInPort.buscarPorId(cliente.getId());
        var endereco = buscarEnderecoPorCepOutPort.buscarPorCep(cep);
        cliente.setEndereco(endereco);
        atualizarClienteOutPort.atualizarCliente(cliente);
    }
}
