package com.hugolini.hexagonal.application.ports.out;

import com.hugolini.hexagonal.application.core.domain.EnderecoDomain;

public interface BuscarEnderecoPorCepOutPort {

    EnderecoDomain buscarPorCep(String cep);
}
