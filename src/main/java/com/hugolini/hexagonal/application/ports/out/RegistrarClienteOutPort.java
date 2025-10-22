package com.hugolini.hexagonal.application.ports.out;

import com.hugolini.hexagonal.application.core.domain.ClienteDomain;

public interface RegistrarClienteOutPort {

    void registrarCliente(ClienteDomain cliente);
}
