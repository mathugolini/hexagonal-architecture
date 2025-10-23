package com.hugolini.hexagonal.application.ports.out;

import com.hugolini.hexagonal.application.core.domain.ClienteDomain;

import java.util.Optional;

public interface BuscarClientePorIdOutPort {

    Optional<ClienteDomain> buscarCliente(String id);
}
