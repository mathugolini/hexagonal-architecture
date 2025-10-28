package com.hugolini.hexagonal.adapters.out.service;

import com.hugolini.hexagonal.adapters.out.client.BuscarEnderecoPorCepClient;
import com.hugolini.hexagonal.adapters.out.mapper.EnderecoResponseAdapterOutMapper;
import com.hugolini.hexagonal.application.core.domain.EnderecoDomain;
import com.hugolini.hexagonal.application.ports.out.BuscarEnderecoPorCepOutPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BuscarEnderecoPorCepAdapterOutService implements BuscarEnderecoPorCepOutPort {

    @Autowired
    private BuscarEnderecoPorCepClient buscarEnderecoPorCepClient;

    @Autowired
    private EnderecoResponseAdapterOutMapper enderecoResponseAdapterOutMapper;

    @Override
    public EnderecoDomain buscarPorCep(String cep) {
        var enderecoResponse = buscarEnderecoPorCepClient.buscarEnderecoPorCep(cep);
        return enderecoResponseAdapterOutMapper.toDomain(enderecoResponse);
    }
}
