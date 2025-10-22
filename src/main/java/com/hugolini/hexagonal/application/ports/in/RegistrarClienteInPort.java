package com.hugolini.hexagonal.application.ports.in;

import com.hugolini.hexagonal.application.core.domain.ClienteDomain;

public interface RegistrarClienteInPort {

    void registrarCliente(ClienteDomain clienteDomain, String cep);

}
