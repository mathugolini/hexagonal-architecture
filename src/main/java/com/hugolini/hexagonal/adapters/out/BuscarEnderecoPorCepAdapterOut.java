package com.hugolini.hexagonal.adapters.out;

import com.hugolini.hexagonal.adapters.out.client.BuscarEnderecoPorCepClient;
import com.hugolini.hexagonal.adapters.out.client.mapper.EnderecoResponseAdapterOutMapper;
import com.hugolini.hexagonal.application.core.domain.EnderecoDomain;
import com.hugolini.hexagonal.application.ports.out.BuscarEnderecoPorCepOutPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BuscarEnderecoPorCepAdapterOut implements BuscarEnderecoPorCepOutPort {

    @Autowired
    private BuscarEnderecoPorCepClient buscarEnderecoPorCepClient;

    @Autowired
    private EnderecoResponseAdapterOutMapper enderecoResponseAdapterOutMapper;

    @Override
    public EnderecoDomain buscar(String cep) {
        var enderecoResponse = buscarEnderecoPorCepClient.buscarEnderecoPorCep(cep);
        return enderecoResponseAdapterOutMapper.toDomain(enderecoResponse);
    }
}
