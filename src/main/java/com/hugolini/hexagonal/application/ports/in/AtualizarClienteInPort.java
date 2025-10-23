package com.hugolini.hexagonal.application.ports.in;

import com.hugolini.hexagonal.application.core.domain.ClienteDomain;

public interface AtualizarClienteInPort {

    void atualizarCliente(ClienteDomain clienteDomain, String cep);
}
