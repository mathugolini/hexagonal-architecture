package com.hugolini.hexagonal.application.core.usecase;

import com.hugolini.hexagonal.adapters.out.BuscarEnderecoPorCepAdapterOut;
import com.hugolini.hexagonal.application.core.domain.ClienteDomain;
import com.hugolini.hexagonal.application.ports.in.BuscarClientePorIdInPort;
import com.hugolini.hexagonal.application.ports.in.RegistrarClienteInPort;
import com.hugolini.hexagonal.application.ports.out.AtualizarClienteOutPort;
import com.hugolini.hexagonal.application.ports.out.BuscarClientePorIdOutPort;
import com.hugolini.hexagonal.application.ports.out.BuscarEnderecoPorCepOutPort;
import com.hugolini.hexagonal.application.ports.out.RegistrarClienteOutPort;

public class RegistrarClienteUseCase implements RegistrarClienteInPort {

    // *** camada de aplicação não deve conter anotações de framework

    private final BuscarClientePorIdInPort buscarClientePorIdInPort;
    private final BuscarEnderecoPorCepOutPort buscarEnderecoPorCepOutPort;
    private final AtualizarClienteOutPort atualizarClienteOutPort;

    public RegistrarClienteUseCase(BuscarEnderecoPorCepOutPort buscarEnderecoPorCepOutPort, RegistrarClienteOutPort registrarClienteOutPort, BuscarEnderecoPorCepAdapterOut buscarEnderecoPorCepAdapterOut, BuscarClientePorIdInPort buscarClientePorIdInPort, AtualizarClienteOutPort atualizarClienteOutPort) {
        this.buscarClientePorIdInPort = buscarClientePorIdInPort;
        this.buscarEnderecoPorCepOutPort = buscarEnderecoPorCepOutPort;
        this.atualizarClienteOutPort = atualizarClienteOutPort;
    }

    @Override
    public void registrarCliente(ClienteDomain cliente, String cep) {
        buscarClientePorIdInPort.buscarPorId(cliente.getId());
        var endereco = buscarEnderecoPorCepOutPort.buscarPorCep(cep);
        cliente.setEndereco(endereco);
        atualizarClienteOutPort.atualizarCliente(cliente);
    }

}
