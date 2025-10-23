package com.hugolini.hexagonal.application.core.usecase;

import com.hugolini.hexagonal.application.core.domain.ClienteDomain;
import com.hugolini.hexagonal.application.ports.in.AtualizarClienteInPort;
import com.hugolini.hexagonal.application.ports.in.BuscarClientePorIdInPort;
import com.hugolini.hexagonal.application.ports.out.BuscarEnderecoPorCepOutPort;

public class AtualizarClienteUseCase implements AtualizarClienteInPort {

    private final BuscarClientePorIdInPort buscarClientePorIdInPort;
    private final BuscarEnderecoPorCepOutPort buscarEnderecoPorCepOutPort;

    public AtualizarClienteUseCase(BuscarClientePorIdInPort buscarClientePorIdInPort, BuscarEnderecoPorCepOutPort buscarEnderecoPorCepOutPort) {
        this.buscarClientePorIdInPort = buscarClientePorIdInPort;
        this.buscarEnderecoPorCepOutPort = buscarEnderecoPorCepOutPort;
    }

    @Override
    public void atualizarCliente(ClienteDomain cliente, String cep) {
        buscarClientePorIdInPort.buscarPorId(cliente.getId());
        var endereco = buscarEnderecoPorCepOutPort.buscarPorCep(cep);
        cliente.setEndereco(endereco);
    }
}
