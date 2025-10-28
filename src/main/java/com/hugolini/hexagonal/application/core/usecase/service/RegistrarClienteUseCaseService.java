package com.hugolini.hexagonal.application.core.usecase.service;

import com.hugolini.hexagonal.application.core.domain.ClienteDomain;
import com.hugolini.hexagonal.application.ports.in.RegistrarClienteInPort;
import com.hugolini.hexagonal.application.ports.out.*;

public class RegistrarClienteUseCaseService implements RegistrarClienteInPort {

    // *** camada de aplicação não deve conter anotações de framework

    private final BuscarEnderecoPorCepOutPort buscarEnderecoPorCepOutPort;
    private final RegistrarClienteOutPort registrarClienteOutPort;
    private final EnviarCpfParaValidacaoOutPort enviarCpfParaValidacaoOutPort;

    public RegistrarClienteUseCaseService(BuscarEnderecoPorCepOutPort buscarEnderecoPorCepOutPort, RegistrarClienteOutPort registrarClienteOutPort, EnviarCpfParaValidacaoOutPort enviarCpfParaValidacaoOutPort) {
        this.buscarEnderecoPorCepOutPort = buscarEnderecoPorCepOutPort;
        this.registrarClienteOutPort = registrarClienteOutPort;
        this.enviarCpfParaValidacaoOutPort = enviarCpfParaValidacaoOutPort;
    }

    @Override
    public void registrarCliente(ClienteDomain cliente, String cep) {
        var endereco = buscarEnderecoPorCepOutPort.buscarPorCep(cep);
        cliente.setEndereco(endereco);
        registrarClienteOutPort.registrarCliente(cliente);
        enviarCpfParaValidacaoOutPort.enviarCpf(cliente.getCpf());
    }

}
