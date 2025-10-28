package com.hugolini.hexagonal.config;

import com.hugolini.hexagonal.adapters.out.service.AtualizarClienteAdapterOutService;
import com.hugolini.hexagonal.adapters.out.service.BuscarEnderecoPorCepAdapterOutService;
import com.hugolini.hexagonal.application.core.usecase.service.AtualizarClienteUseCaseService;
import com.hugolini.hexagonal.application.core.usecase.service.BuscarClientePorIdUseCaseService;
import com.hugolini.hexagonal.application.ports.out.BuscarClientePorIdOutPort;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AtualizarClienteConfig {


    @Bean
    public BuscarClientePorIdUseCaseService buscarClientePorIdUseCase(BuscarClientePorIdOutPort buscarClientePorIdOutPort) {
        return new BuscarClientePorIdUseCaseService(buscarClientePorIdOutPort);
    }

    @Bean
    public AtualizarClienteUseCaseService atualizarClienteUseCase(
            BuscarClientePorIdUseCaseService buscarClientePorIdUseCaseService,
            BuscarEnderecoPorCepAdapterOutService buscarEnderecoPorCepAdapterOutService,
            AtualizarClienteAdapterOutService atualizarClienteAdapterOutService) {

      return new AtualizarClienteUseCaseService(buscarClientePorIdUseCaseService, buscarEnderecoPorCepAdapterOutService, atualizarClienteAdapterOutService);
    }
}
