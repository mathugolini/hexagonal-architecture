package com.hugolini.hexagonal.config;

import com.hugolini.hexagonal.adapters.out.AtualizarClienteAdapterOut;
import com.hugolini.hexagonal.adapters.out.BuscarEnderecoPorCepAdapterOut;
import com.hugolini.hexagonal.application.core.usecase.AtualizarClienteUseCase;
import com.hugolini.hexagonal.application.core.usecase.BuscarClientePorIdUseCase;
import com.hugolini.hexagonal.application.ports.out.BuscarClientePorIdOutPort;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AtualizarClienteConfig {


    @Bean
    public BuscarClientePorIdUseCase buscarClientePorIdUseCase(BuscarClientePorIdOutPort buscarClientePorIdOutPort) {
        return new BuscarClientePorIdUseCase(buscarClientePorIdOutPort);
    }

    @Bean
    public AtualizarClienteUseCase atualizarClienteUseCase(
            BuscarClientePorIdUseCase buscarClientePorIdUseCase,
            BuscarEnderecoPorCepAdapterOut buscarEnderecoPorCepAdapterOut,
            AtualizarClienteAdapterOut atualizarClienteAdapterOut) {

      return new AtualizarClienteUseCase(buscarClientePorIdUseCase, buscarEnderecoPorCepAdapterOut, atualizarClienteAdapterOut);
    }
}
