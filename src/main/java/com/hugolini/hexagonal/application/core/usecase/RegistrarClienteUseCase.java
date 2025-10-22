package com.hugolini.hexagonal.application.core.usecase;

import com.hugolini.hexagonal.application.core.domain.ClienteDomain;
import com.hugolini.hexagonal.application.ports.out.BuscarEnderecoPorCepOutPort;
import com.hugolini.hexagonal.application.ports.out.RegistrarClienteOutPort;

public class RegistrarClienteUseCase {

    // *** camada de aplicação não deve conter anotações de framework

    private final BuscarEnderecoPorCepOutPort buscarEnderecoPorCepOutPort;
    private final RegistrarClienteOutPort registrarClienteOutPort;


    public RegistrarClienteUseCase(BuscarEnderecoPorCepOutPort buscarEnderecoPorCepOutPort, RegistrarClienteOutPort registrarClienteOutPort) {
        this.buscarEnderecoPorCepOutPort = buscarEnderecoPorCepOutPort;
        this.registrarClienteOutPort = registrarClienteOutPort;
    }

    public void registrarCliente(ClienteDomain cliente, String cep) {
        var endereco = buscarEnderecoPorCepOutPort.buscar(cep);
        cliente.setEndereco(endereco);
        registrarClienteOutPort.registrarCliente(cliente);
    }

}
