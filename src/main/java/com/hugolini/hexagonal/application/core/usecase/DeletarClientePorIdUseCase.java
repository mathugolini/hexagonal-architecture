package com.hugolini.hexagonal.application.core.usecase;

import com.hugolini.hexagonal.application.ports.in.BuscarClientePorIdInPort;
import com.hugolini.hexagonal.application.ports.in.DeletarClientePorIdPort;
import com.hugolini.hexagonal.application.ports.out.DeletarClientePorIdOutPort;

public class DeletarClientePorIdUseCase implements DeletarClientePorIdPort {

    // *** camada de aplicação não deve conter anotações de framework

    private final BuscarClientePorIdInPort buscarClientePorIdInPort;
    private final DeletarClientePorIdOutPort deletarClientePorIdOutPort;

    public DeletarClientePorIdUseCase(BuscarClientePorIdInPort buscarClientePorIdInPort, DeletarClientePorIdUseCase deletarClientePorIdUseCase, DeletarClientePorIdOutPort deletarClientePorIdOutPort) {
        this.buscarClientePorIdInPort = buscarClientePorIdInPort;
        this.deletarClientePorIdOutPort = deletarClientePorIdOutPort;
    }

    @Override
    public void deletarClientePorId(String id) {
        buscarClientePorIdInPort.buscarPorId(id);
        deletarClientePorIdOutPort.deletarClientePorId(id);
    }

}
